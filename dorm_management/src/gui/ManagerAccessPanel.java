/*
name: Thang Nguyen
nsid: dun329
student number:11275930
course number:88270
*/

package gui;

import entities.Manager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ManagerAccessPanel extends JPanel{

    JTextField textField;
    public ManagerAccessPanel() {
        JLabel promptLabel = new JLabel("Access Manager with employeeID");
        add(promptLabel);
        textField = new JTextField(10);
        add(textField);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String valueAsString = textField.getText();
                String sSin = textField.getText();
                ManagerFrame frame = null;
                try {
                    frame = new ManagerFrame(sSin);
                } catch (RuntimeException e) {
                    textField.setText("Invalid id: " + textField.getText());
                    textField.revalidate();
                    return;
                }
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
                textField.setText("");
                textField.revalidate();

            }
        });
    }

    public static final long serialVersionUID = 1;
}
