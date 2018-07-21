package com.beyondclass.common.teachernetwork.api

import com.beyondclass.common.teachernetwork.api.Constants.QuestionType
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
 class Question {

    @JsonProperty
    String questionDescription

    @JsonProperty
    List<Options> options

    @JsonProperty
    List<TestCases> testCases

    @JsonProperty
    QuestionType questionType

    @JsonProperty
    int marks

    @JsonProperty
    boolean negativeMarkingRequired

    @JsonProperty
    int negativeMarks

    @JsonProperty
    boolean requiredAttachment

}
