/*
name: Thang Nguyen
nsid: dun329
student number:11275930
course number:88270
*/

package gui;

import javax.swing.JFrame;


import containers.ManagerMapAccess;
import entities.Manager;


public class ManagerFrame extends JFrame{

    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 400;

    /**
     * Create the frame to display the information for a manager.
     *
     * @param mEN the social employee number of the manager
     * @precond mEN the mEN of a manager
     */
    public ManagerFrame(String mEN) {
        Manager manager = ManagerMapAccess.getInstance().get(mEN);
        if (manager != null) {
            setTitle(manager.getName() + " (" + mEN + ")");
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            ManagerPanel panel = new ManagerPanel(manager);
            add(panel);
        } else
            throw new RuntimeException("Invalid employee number " + mEN);
    }

    public static final long serialVersionUID = 1;
}
