package com.design.pattern.builder;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmailTest {

    @Test
    public void buildEmailWithSingleRecipient() {
        Email email = Email.EmailBuilder.getInstance()
                .setFrom("yoda@gmail.com")
                .setTo("darkside@gmail.com")
                .setTo("darkside@gmail.com")
                .setSubject("The Mandalorian")
                .setContent("I am back.")
                .build();
        assertEquals("", "Email{" +
                "from=[yoda@gmail.com], " +
                "to=[darkside@gmail.com], " +
                "cc=[], " +
                "bcc=[], " +
                "subject='The Mandalorian', " +
                "content='I am back.'}", email.toString());
    }

    @Test
    public void buildEmailWithMultipleRecipient() {
        Email email = Email.EmailBuilder.getInstance()
                .setFrom("yoda@gmail.com")
                .setTo("skywalker@gmail.com")
                .setTo("darkside@gmail.com")
                .setSubject("The Mandalorian")
                .setContent("I am back.")
                .build();
        assertEquals("", "Email{" +
                "from=[yoda@gmail.com], " +
                "to=[skywalker@gmail.com, darkside@gmail.com], " +
                "cc=[], bcc=[], " +
                "subject='The Mandalorian', " +
                "content='I am back.'}", email.toString());
    }
}
