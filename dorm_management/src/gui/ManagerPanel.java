/*
name: Thang Nguyen
nsid: dun329
student number:11275930
course number:88270
*/

package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import commands.AssignManagerStudent;
import commands.CommandArguments;
import commands.DropAssociation;
import containers.ManagerMapAccess;
import containers.StudentMapAccess;
import entities.BasicManager;
import entities.Manager;
import entities.Student;


public class ManagerPanel extends JPanel{
    /**
     * Create the panel to display the student's information and accept operations on the student.
     *
     * @param manager the student whose information is to be displayed and on whom operations can be
     *        done
     */
    public ManagerPanel(Manager manager) {
        build(manager);
    }

    private void build(Manager manager) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(new JLabel("Name: " +manager.getName()));
        add(new JLabel("Manager's SIN: " + manager.getSIN()));
        add(new JLabel("ID: " + manager.getEmployeeId()));
        add(new JLabel("Manager's ID: " + manager.getEmployeeId()));

        add(new JLabel("  ")); // blank line in the panel for spacing
        add(new JLabel("Student"));
        for (Student student : manager.getStudents()) {
            JPanel p = listStudentPanel(student, manager);
            add(p);
            p.setAlignmentX(Component.LEFT_ALIGNMENT);
        }

        // add an empty panel to force the add manager and exit components to the bottom
        JPanel emptyPanel = new JPanel();
        add(emptyPanel);
        emptyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel addStudentPanel = addStudentPanel(manager);
        add(addStudentPanel);
        addStudentPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        addStudentPanel.setMaximumSize(addStudentPanel.getPreferredSize());

        add(new JLabel("  ")); // blank line in the panel for spacing
        final JButton exitButton = new JButton("Exit");
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                exitButton.getTopLevelAncestor().setVisible(false);
            }
        });
    }

    /**
     * A panel to display the name of a student for the manager. Also, a button is provided to remove
     * the association of this manager with the student.
     *
     * @param manager a manager of this student
     * @param student the current student
     * @return the panel to display the name of the student, with a button to remove the
     *         student-manager association
     */
    private JPanel listStudentPanel(final Student student, final Manager manager) {
        JPanel managerPanel = new JPanel();
        managerPanel.add(new JLabel("  "));
        managerPanel.add(new JLabel(student.getName()));
        JButton removeButton = new JButton("remove");
        managerPanel.add(removeButton);
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                DropAssociation dropAssoc = new DropAssociation();
                CommandArguments cmdArguments = new CommandArguments();
                cmdArguments.sSIN = student.getSIN();
                cmdArguments.sNSID= student.getNSID();
                cmdArguments.mName = manager.getName();
                cmdArguments.mEN = manager.getEmployeeId();
                dropAssoc.setCommnadArguments(cmdArguments);
                dropAssoc.execute();

                if (dropAssoc.wasSuccessful()) {
                    // recreate the panel as it has changed
                    removeAll();
                    build(manager);
                    revalidate();
                } else {
                    JOptionPane.showMessageDialog( ManagerPanel.this, dropAssoc.getErrorMessage());
                }
            }
        });
        JButton accessButton = new JButton("Access");
        managerPanel.add(accessButton);
        accessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(null, StudentMapAccess.getInstance().values());
            }
        });


        return managerPanel;
    }

    /**
     * A panel to add a manager-student association for this student. The panel as a prompt to enter
     * the student's name, and a field to enter the name.
     *
     * @param manager the current manager
     * @return a panel to associate a new student with this manager
     */
    private JPanel addStudentPanel(final Manager manager) {
        JPanel addStudentPanel = new JPanel();
        addStudentPanel.add(new JLabel("Add student with SIN"));
        final JTextField textField = new JTextField(10);
        addStudentPanel.add(textField);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String sSIN = textField.getText();
                AssignManagerStudent addAssoc = new AssignManagerStudent();

                CommandArguments cmdArguments = new CommandArguments();
                cmdArguments.mEN = manager.getEmployeeId();
                cmdArguments.sSIN= sSIN;
                addAssoc.setCommnadArguments(cmdArguments);
                //addAssoc.assignManager(managerName, student.getSIN());
                addAssoc.execute();
                if (addAssoc.wasSuccessful()) {
                    // recreate the panel as it has changed
                    removeAll();
                    build(manager);
                    revalidate();
                } else {
                    JOptionPane.showMessageDialog( ManagerPanel.this, addAssoc.getErrorMessage());
                }
            }
        });
        return addStudentPanel;
    }


    public static final long serialVersionUID = 1;
}
