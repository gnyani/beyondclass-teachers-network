package com.beyondclass.common.teachernetwork.Controller

import com.beyondclass.common.teachernetwork.Repositories.QuestionSetRepository
import com.beyondclass.common.teachernetwork.Service.NetworkQuestionService
import com.beyondclass.common.teachernetwork.Service.QuestionSetService
import com.beyondclass.common.teachernetwork.api.Comment
import com.beyondclass.common.teachernetwork.api.QuestionSet
import com.beyondclass.common.teachernetwork.api.SingleQuestion
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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

 @PostMapping(value="/teachersnetwork/viewquestionsets/{questionsetId:.+}/like")
  public int UpdateLikedBy(@RequestBody String likedBy ,@PathVariable(value="questionsetId",required=true)String questionsetid)
    {
        QuestionSet questionset= questionSetRepository.findById(questionsetid)
        println(questionset.LikedBy)
        questionset.LikedBy.contains(likedBy)==true?questionset.LikedBy.remove(likedBy):questionset.LikedBy.add(likedBy)
        questionSetRepository.save(questionset)
        questionset.LikedBy.size()
    }
    @PostMapping(value="/teachersnetwork/viewquestionsets/{questionsetId:.+}/comment")
    public List<Comment> AddedComment(@RequestBody Comment comment ,@PathVariable(value="questionsetId",required=true)String questionsetid)
    { println(questionsetid)
        QuestionSet questionset= questionSetRepository.findById(questionsetid)
          println(questionset.Comments+"Entered")
        questionset.Comments.add(comment)
        println("entered after adding comment"+comment)
        questionSetRepository.save(questionset)
        questionset.Comments
    }

    @PostMapping(value="/teachersnetwork/addquestionset/addquestions/savequestionset")
    public QuestionSet AddQuestionSetWithQuestions(@RequestBody QuestionSet questionSet)
    {   List<ObjectId> ids=new ArrayList<ObjectId>()
        for(int i=0;i<questionSet.questionslist.size();i++){

          SingleQuestion sq=networkQuestionService.AddQuestion(questionSet.questionslist[i])
          ids.push(sq.id)
        }


        questionSet.questionids=ids



       questionSetRepository.save(questionSet)

    }



}
