import java.util.Random;

public class UltrasonicTankMonitor {
    private static final int MOT = 6;
    private static final int MOT1 = 7;
    private static final int BUZ = 2;
    private static int md = 0;

    public static void main(String[] args) {
        setup();
        for (int i = 0; i < 10; i++) { // Simulate 10 readings
            loop();
            delay(2000); // Simulated delay between readings
        }
    }

    private static void setup() {
        System.out.println("WELCOME");
        System.out.println("TANK MONITORING SYSTEM");
        delay(2000);
    }

    private static void loop() {
        int distance = measureDistance();
        System.out.println("LEVEL: " + distance + " cm");

        uploadIoT(distance);
        char cmd = readIoT();

        if (cmd == '1') {
            md = 0;
        }
        if (md == 0) {
            if (cmd == '2') {
                System.out.println("Motor ON at speed 80%");
            }
            if (cmd == '3') {
                System.out.println("Motor OFF");
            }
        }
        if (cmd == '4') {
            System.out.println("Control Mode Activated");
        }
    }

    private static int measureDistance() {
        Random random = new Random();
        return random.nextInt(100); // Simulate distance measurement (0-99 cm)
    }

    private static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void uploadIoT(int data) {
        System.out.println("Uploading Data: " + data + " cm to IoT Server...");
    }

    private static char readIoT() {
        return '0'; // Simulated IoT command (change as needed)
    }
}
