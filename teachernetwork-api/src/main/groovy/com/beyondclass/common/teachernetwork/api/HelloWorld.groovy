package com.beyondclass.common.teachernetwork.api

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by Gnyani on 13/07/18.
 */

@ToString
@EqualsAndHashCode
@Document(collection =  "test")
class HelloWorld {

    @JsonProperty
    String name
}
