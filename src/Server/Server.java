// package Server;

import java.net.*;
import java.io.*;

public class Server{

	public static void main(String args[]){

		//initialize socket and input stream
		Socket socket = null;
		ServerSocket server = null;
		DataInputStream in	 = null;

		// starts server and waits for a connection
		try
		{
			server = new ServerSocket(5000);
			System.out.println("Server started");
			System.out.println("Waiting for a client");
			socket = server.accept();
			System.out.println("Client accepted");

			// takes input from the client socket
			in = new DataInputStream(
				new BufferedInputStream(socket.getInputStream()));

			String command = "";

			// reads message from client until "Over" is sent
			while ((!command.equalsIgnoreCase("QUIT")) & (!command.equalsIgnoreCase("off")))
			{
				try
				{
					command = in.readUTF();
					System.out.println(command);

				}
				catch(IOException i)
				{
					System.out.println(i);
				}
			}
			System.out.println("Closing connection");

			// close connection
			socket.close();
			in.close();
		}
		catch(IOException i)
		{
			System.out.println(i);
		}

	}
	
}

