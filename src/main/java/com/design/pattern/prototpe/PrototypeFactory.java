package com.design.pattern.prototpe;

import com.google.common.base.Strings;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

interface Person {
    Person clone();
}

class Tom implements Person {
    private static final String NAME = "Tom";

    @Override
    public String toString() {
        return NAME;
    }

    @Override
    public Person clone() {
        return new Tom();
    }
}

class Dick implements Person {
    private static final String NAME = "Dick";

    @Override
    public String toString() {
        return NAME;
    }

    @Override
    public Person clone() {
        return new Dick();
    }
}

class Harry implements Person {
    private static final String NAME = "Harry";

    @Override
    public String toString() {
        return NAME;
    }

    @Override
    public Person clone() {
        return new Harry();
    }
}

public class PrototypeFactory {
    private static final Map<String, Person> personObjectByName = new HashMap<>();

    static {
        personObjectByName.put("TOM", new Tom());
        personObjectByName.put("DICK", new Dick());
        personObjectByName.put("HARRY", new Harry());
    }

    public static Person getInstance(String type) {
        if(Strings.isNullOrEmpty(type)) {
            return null;
        }
        return personObjectByName.get(type.toUpperCase(Locale.ENGLISH)).clone();
    }
}