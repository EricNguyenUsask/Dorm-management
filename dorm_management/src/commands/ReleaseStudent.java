package commands;

import containers.ResidenceAccess;
import containers.StudentMapAccess;
import entities.Student;
import interfaces.IOAccess;

import java.util.NoSuchElementException;

public class ReleaseStudent extends CommandStatus implements Command {

    /**
     * Checkout a student from the residence.
     */
    public void execute() {

        Student p = StudentMapAccess.getInstance().get(cmdArgument.sSIN);
        successful =true;
        // check the SIN is valid
        if (p == null){
            successful = false;
            errorMessage = "There is no student with social insurance number " + cmdArgument.sSIN;
        }

        int bed = p.getBedLabel();
        // check that the student was actually assigned a bed
        if (bed == -1) {
            successful = false;
            errorMessage = "No bed was assigned to student " + cmdArgument.sSIN;
            throw new NoSuchElementException( "No bed was assigned to student "
                    + cmdArgument.sSIN );
        }

        // check that the bed is actually assigned to the student
        if (ResidenceAccess.getInstance().getStudent(bed) != p) {
            successful = false;
            errorMessage = "Student " + cmdArgument.sSIN + " recorded in bed "
                    + bed + ", but Residence has student " + ResidenceAccess.getInstance().getStudent(bed).getSIN() + " there.";
        }

        // free the bed
        ResidenceAccess.getInstance().freeBed(bed);
        p.setBedLabel(-1);
    }

}
