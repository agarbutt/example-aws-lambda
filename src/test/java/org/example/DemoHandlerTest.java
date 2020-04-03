package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoHandlerTest {

    @Test
    void testReturnsMessage() {
        Context stubbedContext = new TestContext();

        var handler = new DemoHandler();

        String actualResult = handler.handleRequest("SomeInput", stubbedContext);
        assertEquals(DemoHandler.MESSAGE, actualResult);
    }

}