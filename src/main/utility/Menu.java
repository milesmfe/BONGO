/*
    ------------------------------------------------------
    Name:           Menu.java
    Author:         Miles Edwards
    Date:           Jan 2021
    Description:    Parent class for all menu pages
    ------------------------------------------------------
*/

package main.utility;

import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Menu extends Page {
    private static final long serialVersionUID = 1L;
    public final GridBagConstraints CONSTRAINTS = new GridBagConstraints();
    private JPanel Content;

    public Menu() {
        ConfigureContent();
    }

    private void ConfigureContent() {
        Content = new JPanel(new GridBagLayout());
        Content.setOpaque(false);
        Content.setBounds(0, GetTopBarBounds().height, getWidth(), getHeight() - GetTopBarBounds().height);
        add(Content);
    }

    public void AddContent(JComponent component) {
        Content.add(component, CONSTRAINTS);
    }
}