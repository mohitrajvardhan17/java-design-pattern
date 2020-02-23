package com.design.pattern.builder.lombok;

import com.google.common.base.Strings;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The @Builder annotation can be used to automatically generate a builder for our class.
 * <p>
 * Todo:The @Builder annotation also supports default values for attributes but we won't go into that now.
 */
@Builder
/**
 * @Data generates all the boilerplate that is normally associated with a simple POJO (Plain Old Java Object):
 * getters for all fields, setters for all non-final fields, and appropriate toString, equals and hashCode
 * implementations, and a constructor.
 */
@Data
public class Email {
    private String from;
    private Set<String> to;
    private Set<String> cc;
    private Set<String> bcc;
    private String subject;
    private String content;

    /**
     * Customizing a Lombok builder is simple and straightforward: we write the parts of the builder that we want to
     * customize and the Lombok @Builder annotation will simply not generate those parts.
     */
    public static class EmailBuilder {
        private Set<String> to;
        private Set<String> cc;
        private Set<String> bcc;

        public EmailBuilder to(String to) {
            if (!Strings.isNullOrEmpty(to)) {
                if(CollectionUtils.isEmpty(this.to)) {
                    this.to = new LinkedHashSet<>();
                }
                this.to.add(to);
            }
            return this;
        }

        public EmailBuilder cc(String cc) {
            if (!Strings.isNullOrEmpty(cc)) {
                if(CollectionUtils.isEmpty(this.cc)) {
                    this.cc = new LinkedHashSet<>();
                }
                this.cc.add(cc);
            }
            return this;
        }

        public EmailBuilder bcc(String bcc) {
            if (!Strings.isNullOrEmpty(bcc)) {
                if(CollectionUtils.isEmpty(this.bcc)) {
                    this.bcc = new LinkedHashSet<>();
                }
                this.bcc.add(bcc);
            }
            return this;
        }
    }
}
