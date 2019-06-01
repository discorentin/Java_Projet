package mvc.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ControllerNewEmployee
{
    private mvc.view.centralApp.ViewNewEmployee viewNewEmployee;
    private mvc.model.Employee newEmployee;

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

            }
        });
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
