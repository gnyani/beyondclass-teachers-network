package com.beyondclass.common.teachernetwork.api

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.TupleConstructor
import org.hibernate.validator.constraints.NotEmpty

import javax.validation.constraints.NotNull

@TupleConstructor
class Comment {

      @NotEmpty
      @NotNull
      @JsonProperty
      String username

      @JsonProperty
      @NotNull
      @NotEmpty
      String commentContent

      Date date = new Date()
}
