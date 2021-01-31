/*
    ------------------------------------------------------
    Name:           Menu.java
    Author:         Miles Edwards
    Date:           Jan 2021
    Description:    Defines Menu screen object
    ------------------------------------------------------
*/

package main;

import javax.swing.JLabel;
import main.utility.ImageLoader;
import main.utility.Page;

public class Menu extends Page {
    private static final long serialVersionUID = 1L;
    
    public Menu() {
        SetTitle("Menu");
        JLabel Title = new JLabel();
        Title.setIcon(ImageLoader.fromPathScaled("resources/Title.gif", 200, 200));
        Title.setBounds(0, 0, 200, 200);
        add(Title);
    }
}