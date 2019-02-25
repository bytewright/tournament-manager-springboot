package org.bytewright;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.bytewright.springbootvue.SpringBootMvcApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMvcApplication.class)
public class SpringContextIntegrationTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
