package com.design.pattern.abstarctfactory;

import org.junit.Test;

import static org.junit.Assert.*;

public class AircraftFactoryTest {

    @Test
    public void getAircraft() {
        assertEquals("", F16AbstractFactory.F16, F16AbstractFactory.F16);
        Aircraft aircraftF16One = AircraftFactory.getAircraft(F16AbstractFactory.F16);
        Aircraft aircraftF16Two = AircraftFactory.getAircraft(F16AbstractFactory.F16);
        assertNotNull("", aircraftF16One);
        assertNotNull("", aircraftF16Two);
        assertNotEquals("", aircraftF16One, aircraftF16Two);

        assertEquals("", F16AbstractFactory.F16A, F16AbstractFactory.F16A);
        Aircraft aircraftF16AOne = AircraftFactory.getAircraft(F16AbstractFactory.F16A);
        Aircraft aircraftF16ATwo = AircraftFactory.getAircraft(F16AbstractFactory.F16A);
        assertNotNull("", aircraftF16AOne);
        assertNotNull("", aircraftF16ATwo);
        assertNotEquals("", aircraftF16AOne, aircraftF16ATwo);

        assertEquals("", Mig35AbstractFactory.MIG35, Mig35AbstractFactory.MIG35);
        Aircraft aircraftMig35One = AircraftFactory.getAircraft(Mig35AbstractFactory.MIG35);
        Aircraft aircraftMig35Two = AircraftFactory.getAircraft(Mig35AbstractFactory.MIG35);
        assertNotNull("", aircraftMig35One);
        assertNotNull("", aircraftMig35Two);
        assertNotEquals("", aircraftMig35One, aircraftMig35Two);
    }
}
