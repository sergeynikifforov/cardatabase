package com.packt.cardatabase;

import static org.assertj.core.api.Assertions.assertThat;

import com.packt.cardatabase.web.CarController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// The @SpringBootTest annotation specifies that the class is a regular
// test class that runs Spring Boot based tests. The @Test annotation before the
// method defines to JUnit that the method can be run as a test case.
// The @RunWith(SpringRunner.class) annotation provides Spring ApplicationContext and
// get beans injected into your test instance.


@RunWith(SpringRunner.class)
@SpringBootTest
public class CardatabaseApplicationTests {
    // The following test checks that the instance of controller was created and
    // injected successfully

    @Autowired
    private CarController controller;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
