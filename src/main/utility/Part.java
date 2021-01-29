/*
    ------------------------------------------------------
    Name:           Part.java
    Author:         Miles Edwards
    Date:           Jan 2021
    Description:    Defines subclass of Node with a
                    target point
    ------------------------------------------------------
*/

package main.utility;

import java.awt.Rectangle;

public class Part extends Node {
    private static final long serialVersionUID = 1L;
    private Rectangle Target = new Rectangle(0, 0);
    private boolean InPosition = false; public boolean InPosition() { return InPosition; }

    public Part(String image, int width, int height) {
        super(image, width, height);
        setSize(width, height);
    }

    public Part Source(int x, int y) { 
        setBounds(new Rectangle(x, y, getWidth(), getHeight()));
        return this;
    }

    public Part Target(int x, int y) {
        Target = new Rectangle(x, y, getWidth(), getHeight());
        return this; 
    }

    public Part Add(Game game) {
        game.AddPart(this);
        return this;
    }

    public void MoveToTarget() {
        setBounds(Target);
        InPosition = true;
    }

    public void Reset() {
        InPosition = false;
    }

    public Rectangle GetTarget() {
        return Target;
    }
}