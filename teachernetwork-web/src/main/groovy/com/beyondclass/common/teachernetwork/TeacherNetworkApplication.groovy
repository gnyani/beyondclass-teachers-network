package com.beyondclass.common.teachernetwork

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

import javax.annotation.PostConstruct

/**
 * Created by Gnyani on 13/07/18.
 */

@ComponentScan(basePackages = ['com.beyondclass.common.teachernetwork'])
@EnableMongoRepositories(['com.beyondclass.common.teachernetwork.Repositories'])
@SpringBootApplication
class TeacherNetworkApplication {

    @PostConstruct
    public void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("IST"))   // It will set IST timezone
        System.out.println("Spring boot application running in UTC timezone :"+new Date())  // It will print IST timezone
    }

    static void main(String[] args) {
        SpringApplication.run(TeacherNetworkApplication.class, args)
    }
}
