package com.beyondclass.common.teachernetwork.api

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "networkquestionset")
@ToString
@EqualsAndHashCode
class QuestionSet {
   ObjectId id;
    @JsonProperty
    String questionsetdescription
    @JsonProperty
    List<String> questionids
}
