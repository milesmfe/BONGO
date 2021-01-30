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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import main.App;

public class Page extends JPanel {
    private static final long serialVersionUID = 1L;
    private JPanel TopBar;
    private double TopBarCover = 0.05;
    private JPanel BottomBar;
    private double BottomBarCover = 0.05;
    private ActionButton HomeBtn;
    private ActionButton BackBtn;
    private ActionButton CustomBtn;
    private Action HomeBtnAction;
    private Action BackBtnAction;
    private Action CustomBtnAction;
    private JLabel Title = new JLabel();
    
    public Page() {
        setOpaque(false);
        setLayout(null);
        setSize(App.Size());
        ConfigureTopBar();
        ConfigureBottomBar();
        ConfigureBackBtn(() -> App.LastPage());
        ConfigureHomeBtn(() -> App.ChangePage("Menu"));
    }

    private void ConfigureTopBar() { 
        TopBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        TopBar.setBackground(new Color(0, 0, 0, 10));
        TopBar.setBounds(0, 0, getWidth(), (int)(getHeight() * TopBarCover));
        add(TopBar);

        HomeBtn = new ActionButton("H");
        TopBar.add(HomeBtn);
        HomeBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                HomeBtnAction.run();
            }
        });

        BackBtn = new ActionButton("B");
        TopBar.add(BackBtn);
        BackBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                BackBtnAction.run();
            }
        });

        TopBar.add(Title);
    }

    private void ConfigureBottomBar() {
        BottomBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        BottomBar.setBackground(new Color(0, 0, 0, 10));
        BottomBar.setBounds(0, getHeight() - (int)(getHeight() * BottomBarCover), getWidth(), (int)(getHeight() * BottomBarCover));
        add(BottomBar);

        CustomBtn = new ActionButton("");
        CustomBtn.setVisible(false);
        BottomBar.add(CustomBtn);
        CustomBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                CustomBtnAction.run();
            }
        });
    }

    public void SetTitle(String title) {
        Title.setText(title);
    }

    public void ConfigureBackBtn(Action action) {
        BackBtnAction = action;
    }

    public void ConfigureHomeBtn(Action action) {
        HomeBtnAction = action;
    }

    public void ConfigureCustomBtn(String text, Action action) {
        CustomBtnAction = action;
        CustomBtn.setText(text);
        CustomBtn.setVisible(true);
    }

    public Rectangle GetTopBarBounds() {
        return TopBar.getBounds();
    }

    public Rectangle GetBottomBarBounds() {
        return BottomBar.getBounds();
    }
}