package com.design.pattern.abstarctfactory;

interface Wing {
    Wing buildWing();
}

class F16Wing implements Wing {

    @Override
    public Wing buildWing() {
        System.out.println("Building F16 Wing!!!");
        return new F16Wing();
    }
}

class F16AWing implements Wing {

    @Override
    public Wing buildWing() {
        System.out.println("Building F16A Wing!!!");
        return new F16AWing();
    }
}

class Mig35Wing implements Wing {

    @Override
    public Wing buildWing() {
        System.out.println("Building MIG-35 Wing!!!");
        return new Mig35Wing();
    }
}

interface Engine {
    Engine buildEngine();
}

class F16Engine implements Engine {

    @Override
    public Engine buildEngine() {
        System.out.println("Building F16 Engine!!!");
        return new F16Engine();
    }
}

class F16AEngine implements Engine {

    @Override
    public Engine buildEngine() {
        System.out.println("Building F16A Engine!!!");
        return new F16AEngine();
    }
}

class Mig35Engine implements Engine {

    @Override
    public Engine buildEngine() {
        System.out.println("Building MIG-35 Engine!!!");
        return new Mig35Engine();
    }
}

interface Cockpit {
    Cockpit buildCockpit();
}

class F16Cockpit implements Cockpit {

    @Override
    public Cockpit buildCockpit() {
        System.out.println("Building F16 Cockpit!!!");
        return new F16Cockpit();
    }
}

class F16ACockpit implements Cockpit {

    @Override
    public Cockpit buildCockpit() {
        System.out.println("Building F16A Cockpit!!!");
        return new F16ACockpit();
    }
}

class Mig35Cockpit implements Cockpit {

    @Override
    public Cockpit buildCockpit() {
        System.out.println("Building MIG-35 Cockpit!!!");
        return new Mig35Cockpit();
    }
}

interface Aircraft {
    Wing createWing();

    Engine createEngine();

    Cockpit createCockpit();

    Aircraft getAircraft();
}

class F16 implements Aircraft {
    private Wing wing;
    private Engine engine;
    private Cockpit cockpit;

    public F16() {

    }

    private F16(Wing wing, Engine engine, Cockpit cockpit) {
        this.wing = wing;
        this.engine = engine;
        this.cockpit = cockpit;
    }

    @Override
    public Wing createWing() {
        System.out.println("Creating F16 Wing!!!");
        return new F16Wing();
    }

    @Override
    public Engine createEngine() {
        System.out.println("Creating F16 Engine!!!");
        return new F16Engine();
    }

    @Override
    public Cockpit createCockpit() {
        System.out.println("Creating F16 Cockpit!!!");
        return new F16Cockpit();
    }

    @Override
    public Aircraft getAircraft() {
        System.out.println("Creating F16 Components!!!");
        Wing wing = this.createWing();
        Engine engine = this.createEngine();
        Cockpit cockpit = this.createCockpit();
        System.out.println("Creating F16!!!");
        return new F16(wing, engine, cockpit);
    }
}

class F16A extends F16 {
    public F16A() {
    }

    @Override
    public Wing createWing() {
        System.out.println("Creating F16A Wing!!!");
        return new F16AWing();
    }

    @Override
    public Engine createEngine() {
        System.out.println("Creating F16A Engine!!!");
        return new F16AEngine();
    }

    @Override
    public Cockpit createCockpit() {
        System.out.println("Creating F16A Cockpit!!!");
        return new F16ACockpit();
    }
}

class Mig35 implements Aircraft {
    private Wing wing;
    private Engine engine;
    private Cockpit cockpit;

    public Mig35() {

    }

    public Mig35(Wing wing, Engine engine, Cockpit cockpit) {
        this.wing = wing;
        this.engine = engine;
        this.cockpit = cockpit;
    }

    @Override
    public Wing createWing() {
        System.out.println("Creating MIG-35 Wing!!!");
        return new Mig35Wing();
    }

    @Override
    public Engine createEngine() {
        System.out.println("Creating MIG-35 Engine!!!");
        return new Mig35Engine();
    }

    @Override
    public Cockpit createCockpit() {
        System.out.println("Creating MIG-35 Cockpit!!!");
        return new Mig35Cockpit();
    }

    @Override
    public Aircraft getAircraft() {
        System.out.println("Creating MIG-35 Components!!!");
        Wing wing = this.createWing();
        Engine engine = this.createEngine();
        Cockpit cockpit = this.createCockpit();
        System.out.println("Creating MIG-35!!!");
        return new Mig35(wing, engine, cockpit);
    }
}

interface AircraftAbstractFactory {
    Aircraft createAircraft();
}

enum F16AbstractFactory implements AircraftAbstractFactory {
    F16(F16.class),
    F16A(F16A.class);

    private F16 f16;

    F16AbstractFactory(Class<?> clazz) {
        try {
            this.f16 = (F16) clazz.getConstructor().newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Failed to create instance.");
        }
    }

    @Override
    public Aircraft createAircraft() {
        System.out.println("Creating F16 using F16AbstractFactory!!!");
        return f16.getAircraft();
    }
}

enum Mig35AbstractFactory implements AircraftAbstractFactory {
    MIG35(Mig35.class);

    private Mig35 mig35;

    Mig35AbstractFactory(Class<?> clazz) {
        try {
            this.mig35 = (Mig35) clazz.getConstructor().newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Failed to create instance.");
        }
    }

    @Override
    public Aircraft createAircraft() {
        System.out.println("Creating MIG-35 using F16AbstractFactory!!!");
        return mig35.getAircraft();
    }
}

interface AircraftFactory {
    static Aircraft getAircraft(AircraftAbstractFactory aircraftAbstractFactory) {
        System.out.println("Getting Aircraft using AircraftFactory!!!");
        return aircraftAbstractFactory.createAircraft();
    }
}


public class AbstractFactory {
    public static void main(String[] args) {
        Aircraft aircraftF16 = AircraftFactory.getAircraft(F16AbstractFactory.F16);
        Aircraft aircraftF16A = AircraftFactory.getAircraft(F16AbstractFactory.F16A);
        Aircraft aircraftMig35 = AircraftFactory.getAircraft(Mig35AbstractFactory.MIG35);
    }
}
