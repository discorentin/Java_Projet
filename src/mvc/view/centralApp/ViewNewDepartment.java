package mvc.view.centralApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ViewNewDepartment extends JFrame
{
    private JTextArea departmentNameTextArea;
    private JTextField depNameTextField;
    private JCheckBox setManagerCheckBox;
    private JTextField searchManagerTextField;
    private JTable managersTable;
    private JButton okButton;
    private JButton cancelButton;
    private JPanel newDepartmentPanel;
    private JButton selectButton;

    public ViewNewDepartment()
    {
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(newDepartmentPanel);
        setVisible(true);
    }

    public JCheckBox getSetManagerCheckBox()
    {
        return this.setManagerCheckBox;
    }

    public JTextField getSearchManagerTextField()
    {
        return this.searchManagerTextField;
    }

    public JButton getOkButton()
    {
        return this.okButton;
    }

    public JTextField getDepNameTextField()
    {
        return this.depNameTextField;
    }

    public JButton getSelectButton()
    {
        return this.selectButton;
    }

    public JTable getManagersTable()
    {
        return this.managersTable;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        newDepartmentPanel = new JPanel();
        newDepartmentPanel.setLayout(new GridBagLayout());
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        newDepartmentPanel.add(panel1, gbc);
        departmentNameTextArea = new JTextArea();
        departmentNameTextArea.setEditable(false);
        departmentNameTextArea.setText("Department name :");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(departmentNameTextArea, gbc);
        depNameTextField = new JTextField();
        depNameTextField.setColumns(14);
        depNameTextField.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(depNameTextField, gbc);
        setManagerCheckBox = new JCheckBox();
        setManagerCheckBox.setText("Set manager");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel1.add(setManagerCheckBox, gbc);
        searchManagerTextField = new JTextField();
        searchManagerTextField.setEditable(true);
        searchManagerTextField.setEnabled(false);
        searchManagerTextField.setText("Search manager");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(searchManagerTextField, gbc);
        managersTable = new JTable();
        managersTable.setEnabled(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(managersTable, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel2, gbc);
        okButton = new JButton();
        okButton.setText("Ok");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(okButton, gbc);
        cancelButton = new JButton();
        cancelButton.setText("Cancel");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(cancelButton, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(spacer1, gbc);
        selectButton = new JButton();
        selectButton.setEnabled(false);
        selectButton.setText("Select");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel1.add(selectButton, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        newDepartmentPanel.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        newDepartmentPanel.add(spacer3, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return newDepartmentPanel;
    }

}