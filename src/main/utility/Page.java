/*
    ------------------------------------------------------
    Name:           Page.java
    Author:         Miles Edwards
    Date:           Jan 2021
    Description:    Parent class for all pages - defined
                    as a glass JPanel divided into 
                    content and top bar
    ------------------------------------------------------
*/

package main.utility;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.GridLayout;
import main.App;

public class Page extends JPanel {
    private static final long serialVersionUID = 1L;
    private JPanel TopBar;
    private double TopBarCover = 0.06;
    private ActionButton HomeBtn;
    private ActionButton OptionsBtn; 
    private ActionButton BackBtn;
    private JLabel Title;
    private JLabel Time;
    
    public Page() {
        setOpaque(false);
        setLayout(null);
        setSize(App.Size());
        ConfigureTopBar();
    }

    private void ConfigureTopBar() { 
        TopBar = new JPanel(new GridLayout());
        TopBar.setBackground(new Color(0, 0, 0, 10));
        TopBar.setBounds(0, 0, getWidth(), (int)(getHeight() * TopBarCover));
        add(TopBar);

        HomeBtn = new ActionButton()
            .Text("Home")
            .Action(() -> App.ChangePage("Menu"));
        
        OptionsBtn = new ActionButton()
            .Text("Options")
            .Action(() -> App.ChangePage("Options"));

        BackBtn = new ActionButton()
            .Text("Back")
            .Action(() -> App.LastPage());

        Title = new JLabel("New Page", SwingConstants.CENTER);
        Title.setFont(FontLoader.Get("resources/fonts/AGENCYB.TTF", 15f));

        Time = new JLabel("Time: 000", SwingConstants.CENTER);
        Time.setFont(FontLoader.Get("resources/fonts/AGENCYB.TTF", 15f));
        Time.setVisible(false);

        TopBar.add(HomeBtn, 0, 0);
        TopBar.add(OptionsBtn, 0, 1);
        TopBar.add(BackBtn, 0, 2);
        TopBar.add(new JLabel(), 0, 3);
        TopBar.add(Title, 0, 4);
        TopBar.add(new JLabel(), 0, 5);
        TopBar.add(new JLabel(), 0, 6);
        TopBar.add(new JLabel(), 0, 7);
        TopBar.add(Time, 0, 8);
    }

    public void SetTitle(String title) {
        Title.setText(title);
    }

    public void ShowTime(boolean flag) {
        Time.setVisible(flag);
    }

    public void BackBtnAction(Action action, String text) {
        BackBtn.Action(action).Text(text);
    }

    public Rectangle GetTopBarBounds() {
        return TopBar.getBounds();
    }
}
