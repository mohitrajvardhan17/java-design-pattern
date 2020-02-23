package com.design.pattern.builder.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.Set;

/**
 * We've seen how the @Singular annotation helps us to work with collections in Lombok. Besides providing convenience
 * and expressiveness, it can also help us to keep our code clean.
 *
 * Immutable objects are defined as objects that cannot be modified once they are created. Immutability is important
 * in reactive architectures, for example, because it allows us to pass an object into a method with a guarantee of
 * no side effects. The Builder pattern is most commonly used as an alternative to POJO getters and setters in order
 * to support immutability.
 *
 * When our data objects contain Collection classes, it can be easy to let immutability slip a little. The base
 * collection interfaces — List, Set, and Map — all have mutable and immutable implementations. If we rely on the
 * standard Lombok builder, we can accidentally pass in a mutable collection, and then modify it:
 *
 * List<String> tags= new ArrayList();
 * tags.add("fictional");
 * tags.add("incidental");
 * Person person = Person.builder()
 *   .givenName("Aaron")
 *   .tags(tags)
 *   .build();
 * person.getTags().clear();
 * person.getTags().add("non-fictional");
 * person.getTags().add("important");
 *
 * We've had to work quite hard in this simple example to make the mistake. If we'd used Arrays.asList(), for
 * example, to construct the variable tags, we would've gotten an immutable list for free, and calls to add() or
 * clear() would throw an UnsupportedOperationException.
 *
 * In real coding, the error is more likely to occur if the collection is passed in as a parameter, for example.
 * However, it's good to know that with @Singular, we can work with the base Collection interfaces and get immutable
 * instances when we call build().
 */

@Data
@Builder
public class SingularEmail {
    private String from;
    /**
     * Lombok can handle the word “grasses”, but is lost with “fish”. In English, the singular and plural forms are
     * the same, strangely enough. This code won't compile, and we'll get an error:
     *
     * Can't singularize this name; please specify the singular explicitly (i.e. @Singular("sheep"))
     *
     * We can sort things out by adding a value to the annotation to use as the singular method name:
     * @Singular("oneFish") private final List<String> fish;
     */
    @Singular("to")
    private Set<String> to;
    @Singular("cc")
    private Set<String> cc;
    @Singular("bcc")
    private Set<String> bcc;
    private String subject;
    private String content;
}
