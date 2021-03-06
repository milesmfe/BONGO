/*
    ------------------------------------------------------
    Name:           Node.java
    Author:         Miles Edwards
    Date:           Jan 2021
    Description:    Defines JLabel object with specified
                    Image and bounds
    ------------------------------------------------------
*/

package main.utility;

import javax.swing.JLabel;

public class Node extends JLabel {
    private static final long serialVersionUID = 1L;

    public Node(String image, int width, int height, int x, int y) {
        super(ImageLoader.fromPathScaled(image, width, height));
        setBounds(x, y, width, height);
    }

    public Node(String image, int width, int height) {
        super(ImageLoader.fromPathScaled(image, width, height));
    }

    public Node(String image) {
        super(ImageLoader.fromPath(image));
    }

    public Node Add(Page Target) {
        Target.add(this);
        return this;
    }

    public Node AddContent(Menu Target) {
        Target.AddContent(this);
        return this;
    }
}