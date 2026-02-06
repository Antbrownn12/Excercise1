package smarthome;

public class SmartLight extends SmartDevice implements Adjustable {

    private int brightness; // 0–100

    public SmartLight(String deviceName) {
        super(deviceName);
        this.brightness = 0; // default brightness
    }

    @Override
    public void turnOn() {
        // Only change state if needed; SmartDevice handles the counter
        if (!isOn) {
            super.turnOn();  // updates isOn + activeDevicesCount
            System.out.println(deviceName + " brightness is " + brightness + "%.");
        } else {
            System.out.println(deviceName + " is already ON.");
        }
    }

    @Override
    public void turnOff() {
        if (isOn) {
            super.turnOff(); // updates isOn + activeDevicesCount
            brightness = 0;
            System.out.println(deviceName + " brightness reset to " + brightness + "%.");
        } else {
            System.out.println(deviceName + " is already OFF.");
        }
    }

    @Override
    public void setLevel(int level) {
        if (!isOn) {
            System.out.println(deviceName + " - Cannot adjust: Device is OFF.");
            return;
        }

        if (level < 0) {
            level = 0;
        } else if (level > 100) {
            level = 100;
        }

        brightness = level;
        System.out.println(deviceName + " brightness set to " + brightness + "%.");
    }

    @Override
    public void performSelfDiagnostic() {
        System.out.println(deviceName + ": Checking LED health...");
    }
}
