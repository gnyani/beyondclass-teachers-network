package com.beyondclass.common.teachernetwork.Repositories

import com.beyondclass.common.teachernetwork.api.QuestionSet
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface QuestionSetRepository extends MongoRepository<QuestionSet,String> {
       QuestionSet findById(String id)

        List<QuestionSet> findAllByOrderByCreatedAtDesc()

    }