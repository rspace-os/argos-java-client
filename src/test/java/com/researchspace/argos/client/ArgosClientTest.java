package com.researchspace.argos.client;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.client.MockRestServiceServer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

class ArgosClientTest {

    private ArgosClientImpl argosClientImpl;
    private MockRestServiceServer mockServer;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void startUp() throws MalformedURLException {
        argosClientImpl = new ArgosClientImpl(new URL("https://devel.opendmp.eu/srv/api/public"));
        mockServer = MockRestServiceServer.createServer(argosClientImpl.getRestTemplate());
        objectMapper = new ObjectMapper();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testFoo() throws IOException {
        assertEquals(true, true);
    }

}
