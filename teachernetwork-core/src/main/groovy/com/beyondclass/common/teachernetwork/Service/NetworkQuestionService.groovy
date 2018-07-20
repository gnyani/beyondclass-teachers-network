package com.beyondclass.common.teachernetwork.Service

import com.beyondclass.common.teachernetwork.Repositories.NetworkQuestionRepository
import com.beyondclass.common.teachernetwork.api.SingleQuestion
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NetworkQuestionService {
    @Autowired
            NetworkQuestionRepository NetworkRepo

    def AddQuestion(SingleQuestion networkQuestion){
        if(ValidQuestion(networkQuestion)==true)
        {
          return NetworkRepo.save(networkQuestion)
        }
        else {
            println("Something went wrong in inserting the question")
        }
    }

    def GetQuestion(String id){
        NetworkRepo.findById(id)
    }
   // this function is used to add validations to the questions
    boolean ValidQuestion(SingleQuestion Q )
    {return true}

}
