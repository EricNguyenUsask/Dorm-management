/*
name: Thang Nguyen
nsid: dun329
student number:11275930
course number:88270
*/

package gui;

import entities.Manager;

import javax.swing.JFrame;

public class ManagerAddFrame extends JFrame {
    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 200;

    /**
     * Create the frame to add a student.
     */
    public ManagerAddFrame() {
        setTitle("student Addition");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        ManagerAddPanel panel = new ManagerAddPanel();
        add(panel);
    }

    public static final long serialVersionUID = 1;
}
