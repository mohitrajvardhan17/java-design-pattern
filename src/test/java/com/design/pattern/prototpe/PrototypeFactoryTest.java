package com.design.pattern.prototpe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class PrototypeFactoryTest {


    @Test
    public void getInstance() {
        Person tom = PrototypeFactory.getInstance("tom");
        assertNotNull(tom);
        assertEquals("", "Tom", tom.toString());
        Person dick = PrototypeFactory.getInstance("dick");
        assertNotNull(dick);
        assertEquals("", "Dick", dick.toString());
        Person harry = PrototypeFactory.getInstance("harry");
        assertNotNull(harry);
        assertEquals("", "Harry", harry.toString());
        Person nullEmpty = PrototypeFactory.getInstance("");
        assertNull(nullEmpty);
        Person nullCheck = PrototypeFactory.getInstance(null);
        assertNull(nullCheck);
    }
}
