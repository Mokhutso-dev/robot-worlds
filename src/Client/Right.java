package Client;
public class Right extends Command {

    @Override
    public boolean execute(Robot target) {
        target.turnRight();
        target.setStatus("Turned right.");
        
        return true;
    }


    public Right() {
        super("right");
        
    }
}
