package mvc.controller;

import mvc.view.centralApp.ViewDeleteDepartment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ControllerDeleteDepartment
{
    private mvc.view.centralApp.ViewDeleteDepartment viewDeleteDepartment;

    public ControllerDeleteDepartment(mvc.model.ModelCentralApp model, mvc.model.Department department)
    {
        viewDeleteDepartment = new ViewDeleteDepartment();

        viewDeleteDepartment.getMsgLabel().setText(department.getDepName() + " will be deleted from the company.");

        if(model.getCompany().getNbDepartments() > 1)
        {
            for (int i = 0; i < model.getCompany().getNbDepartments(); i++)
            {
                if (!model.getCompany().getDepartmentList().get(i).getDepName().equals(department.getDepName()))
                {
                    viewDeleteDepartment.getDepartmentComboBox().addItem(model.getCompany().getDepartmentList().get(i).getDepName());
                }
            }

            viewDeleteDepartment.getMoveEmployeesToDepartmentCheckBox().setEnabled(true);
            viewDeleteDepartment.getMoveEmployeesToDepartmentCheckBox().setSelected(true);
            viewDeleteDepartment.getDepartmentComboBox().setEnabled(true);
            viewDeleteDepartment.getWarningHeaderLabel().setVisible(false);
            viewDeleteDepartment.getWarningMsgLabel().setVisible(false);
            viewDeleteDepartment.getNoOtherDepartmentLabel().setVisible(false);
        }
        else
        {
            viewDeleteDepartment.getMoveEmployeesToDepartmentCheckBox().setSelected(false);
            viewDeleteDepartment.getMoveEmployeesToDepartmentCheckBox().setEnabled(false);
            viewDeleteDepartment.getDepartmentComboBox().setEnabled(false);
            viewDeleteDepartment.getWarningHeaderLabel().setVisible(true);
            viewDeleteDepartment.getWarningMsgLabel().setVisible(true);
            viewDeleteDepartment.getNoOtherDepartmentLabel().setVisible(true);
        }

        viewDeleteDepartment.getMoveEmployeesToDepartmentCheckBox().addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                viewDeleteDepartment.getDepartmentComboBox().setEnabled(!viewDeleteDepartment.getDepartmentComboBox().isEnabled());
                viewDeleteDepartment.getWarningMsgLabel().setVisible(!viewDeleteDepartment.getWarningMsgLabel().isVisible());
                viewDeleteDepartment.getWarningHeaderLabel().setVisible(!viewDeleteDepartment.getWarningHeaderLabel().isVisible());
            }
        });

        viewDeleteDepartment.getOkButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(viewDeleteDepartment.getMoveEmployeesToDepartmentCheckBox().isSelected())
                {
                    String otherDepartmentName = viewDeleteDepartment.getDepartmentComboBox().getSelectedItem().toString();
                    mvc.model.Department otherDepartment = model.getCompany().getDepartment(otherDepartmentName);

                    for(int i = 0; i < department.getNbEmployees(); i++)
                    {
                        otherDepartment.addEmployee(department.getEmployeeList().get(i));
                    }
                }

                model.getCompany().removeDepartment(department);
                viewDeleteDepartment.dispose();
            }
        });

        viewDeleteDepartment.getCancelButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                viewDeleteDepartment.dispose();
            }
        });
    }

    /* GETTER */

    mvc.view.centralApp.ViewDeleteDepartment getView()
    {
        return viewDeleteDepartment;
    }
}
