package mvc.controller;

import mvc.view.centralApp.ViewAddEmployee;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.time.Duration;

public class ControllerAddEmployee
{
    private mvc.view.centralApp.ViewAddEmployee viewAddEmployee;
    private mvc.model.Employee employeeToAdd;
    private mvc.controller.ControllerNewEmployee controllerNewEmployee;

    /* CONSTRUCTOR */

    public ControllerAddEmployee(mvc.model.ModelCentralApp model, mvc.model.Department department, TableModel dataModel)
    {
        viewAddEmployee = new ViewAddEmployee();

        viewAddEmployee.getEmployeesTable().setModel(dataModel);

        java.util.List<RowFilter<Object,Object>> filters = new java.util.ArrayList<>(2);
        filters.add(RowFilter.notFilter(RowFilter.regexFilter(department.getDepName())));
        filters.add(null);

        TableRowSorter<TableModel> sorter = (TableRowSorter) viewAddEmployee.getEmployeesTable().getRowSorter();
        sorter.setRowFilter(filters.get(0));

        viewAddEmployee.getSearchEmployeeTextField().addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                super.focusGained(e);
                viewAddEmployee.getSearchEmployeeTextField().setText("");
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                super.focusLost(e);

                if (viewAddEmployee.getSearchEmployeeTextField().getText().equals(""))
                {
                    viewAddEmployee.getSearchEmployeeTextField().setText("Search employee");
                }
            }
        });

        viewAddEmployee.getSearchEmployeeTextField().addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyReleased(KeyEvent e)
            {
                super.keyReleased(e);
                filters.set(1, RowFilter.regexFilter(viewAddEmployee.getSearchEmployeeTextField().getText()));
                sorter.setRowFilter(RowFilter.andFilter(filters));
            }
        });

        viewAddEmployee.getSelectEmployeeButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int rowIndex = viewAddEmployee.getEmployeesTable().getSelectedRow();

                if (rowIndex >= 0)
                {
                    mvc.model.Employee selectedEmployee = new mvc.model.Employee("", "", false, Duration.ofHours(0), Duration.ofHours(0));

                    for (int i = 0; i < model.getCompany().getNbEmployees(); i++)
                    {
                        if (model.getCompany().getEmployeesList().get(i).getEmployeeId().toString().equals(viewAddEmployee.getEmployeesTable().getValueAt(rowIndex, 4)))
                        {
                            selectedEmployee = model.getCompany().getEmployeesList().get(i);
                        }
                    }

                    employeeToAdd = selectedEmployee;

                    viewAddEmployee.getSelectedEmployeeLabel().setVisible(true);
                    viewAddEmployee.getSelectedEmployeeIsLabel().setVisible(true);
                    viewAddEmployee.getOkButton().setEnabled(true);

                    viewAddEmployee.getSelectedEmployeeIsLabel().setText(selectedEmployee.getName() + " " + selectedEmployee.getSurname());
                }
            }
        });

        viewAddEmployee.getNewEmployeeButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                controllerNewEmployee = new ControllerNewEmployee(model, department);

                controllerNewEmployee.getOkButton().addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        viewAddEmployee.dispose();
                    }
                });
            }
        });

        viewAddEmployee.getOkButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                employeeToAdd.setDepartment(department);
                viewAddEmployee.dispose();
            }
        });

        viewAddEmployee.getCancelButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                viewAddEmployee.dispose();
            }
        });
    }

    /* GETTER */

    mvc.view.centralApp.ViewAddEmployee getView()
    {
        return this.viewAddEmployee;
    }
}
