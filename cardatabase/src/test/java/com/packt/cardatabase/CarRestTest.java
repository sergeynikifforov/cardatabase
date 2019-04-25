package com.packt.cardatabase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

// Next, we will show how to test your RESTful web service JWT authentication functionality.
// For testing the controllers or any endpoint that is exposed, we can use a MockMvc.
// By using the MockMvc, the server is not started but the tests are
// performed in the layer where Spring handles HTTP requests, and therefore it
// mocks the real situation. MockMvc provides the perform method to send the requests.
// To test authentication, we have to add credentials to the request body. We
// perform two requests; the first has the correct credentials and we check that the
// status is OK. The second request contains incorrect credentials and we check
// that we get a 4XX HTTP error.

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CarRestTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAuthentication() throws Exception {
        // Testing authentication with correct credentials
        this.mockMvc.perform(post("/login").content("{\"username\":\"admin\", \"password\":\"admin\"}")).
                andDo(print()).andExpect(status().isOk());

        // Testing authentication with wrong credentials
        this.mockMvc.perform(post("/login").content("{\"username\":\"admin\", \"password\":\"wrongpwd\"}")).
                andDo(print()).andExpect(status().is4xxClientError());

    }
}
