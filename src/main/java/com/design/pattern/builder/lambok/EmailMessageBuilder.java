package com.design.pattern.builder.lambok;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Data
/**
 * If we want to create copies or near-copies of objects, we can add the property toBuilder = true to the @Builder
 * annotation:
 * Todo:Find difference between copies or near-copies of objects
 */
@Builder(toBuilder = true)
class Messages {
    private String content;
}

/**
 * In case the superclass is itself annotated with @Builder, we'll get the following error when annotating the Child
 * class' constructor:
 * <p>
 * The return type is incompatible with Parent.builder()
 * <p>
 * This is because the Child class is trying to expose both the Builders with the same name.
 */

/**
 * Solution
 **/
@ToString
@Getter
public class EmailMessageBuilder extends Messages {
    private String from;
    private Set<String> to;
    private Set<String> cc;
    private Set<String> bcc;
    private String subject;

    /**
     * We can fix this problem by assigning a unique name to at least one of the builder methods:
     * <p>
     * We'll then be able to obtain a ParentBuilder through Messages.builder() and a ChildBuilder through
     * EmailMessageBuilder.EmailMessageBuilder().
     */
    @Builder(builderMethodName = "EmailMessageBuilder")
    public EmailMessageBuilder(String content, String from, Set<String> to, Set<String> cc,
                               Set<String> bcc, String subject) {
        super(content);
        this.from = from;
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.subject = subject;

    }

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
