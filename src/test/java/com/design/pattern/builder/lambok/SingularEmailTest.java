package com.design.pattern.builder.lambok;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingularEmailTest {
    @Test
    public void buildEmailWithSingleRecipient() {
        SingularEmail email = SingularEmail.builder()
                .from("yoda@gmail.com")
                .to("darkside@gmail.com")
                .subject("The Mandalorian")
                .content("I am back.")
                .build();
        assertEquals("", "SingularEmail(" +
                "from=yoda@gmail.com, " +
                "to=[darkside@gmail.com], " +
                "cc=[], " +
                "bcc=[], " +
                "subject=The Mandalorian, " +
                "content=I am back.)", email.toString());

    }
}
