package com.beyondclass.common.teachernetwork.Repositories

import com.beyondclass.common.teachernetwork.api.QuestionSet
import org.springframework.data.mongodb.repository.MongoRepository

interface QuestionSetRepository extends MongoRepository<QuestionSet,String> {


    }