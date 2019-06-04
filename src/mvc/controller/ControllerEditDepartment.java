package mvc.controller;

import mvc.view.centralApp.ViewEditDepartment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ControllerEditDepartment
{
    mvc.view.centralApp.ViewEditDepartment viewEditDepartment;

    public ControllerEditDepartment(mvc.model.Department department)
    {
        viewEditDepartment = new ViewEditDepartment();

        SwingUtilities.getRootPane(viewEditDepartment.getOkButton()).setDefaultButton(viewEditDepartment.getOkButton());


        viewEditDepartment.getNameTextField().setText(department.getDepName());

        viewEditDepartment.getNameTextField().addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                super.focusGained(e);
                viewEditDepartment.getNameTextField().selectAll();
            }
        });

        viewEditDepartment.getOkButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                department.setDepName(viewEditDepartment.getNameTextField().getText());
                viewEditDepartment.dispose();
            }
        });

        viewEditDepartment.getCancelButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                viewEditDepartment.dispose();
            }
        });
    }

    /* GETTER */

    public mvc.view.centralApp.ViewEditDepartment getView()
    {
        return this.viewEditDepartment;
    }
}
