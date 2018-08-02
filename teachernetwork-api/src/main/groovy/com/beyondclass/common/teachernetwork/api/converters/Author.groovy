package com.beyondclass.common.teachernetwork.api.converters

import com.beyondclass.common.teachernetwork.api.converters.user.UserDetails
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Created by Gnyani on 30/07/18.
 */
@ToString
@EqualsAndHashCode
class Author {

    UserDetails realOwner

    String questionSetReferenceId
}
