package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.newrelic.opentracing.LambdaTracer;
import com.newrelic.opentracing.aws.TracingRequestHandler;
import io.opentracing.util.GlobalTracer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoHandler implements TracingRequestHandler<String, String> {

    private static final Logger log = LogManager.getLogger(DemoHandler.class);

    static final String MESSAGE = "Lambda Functions are great!";

    static {
        // Register the New Relic OpenTracing LambdaTracer as the Global Tracer
        log.info("Registering New Relic OpenTracing LambdaTracer");
        GlobalTracer.registerIfAbsent(LambdaTracer.INSTANCE);
    }

    @Override
    public String doHandleRequest(String s, Context context) {
        return MESSAGE;
    }
}
