package com.beyondclass.common.teachernetwork.api

import com.beyondclass.common.teachernetwork.api.Constants.Options;
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.NotEmpty
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;

@Document(collection = "networkquestions")
@ToString
@EqualsAndHashCode
 class SingleQuestion {

    @Id
    String id;

    @JsonProperty

    String questionDescription;

    @JsonProperty
    List<Options> options

    @JsonProperty
    String QuestionType;
    @JsonProperty
    int marks
    @JsonProperty
    boolean negativemarkingrequired

    @JsonProperty
    int negativemarks

    @JsonProperty
    boolean requiredattachment

}
