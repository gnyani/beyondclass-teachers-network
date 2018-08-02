package com.beyondclass.common.teachernetwork.Controller

import com.beyondclass.common.teachernetwork.Service.CommonUtils
import com.beyondclass.common.teachernetwork.Service.GetAssignmentService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


/**
 * Created by Gnyani on 01/08/18.
 */

@RestController
class AssignmentRestController {

    @Autowired
    CommonUtils commonUtils

    @Autowired
    GetAssignmentService assignmentService

    Logger logger = LoggerFactory.getLogger(AssignmentRestController.class)

    @ResponseBody
    @GetMapping(value="/get/assignment/{assignmentId:.+}")
    public ResponseEntity<?> getAssignment(@PathVariable(value="assignmentId", required = true) String assignmentId, @RequestParam(value="questionsetid", required = false)String questionSetId ){

        def collegeCode = commonUtils.parseCollegeCodeFromAssignmentId(assignmentId)

        def hostName = assignmentService.getHostNameForCollege(collegeCode)

        def responseAssignment = assignmentService.getAssignmentFromHostName(hostName, assignmentId)

        logger.info("requesting the host ${hostName} for fetching the assignment")

        if(questionSetId)
        responseAssignment.author.questionSetReferenceId = questionSetId

        responseAssignment.assignmentid ? new ResponseEntity<?>(responseAssignment,HttpStatus.OK) : new ResponseEntity<?>("not found",HttpStatus.NOT_FOUND)
    }
}
