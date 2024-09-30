package com.nikolaypodlesnykh.spring.rest;

import com.nikolaypodlesnykh.spring.rest.configuration.MyConfig;
import com.nikolaypodlesnykh.spring.rest.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;



public class App {


    public static void main(String[] args) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean(Communication.class);

        //SHOW ALL USER
        communication.showAllEmployees();
        //ADD USER
        User user = new User(3,"James","Brown", (byte) 34 );
        communication.saveEmployee(user);
        user.setName("Thomas");
        user.setLastName("Shelby");
        //UPDATE USER
        communication.updateEmployee(3,user);
        //DELETE USER
        communication.deleteEmployee(3);





    }
}
