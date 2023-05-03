package org.hypnos.spring6;


import lombok.extern.slf4j.Slf4j;
import org.hypnos.spring6.validator.TestDTO;
import org.hypnos.spring6.validator.two.ValidationConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.net.MalformedURLException;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/30-20:53
 */
@Slf4j
@Validated
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

    public static void fileCheck(@Valid TestDTO file){
        System.out.println(312312);
    }

    public static void main(String[] args) throws MalformedURLException {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ValidationConfig.class);
        fileCheck(new TestDTO());
    }

}
