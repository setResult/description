package org.aomr.desc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DescApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(DescApplicationTests.class);

    @Test
    public void contextLoads() {
        logger.info("test");
        System.out.println("hello world");
    }

}
