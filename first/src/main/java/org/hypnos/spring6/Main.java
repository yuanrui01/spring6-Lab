package org.hypnos.spring6;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/30-20:40
 */
public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Person person = (Person)classPathXmlApplicationContext.getBean("person");
        person.hello();
    }
}