package com.beyondclass.common.teachernetwork.Service

import com.beyondclass.common.teachernetwork.Constants.EmailTypes
import groovy.text.SimpleTemplateEngine
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

/**
 * Created by GnyaniMac on 15/01/18.
 */
@Component
class EmailUtils {

    @Value('${beyondclass.host}')
    private String hostName

    public String createEmailMessage(EmailTypes type, String ... strings){

        String message = "";

        String sender = strings[0]

        String college = strings[1].toLowerCase()

        if (type == EmailTypes.PULL_NOTIFICATION)
        {
            def emailTemplate = getClass().getResource("/Assignment_Pulled.html")
            Map<String,String> config = new HashMap<>()
            config.put("hostname","${college}.${hostName}")
            config.put("sender", sender)
            config.put("college", college)
            def engine = new SimpleTemplateEngine()
            def template = engine.createTemplate(emailTemplate).make(config)
            message = template.toString()
        }
        return message
    }

    public String createSubject(EmailTypes type){

        String subject = ""
        if(type == EmailTypes.PULL_NOTIFICATION)
            subject = "Your assignment is getting traction on BeyondClass"
        return subject
    }
}
