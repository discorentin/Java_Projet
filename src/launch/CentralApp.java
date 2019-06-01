package launch;

import mvc.model.ModelCentralApp;
import mvc.controller.ControllerCentralApp;
import mvc.view.centralApp.*;

public class CentralApp
{
    private mvc.controller.ControllerCentralApp controller;

    public CentralApp()
    {
        this.controller = new ControllerCentralApp();
    }

    public static void main(String[] args)
    {
        CentralApp centralApp = new CentralApp();
    }
}
