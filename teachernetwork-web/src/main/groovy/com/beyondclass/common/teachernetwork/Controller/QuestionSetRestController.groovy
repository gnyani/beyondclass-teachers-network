package com.beyondclass.common.teachernetwork.Controller

import com.beyondclass.common.teachernetwork.Repositories.QuestionSetRepository
import com.beyondclass.common.teachernetwork.Service.CreateAssignmentToQuestionSetConverter
import com.beyondclass.common.teachernetwork.Service.QuestionSetService
import com.beyondclass.common.teachernetwork.api.Comment
import com.beyondclass.common.teachernetwork.api.QuestionSet
import com.beyondclass.common.teachernetwork.api.Question
import com.beyondclass.common.teachernetwork.api.converters.CreateAssignment
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class QuestionSetRestController {

    @Autowired
    QuestionSetService questionSetService

    @Autowired
    QuestionSetRepository questionSetRepository

    @Autowired
    CreateAssignmentToQuestionSetConverter createAssignmentToQuestionSetConverter


    Logger log = LoggerFactory.getLogger(QuestionSetRestController.class)

    @GetMapping(value="/addquestionset")
    ResponseEntity<?> AddQuestionSet(@RequestParam String questionsetdesc){
        QuestionSet questionSet = new QuestionSet()
        questionSet.questionSetDescription = questionsetdesc
        questionSet = questionSetService.insertQuestionSet(questionSet)
        questionSet?new ResponseEntity<>('Successful',HttpStatus.OK):new ResponseEntity<>(body:'Something went wrong',HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ResponseBody
    @GetMapping(value="/viewquestionsets")
    ResponseEntity<?> ViewQuestionSets( ){

        log.info("<QuestionSetController> fetching all question sets")
        List<QuestionSet> questionSetList = questionSetRepository.findAll()
        questionSetList ? new ResponseEntity<>(questionSetList, HttpStatus.OK) : new ResponseEntity<>("Empty ",HttpStatus.NO_CONTENT)

    }

    @ResponseBody
    @PostMapping(value="/viewquestionsets/{questionsetId:.+}/like")
    ResponseEntity<?> UpdateLikedBy(@RequestBody String likedBy ,@PathVariable(value="questionsetId",required=true)String questionsetid)
    {
        log.info("<QuestionSetController> liking/unliking question sets")
        QuestionSet questionSet= questionSetRepository.findById(questionsetid)
        questionSet.likedBy.contains(likedBy)?questionSet.likedBy.remove(likedBy):questionSet.likedBy.add(likedBy)
        def newQuestionSet = questionSetRepository.save(questionSet)
        newQuestionSet ? new ResponseEntity<>(newQuestionSet.likedBy, HttpStatus.OK) : new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ResponseBody
    @PostMapping(value="/viewquestionsets/{questionsetId:.+}/comment")
    ResponseEntity<?> AddedComment(@RequestBody Comment comment ,@PathVariable(value="questionsetId",required=true)String questionsetid)
    {
        log.info("<QuestionSetController> adding a comment to question set")
        QuestionSet questionset= questionSetRepository.findById(questionsetid)
        questionset.comments.add(comment)
        def newQuestionSet = questionSetRepository.save(questionset)
        newQuestionSet ? new ResponseEntity<>(newQuestionSet.comments, HttpStatus.OK) : new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ResponseBody
    @PostMapping(value="/savequestionset")
    ResponseEntity<?> AddQuestionSetWithQuestions(@RequestBody CreateAssignment createAssignment)
    {
        log.info("<QuestionSetController> coverting createAssignment to QuestionSet ${createAssignment}")
        QuestionSet questionSet = createAssignmentToQuestionSetConverter.convertToQuestionSetConverter(createAssignment)
        log.info("<QuestionSetController> saving question set to Db")
        def inserted = questionSetRepository.save(questionSet)
        inserted ? new ResponseEntity<>(inserted, HttpStatus.OK) : new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
