package com.beyondclass.common.teachernetwork.Service


import com.beyondclass.common.teachernetwork.Repositories.QuestionSetRepository
import com.beyondclass.common.teachernetwork.api.QuestionSet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class QuestionSetService {

    @Autowired
    QuestionSetRepository questionSetRepository

    def insertQuestionSet(QuestionSet questionSet)
    {
       return questionSetRepository.save(questionSet)
    }

    def getQuestionSetBySubject(String subject, Pageable pageable){

        return questionSetRepository.findBySubjectOrderByCreatedAtDesc(subject,pageable)
    }


}
