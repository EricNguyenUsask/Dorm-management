/*
name: Thang Nguyen
nsid: dun329
student number:11275930
course number:88270
*/

package gui;

import entities.Manager;
import startup.ResidenceSystem;

import javax.swing.JFrame;


public class ManagerOpsFrame extends JFrame{
    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 200;

    /**
     * Create the frame for the operations that involve managers.
     */
    public ManagerOpsFrame() {
        setTitle("manager Operations");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        ManagerOpsPanel panel = new ManagerOpsPanel();
        add(panel);
    }

    /**
     * A main to run the GUI version of the residence system that only involves manager operations
     * and the ward.
     */
    public static void main(String[] args) {
        //ResidenceSystem system = new ResidenceSystem();
        // system.initialize();
        ManagerOpsFrame frame = new ManagerOpsFrame();
        frame.setLocation(300, 300);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }

    public static final long serialVersionUID = 1;
}
