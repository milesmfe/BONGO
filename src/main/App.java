/*
    ------------------------------------------------------
    Name:           App.java
    Author:         Miles Edwards
    Date:           Jan 2021
    Description:    Main class of program
    ------------------------------------------------------
*/

package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import main.gamemodes.*;
import main.utility.ImageLoader;

public class App extends JFrame {
    private static final long serialVersionUID = 1L;
    public static Dimension Size() { return new Dimension(
            Toolkit.getDefaultToolkit().getScreenSize().width / 2,
            Toolkit.getDefaultToolkit().getScreenSize().height / 2); }
    private static CardLayout ViewManager = new CardLayout();
    private static JPanel View;

    public App() {
        setTitle("BONGO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        setIconImage(ImageLoader.fromPath("resources/Icon.png").getImage());
        setupView();
        setContentPane(View);
        pack();
        setVisible(true);
    }

    private void setupView() {
        View = new JPanel();
        View.setPreferredSize(Size());
        View.setLayout(ViewManager);
        View.add(new Motherboard(), "Motherboard");
    }

    public static void ChangePage(String pageName) {
        ViewManager.show(View, pageName);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Launching BONGO...");
        SwingUtilities.invokeLater(App::new);
    }
}