package com.design.pattern.builder.lambok;

import lombok.Builder;
import lombok.Value;

import java.util.Set;

/**
 * Lombok's @Value annotation: https://www.baeldung.com/intro-to-project-lombok
 * @Value is the immutable variant of @Data
 */
@Value
final class EmailMessage {
    private String from;
    private Set<String> to;
    private Set<String> cc;
    private Set<String> bcc;
    private String subject;
    private String content;
}

/**
 * We covered how to use @Builder on a Class, but we can use it on methods, too. We'll use this ability to work
 * around not being able to modify or extend ImmutableClient.
 */
public class FinalEmail {

    /**
     * This annotation creates a method named builder() that returns a Builder for creating ImmutableClients.
     */
    @Builder(builderMethodName = "builder")
    public static EmailMessage newEmail(String from, Set<String> to, Set<String> cc, Set<String> bcc, String subject,
                                        String content) {
        return new EmailMessage(from, to, cc, bcc, subject, content);
    }
}
