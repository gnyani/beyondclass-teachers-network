package com.beyondclass.common.teachernetwork.api

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.TupleConstructor

@TupleConstructor
class Comment {
      @JsonProperty
    String username
    @JsonProperty
  String commentcontent;
    Date date=new Date();
}
