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
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.FlowLayout;
import main.App;

public class Page extends JPanel {
    private static final long serialVersionUID = 1L;
    private JPanel TopBar;
    private double TopBarCover = 0.06;
    private ActionButton HomeBtn;
    private ActionButton OptionsBtn; 
    private ActionButton BackBtn;
    private JLabel Title;
    
    public Page() {
        setOpaque(false);
        setLayout(null);
        setSize(App.Size());
        ConfigureTopBar();
    }

    private void ConfigureTopBar() { 
        TopBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        TopBar.setBackground(new Color(0, 0, 0, 10));
        TopBar.setBounds(0, 0, getWidth(), (int)(getHeight() * TopBarCover));
        add(TopBar);

        HomeBtn = new ActionButton()
            .Text("H")
            .Action(() -> App.ChangePage("Menu"));
        
        OptionsBtn = new ActionButton()
            .Text("O")
            .Action(() -> App.ChangePage("Options"));

        BackBtn = new ActionButton()
            .Text("B")
            .Action(() -> App.LastPage());

        Title = new JLabel("New Page");
        Title.setFont(FontLoader.Get("resources/fonts/AGENCYB.TTF", 15f));

        TopBar.add(HomeBtn);
        TopBar.add(OptionsBtn);
        TopBar.add(BackBtn);
        TopBar.add(Title);
    }

    public void SetTitle(String title) {
        Title.setText(title);
    }

    public void BackBtnAction(Action action) {
        BackBtn.Action(action);
    }

    public Rectangle GetTopBarBounds() {
        return TopBar.getBounds();
    }
}
