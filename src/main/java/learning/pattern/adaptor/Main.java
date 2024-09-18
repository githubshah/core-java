package learning.pattern.adaptor;


import java.util.ArrayList;
import java.util.List;

abstract class Device {
    abstract void load();
}

interface USB {
    public void attach(Device device);
    void loadDevice();
}

class UniversalUSBAdapter implements USB {

    List<Device> list = new ArrayList<>();

    @Override
    public void attach(Device device) {
        list.add(device);
    }

    @Override
    public void loadDevice() {
        list.forEach(Device::load);
    }
}

class Mouse extends Device {

    @Override
    void load() {
        System.out.println("load Mouse");
    }
}

class Keyboard extends Device {
    @Override
    void load() {
        System.out.println("load Keyboard");
    }
}

class Computer {

    private USB usb;

    public Computer(USB universalUSB) {
        this.usb = universalUSB;
    }

    public void on() {
        usb.loadDevice();
    }
}


public class Main {
    public static void main(String[] args) {
        // Create a universal USB adapter for all devices
        USB universalUSB = new UniversalUSBAdapter();
        universalUSB.attach(new Mouse());
        universalUSB.attach(new Keyboard());

        // Create a computer instance with the universal USB
        Computer computer = new Computer(universalUSB);

        // Attach devices to the computer via USB
        computer.on();
    }
}



