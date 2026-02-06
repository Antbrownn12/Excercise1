package smarthome;

public class SmartThermostat extends SmartDevice implements Adjustable {

    private int temperature; // e.g., 60–80 degrees

    public SmartThermostat(String deviceName, int initialTemp) {
        super(deviceName);
        this.temperature = initialTemp;
    }

    @Override
    public void turnOn() {
        System.out.println(deviceName + ": HVAC System Starting...");
        // Reuse the common logic in SmartDevice
        super.turnOn();
    }

    @Override
    public void setLevel(int level) {
        // Level represents desired temperature
        if (level < 60 || level > 80) {
            System.out.println(deviceName + " - Invalid temperature: " +
                               level + " (must be between 60 and 80).");
            return;
        }

        temperature = level;
        System.out.println(deviceName + " temperature set to " + temperature + "°F.");
    }

    @Override
    public void performSelfDiagnostic() {
        System.out.println(deviceName + ": Running thermostat calibration...");
    }
}
