package com.beyondclass.common.teachernetwork.api

import com.fasterxml.jackson.annotation.JsonProperty

class Options {

    @JsonProperty
    String optionDescription

    @JsonProperty
    boolean isCorrect

}
