package commands;

import containers.ResidenceAccess;
import containers.StudentMapAccess;
import entities.Student;
import interfaces.IOAccess;

import java.util.NoSuchElementException;

public class AssignBed extends CommandStatus implements Command {

    public void execute() {

        Student p = StudentMapAccess.getInstance().get(cmdArgument.sSIN);
        if (p == null) {

            successful=false;
            errorMessage= "There is no student with social insurance number " + cmdArgument.sSIN;

        }

        else if (p.getBedLabel() != -1) {
            successful = false;
            errorMessage =  " Student " + p
                    + " is already in a bed so cannot be assigned a new bed";
        }

        else if (cmdArgument.bedNum < ResidenceAccess.getInstance().getMinBedLabel() || cmdArgument.bedNum > ResidenceAccess.getInstance().getMaxBedLabel()) {
            successful = false;
            errorMessage = "Bed label " + cmdArgument.bedNum + " is not valid, as "
                    + "the value must be between " + ResidenceAccess.getInstance().getMinBedLabel()
                    + " and " + ResidenceAccess.getInstance().getMaxBedLabel();
        }

        else if (ResidenceAccess.getInstance().isOccupied(cmdArgument.bedNum)) {
            successful=false;
            errorMessage = "There is already a different Student in that bed.";
            //throw new IllegalStateException("There is already a different Student in that bed.");
        } else {

            p.setBedLabel(cmdArgument.bedNum);
            ResidenceAccess.getInstance().assignStudentToBed(p, cmdArgument.bedNum);
            successful=true;
        }
    }



}
