package com.beyondclass.common.teachernetwork.Service

import com.beyondclass.common.teachernetwork.Repositories.NetworkQuestionRepository
import com.beyondclass.common.teachernetwork.Repositories.QuestionSetRepository
import com.beyondclass.common.teachernetwork.api.QuestionSet
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class QuestionSetService {
    @Autowired
    QuestionSetRepository questionSetRepository
    @Autowired
    NetworkQuestionRepository networkQuestionRepository

    def AddQuestionSet(QuestionSet questionSet)
    {
       return questionSetRepository.save(questionSet)

    }



}
