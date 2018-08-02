package com.beyondclass.common.teachernetwork.Service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

/**
 * Created by Gnyani on 01/08/18.
 */

@Service
class CommonUtils {

    Logger logger = LoggerFactory.getLogger(CommonUtils.class)

    public String parseCollegeCodeFromAssignmentId(String assignmentId){
        def splits = assignmentId.split('-')
        logger.info("assignment Id is ${assignmentId} and college Code is ${splits[1]}")
        splits[1]
    }
}
