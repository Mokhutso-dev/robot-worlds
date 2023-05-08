# robot-worlds

Client-Server Game
Socket API: connection-oriented stream-mode sockets

Managing the world is done via a console interface on the server program. After the program is started, the program allow for world commands to be issued.
The client program must connect to a world using the world-server’s IP address and port. 
The client sends request messages to the server and receives response messages from the server. Every request be replied to by a response.


### Server
Send responses from the server to the client(user0

### Client
Send request from the user to the server.

### Build, Test & Run
You may use Visual Studio Code to run the program and tests.

First ensure you are in the root directory of the project
To compile your code, run: mvn compile

To run the tests: mvn test

To run your application: 
  Open terminal
  Type server.java to run the server side
  Type client.java to run the client side
