package com.wzw.springboot;

import com.wzw.springboot.bean.Person;
import com.wzw.springboot.service.HelloService;
import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * springboot的单元测试
 */
@SpringBootTest
class SpringBoot02ConfigApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    public void testHelloService(){
        boolean b=ioc.containsBean("helloService");

        System.out.println(b);
    }

	@Test
	void contextLoads() {
        System.out.println(person);
	}

}
