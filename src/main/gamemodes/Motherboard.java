/*
    ------------------------------------------------------
    Name:           Motherboard.java
    Author:         Miles Edwards
    Date:           Jan 2021
    Description:    Defines the motherboard gamemode
    ------------------------------------------------------
*/

package main.gamemodes;

import main.utility.Part;
import main.utility.Project;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import main.App;
import main.utility.Game;

public class Motherboard extends Game {
    private static final long serialVersionUID = 1L;

    public Motherboard() {

        // Disperse Parts Button
        JButton Btn = new JButton("Disperse Parts");
        Btn.setBounds(App.Size().width / 2 - 60, 5, 120, 30);
        add(Btn);
        Btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                DisperseParts();
            }
        });

        new Part("resources/CPU.png", 116, 116)
            .Target(336, 44)
            .Lenience(10)
            .Add(this);

        new Part("resources/GPU.png", 52, 52)
            .Target(320, 228)
            .Lenience(5)
            .Add(this);

        new Part("resources/RAM.png", 220, 8)
            .Target(64, 28)
            .Lenience(50)
            .Add(this);

        new Part("resources/RAM.png", 220, 8)
            .Target(64, 68)
            .Lenience(50)
            .Add(this);

        new Part("resources/BIOS-CMOS.png", 68, 100)
            .Target(332, 336)
            .Lenience(5)
            .Add(this);

        new Project("resources/Motherboard.png", 524, 496)
            .Add(this);
    }
}