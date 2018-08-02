package com.beyondclass.common.teachernetwork.api.converters

import com.beyondclass.common.teachernetwork.api.converters.user.UserDetails
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TupleConstructor
import org.hibernate.validator.constraints.NotEmpty

import javax.validation.constraints.NotNull

/**
 * Created by GnyaniMac on 02/10/17.
 */

@EqualsAndHashCode
@ToString
@TupleConstructor
class CreateAssignment {

    @JsonProperty
    @NotNull
    @NotEmpty
    String assignmentid

    @JsonProperty
    @NotEmpty
    @NotNull
    String email

    @JsonProperty
    @NotEmpty
    @NotNull
    String propicurl

    @JsonProperty
    @NotEmpty
    @NotNull
    Date createDate

    @JsonProperty
    String subject

    @JsonProperty
    @NotEmpty
    @NotNull
    String batch

    @JsonProperty
    @NotEmpty
    @NotNull
    Date lastdate

    @JsonProperty
    @NotEmpty
    @NotNull
    String  message

    @JsonProperty
    @NotEmpty
    @NotNull
    Object[] questions

    @JsonProperty
    @NotEmpty
    @NotNull
    AssignmentType assignmentType

    @JsonProperty
    @NotEmpty
    @NotNull
    int numberOfQuesPerStudent

    Author author

    @JsonProperty
    List<String []> inputs

    @JsonProperty
    List<String []> outputs

    HashMap<String,List<Integer>> studentQuestionMapping

    @JsonProperty
    List<String[]> options;

    @JsonProperty
    List<int[]> validity;

    HashSet<String> submittedstudents

    HashMap<String,Date> submittedDates
}
