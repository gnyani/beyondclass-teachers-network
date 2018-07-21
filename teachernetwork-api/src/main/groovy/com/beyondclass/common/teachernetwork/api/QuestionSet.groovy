package com.beyondclass.common.teachernetwork.api

import com.beyondclass.common.teachernetwork.api.Constants.DifficultyLevel
import com.beyondclass.common.teachernetwork.api.Constants.QuestionSetType
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "networkquestionset")
@ToString
@EqualsAndHashCode
class QuestionSet {

    @Id
    String id;

    @JsonProperty
    String questionSetDescription

    @JsonProperty
    List<Question> questionsList

    @JsonProperty
    DifficultyLevel difficultyLevel

    @JsonProperty
    QuestionSetType questionSetType

    Date createdAt = new Date()

    @JsonProperty
    @Indexed
    String email

    @JsonProperty
    String organizationName

    @JsonProperty
     List<String> likedBy

    @JsonProperty
    List<Comment> comments

}
