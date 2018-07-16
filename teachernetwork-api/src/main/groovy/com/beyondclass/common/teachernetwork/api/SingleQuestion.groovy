package com.beyondclass.common.teachernetwork.api;

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;

@Document(collection = "networkquestions")
@ToString
@EqualsAndHashCode
 class SingleQuestion {
    ObjectId id;

    @JsonProperty

    String questionDescription;

    @JsonProperty
     HashMap answer;

}
