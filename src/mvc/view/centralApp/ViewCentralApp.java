package mvc.view.centralApp;

import mvc.model.Employee;
import mvc.model.ModelCentralApp;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ViewCentralApp extends JFrame
{
    private JTabbedPane mainAppTabbedPane;
    private JComboBox departmentComboBox;
    private JTable employeesTable1;
    private JTable managerTable;
    private JButton editButton1;
    private JButton deleteDepartmentButton;
    private JButton newDepartmentButton;
    private JTextArea departmentTextArea;
    private JTextArea IdTextArea;
    private JTextArea hRatioTextArea;
    private JButton editButton2;
    private JButton deleteButton2;
    private JTextArea nameTextArea;
    private JTextArea surnameTextArea;
    private JTextField searchEmployeeTextField1;
    private JTable employeesTable2;
    private JButton addEmployeeButton;
    private JButton importEmployeesListButton;
    private JButton exportEmployeesListButton;
    private JTable employeesTable3;
    private JTextField searchEmployeeTextField2;
    private JTextField IpParamTextField;
    private JTextField tallyPortTextField;
    private JButton newEmployeeButton;

    private TableModel dataModel;
    private String[] columnNames = {"First Name",
            "Last Name",
            "ID",
            "Department",
            "Status"};

    public ViewCentralApp(ModelCentralApp model)
    {
        editButton2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        deleteButton2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        searchEmployeeTextField1.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                super.keyTyped(e);
            }
        });
        editButton1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        deleteDepartmentButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });


        searchEmployeeTextField2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });

        setSize(600, 450);
        setLocationRelativeTo(null);
        add(mainAppTabbedPane);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        dataModel = new AbstractTableModel()
        {
            public String getColumnName(int col)
            {
                return columnNames[col];
            }

            public int getColumnCount()
            {
                return columnNames.length;
            }

            public int getRowCount()
            {
                return model.getCompany().getNbEmployees();
            }

            public Object getValueAt(int row, int col)
            {
                Employee employee = model.getCompany().getEmployeesList().get(row);

                switch (col)
                {
                    case 0:
                        return employee.getName();
                    case 1:
                        return employee.getSurname();
                    case 2:
                        return employee.getEmployeeId().toString();
                    case 3:
                        return employee.getDepartment().getDepName();
                    case 4:
                        if (employee.isManager())
                        {
                            return "Manager";
                        }
                        else
                        {
                            return "Employee";
                        }
                    default:
                        return null;
                }
            }
        };
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
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        mainAppTabbedPane = new JTabbedPane();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(mainAppTabbedPane, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        mainAppTabbedPane.addTab("Departments", panel2);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel2.add(panel3, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 4;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(spacer1, gbc);
        newDepartmentButton = new JButton();
        newDepartmentButton.setText("New department");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(newDepartmentButton, gbc);
        deleteDepartmentButton = new JButton();
        deleteDepartmentButton.setText("Delete department");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(deleteDepartmentButton, gbc);
        departmentComboBox = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(departmentComboBox, gbc);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel2.add(panel4, gbc);
        managerTable = new JTable();
        managerTable.setAutoCreateRowSorter(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel4.add(managerTable, gbc);
        employeesTable1 = new JTable();
        employeesTable1.setAutoCreateRowSorter(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel4.add(employeesTable1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel4.add(spacer2, gbc);
        editButton1 = new JButton();
        editButton1.setText("Edit employee");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(editButton1, gbc);
        newEmployeeButton = new JButton();
        newEmployeeButton.setText("New employee");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(newEmployeeButton, gbc);
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridBagLayout());
        mainAppTabbedPane.addTab("Employees", panel5);
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel5.add(panel6, gbc);
        departmentTextArea = new JTextArea();
        departmentTextArea.setText("Department");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel6.add(departmentTextArea, gbc);
        hRatioTextArea = new JTextArea();
        hRatioTextArea.setText("Hours Ratio");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel6.add(hRatioTextArea, gbc);
        editButton2 = new JButton();
        editButton2.setText("Edit");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel6.add(editButton2, gbc);
        nameTextArea = new JTextArea();
        nameTextArea.setText("Name");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel6.add(nameTextArea, gbc);
        surnameTextArea = new JTextArea();
        surnameTextArea.setText("Surname");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel6.add(surnameTextArea, gbc);
        IdTextArea = new JTextArea();
        IdTextArea.setText("ID");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel6.add(IdTextArea, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel6.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel6.add(spacer4, gbc);
        deleteButton2 = new JButton();
        deleteButton2.setText("Delete");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel6.add(deleteButton2, gbc);
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel5.add(panel7, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridheight = 7;
        gbc.fill = GridBagConstraints.BOTH;
        panel7.add(spacer5, gbc);
        searchEmployeeTextField1 = new JTextField();
        searchEmployeeTextField1.setText("Search Employee");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel7.add(searchEmployeeTextField1, gbc);
        employeesTable2 = new JTable();
        employeesTable2.setAutoCreateRowSorter(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel7.add(employeesTable2, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        panel7.add(spacer6, gbc);
        exportEmployeesListButton = new JButton();
        exportEmployeesListButton.setText("Export Employees List");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel7.add(exportEmployeesListButton, gbc);
        importEmployeesListButton = new JButton();
        importEmployeesListButton.setText("Import Employees List");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel7.add(importEmployeesListButton, gbc);
        addEmployeeButton = new JButton();
        addEmployeeButton.setText("Add Employee");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel7.add(addEmployeeButton, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        panel7.add(spacer7, gbc);
        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel7.add(spacer8, gbc);
        final JPanel panel8 = new JPanel();
        panel8.setLayout(new GridBagLayout());
        mainAppTabbedPane.addTab("Attendencies", panel8);
        final JPanel panel9 = new JPanel();
        panel9.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel8.add(panel9, gbc);
        searchEmployeeTextField2 = new JTextField();
        searchEmployeeTextField2.setText("Search Employee");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel9.add(searchEmployeeTextField2, gbc);
        employeesTable3 = new JTable();
        employeesTable3.setAutoCreateRowSorter(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel9.add(employeesTable3, gbc);
        final JPanel spacer9 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel8.add(spacer9, gbc);
        final JPanel spacer10 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel8.add(spacer10, gbc);
        final JPanel panel10 = new JPanel();
        panel10.setLayout(new GridBagLayout());
        mainAppTabbedPane.addTab("Config", panel10);
        final JPanel panel11 = new JPanel();
        panel11.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel10.add(panel11, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("IP param :");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel11.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Tally Port :");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel11.add(label2, gbc);
        IpParamTextField = new JTextField();
        IpParamTextField.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel11.add(IpParamTextField, gbc);
        tallyPortTextField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel11.add(tallyPortTextField, gbc);
        final JPanel spacer11 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel11.add(spacer11, gbc);
        final JPanel spacer12 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel10.add(spacer12, gbc);
        final JPanel spacer13 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel10.add(spacer13, gbc);
        final JPanel spacer14 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(spacer14, gbc);
        final JPanel spacer15 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(spacer15, gbc);
    }

    private void createUIComponents()
    {
        this.employeesTable1 = new JTable(dataModel);
        this.employeesTable2 = new JTable(dataModel);
        this.employeesTable3 = new JTable(dataModel);
    }

    public JComboBox getDepartmentComboBox()
    {
        return this.departmentComboBox;
    }

    public JButton getNewDepartmentButton()
    {
        return this.newDepartmentButton;
    }

    public JTable getEmployeesTable1()
    {
        return this.employeesTable1;
    }

    public void setDepartmentComboBox(ModelCentralApp model)
    {
        this.departmentComboBox.removeAllItems();
        for (int i = 0; i < model.getCompany().getNbDepartments(); i++)
        {
            this.departmentComboBox.addItem(model.getCompany().getDepartmentList().get(i).getDepName());
        }
    }
}