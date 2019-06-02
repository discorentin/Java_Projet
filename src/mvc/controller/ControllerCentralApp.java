package mvc.controller;

import mvc.model.ModelCentralApp;
import mvc.view.centralApp.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.time.Duration;
import java.util.UUID;

public class ControllerCentralApp
{
    private mvc.model.ModelCentralApp model;
    private mvc.view.centralApp.ViewCentralApp viewCentralApp;
    private mvc.controller.ControllerNewDepartment controllerNewDepartment;
    private mvc.controller.ControllerNewEmployee controllerNewEmployee;

    public ControllerCentralApp()
    {
        model = new ModelCentralApp();
        viewCentralApp = new ViewCentralApp(model);

        /* DEPARTMENTS TAB */

        viewCentralApp.getDepartmentComboBox().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });

        viewCentralApp.getNewDepartmentButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                controllerNewDepartment = new ControllerNewDepartment(model);

                controllerNewDepartment.getView().addWindowListener(new WindowAdapter()
                {
                    @Override
                    public void windowClosed(WindowEvent e)
                    {
                        super.windowClosed(e);
                        viewCentralApp.setDepartmentComboBox(model);
                    }
                });
            }
        });

        /* EMPLOYEES TAB */

        viewCentralApp.getCentralAppTabbedPane().addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                switch(viewCentralApp.getCentralAppTabbedPane().getSelectedIndex())
                {
                    case 0 :
                        viewCentralApp.getEmployeesTable2().setEnabled(false);
                        break;
                    case 1 :
                        viewCentralApp.getSearchEmployeeTextField1().requestFocus();
                        viewCentralApp.getEmployeesTable2().setEnabled(true);
                        break;
                    case 2 :
                        viewCentralApp.getSearchEmployeeTextField2().requestFocus();
                        viewCentralApp.getEmployeesTable2().setEnabled(false);
                        break;
                    case 3 :
                        viewCentralApp.getIpParamTextField().requestFocus();
                        viewCentralApp.getEmployeesTable2().setEnabled(false);
                        break;
                    default :
                        viewCentralApp.getEmployeesTable2().setEnabled(false);
                        break;
                }
            }
        });

        viewCentralApp.getSearchEmployeeTextField1().addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                super.focusGained(e);
                viewCentralApp.getSearchEmployeeTextField1().setText("");
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                super.focusLost(e);

                if (viewCentralApp.getSearchEmployeeTextField1().getText().equals(""))
                {
                    viewCentralApp.getSearchEmployeeTextField1().setText("Search employee");
                }
            }
        });

        viewCentralApp.getSearchEmployeeTextField1().addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyReleased(KeyEvent e)
            {
                super.keyReleased(e);
                TableRowSorter<TableModel> sorter = (TableRowSorter) viewCentralApp.getEmployeesTable2().getRowSorter();//new TableRowSorter<>(viewCentralApp.getEmployeesTable2().getModel());
                sorter.setRowFilter(RowFilter.regexFilter(viewCentralApp.getSearchEmployeeTextField1().getText()));
            }
        });

        viewCentralApp.getEmployeesTable2().addFocusListener(new FocusAdapter() //TODO : change listener
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                super.focusGained(e);
                int rowIndex = viewCentralApp.getEmployeesTable2().getSelectedRow();
                mvc.model.Employee selectedEmployee = new mvc.model.Employee("", "", false, Duration.ofHours(0), Duration.ofHours(0));

                for(int i = 0; i < model.getCompany().getNbEmployees(); i++)
                {
                    if(model.getCompany().getEmployeesList().get(i).getEmployeeId().toString().equals(viewCentralApp.getEmployeesTable2().getValueAt(rowIndex, 4)))
                    {
                        selectedEmployee = new mvc.model.Employee(model.getCompany().getEmployeesList().get(i));
                    }
                }

                viewCentralApp.getFirstNameIsLabel().setText(selectedEmployee.getName());
                viewCentralApp.getLastNameIsLabel().setText(selectedEmployee.getSurname());
                viewCentralApp.getDepartmentIsLabel().setText(selectedEmployee.getDepartment().getDepName());
                viewCentralApp.getIdIsLabel().setText(selectedEmployee.getEmployeeId().toString());

                if(selectedEmployee.isManager())
                {
                    viewCentralApp.getStatusIsLabel().setText("Manager");
                }
                else
                {
                    viewCentralApp.getStatusIsLabel().setText("Employee");
                }

                viewCentralApp.getHRatioIsLabel().setText(selectedEmployee.getEmployeeTime().getHRatio().toString());
            }
        });

        viewCentralApp.getNewEmployeeButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                controllerNewEmployee = new ControllerNewEmployee(model);

                controllerNewEmployee.getView().addWindowListener(new WindowAdapter()
                {
                    @Override
                    public void windowClosed(WindowEvent e)
                    {
                        super.windowClosed(e);
                        ((AbstractTableModel) viewCentralApp.getEmployeesTable1().getModel()).fireTableDataChanged();
                    }
                });
            }
        });

        /* ATTENDANCES TAB */

        viewCentralApp.getSearchEmployeeTextField2().addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                super.focusGained(e);
                viewCentralApp.getSearchEmployeeTextField2().setText("");
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                super.focusLost(e);

                if (viewCentralApp.getSearchEmployeeTextField2().getText().equals(""))
                {
                    viewCentralApp.getSearchEmployeeTextField2().setText("Search employee");
                }
            }
        });

        viewCentralApp.getSearchEmployeeTextField2().addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyReleased(KeyEvent e)
            {
                super.keyReleased(e);
                TableRowSorter<TableModel> sorter = (TableRowSorter) viewCentralApp.getEmployeesTable3().getRowSorter();//new TableRowSorter<>(viewCentralApp.getEmployeesTable2().getModel());
                sorter.setRowFilter(RowFilter.regexFilter(viewCentralApp.getSearchEmployeeTextField2().getText()));
            }
        });
    }

    public mvc.model.ModelCentralApp getModel()
    {
        return this.model;
    }
}
