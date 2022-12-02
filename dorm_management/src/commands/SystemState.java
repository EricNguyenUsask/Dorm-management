package commands;

import containers.ManagerMapAccess;
import containers.ResidenceAccess;
import containers.StudentMapAccess;
import entities.Manager;
import entities.Student;
import interfaces.IOAccess;

import java.util.Collection;

public class SystemState implements Command {

    /**
     * Displays the system state
     */
    public void execute() {
        String result = "\nThe students in the system are \n";
        Collection<Student> studentsColl = StudentMapAccess.getInstance().values();
        for (Student p : studentsColl)
            result = result + p;
        result = result + "\nThe managers in the system are \n";
        Collection<Manager> managersColl = ManagerMapAccess.getInstance().values();
        for (Manager mgr : managersColl)
            result = result + mgr;
        result = result + "\nThe residence is " + ResidenceAccess.getInstance();
        IOAccess.getInstance().outputString(result);
    }
}
