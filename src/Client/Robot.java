package Client;

import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

public class Robot {
    private final Position TOP_LEFT = new Position(-100,200);
    private final Position BOTTOM_RIGHT = new Position(100,-200);

    public static final Position CENTRE = new Position(0,0);
    
    ArrayList<Command> commandHistory = new ArrayList<>();
    
    private Position position;
    private Direction currentDirection;
    private String status;
    private String name;

    public Robot(String name) {
        this.name = name;
        this.status = "Ready";
        this.position = CENTRE;
        this.currentDirection = Direction.NORTH;
    }

    public String getStatus() {
        return this.status;
    }

    public Direction getCurrentDirection() {
        return this.currentDirection;
    }

    public boolean handleCommand(Command command) {
        // 

        if (!command.getName().equals("replay")  && !command.getName().equals("reverse")){
            commandHistory.add(command);
        }
        
        
        return command.execute(this);
    }
    // new methods 

    public void turnRight(){

        if (Direction.NORTH.equals(this.currentDirection)) {
            this.currentDirection = Direction.EAST;
        }
        else if (Direction.EAST.equals(this.currentDirection)) {
            this.currentDirection = Direction.SOUTH;
        }
        else if (Direction.SOUTH.equals(this.currentDirection)) {
            this.currentDirection = Direction.WEST;
        }
        else if (Direction.WEST.equals(this.currentDirection)) {
            this.currentDirection = Direction.NORTH;
        }
    }


    public void turnLeft(){

        if (Direction.NORTH.equals(this.currentDirection)) {
            this.currentDirection = Direction.WEST;
        }
        else if (Direction.WEST.equals(this.currentDirection)) {
            this.currentDirection = Direction.SOUTH;
        }
        else if (Direction.SOUTH.equals(this.currentDirection)) {
            this.currentDirection = Direction.EAST;
        }
        else if (Direction.EAST.equals(this.currentDirection)) {
            this.currentDirection = Direction.NORTH;
        }
    }


    public boolean updatePosition(int nrSteps){
        int newX = this.position.getX();
        int newY = this.position.getY();

        if (Direction.NORTH.equals(this.currentDirection)) {
            newY = newY + nrSteps;
        }
        else if (Direction.SOUTH.equals(this.currentDirection)) {
            newY = newY - nrSteps;
        }
        else if (Direction.EAST.equals(this.currentDirection)) {
            newX = newX + nrSteps;
        }
        else if (Direction.WEST.equals(this.currentDirection)) {
            newX = newX - nrSteps;
        }

        Position newPosition = new Position(newX, newY);
        if (newPosition.isIn(TOP_LEFT,BOTTOM_RIGHT)){
            this.position = newPosition;
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
       return "[" + this.position.getX() + "," + this.position.getY() + "] "
               + this.name + "> " + this.status;
    }


    public Position getPosition() {
        return this.position;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    
}
