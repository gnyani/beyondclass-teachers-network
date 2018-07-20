package com.beyondclass.common.teachernetwork.api

import com.beyondclass.common.teachernetwork.api.Constants.DifficultyLevel
import com.beyondclass.common.teachernetwork.api.Constants.QuestionSetType
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "networkquestionset")
@ToString
@EqualsAndHashCode
class QuestionSet {
    @Id
    String id;
    @JsonProperty
    String questionsetdescription
    @JsonProperty
    ArrayList<String> questionids
    @JsonProperty
    @Transient
    List<SingleQuestion> questionslist
    @JsonProperty
    DifficultyLevel difficultyLevel
    @JsonProperty
    QuestionSetType questionSetType
    Date createdAt = new Date();
    @JsonProperty
    String email
    @JsonProperty
    String organizationname
    //definition for questions network post attributes
    @JsonProperty
     List<String> LikedBy
    @JsonProperty
    List<Comment> Comments


}
