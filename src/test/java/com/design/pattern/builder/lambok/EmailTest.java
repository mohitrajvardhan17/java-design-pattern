package com.design.pattern.builder.lambok;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmailTest {
    @Test
    public void buildEmailWithSingleRecipient() {
        Email email = new Email.EmailBuilder()
                .from("yoda@gmail.com")
                .to("darkside@gmail.com")
                .subject("The Mandalorian")
                .content("I am back.")
                .build();
        assertEquals("", "Email(" +
                "from=yoda@gmail.com, " +
                "to=[darkside@gmail.com], " +
                "cc=null, " +
                "bcc=null, " +
                "subject=The Mandalorian, " +
                "content=I am back.)", email.toString());

    }
}
