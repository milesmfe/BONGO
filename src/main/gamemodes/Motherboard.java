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
import main.utility.Game;

public class Motherboard extends Game {
    private static final long serialVersionUID = 1L;

    public Motherboard() {

        SetTitle("The Motherboard");

        new Part("resources/CPU.png", 58, 58)
            .Target(168, 22)
            .Lenience(10)
            .Add(this);

        new Part("resources/GPU.png", 26, 26)
            .Target(160, 114)
            .Lenience(5)
            .Add(this);

        new Part("resources/RAM.png", 110, 4)
            .Target(32, 14)
            .Lenience(50)
            .Add(this);

        new Part("resources/RAM.png", 110, 4)
            .Target(32, 34)
            .Lenience(50)
            .Add(this);

        new Part("resources/BIOS-CMOS.png", 34, 50)
            .Target(166, 168)
            .Lenience(5)
            .Add(this);

        new Project("resources/Motherboard.png", 262, 248)
            .Add(this);

        DisperseParts();
    }
}