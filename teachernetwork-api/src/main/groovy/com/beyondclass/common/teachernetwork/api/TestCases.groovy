package com.beyondclass.common.teachernetwork.api

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by Gnyani on 21/07/18.
 */
class TestCases {

    @JsonProperty
    String[] inputs

    @JsonProperty
    String[] outputs
}
