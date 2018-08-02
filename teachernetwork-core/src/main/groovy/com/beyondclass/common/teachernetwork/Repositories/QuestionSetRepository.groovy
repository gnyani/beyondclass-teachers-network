package com.beyondclass.common.teachernetwork.Repositories

import com.beyondclass.common.teachernetwork.api.QuestionSet

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository

interface QuestionSetRepository extends MongoRepository<QuestionSet,String> {

    QuestionSet findById(String id)
    Page<QuestionSet> findAllByOrderByCreatedAtDesc(Pageable pageable)
    Page<QuestionSet> findBySubjectOrderByCreatedAtDesc(String subject,Pageable pageable)

}