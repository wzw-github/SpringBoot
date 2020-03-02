package com.wzw.springboot;

import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot03LoggingApplicationTests {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	void contextLoads() {
	    //日志级别：由低到高trace<debug<info<warn<error
        //可以调整日志的输出级别，调整以后就只会在这个级别或更高级别生效
		logger.trace("这是trace日志。。。");
		logger.debug("这是debug日志。。。");
		//SpringBoot默认是Info级别
		logger.info("这是Info日志。。。");
		logger.warn("这是warn日志....");
        logger.error("这是error日志....");
	}

}
