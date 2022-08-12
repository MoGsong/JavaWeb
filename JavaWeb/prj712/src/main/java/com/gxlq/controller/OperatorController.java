package com.gxlq.controller;

import java.util.Scanner;

import com.gxlq.entity.Operator;
import com.gxlq.service.IOperatorService;
import com.gxlq.service.imp.OperatorService;

public class OperatorController {
    public static Operator Login() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("ÇëÊäÈëÕËºÅ:");
        String username = sc.next();
        System.out.println("ÇëÊäÈëÃÜÂë:");
        String password = sc.next();

        IOperatorService ios = new OperatorService();
        Operator operator = ios.find(username, password);
        if (operator.getId() > 0) {
            System.out.println(operator.getRole().getName() + "\t" + operator.getUsername() + "\t" + "µÇÂ½³É¹¦");
//			sc.close();  //NoSuchElementException
        } else {
            System.out.println("ÍË³ö");
        }
        return operator;
    }
}
