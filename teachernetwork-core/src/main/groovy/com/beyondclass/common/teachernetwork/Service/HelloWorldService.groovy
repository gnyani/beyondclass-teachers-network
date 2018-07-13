package com.beyondclass.common.teachernetwork.Service

import com.beyondclass.common.teachernetwork.Repositories.HelloWorldRepository
import com.beyondclass.common.teachernetwork.api.HelloWorld
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by Gnyani on 13/07/18.
 */

@Service
class HelloWorldService {

    @Autowired
    HelloWorldRepository repository

     boolean insert(HelloWorld helloWorld){

        def insertedObject = repository.save(helloWorld)

        insertedObject ? true : false
    }

     List<HelloWorld> retrieve(String name) {

        repository.findByName(name)
    }

}
