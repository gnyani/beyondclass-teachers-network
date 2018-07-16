package com.beyondclass.common.teachernetwork.Service

import com.beyondclass.common.teachernetwork.Repositories.QuestionSetRepository
import com.beyondclass.common.teachernetwork.api.QuestionSet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class QuestionSetService {
    @Autowired
    QuestionSetRepository questionSetRepository

    def AddQuestionSet(QuestionSet questionSet)
    {
       return questionSetRepository.save(questionSet)

    }


}
