package com.beyondclass.common.teachernetwork.Service

import com.beyondclass.common.teachernetwork.api.converters.CreateAssignment
import groovy.json.JsonSlurper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service

/**
 * Created by Gnyani on 02/08/18.
 */

@Service
class GetAssignmentService {

    @Autowired
    private Environment env

    JsonSlurper jsonSlurper = new JsonSlurper()

    Logger logger = LoggerFactory.getLogger(GetAssignmentService.class)

    public String getHostNameForCollege(String collegeCode){

        String hostName = env.getProperty("beyond.class.college.host.${collegeCode.toLowerCase()}")

        hostName
    }

    public def getAssignmentFromHostName(String hostName, String assignmentId){

        def requestUrl = "http://${hostName}:8090/teacher/get/assignment/${assignmentId}"

        def response =  jsonSlurper.parseText(new URL(requestUrl).text)

        response

    }

}
