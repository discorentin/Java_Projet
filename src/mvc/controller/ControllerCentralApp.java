package mvc.controller;

import mvc.model.Employee;
import mvc.model.ModelCentralApp;
import mvc.view.centralApp.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.time.Duration;

public class ControllerCentralApp
{
    private mvc.model.ModelCentralApp model;
    private mvc.view.centralApp.ViewCentralApp viewCentralApp;
    private mvc.controller.ControllerEditDepartment controllerEditDepartment;
    private mvc.controller.ControllerDeleteDepartment controllerDeleteDepartment;
    private mvc.controller.ControllerNewDepartment controllerNewDepartment;
    private mvc.controller.ControllerAddEmployee controllerAddEmployee;
    private mvc.controller.ControllerNewEmployee controllerNewEmployee;
    private mvc.controller.ControllerEditEmployee controllerEditEmployee;

    /* CONSTRUCTOR */

    public ControllerCentralApp()
    {
        model = new ModelCentralApp();
        viewCentralApp = new ViewCentralApp();

        class DataModel extends AbstractTableModel
        {
            private String[] columnNames = {"First Name",
                    "Last Name",
                    "Department",
                    "Status",
                    "ID"};

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
                        return employee.getDepartment().getDepName();
                    case 3:
                        if (employee.isManager())
                        {
                            return "Manager";
                        }
                        else
                        {
                            return "Employee";
                        }
                    case 4:
                        return employee.getEmployeeId().toString();
                    default:
                        return null;
                }
            }
        }

        setDepartmentComboBox(model);
        DataModel dataModel = new DataModel();
        viewCentralApp.getEmployeesTable1().setModel(dataModel);
        viewCentralApp.getEmployeesTable2().setModel(dataModel);
        viewCentralApp.getEmployeesTable3().setModel(dataModel);

        viewCentralApp.getCentralAppTabbedPane().addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                switch(viewCentralApp.getCentralAppTabbedPane().getSelectedIndex())
                {
                    case 0 :
                        viewCentralApp.getEmployeesTable2().setEnabled(false);
                        ((AbstractTableModel)viewCentralApp.getEmployeesTable1().getModel()).fireTableDataChanged();
                        break;
                    case 1 :
                        viewCentralApp.getSearchEmployeeTextField1().requestFocus();
                        viewCentralApp.getEmployeesTable2().setEnabled(true);
                        ((AbstractTableModel)viewCentralApp.getEmployeesTable2().getModel()).fireTableDataChanged();
                        break;
                    case 2 :
                        viewCentralApp.getSearchEmployeeTextField2().requestFocus();
                        viewCentralApp.getEmployeesTable2().setEnabled(false);
                        ((AbstractTableModel)viewCentralApp.getEmployeesTable3().getModel()).fireTableDataChanged();
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

        /* DEPARTMENTS TAB */

        viewCentralApp.getDepartmentComboBox().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(viewCentralApp.getDepartmentComboBox().getSelectedItem() != null)
                {
                    TableRowSorter<TableModel> sorter = (TableRowSorter) viewCentralApp.getEmployeesTable1().getRowSorter();//new TableRowSorter<>(viewCentralApp.getEmployeesTable2().getModel());
                    sorter.setRowFilter(RowFilter.regexFilter(getSelectedDepartment(viewCentralApp.getDepartmentComboBox()).toString(), 2));

                    viewCentralApp.getDeleteDepartmentButton().setEnabled(true);
                    viewCentralApp.getEditDepartmentButton().setEnabled(true);
                }
                else
                {
                    viewCentralApp.getDeleteDepartmentButton().setEnabled(false);
                }
            }
        });

        viewCentralApp.getEditDepartmentButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mvc.model.Department selectedDepartment = getSelectedDepartment(viewCentralApp.getDepartmentComboBox());
                controllerEditDepartment = new ControllerEditDepartment(selectedDepartment);

                controllerEditDepartment.getView().addWindowListener(new WindowAdapter()
                {
                    @Override
                    public void windowClosed(WindowEvent e)
                    {
                        super.windowClosed(e);
                        ((AbstractTableModel) viewCentralApp.getEmployeesTable1().getModel()).fireTableDataChanged();
                        setDepartmentComboBox(model);
                        viewCentralApp.getDepartmentComboBox().setSelectedItem(selectedDepartment.getDepName());
                    }
                });
            }
        });

        viewCentralApp.getDeleteDepartmentButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mvc.model.Department selectedDepartment = getSelectedDepartment(viewCentralApp.getDepartmentComboBox());
                controllerDeleteDepartment = new ControllerDeleteDepartment(model, selectedDepartment);

                controllerDeleteDepartment.getView().addWindowListener(new WindowAdapter()
                {
                    @Override
                    public void windowClosed(WindowEvent e)
                    {
                        super.windowClosed(e);
                        ((AbstractTableModel) viewCentralApp.getEmployeesTable1().getModel()).fireTableDataChanged();
                        setDepartmentComboBox(model);
                    }
                });
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
                        ((AbstractTableModel) viewCentralApp.getEmployeesTable1().getModel()).fireTableDataChanged();
                        setDepartmentComboBox(model);
                        viewCentralApp.getDepartmentComboBox().setSelectedIndex(viewCentralApp.getDepartmentComboBox().getItemCount() - 1);
                    }
                });
            }
        });

        viewCentralApp.getAddEmployeeButton1().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mvc.model.Department selectedDepartment = getSelectedDepartment(viewCentralApp.getDepartmentComboBox());

                controllerAddEmployee = new ControllerAddEmployee(model, selectedDepartment, dataModel);

                controllerAddEmployee.getView().addWindowListener(new WindowAdapter()
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

        /* EMPLOYEES TAB */

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

        viewCentralApp.getEmployeesTable2().getSelectionModel().addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                mvc.model.Employee selectedEmployee = getSelectedEmployee(viewCentralApp.getEmployeesTable2());

                if (selectedEmployee != null)
                {
                    viewCentralApp.getFirstNameIsLabel().setText(selectedEmployee.getName());
                    viewCentralApp.getLastNameIsLabel().setText(selectedEmployee.getSurname());
                    viewCentralApp.getDepartmentIsLabel().setText(selectedEmployee.getDepartment().getDepName());

                    if(viewCentralApp.getWidth() < 750)
                    {
                        String shortId[] = selectedEmployee.getEmployeeId().toString().split("-");
                        viewCentralApp.getIdIsLabel().setText(shortId[0] + "...");
                    }
                    else
                    {
                        viewCentralApp.getIdIsLabel().setText(selectedEmployee.getEmployeeId().toString());
                    }

                    if (selectedEmployee.isManager())
                    {
                        viewCentralApp.getStatusIsLabel().setText("Manager");
                    }
                    else
                    {
                        viewCentralApp.getStatusIsLabel().setText("Employee");
                    }

                    viewCentralApp.getHRatioIsLabel().setText(selectedEmployee.getEmployeeTime().getHRatio().toString());
                }
                else
                {
                    viewCentralApp.getFirstNameIsLabel().setText("");
                    viewCentralApp.getLastNameIsLabel().setText("");
                    viewCentralApp.getDepartmentIsLabel().setText("");
                    viewCentralApp.getIdIsLabel().setText("");
                    viewCentralApp.getStatusIsLabel().setText("");
                    viewCentralApp.getHRatioIsLabel().setText("");
                }
            }
        });

        viewCentralApp.addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                super.componentResized(e);

                mvc.model.Employee selectedEmployee = getSelectedEmployee(viewCentralApp.getEmployeesTable2());

                if(selectedEmployee != null)
                {
                    if(viewCentralApp.getWidth() < 750)
                    {
                        String shortId[] = selectedEmployee.getEmployeeId().toString().split("-");
                        viewCentralApp.getIdIsLabel().setText(shortId[0] + "...");
                    }
                    else
                    {
                        viewCentralApp.getIdIsLabel().setText(selectedEmployee.getEmployeeId().toString());
                    }
                }
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

        viewCentralApp.getEditEmployeeButton2().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mvc.model.Employee selectedEmployee = getSelectedEmployee(viewCentralApp.getEmployeesTable2());

                if(selectedEmployee != null)
                {
                    controllerEditEmployee = new ControllerEditEmployee(model, selectedEmployee);

                    controllerEditEmployee.getView().addWindowListener(new WindowAdapter()
                    {
                        @Override
                        public void windowClosed(WindowEvent e)
                        {
                            super.windowClosed(e);
                            ((AbstractTableModel) viewCentralApp.getEmployeesTable2().getModel()).fireTableDataChanged();
                        }
                    });
                }
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

    /* GETTER */

    public mvc.model.ModelCentralApp getModel()
    {
        return this.model;
    }

    public mvc.model.Department getSelectedDepartment(JComboBox departmentComboBox)
    {
        String selectedDepName = departmentComboBox.getSelectedItem().toString();
        mvc.model.Department selectedDepartment = model.getCompany().getDepartment(selectedDepName);

        return selectedDepartment;
    }

    private mvc.model.Employee getSelectedEmployee(JTable employeesTable)
    {
        int rowIndex = employeesTable.getSelectedRow();

        if(employeesTable.getSelectedRow() >= 0)
        {
            mvc.model.Employee selectedEmployee = new mvc.model.Employee("", "", false, Duration.ofHours(0), Duration.ofHours(0));

            for (int i = 0; i < model.getCompany().getNbEmployees(); i++)
            {
                if (model.getCompany().getEmployeesList().get(i).getEmployeeId().toString().equals(employeesTable.getValueAt(rowIndex, 4)))
                {
                    selectedEmployee = model.getCompany().getEmployeesList().get(i);
                }
            }

            return selectedEmployee;
        }
        else
        {
            return null;
        }
    }

    /* SETTER */

    private void setDepartmentComboBox(ModelCentralApp model)
    {
        viewCentralApp.getDepartmentComboBox().removeAllItems();
        for (int i = 0; i < model.getCompany().getNbDepartments(); i++)
        {
            viewCentralApp.getDepartmentComboBox().addItem(model.getCompany().getDepartmentList().get(i).getDepName());
        }
    }
}
