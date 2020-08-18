public class PatternFactoryDemo {
    public static void main(String[] args) {
        DeviceFactory factory = new DeviceFactory();
        Device beta1Device = DeviceFactory.getDevice("BETA1DELL10", "Beta1");
        beta1Device.healthCheck();
        Device powerstoreDevice = DeviceFactory.getDevice("POWERSTORE99", "powerstore");
        powerstoreDevice.healthCheck();
        Device vmaxDevice = DeviceFactory.getDevice("VMAX1000", "VMAX");
        vmaxDevice.healthCheck();
        Device unknownDevice = DeviceFactory.getDevice("STU2636DD", "unknown");
        unknownDevice.healthCheck();
    }   
}

class DeviceFactory {
    public static Device getDevice(String serial, String model) {
        if(model.equalsIgnoreCase("BETA1")) {
            return new Beta1(serial, Model.BETA1);
        } else if(model.equalsIgnoreCase("BETA2")) {
            return new Beta2(serial, Model.BETA2);
        } else if(model.equalsIgnoreCase("POWERSTORE")) {
            return new Powerstore(serial, Model.POWERSTORE);
        } else if(model.equalsIgnoreCase("VMAX")) {
            return new Vmax(serial, Model.VMAX);
        } else {
            throw new IllegalArgumentException("Invalid model " + model + " specified");
        }
    }
}

abstract class Device {
    private String serial;
    private Model model;

    public Device(String serial, Model model) {
        this.serial = serial;
        this.model = model;
    }

    public abstract void healthCheck();
}

class Beta1 extends Device {
    public Beta1(String serial, Model model) {
        super(serial, model);
    }
    @Override
    public void healthCheck() {
        System.out.println("BETA1 device is up");
    }
}

class Beta2 extends Device {
    public Beta2(String serial, Model model) {
        super(serial, model);
    }
    @Override
    public void healthCheck() {
        System.out.println("BETA2 device is up");
    }
}

class Powerstore extends Device {
    public Powerstore(String serial, Model model) {
        super(serial, model);
    }
    @Override
    public void healthCheck() {
        System.out.println("Powerstore device is up");
    }
}

class Vmax extends Device {
    public Vmax(String serial, Model model) {
        super(serial, model);
    }
    @Override
    public void healthCheck() {
        System.out.println("VMAX device is up");
    }
}

enum Model {
    BETA1, BETA2, POWERSTORE, VMAX
}
