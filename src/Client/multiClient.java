package Client;

import java.io.*;
import java.net.*;
import java.util.*;

public class multiClient {
    static Scanner scanner;
    
    public static void main(String[] args)
    {
        scanner = new Scanner(System.in);
        Robot robot;
        Command command;
        boolean shouldContinue = true;

        try (
            Socket socket = new Socket("localhost", 8000)) 
            {
            System.out.println("Connected");
            
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
  
            Scanner input = new Scanner(System.in);

            String name = getInput("What do you want to name your robot?");
            robot = new Robot(name);
            System.out.println(robot.toString());

            do {
                String instruction = getInput(robot.getName() + "> What must I do next?").strip().toLowerCase();
                try {
                    command = Command.create(instruction);
                    shouldContinue = robot.handleCommand(command);
                } catch (IllegalArgumentException e) {
                    robot.setStatus("Sorry, I did not understand '" + instruction + "'.");
                }
                System.out.println(robot);
            } while (shouldContinue);
    
    

            try {
                in.close();
                // input.close();
                out.close();
                socket.close();
            } catch (Exception e) {
                System.out.println(e);
            }       
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getInput(String prompt) {
        Scanner input = new Scanner(System.in);

        System.out.println(prompt);
        String inputs = input.nextLine();

        while (inputs.isBlank()) {
            System.out.println(prompt);
            inputs = input.nextLine();
        }
        return inputs;
    }
}
