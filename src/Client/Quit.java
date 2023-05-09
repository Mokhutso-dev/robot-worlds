package Client;
public class Quit extends Command {
    public Quit() {
        super("quit");
    }

    @Override
    public boolean execute(Robot target) {
        target.setStatus("Shutting down...");
        return false;
    }
}