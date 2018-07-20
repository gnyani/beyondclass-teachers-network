package com.beyondclass.common.teachernetwork.Repositories

import com.beyondclass.common.teachernetwork.api.SingleQuestion
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface NetworkQuestionRepository extends MongoRepository<SingleQuestion, String>{
SingleQuestion findById(String Id)
}