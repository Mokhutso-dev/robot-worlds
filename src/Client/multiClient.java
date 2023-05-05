package Client;

import java.io.*;
import java.net.*;
import java.util.*;

public class multiClient {
    
    public static void main(String[] args)
    {

        try (
            Socket socket = new Socket("localhost", 4999)) 
            {
            System.out.println("Connected");
            
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
  
            Scanner input = new Scanner(System.in);
            String command = "";
            String name = "";

            System.out.print("What do you want to name your robot: ");
            try {
                name = input.nextLine();
            } catch (Exception e) {
                System.out.println(e);
            }
            
  
            while (!"quit".equalsIgnoreCase(command)) {
                try {
                    System.out.print(name+ "> What must I do next? ");
                    command = input.nextLine();
                    out.println(command);
                    out.flush();
                    System.out.println("Response from the server {}");
                                //  + in.readLine());
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            try {
                input.close();
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
}
