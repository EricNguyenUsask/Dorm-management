/*
name: Thang Nguyen
nsid: dun329
student number:11275930
course number:88270
*/

package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CreateMainMenuPanel extends JPanel {

    public CreateMainMenuPanel(){
        JFrame frame = new JFrame("Main Menu");
        frame.setVisible(true);
        frame.setSize(500,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        JButton button = new JButton("Add Student");
        panel.add(button);
        button.addActionListener (new Action1());

        JButton button2 = new JButton("Add Manager");
        panel.add(button2);
        button2.addActionListener (new Action2());

        JButton button3 = new JButton("Display");
        panel.add(button3);
        button3.addActionListener (new Action3());

        JButton button4 = new JButton("Exit");
        panel.add(button4);
        button4.addActionListener (new Action4());


    }
    static class Action1 implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            StudentOpsFrame frame1 = new StudentOpsFrame(); // Modified from original code
            frame1.setLocation(300,300);
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.setVisible(true);
        }
    }

    static class Action2 implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            ManagerOpsFrame frame =new ManagerOpsFrame();
            frame.setLocation(500,500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }

    class Action3 implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            CreateDisplayFrame bedPanel = new CreateDisplayFrame();
            bedPanel.setLocation(500,500);
            bedPanel.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            bedPanel.setVisible(true);


        }
    }

    static class Action4 implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            System.exit(0);
        }
    }
}
