package smarthome;

public abstract class SmartDevice implements Powerable {

    protected String deviceName;
    protected boolean isOn;

    // Global count of devices that are currently ON
    protected static int activeDevicesCount = 0;

    public SmartDevice(String deviceName) {
        this.deviceName = deviceName;
        this.isOn = false; // default OFF
    }

    // Common power logic for ALL smart devices
    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            activeDevicesCount++;
            System.out.println(deviceName + " is now ON.");
        } else {
            System.out.println(deviceName + " is already ON.");
        }
    }

    @Override
    public void turnOff() {
        if (isOn) {
            isOn = false;
            activeDevicesCount--;
            System.out.println(deviceName + " is now OFF.");
        } else {
            System.out.println(deviceName + " is already OFF.");
        }
    }

    public static int getActiveDevicesCount() {
        return activeDevicesCount;
    }

    // Every concrete device must define its own diagnostic
    public abstract void performSelfDiagnostic();
}
