package com.design.pattern.builder.lambok;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@SuperBuilder
class Message {
    private String content;
}

/**
 * When using @Builder on a class which extends another class like that, we'll get the following compilation error on
 * the annotation:
 * Implicit super constructor Parent() is undefined. Must explicitly invoke another constructor
 * <p>
 * This is due to the fact that Lombok doesn't take into account the fields of the superclasses, but only the ones
 * from the current class.
 *
 * @Getter
 * @Builder public class MessageEmail {
 * private String from;
 * private Set<String> to;
 * private Set<String> cc;
 * private Set<String> bcc;
 * private String subject;
 * }
 */

/**
 * Solution
 **/
@Data
@SuperBuilder
public class MessageEmail extends Message {
    private String from;
    private Set<String> to;
    private Set<String> cc;
    private Set<String> bcc;
    private String subject;

    @Override
    public String toString() {
        return "MessageEmail(" +
                "from='" + from + '\'' +
                ", to=" + to +
                ", cc=" + cc +
                ", bcc=" + bcc +
                ", subject=" + subject +
                ", content='" + super.getContent() + '\'' +
                ')';
    }
}