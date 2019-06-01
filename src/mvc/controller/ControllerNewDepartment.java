package mvc.controller;

import mvc.model.Department;
import mvc.model.Employee;
import mvc.model.Manager;
import mvc.model.ModelCentralApp;
import mvc.view.centralApp.ViewNewDepartment;

import javax.swing.*;
import java.awt.event.*;

public class ControllerNewDepartment
{
    private mvc.view.centralApp.ViewNewDepartment viewNewDepartment;
    private mvc.model.Department newDepartment;
    private mvc.model.Manager manager;


    public ControllerNewDepartment(mvc.model.ModelCentralApp model)
    {
        viewNewDepartment = new ViewNewDepartment();
        SwingUtilities.getRootPane(viewNewDepartment.getOkButton()).setDefaultButton(viewNewDepartment.getOkButton());

        viewNewDepartment.getSetManagerCheckBox().addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                viewNewDepartment.getSearchManagerTextField().setEnabled(!(viewNewDepartment.getSearchManagerTextField().isEnabled()));
                viewNewDepartment.getManagersTable().setEnabled(!(viewNewDepartment.getManagersTable().isEnabled()));
                viewNewDepartment.getSelectButton().setEnabled(!(viewNewDepartment.getSelectButton().isEnabled()));
            }
        });

        viewNewDepartment.getSearchManagerTextField().addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                super.focusGained(e);
                viewNewDepartment.getSearchManagerTextField().setText("");
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                super.focusLost(e);

                if(viewNewDepartment.getSearchManagerTextField().getText().equals(""))
                {
                    viewNewDepartment.getSearchManagerTextField().setText("Search manager");
                }
            }
        });

        viewNewDepartment.getOkButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(viewNewDepartment.getDepNameTextField().getText() != "")
                {
                    newDepartment = new Department(viewNewDepartment.getDepNameTextField().getText());
                    model.getCompany().addDepartment(newDepartment);
                }

                viewNewDepartment.dispose();
            }
        });

        viewNewDepartment.getSelectButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
    }

    public JFrame getView()
    {
        return viewNewDepartment;
    }
}
