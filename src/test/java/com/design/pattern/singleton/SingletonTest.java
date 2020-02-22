package com.design.pattern.singleton;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SingletonTest {

    @Test
    public void getInstanceCheckUnderNonMultithreadedCondition() {
        Singleton instanceOne = Singleton.INSTANCE.getInstance();
        Singleton instanceTwo = Singleton.INSTANCE.getInstance();
        assertEquals("", instanceOne.hashCode(), instanceTwo.hashCode());
    }

    @Test
    public void getInstanceCheckUnderMultithreadedCondition() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Singleton instanceOne = executorService.submit(Singleton.INSTANCE::getInstance).get();
        Singleton instanceTwo = executorService.submit(Singleton.INSTANCE::getInstance).get();
        Singleton instanceThree = executorService.submit(Singleton.INSTANCE::getInstance).get();
        Singleton instanceFour = executorService.submit(Singleton.INSTANCE::getInstance).get();
        Singleton instanceFive = executorService.submit(Singleton.INSTANCE::getInstance).get();
        executorService.shutdown();
        assertEquals("", instanceOne.hashCode(), instanceTwo.hashCode());
        assertEquals("", instanceOne.hashCode(), instanceThree.hashCode());
        assertEquals("", instanceOne.hashCode(), instanceFour.hashCode());
        assertEquals("", instanceOne.hashCode(), instanceFive.hashCode());
    }

    @Test(expected = NoSuchMethodException.class)
    public void getInstanceCheckUnderReflectionThreat()
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Singleton.class;
        Constructor<Singleton> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton instanceTwo = constructor.newInstance();
    }

    @Test
    public void getInstanceCheckUnderSerializationThreat() throws IOException, ClassNotFoundException {
        Singleton instanceOne = Singleton.INSTANCE.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serial.txt"));
        oos.writeObject(instanceOne);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serial.txt"));
        Singleton instanceTwo = (Singleton) ois.readObject();
        assertNotNull("", instanceOne);
        assertNotNull("", instanceTwo);
        assertEquals("", instanceOne.hashCode(), instanceTwo.hashCode());
    }

    @Test
    public void getInstanceCheckUnderCloneThreat() {
        Singleton instanceOne = Singleton.INSTANCE.getInstance();
        //Enum has protected access to clone method
        //Singleton instanceTwo = (Singleton) instanceOne.clone();
        Singleton instanceTwo = instanceOne;
        assertNotNull("", instanceOne);
        assertNotNull("", instanceTwo);
        assertEquals("", instanceOne.hashCode(), instanceTwo.hashCode());
    }

}
