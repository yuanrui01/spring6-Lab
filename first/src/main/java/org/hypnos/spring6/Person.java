package org.hypnos.spring6;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/30-20:53
 */
@Slf4j
public class Person {

    public void hello(){
        System.out.println("say Hello!");
    }
    @Test
    void test(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Person person = (Person)classPathXmlApplicationContext.getBean("person");
        person.hello();
        
        log.error("淄博烧烤");
    }

}
