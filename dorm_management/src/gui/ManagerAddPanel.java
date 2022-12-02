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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import commands.AddManager;
import commands.CommandArguments;

public class ManagerAddPanel extends JPanel{
    /* Declare the components of the panel needed by inner classes. */

    /**
     * A text area to be used to display an error if one should occur.
     */
    JTextArea error = null;

    /**
     * A panel for the entry of the name of a new manager.
     */
    ValueEntryPanel namePanel;

    /**
     * A panel for the entry of the social insurance number of a new manager.
     */
    ValueEntryPanel sinPanel;

    /**
     * A panel for the entry of the ID of a new manager.
     */
    ValueEntryPanel mEnPanel;

    /**
     * A panel for the entry to check if manager is consultant.
     */
    ValueEntryPanel mConsultant;

    /**
     * Create the panel to obtain data for the creation of a manager, and to cause the manager to be
     * created.
     */
    public ManagerAddPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        // add a label with a prompt to enter the manager data
        JLabel prompt = new JLabel("Enter Manager Information");
        prompt.setMaximumSize(prompt.getPreferredSize());
        add(prompt);
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a panel with the field for the entry of the manager's name
        namePanel = new ValueEntryPanel("Name");
        namePanel.setMaximumSize(namePanel.getPreferredSize());
        add(namePanel);
        namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a panel with the field for the entry of the manager's sin
        sinPanel = new ValueEntryPanel("Manager SIN");
        sinPanel.setMaximumSize(sinPanel.getPreferredSize());
        add(sinPanel);
        sinPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a panel with the field for the entry of the manager's ID
        mEnPanel = new ValueEntryPanel("Manager ID");
        mEnPanel.setMaximumSize(mEnPanel.getPreferredSize());
        add(mEnPanel);
        sinPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a panel with the field for the entry of the student's nsid
        mConsultant = new ValueEntryPanel("Is this a consultant? Y or N");
        mConsultant.setMaximumSize(mConsultant.getPreferredSize());
        add(mConsultant);
        mConsultant.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());


        // add a button to submit the information and create the manager
        JButton submitButton = new JButton("Submit");
        submitButton.setMaximumSize(submitButton.getPreferredSize());
        add(submitButton);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new SubmitListener());
        add(Box.createVerticalGlue());
    }

    /**
     * The class listening for the press of the submit button. It accesses the name and health
     * number entered, and uses them to add a new Student to the system.
     */
    private class SubmitListener implements ActionListener {
        /**
         * When the submit button is pressed, access the name and social insurance number entered, and use
         * them to add a new manager to the system.
         */
        public void actionPerformed(ActionEvent event) {
            if (error != null) {
                // remove error from the previous submission
                remove(error);
                error = null;
            }
            String mName = namePanel.getValueAsString();
            String mSin = sinPanel.getValueAsString();
            String mEn = mEnPanel.getValueAsString();
            String mConsult = mConsultant.getValueAsString();
            AddManager addManager = new AddManager();

            CommandArguments cmdArguments = new CommandArguments();
            cmdArguments.mName = mName;
            cmdArguments.mSIN = mSin;
            cmdArguments.mEN = mEn;
            cmdArguments.response = mConsult;

            addManager.setCommnadArguments(cmdArguments);
            addManager.execute();

            if (addManager.wasSuccessful()) {
                getTopLevelAncestor().setVisible(false);
            } else {
                error = new JTextArea(SplitString.at(addManager.getErrorMessage(), 40));
                error.setMaximumSize(error.getPreferredSize());
                add(error);
                error.setAlignmentX(Component.CENTER_ALIGNMENT);
                add(Box.createVerticalGlue());
                revalidate(); // redraw the window as it has changed
            }
        }
    }

    public static final long serialVersionUID = 1;
}
