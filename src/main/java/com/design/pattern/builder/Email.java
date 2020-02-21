package com.design.pattern.builder;

import com.google.common.base.Strings;
import org.apache.commons.collections4.CollectionUtils;

import java.util.LinkedHashSet;
import java.util.Set;

public final class Email {
    private String from;
    private Set<String> to;
    private Set<String> cc;
    private Set<String> bcc;
    private String subject;
    private String content;

    private Email(EmailBuilder emailBuilder) {
        //Step 1: Make the public constructor private and input type as Builder
        this.from = emailBuilder.from;
        this.to = emailBuilder.to;
        this.cc = emailBuilder.cc;
        this.bcc = emailBuilder.bcc;
        this.subject = emailBuilder.subject;
        this.content = emailBuilder.content;
    }

    @Override
    public String toString() {
        return "Email{" +
                "from=" + from +
                ", to=" + to +
                ", cc=" + cc +
                ", bcc=" + bcc +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    //Step 2: Define interfaces to set data in the Builder Class
    // Interface to Set From
    interface EmailFrom {
        EmailTo setFrom(String from);
    }

    //Interface to Set To
    interface EmailTo {
        EmailSubject setTo(String to);
    }

    //Interface to Set subject
    interface EmailSubject {
        EmailSubject setTo(String to);

        EmailContent setSubject(String subject);
    }

    // Interface to set Content
    interface EmailContent {
        EmailCreator setContent(String content);
    }

    // Final Email Creator Class
    interface EmailCreator {
        EmailCreator setBCC(String bcc);

        EmailCreator setCC(String cc);

        Email build();
    }

    public static class EmailBuilder implements EmailFrom, EmailTo, EmailSubject, EmailContent, EmailCreator {
        private String from;
        private Set<String> to = new LinkedHashSet<String>();
        ;
        private Set<String> cc = new LinkedHashSet<String>();
        ;
        private Set<String> bcc = new LinkedHashSet<String>();
        ;
        private String subject;
        private String content;

        public EmailBuilder() {
        }

        public static EmailBuilder getInstance() {
            return new EmailBuilder();
        }

        public EmailTo setFrom(String from) {
            this.from = from;
            return this;
        }

        public EmailSubject setTo(String to) {
            if(!Strings.isNullOrEmpty(to)) {
                this.to.add(to);
            }
            return this;
        }

        public EmailContent setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public EmailCreator setContent(String content) {
            this.content = content;
            return this;
        }

        public EmailCreator setBCC(String bcc) {
            if(!Strings.isNullOrEmpty(bcc)) {
                this.bcc.add(bcc);
            }
            return this;
        }

        public EmailCreator setCC(String cc) {
            if(!Strings.isNullOrEmpty(cc)) {
                this.cc.add(cc);
            }
            return this;
        }

        public Email build() {
            if (Strings.isNullOrEmpty(this.from)) {
                throw new IllegalArgumentException("Sender Address cannot be null or empty.");
            }
            if (CollectionUtils.isEmpty(to) && CollectionUtils.isEmpty(cc) && CollectionUtils.isEmpty(bcc)) {
                throw new IllegalArgumentException("Recipient Address cannot be null or empty.");
            }
            return new Email(this);
        }
    }
}