package com.beyondclass.common.teachernetwork.Controller

import com.beyondclass.common.teachernetwork.Service.HelloWorldService
import com.beyondclass.common.teachernetwork.api.HelloWorld
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Gnyani on 13/07/18.
 */

@RestController
class HelloWorldRestController {

    @Autowired
    HelloWorldService service

    @GetMapping(value = "/test")
    public ResponseEntity<?> insertData(@RequestParam String name){

        HelloWorld helloWorld = new HelloWorld()
        helloWorld.name = name

        service.insert(helloWorld) ? new ResponseEntity<>("Insert success for ${name}", HttpStatus.OK) : new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR)

    }

    @GetMapping(value = "/test/retrieve", produces = "application/json")
    public ResponseEntity<?> retrieveDate(@RequestParam String name){

        def list = service.retrieve(name)

         list ? new ResponseEntity<>("${list.toString()}", HttpStatus.OK) : new ResponseEntity<>("not found", HttpStatus.NOT_FOUND)

    }


}
