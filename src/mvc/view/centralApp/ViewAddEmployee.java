package mvc.view.centralApp;

import javax.swing.*;
import java.awt.*;

public class ViewAddEmployee extends JFrame
{
    private JTextField searchEmployeeTextField;
    private JTable employeesTable;
    private JButton selectEmployeeButton;
    private JButton newEmployeeButton;
    private JButton okButton;
    private JButton cancelButton;
    private JPanel addEmployeePanel;
    private JLabel selectedEmployeeIsLabel;
    private JLabel selectedEmployeeLabel;

    /* CONSTRUCTOR */

    public ViewAddEmployee()
    {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(addEmployeePanel);
        setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        addEmployeePanel = new JPanel();
        addEmployeePanel.setLayout(new GridBagLayout());
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        addEmployeePanel.add(panel1, gbc);
        searchEmployeeTextField = new JTextField();
        searchEmployeeTextField.setText("Search employee");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(searchEmployeeTextField, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(spacer1, gbc);
        employeesTable = new JTable();
        employeesTable.setAutoCreateRowSorter(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(employeesTable, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(spacer2, gbc);
        selectEmployeeButton = new JButton();
        selectEmployeeButton.setText("Select Employee");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panel1.add(selectEmployeeButton, gbc);
        newEmployeeButton = new JButton();
        newEmployeeButton.setText("New Employee");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panel1.add(newEmployeeButton, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(spacer3, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel2, gbc);
        selectedEmployeeLabel = new JLabel();
        Font selectedEmployeeLabelFont = this.$$$getFont$$$(null, Font.PLAIN, -1, selectedEmployeeLabel.getFont());
        if (selectedEmployeeLabelFont != null) selectedEmployeeLabel.setFont(selectedEmployeeLabelFont);
        selectedEmployeeLabel.setText("Selected employee : ");
        selectedEmployeeLabel.setVisible(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel2.add(selectedEmployeeLabel, gbc);
        selectedEmployeeIsLabel = new JLabel();
        Font selectedEmployeeIsLabelFont = this.$$$getFont$$$(null, Font.PLAIN, -1, selectedEmployeeIsLabel.getFont());
        if (selectedEmployeeIsLabelFont != null) selectedEmployeeIsLabel.setFont(selectedEmployeeIsLabelFont);
        selectedEmployeeIsLabel.setText("");
        selectedEmployeeIsLabel.setVisible(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(selectedEmployeeIsLabel, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        addEmployeePanel.add(spacer5, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        addEmployeePanel.add(spacer6, gbc);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        addEmployeePanel.add(panel3, gbc);
        okButton = new JButton();
        okButton.setEnabled(false);
        okButton.setText("Ok");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(okButton, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(spacer7, gbc);
        cancelButton = new JButton();
        cancelButton.setText("Cancel");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(cancelButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont)
    {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {resultName = currentFont.getName();}
        else
        {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {resultName = fontName;}
            else {resultName = currentFont.getName();}
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return addEmployeePanel;
    }

    /* GETTER */

    public JTextField getSearchEmployeeTextField()
    {
        return this.searchEmployeeTextField;
    }

    public JTable getEmployeesTable()
    {
        return this.employeesTable;
    }

    public JButton getSelectEmployeeButton()
    {
        return this.selectEmployeeButton;
    }

    public JButton getNewEmployeeButton()
    {
        return this.newEmployeeButton;
    }

    public JLabel getSelectedEmployeeLabel()
    {
        return this.selectedEmployeeLabel;
    }

    public JLabel getSelectedEmployeeIsLabel()
    {
        return this.selectedEmployeeIsLabel;
    }

    public JButton getOkButton()
    {
        return this.okButton;
    }

    public JButton getCancelButton()
    {
        return this.cancelButton;
    }
}
