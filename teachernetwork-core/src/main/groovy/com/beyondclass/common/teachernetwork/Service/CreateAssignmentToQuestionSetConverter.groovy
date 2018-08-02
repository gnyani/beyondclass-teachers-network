package com.beyondclass.common.teachernetwork.Service

import com.beyondclass.common.teachernetwork.api.Constants.QuestionSetType
import com.beyondclass.common.teachernetwork.api.Constants.QuestionType
import com.beyondclass.common.teachernetwork.api.Options
import com.beyondclass.common.teachernetwork.api.Question
import com.beyondclass.common.teachernetwork.api.QuestionSet
import com.beyondclass.common.teachernetwork.api.TestCases
import com.beyondclass.common.teachernetwork.api.converters.AssignmentType
import com.beyondclass.common.teachernetwork.api.converters.CreateAssignment
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

/**
 * Created by Gnyani on 21/07/18.
 */

@Service
class CreateAssignmentToQuestionSetConverter {


    Logger log = LoggerFactory.getLogger(CreateAssignmentToQuestionSetConverter.class)

    QuestionSet convertToQuestionSetConverter(CreateAssignment createAssignment){

        QuestionSet questionSet = new QuestionSet()

        questionSet.with {
            postedUser = createAssignment ?. author ?.realOwner
            questionSetDescription = createAssignment.message
            questionsList = generateQuestionsList(createAssignment)
            questionSetType = QuestionSetType.ASSIGNMENT
            email = createAssignment.email
            subject = createAssignment.subject
            referenceAssignmentId = createAssignment.assignmentid
            previousAssignmentType = createAssignment.assignmentType
        }

        questionSet
    }

    List<Question> generateQuestionsList(CreateAssignment createAssignment){

        List<Question> questions = new ArrayList()

        for(int i = 0; i < createAssignment.questions.size() ; i++) {

            Question question = new Question()
            if (createAssignment.assignmentType == AssignmentType.OBJECTIVE) {
                question.options = generateOptions(createAssignment.options[i], createAssignment.validity[i])
            } else if (createAssignment.assignmentType == AssignmentType.CODING) {
                question.testCases = generateTestCases(createAssignment.inputs[i], createAssignment.outputs[i])
            }
            question.with {
                questionDescription = createAssignment.questions[i]
                questionType = QuestionType.valueOf(createAssignment.assignmentType.toString())
            }
            questions.add(question)
        }

        questions
    }

    List<Options> generateOptions(String[] questionOptions, int[] questionValidity) {

        List<Options> options = new ArrayList<>()

        questionOptions.eachWithIndex { desc, index ->
            Options option = new Options()
            option.optionDescription = desc
            option.isCorrect = questionValidity.contains(index)
            options.add(option)
            }

        options
    }

    List<TestCases> generateTestCases(String[] inputs, String[] outputs){

        List<TestCases> testCases = new ArrayList<>()

        inputs.eachWithIndex{ String input, int index ->
            TestCases testCase = new TestCases()
            testCase.inputs = input
            testCase.outputs = outputs[index]
            testCases.add(testCase)
        }

        testCases
    }

//    String getOrganizationName(String email){
//
//        User user = getUser(email)
//        user.college
//
//    }
//
//    User getUser(String email){
//
//        def baseUrl = new URL("http://localhost:8080/get/user?email=${email}")
//        HttpURLConnection connection = (HttpURLConnection) baseUrl.openConnection()
//        connection.addRequestProperty("Accept", "application/json")
//        connection.with {
//            doOutput = true
//            requestMethod = 'GET'
//        }
//        log.info(connection.responseCode.toString())
//        log.info(connection.toString())
//        JsonSlurper jsonSlurper = new JsonSlurper()
//        log.info("text is : ${new URL("http://localhost:8080/get/user?email=${email}").text}")
//        User user = jsonSlurper.parseText(new URL("http://localhost:8080/get/user?email=${email}").text)
//        log.info("user is ${user}")
//        user
//    }
}
