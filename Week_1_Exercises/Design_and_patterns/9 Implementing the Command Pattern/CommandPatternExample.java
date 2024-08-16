// CommandPatternExample.java

import java.util.Scanner;

// Step 2: Define Command Interface
interface Command {
    void execute();
}

// Step 3: Implement Concrete Commands
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Step 5: Implement Receiver Class
class Light {
    public void turnOn() {
        System.out.println("The light is on.");
    }

    public void turnOff() {
        System.out.println("The light is off.");
    }
}

// Step 4: Implement Invoker Class
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Step 6: Test the Command Implementation with User Interaction
public class CommandPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);
        RemoteControl remoteControl = new RemoteControl();

        while (true) {
            System.out.println("Select command:");
            System.out.println("1. Turn Light On");
            System.out.println("2. Turn Light Off");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    remoteControl.setCommand(lightOnCommand);
                    remoteControl.pressButton();
                    break;
                case 2:
                    remoteControl.setCommand(lightOffCommand);
                    remoteControl.pressButton();
                    break;
                case 3:
                    System.out.println("Exiting.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
