package com.beyondclass.common.teachernetwork.Controller

import com.beyondclass.common.teachernetwork.Service.HelloWorldService
import com.beyondclass.common.teachernetwork.Service.NetworkQuestionService
import com.beyondclass.common.teachernetwork.api.HelloWorld
import com.beyondclass.common.teachernetwork.api.SingleQuestion
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
NetworkQuestionService networkQuestionService

    @Autowired
    HelloWorldService service

    @GetMapping(value = "/test")
    public ResponseEntity<?> insertData(@RequestParam String name){

        HelloWorld helloWorld = new HelloWorld()
        helloWorld.name = name
        String s=new String("pratapraj")
        s

    }

    @GetMapping(value = "/test/retrieve", produces = "application/json")
    public ResponseEntity<?> retrieveDate(@RequestParam String name){
        String s=new String("pratapraj")
        s
    }

    @GetMapping(value = "/teachersnetwork")
 public ResponseEntity<?> AddQuestionToNetwork(@RequestParam String questiondesc)
    {
        SingleQuestion question=new SingleQuestion();
        question.questionDescription=questiondesc
         HashMap answers=new HashMap()
        answers.put("A","Pointer stores address of a variable")
        question.answer=answers
      question=networkQuestionService.AddQuestion(question)
       //println(question._id.toString())
      //  println(question.getId())
        println(question.id)
        question? new ResponseEntity<>('Successful',HttpStatus.OK) : new ResponseEntity<>('something went wrong',HttpStatus.INTERNAL_SERVER_ERROR)


    }



}
