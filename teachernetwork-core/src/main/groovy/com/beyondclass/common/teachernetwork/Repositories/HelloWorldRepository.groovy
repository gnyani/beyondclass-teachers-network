package com.beyondclass.common.teachernetwork.Repositories

import com.beyondclass.common.teachernetwork.api.HelloWorld
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by Gnyani on 13/07/18.
 */
interface HelloWorldRepository extends  MongoRepository<HelloWorld, String> {

    List<HelloWorld> findByName(String name)
}
