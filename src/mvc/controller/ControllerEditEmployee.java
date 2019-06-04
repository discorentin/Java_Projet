package mvc.controller;

import mvc.model.Manager;
import mvc.view.centralApp.ViewEditEmployee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ControllerEditEmployee
{
    private mvc.view.centralApp.ViewEditEmployee viewEditEmployee;

    /* CONSTRUCTOR */

    public ControllerEditEmployee(mvc.model.ModelCentralApp model, mvc.model.Employee employee)
    {
        viewEditEmployee = new ViewEditEmployee();

        for (int i = 0; i < model.getCompany().getNbDepartments(); i++)
        {
            viewEditEmployee.getDepartmentComboBox().addItem(model.getCompany().getDepartmentList().get(i));
        }

        viewEditEmployee.getStatusComboBox().addItem("Employee");
        viewEditEmployee.getStatusComboBox().addItem("Manager");

        viewEditEmployee.getFirstNameTextField().setText(employee.getName());
        viewEditEmployee.getLastNameTextField().setText(employee.getSurname());
        viewEditEmployee.getDepartmentComboBox().setSelectedItem(employee.getDepartment().getDepName());

        if(employee.isManager())
        {
            viewEditEmployee.getStatusComboBox().setSelectedItem("Manager");
        }
        else
        {
            viewEditEmployee.getStatusComboBox().setSelectedItem("Employee");
        }

        viewEditEmployee.getFirstNameTextField().addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                super.focusGained(e);
                viewEditEmployee.getFirstNameTextField().selectAll();
            }
        });

        viewEditEmployee.getLastNameTextField().addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                super.focusGained(e);
                viewEditEmployee.getLastNameTextField().selectAll();
            }
        });

        viewEditEmployee.getOkButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mvc.model.Department selectedDepartment;
                employee.setName(viewEditEmployee.getFirstNameTextField().getText());
                employee.setSurname(viewEditEmployee.getLastNameTextField().getText());
                selectedDepartment = (mvc.model.Department)viewEditEmployee.getDepartmentComboBox().getSelectedItem();

                if(!selectedDepartment.equals(employee.getDepartment()))
                {
                    selectedDepartment.addEmployee(employee);
                }

                if(viewEditEmployee.getStatusComboBox().getSelectedItem().equals("Manager"))
                {
                    employee.makeManager();
                }
                else
                {
                    employee.makeEmployee();
                }

                viewEditEmployee.dispose();
            }
        });
    }

    /* GETTER */

    public mvc.view.centralApp.ViewEditEmployee getView()
    {
        return viewEditEmployee;
    }
}
