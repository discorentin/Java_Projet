package mvc.controller;

import mvc.model.ModelCentralApp;
import mvc.view.centralApp.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControllerCentralApp
{
    private mvc.model.ModelCentralApp model;
    private mvc.view.centralApp.ViewCentralApp viewCentralApp;
    private mvc.view.centralApp.ViewDepEdit viewDepEdit;
    private mvc.controller.ControllerNewDepartment controllerNewDepartment;

    public ControllerCentralApp()
    {
        model = new ModelCentralApp();
        viewCentralApp = new ViewCentralApp(model);

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

        viewCentralApp.getDepartmentComboBox().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
    }

    public mvc.model.ModelCentralApp getModel()
    {
        return this.model;
    }
}
