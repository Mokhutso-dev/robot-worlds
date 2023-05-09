package Client;
public class Left extends Command{
    @Override
    public boolean execute(Robot target) {
        target.turnLeft();

        target.setStatus("Turned left.");
        
        return true;
    }


    public Left() {
        super("left");
        
    }
}
