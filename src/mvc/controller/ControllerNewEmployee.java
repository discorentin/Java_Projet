package mvc.controller;

import mvc.model.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class ControllerNewEmployee
{
    private mvc.view.centralApp.ViewNewEmployee viewNewEmployee;

    public ControllerNewEmployee(mvc.model.ModelCentralApp model)
    {
        viewNewEmployee = new mvc.view.centralApp.ViewNewEmployee();
        SwingUtilities.getRootPane(viewNewEmployee.getOkButton()).setDefaultButton(viewNewEmployee.getOkButton());

        for (int i = 0; i < model.getCompany().getNbDepartments(); i++)
        {
            viewNewEmployee.getDepartmentComboBox().addItem(model.getCompany().getDepartmentList().get(i).getDepName());
        }

        viewNewEmployee.getFirstNameTextField().addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyReleased(KeyEvent e)
            {
                super.keyTyped(e);
                refreshOkButton();
            }
        });

        viewNewEmployee.getLastNameTextField().addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyReleased(KeyEvent e)
            {
                super.keyTyped(e);
                refreshOkButton();
            }
        });

        viewNewEmployee.getDepartmentComboBox().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                refreshOkButton();
            }
        });

        viewNewEmployee.getCheckInComboBox().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                refreshOkButton();
            }
        });

        viewNewEmployee.getCheckOutComboBox().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                refreshOkButton();
            }
        });

        viewNewEmployee.getOkButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mvc.model.Employee newEmployee;
                Duration checkInTime;
                Duration checkOutTime;
                String[] timePartsIn;
                String[] timePartsOut;

                timePartsIn = viewNewEmployee.getCheckInComboBox().getSelectedItem().toString().split(":");
                timePartsOut = viewNewEmployee.getCheckOutComboBox().getSelectedItem().toString().split(":");

                checkInTime = Duration.ofHours(Integer.valueOf(timePartsIn[0])).plus(Duration.ofMinutes(Integer.valueOf(timePartsIn[1])));
                checkOutTime = Duration.ofHours(Integer.valueOf(timePartsOut[0])).plus(Duration.ofMinutes(Integer.valueOf(timePartsOut[1])));

                newEmployee = new Employee(viewNewEmployee.getFirstNameTextField().getText(), viewNewEmployee.getLastNameTextField().getText(),
                                            false, checkInTime, checkOutTime);

                model.getCompany().getDepartment(viewNewEmployee.getDepartmentComboBox().getSelectedItem().toString()).addEmployee(newEmployee);

                viewNewEmployee.dispose();
            }
        });
    }

    /* GETTER */

    public mvc.view.centralApp.ViewNewEmployee getView()
    {
        return viewNewEmployee;
    }

    /* METHOD */

    private void refreshOkButton()
    {
        if(!viewNewEmployee.getFirstNameTextField().getText().equals("")
                && !viewNewEmployee.getLastNameTextField().getText().equals("")
                && viewNewEmployee.getDepartmentComboBox().getSelectedItem() != null
                && !viewNewEmployee.getCheckInComboBox().getSelectedItem().equals(viewNewEmployee.getCheckOutComboBox().getSelectedItem())
                )
        {
            viewNewEmployee.getOkButton().setEnabled(true);
        }
        else
        {
            viewNewEmployee.getOkButton().setEnabled(false);
        }
    }
}
