package com.javastudy;

import com.javastudy.model.Operator;
import com.javastudy.model.OperatorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Maxim Sambulat
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        OperatorService operatorService = ctx.getBean("jpaOperatorService", OperatorService.class);
        Operator operator = operatorService.findById(1);

        if (operator != null) {
            System.out.println(operator.getName());
            System.out.println(operator.getAccount().getLogin());
        }
    }
}
