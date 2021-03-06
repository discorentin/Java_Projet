package mvc.view.centralApp;

import javax.swing.*;
import java.awt.*;

public class ViewCentralApp extends JFrame
{
    private JTabbedPane centralAppTabbedPane;
    private JComboBox departmentComboBox;
    private JTable employeesTable1;
    private JTable managerTable;
    private JButton deleteDepartmentButton;
    private JButton newDepartmentButton;
    private JButton editEmployeeButton2;
    private JButton deleteEmployeeButton2;
    private JTextField searchEmployeeTextField1;
    private JTable employeesTable2;
    private JButton newEmployeeButton;
    private JButton importEmployeesListButton;
    private JButton exportEmployeesListButton;
    private JTable employeesTable3;
    private JTextField searchEmployeeTextField2;
    private JTextField IpParamTextField;
    private JTextField tallyPortTextField;
    private JButton addEmployeeButton1;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel departmentLabel;
    private JLabel idLabel;
    private JLabel hRatioLabel;
    private JLabel statusLabel;
    private JLabel firstNameIsLabel;
    private JLabel lastNameIsLabel;
    private JLabel departmentIsLabel;
    private JLabel idIsLabel;
    private JLabel statusIsLabel;
    private JLabel hRatioIsLabel;
    private JButton editDepartmentButton;
    private JButton editEmployeeButton1;
    private JPanel centralAppPanel;

    public ViewCentralApp()
    {
        $$$setupUI$$$();

        setSize(500, 400);
        setLocationRelativeTo(null);
        add(centralAppTabbedPane);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        centralAppPanel = new JPanel();
        centralAppPanel.setLayout(new GridBagLayout());
        centralAppTabbedPane = new JTabbedPane();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        centralAppPanel.add(centralAppTabbedPane, gbc);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        centralAppTabbedPane.addTab("Departments", panel1);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel2, gbc);
        newDepartmentButton = new JButton();
        newDepartmentButton.setText("New department");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel2.add(newDepartmentButton, gbc);
        deleteDepartmentButton = new JButton();
        deleteDepartmentButton.setEnabled(false);
        deleteDepartmentButton.setText("Delete department");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(deleteDepartmentButton, gbc);
        departmentComboBox = new JComboBox();
        Font departmentComboBoxFont = this.$$$getFont$$$(null, Font.PLAIN, -1, departmentComboBox.getFont());
        if (departmentComboBoxFont != null) departmentComboBox.setFont(departmentComboBoxFont);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(departmentComboBox, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        panel2.add(spacer1, gbc);
        editDepartmentButton = new JButton();
        editDepartmentButton.setEnabled(false);
        editDepartmentButton.setText("Edit department");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(editDepartmentButton, gbc);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel3, gbc);
        managerTable = new JTable();
        managerTable.setAutoCreateRowSorter(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(managerTable, gbc);
        employeesTable1 = new JTable();
        employeesTable1.setAutoCreateRowSorter(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(employeesTable1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(spacer2, gbc);
        addEmployeeButton1 = new JButton();
        addEmployeeButton1.setText("Add employee");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        panel3.add(addEmployeeButton1, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(spacer3, gbc);
        editEmployeeButton1 = new JButton();
        editEmployeeButton1.setText("Edit employee");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(editEmployeeButton1, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 5;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(spacer4, gbc);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridBagLayout());
        centralAppTabbedPane.addTab("Employees", panel4);
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel4.add(panel5, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        panel5.add(spacer5, gbc);
        firstNameLabel = new JLabel();
        firstNameLabel.setText("First name :");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel5.add(firstNameLabel, gbc);
        lastNameLabel = new JLabel();
        lastNameLabel.setText("Last name :");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel5.add(lastNameLabel, gbc);
        departmentLabel = new JLabel();
        departmentLabel.setText("Department :");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel5.add(departmentLabel, gbc);
        idLabel = new JLabel();
        idLabel.setText("ID :");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panel5.add(idLabel, gbc);
        hRatioLabel = new JLabel();
        hRatioLabel.setText("Hours Ratio :");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        panel5.add(hRatioLabel, gbc);
        statusLabel = new JLabel();
        statusLabel.setText("Status :");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        panel5.add(statusLabel, gbc);
        firstNameIsLabel = new JLabel();
        firstNameIsLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel5.add(firstNameIsLabel, gbc);
        lastNameIsLabel = new JLabel();
        lastNameIsLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel5.add(lastNameIsLabel, gbc);
        departmentIsLabel = new JLabel();
        departmentIsLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel5.add(departmentIsLabel, gbc);
        idIsLabel = new JLabel();
        idIsLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panel5.add(idIsLabel, gbc);
        statusIsLabel = new JLabel();
        statusIsLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        panel5.add(statusIsLabel, gbc);
        hRatioIsLabel = new JLabel();
        hRatioIsLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        panel5.add(hRatioIsLabel, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 6;
        gbc.fill = GridBagConstraints.BOTH;
        panel5.add(spacer6, gbc);
        editEmployeeButton2 = new JButton();
        editEmployeeButton2.setText("Edit");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.EAST;
        panel5.add(editEmployeeButton2, gbc);
        deleteEmployeeButton2 = new JButton();
        deleteEmployeeButton2.setText("Delete");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        panel5.add(deleteEmployeeButton2, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.BOTH;
        panel5.add(spacer7, gbc);
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel4.add(panel6, gbc);
        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridheight = 7;
        gbc.fill = GridBagConstraints.BOTH;
        panel6.add(spacer8, gbc);
        searchEmployeeTextField1 = new JTextField();
        searchEmployeeTextField1.setColumns(14);
        searchEmployeeTextField1.setText("Search employee");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel6.add(searchEmployeeTextField1, gbc);
        employeesTable2 = new JTable();
        employeesTable2.setAutoCreateRowSorter(true);
        employeesTable2.setEnabled(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel6.add(employeesTable2, gbc);
        final JPanel spacer9 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        panel6.add(spacer9, gbc);
        exportEmployeesListButton = new JButton();
        exportEmployeesListButton.setText("Export employees list");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel6.add(exportEmployeesListButton, gbc);
        importEmployeesListButton = new JButton();
        importEmployeesListButton.setText("Import employees list");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel6.add(importEmployeesListButton, gbc);
        newEmployeeButton = new JButton();
        newEmployeeButton.setText("New employee");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel6.add(newEmployeeButton, gbc);
        final JPanel spacer10 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        panel6.add(spacer10, gbc);
        final JPanel spacer11 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel6.add(spacer11, gbc);
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new GridBagLayout());
        centralAppTabbedPane.addTab("Attendances", panel7);
        final JPanel panel8 = new JPanel();
        panel8.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel7.add(panel8, gbc);
        searchEmployeeTextField2 = new JTextField();
        searchEmployeeTextField2.setText("Search Employee");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel8.add(searchEmployeeTextField2, gbc);
        employeesTable3 = new JTable();
        employeesTable3.setAutoCreateRowSorter(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel8.add(employeesTable3, gbc);
        final JPanel spacer12 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel7.add(spacer12, gbc);
        final JPanel spacer13 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel7.add(spacer13, gbc);
        final JPanel panel9 = new JPanel();
        panel9.setLayout(new GridBagLayout());
        centralAppTabbedPane.addTab("Config", panel9);
        final JPanel panel10 = new JPanel();
        panel10.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel9.add(panel10, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("IP param :");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel10.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Tally Port :");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel10.add(label2, gbc);
        IpParamTextField = new JTextField();
        IpParamTextField.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel10.add(IpParamTextField, gbc);
        tallyPortTextField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel10.add(tallyPortTextField, gbc);
        final JPanel spacer14 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel10.add(spacer14, gbc);
        final JPanel spacer15 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel9.add(spacer15, gbc);
        final JPanel spacer16 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel9.add(spacer16, gbc);
        final JPanel spacer17 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        centralAppPanel.add(spacer17, gbc);
        final JPanel spacer18 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        centralAppPanel.add(spacer18, gbc);
        final JPanel spacer19 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        centralAppPanel.add(spacer19, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont)
    {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {resultName = currentFont.getName();}
        else
        {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {resultName = fontName;}
            else {resultName = currentFont.getName();}
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return centralAppPanel;
    }

    /**
     * @noinspection ALL
     */
    private void createUIComponents()
    {
    }


    /* GETTER */

    public JTabbedPane getCentralAppTabbedPane()
    {
        return this.centralAppTabbedPane;
    }

    /* DEPARTMENTS TAB */

    public JComboBox getDepartmentComboBox()
    {
        return this.departmentComboBox;
    }

    public JButton getEditDepartmentButton()
    {
        return this.editDepartmentButton;
    }

    public JButton getDeleteDepartmentButton()
    {
        return this.deleteDepartmentButton;
    }

    public JButton getNewDepartmentButton()
    {
        return this.newDepartmentButton;
    }

    public JTable getEmployeesTable1()
    {
        return this.employeesTable1;
    }

    public JButton getAddEmployeeButton1()
    {
        return this.addEmployeeButton1;
    }

    /* EMPLOYEES TAB */

    public JTextField getSearchEmployeeTextField1()
    {
        return this.searchEmployeeTextField1;
    }

    public JTable getEmployeesTable2()
    {
        return this.employeesTable2;
    }

    public JButton getNewEmployeeButton()
    {
        return this.newEmployeeButton;
    }

    public JLabel getFirstNameIsLabel()
    {
        return this.firstNameIsLabel;
    }

    public JLabel getLastNameIsLabel()
    {
        return this.lastNameIsLabel;
    }

    public JLabel getDepartmentIsLabel()
    {
        return this.departmentIsLabel;
    }

    public JLabel getIdIsLabel()
    {
        return this.idIsLabel;
    }

    public JLabel getStatusIsLabel()
    {
        return this.statusIsLabel;
    }

    public JLabel getHRatioIsLabel()
    {
        return this.hRatioIsLabel;
    }

    public JButton getEditEmployeeButton2()
    {
        return editEmployeeButton2;
    }

    public JButton getDeleteEmployeeButton2()
    {
        return deleteEmployeeButton2;
    }

    /* ATTENDANCES TAB */

    public JTextField getSearchEmployeeTextField2()
    {
        return this.searchEmployeeTextField2;
    }

    public JTable getEmployeesTable3()
    {
        return this.employeesTable3;
    }

    /* CONFIG TAB */

    public JTextField getIpParamTextField()
    {
        return this.IpParamTextField;
    }
}
