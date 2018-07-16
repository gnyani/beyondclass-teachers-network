package com.beyondclass.common.teachernetwork.Controller

import com.beyondclass.common.teachernetwork.Repositories.QuestionSetRepository
import com.beyondclass.common.teachernetwork.Service.NetworkQuestionService
import com.beyondclass.common.teachernetwork.Service.QuestionSetService
import com.beyondclass.common.teachernetwork.api.QuestionSet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class QuestionSetRestController {
    @Autowired
    QuestionSetService questionSetService
    @Autowired
    NetworkQuestionService networkQuestionService
    @Autowired
    QuestionSetRepository questionSetRepository
    @GetMapping(value="/teachersnetwork/addquestionset")
    public ResponseEntity<?> AddQuestionSet(@RequestParam String questionsetdesc){
        QuestionSet questionSet=new QuestionSet()
        questionSet.questionsetdescription=questionsetdesc
        List<String> Ids=new ArrayList<String>()
        Ids.add("5b4b81f664f12a1ed4e98b8f")
        Ids.add("5b4b609c64f12a452cc66009")
       questionSet.questionids=Ids
      questionSet=questionSetService.AddQuestionSet(questionSet)
        questionSet?new ResponseEntity<>('Successful',HttpStatus.OK):new ResponseEntity<>(body:'Something went wrong',HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @GetMapping(value="/teachersnetwork/viewquestionsets")
    public List<QuestionSet> ViewQuestionSets( ){
       List<QuestionSet> questionsetlist=questionSetRepository.findAll()
        questionsetlist

    }
}
