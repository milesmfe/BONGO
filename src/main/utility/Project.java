/*
    ------------------------------------------------------
    Name:           Project.java
    Author:         Miles Edwards
    Date:           Jan 2021
    Description:    Defines subclass of Node with position
                    center screen
    ------------------------------------------------------
*/

package main.utility;

import main.App;
import java.awt.Rectangle;

public class Project extends Node {
    private static final long serialVersionUID = 1L;

    public Project(String image, int width, int height) {
        super(image, width, height, 0, 0);
        int x = App.Size().width / 2 - width / 2;
        int y = App.Size().height / 2 - height / 2;
        setBounds(new Rectangle(x, y, width, height));
    }

    public Project Add(Game game) {
        game.SetProject(this);
        return this;
    }
}