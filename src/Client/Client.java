package Client;

import java.io.*;
import java.net.*;

public class Client {
	
	public static void main(String args[]){
		
		//initialize socket and input stream
		Socket socket = null;
		DataInputStream input = null;
		DataOutputStream out = null;
        
		
		try {
			socket = new Socket("127.0.0.1", 8000);
			System.out.println("Connected");

			input = new DataInputStream(System.in);

			out = new DataOutputStream(
				socket.getOutputStream());
		}
		catch (UnknownHostException u) {
			System.out.println(u);
			return;
		}
		catch (IOException i) {
			System.out.println(i);
			return;
		}

		String command = "";
        String name = "";

        System.out.print("What do you want to name your robot: ");
        try{
            name = input.readLine();
            // out.writeUTF(name);
        }
        catch (IOException i) {
            System.out.println(i);
        }
        
		while (!command.equalsIgnoreCase("Quit")){
			try {
                
                System.out.print(name+ "> What must I do next? ");
				command = input.readLine();
				out.writeUTF(command);
			}
			catch (IOException i) {
				System.out.println(i);
			}
		}

		// close the connection
		try {
            input.close();
			out.close();
			socket.close();
        }
		catch (IOException i) {
			System.out.println(i);
		}
	}
}

