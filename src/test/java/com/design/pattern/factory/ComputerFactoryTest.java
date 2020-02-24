package com.design.pattern.factory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ComputerFactoryTest {

    @Test
    public void getComputerCheckForPC() {
        Computer computer = ComputerFactory.getComputer("pc", "2gb", "1tb", "i9");
        assertNotNull("", computer);
        assertTrue("", computer instanceof PC);
        assertEquals("", "2gb", computer.getRAM());
        assertEquals("", "1tb", computer.getHDD());
        assertEquals("", "i9", computer.getCPU());
    }

    @Test
    public void getComputerCheckForServer() {
        Computer computer = ComputerFactory.getComputer("server", "2gb", "1tb", "i9");
        assertNotNull("", computer);
        assertTrue("", computer instanceof Server);
        assertEquals("", "2gb", computer.getRAM());
        assertEquals("", "1tb", computer.getHDD());
        assertEquals("", "i9", computer.getCPU());
    }

    @Test
    public void getComputerCheckForNullType() {
        Computer computer = ComputerFactory.getComputer(null, "2gb", "1tb", "i9");
        assertNull("", computer);
    }

    @Test
    public void getComputerCheckForEmptyType() {
        Computer computer = ComputerFactory.getComputer("", "2gb", "1tb", "i9");
        assertNull("", computer);
    }

    @Test
    public void getComputerCheckForInvalidType() {
        Computer computer = ComputerFactory.getComputer("abc", "2gb", "1tb", "i9");
        assertNull("", computer);
    }
}
