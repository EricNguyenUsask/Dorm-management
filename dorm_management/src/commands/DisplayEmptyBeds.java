package commands;

import containers.ResidenceAccess;
import interfaces.IOAccess;

import java.util.LinkedList;

public class DisplayEmptyBeds extends CommandStatus implements Command {
    /**
     * Display the empty beds for the residence.
     */
    public void execute() {
        LinkedList<Integer> beds = ResidenceAccess.getInstance().availableBeds();

        if (beds.size() == 0) {

            IOAccess.getInstance().outputString("No beds available!");
        } else {
            IOAccess.getInstance().outputString("Available beds: " + ResidenceAccess.getInstance().availableBeds());
        }
    }

    public static void main(String[] args) {
        Command cmd = new DisplayEmptyBeds();
        cmd.execute();
    }
}
