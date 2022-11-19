/*
name: Thang Nguyen
nsid: dun329
student number:11275930
course number:88270
*/

package gui;

import javax.swing.JFrame;

/**
 * The frame to obtain input to initialize the ward, and then it will start the main system.
 */
public class CreateDisplayFrame extends JFrame {
    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 200;

    /**
     * Create the frame for the entry of the ward information.
     */
    public CreateDisplayFrame() {
        setTitle("Display student info");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        CreateDisplayPanel panel = new CreateDisplayPanel();
        add(panel);
    }

    public static final long serialVersionUID = 1;
}
