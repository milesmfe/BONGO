/*
    ------------------------------------------------------
    Name:           Home.java
    Author:         Miles Edwards
    Date:           Jan 2021
    Description:    Defines Menu screen object
    ------------------------------------------------------
*/

package main;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import main.utility.FontLoader;
import main.utility.Menu;
import main.utility.Node;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

public class Home extends Menu {
    private static final long serialVersionUID = 1L;
    private Font LabelFont = FontLoader.Get("resources/fonts/AGENCYR.ttf", 30f);
    
    public Home() {
        SetTitle("Home");
        CONSTRAINTS.ipadx = 100;
        BuildUI();
    }

    public void BuildUI() {
        // Start
        JPanel StartPanel = new JPanel(); 
        JLabel StartIcn = new Node("resources/Play.png", 100, 100); 
        JLabel StartTxt = new JLabel("Start"); 
        StartTxt.setFont(LabelFont); 
        StartTxt.setForeground(Color.decode("#E04545")); 
        StartTxt.setVisible(false); 
        StartPanel.setOpaque(false); 
        StartPanel.add(StartIcn); 
        StartPanel.add(StartTxt);

        // Options
        JPanel OptionsPanel = new JPanel(); 
        JLabel OptionsIcn = new Node("resources/Options.png", 100, 100);
        JLabel OptionsTxt = new JLabel("Options"); 
        OptionsTxt.setFont(LabelFont);
        OptionsTxt.setForeground(Color.decode("#2D4B89")); 
        OptionsTxt.setVisible(false); 
        OptionsPanel.setOpaque(false);
        OptionsPanel.add(OptionsIcn); 
        OptionsPanel.add(OptionsTxt);

        // Title
        JLabel title = new Node("resources/Title.gif");
        AddContent(title); 

        // Side Panel
        JPanel Side = new JPanel(new GridLayout(2, 1, 0, 30)); 
        Side.setOpaque(false);
        Side.add(StartPanel);
        Side.add(OptionsPanel); 
        AddContent(Side);

        // Start Mouse Event Listener
        StartPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                StartTxt.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                StartTxt.setVisible(false);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                App.ChangePage("Motherboard");
            }
        });

        // Options Mouse Event Listener
        OptionsPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { 
                super.mouseEntered(e);
                setCursor(new Cursor(Cursor.HAND_CURSOR)); 
                OptionsTxt.setVisible(true); 
            }
            @Override
            public void mouseExited(MouseEvent e) { 
                super.mouseExited(e);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                OptionsTxt.setVisible(false); 
            }
            @Override
            public void mouseClicked(MouseEvent e) { 
                super.mouseClicked(e);
                App.ChangePage("Options");
            }
        });
    }
}
