package commands;

import containers.ManagerMapAccess;
import containers.StudentMapAccess;
import entities.Manager;
import entities.Student;
import interfaces.IOAccess;

import java.util.NoSuchElementException;

public class AssignManagerStudent extends  CommandStatus implements Command {

    /**
     * Assign a manager to take care of a student.
     */
    public void execute() {


        Student st = StudentMapAccess.getInstance().get(cmdArgument.sSIN);
        if (st == null) {
            successful = false;
            errorMessage = "There is no student with social insurance number " + cmdArgument.sSIN;
        }

        Manager mgr = ManagerMapAccess.getInstance().get(cmdArgument.mEN);

        if (mgr == null) {
            successful=false;
            errorMessage= "There is no manager with the employee id " + cmdArgument.mEN;
        }
        else {
            st.addManager(mgr);
            mgr.addStudent(st);
            successful=true;
        }
    }


}
