package Client;
public class Forward extends Command {
    @Override
    public boolean execute(Robot target) {

        int nrSteps = Integer.parseInt(getArgument());
        if (target.updatePosition(nrSteps)){
            target.setStatus("Moved forward by "+nrSteps+" steps.");
        
        } else {
            target.setStatus("Sorry, I cannot go outside my safe zone.");
        }
        return true;
    }

    public Forward(String argument) {
        super("forward", argument);
    }
}



