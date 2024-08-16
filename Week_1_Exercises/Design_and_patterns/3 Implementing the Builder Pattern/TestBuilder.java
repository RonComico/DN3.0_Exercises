// TestBuilder.java
public class TestBuilder {
    public static void main(String[] args) {
        // Create a Computer using the Builder pattern
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setGraphicsCardEnabled(false)
                .setBluetoothEnabled(true)
                .build();

        System.out.println(gamingPC);
        System.out.println(officePC);
    }
}
