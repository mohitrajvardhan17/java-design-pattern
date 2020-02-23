package com.design.pattern.builder.lombok;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class MessageEmailTest {
    @Test
    public void buildEmailWithSingleRecipient() {
        MessageEmail email = MessageEmail.builder()
                .from("yoda@gmail.com")
                .to(new HashSet<>() {{ add("darkside@gmail.com"); }})
                .subject("The Mandalorian")
                .content("I am back.")
                .build();
        assertEquals("", "MessageEmail(" +
                "from='yoda@gmail.com', " +
                "to=[darkside@gmail.com], " +
                "cc=null, " +
                "bcc=null, " +
                "subject=The Mandalorian, " +
                "content='I am back.')", email.toString());

    }
}
