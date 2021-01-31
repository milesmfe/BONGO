/*
    ------------------------------------------------------
    Name:           ImageLoader.java
    Author:         Miles Edwards
    Date:           Jan 2021
    Description:    Utility object used to handle the
                    loading of images
    ------------------------------------------------------
*/

package main.utility;

import java.awt.Image;
import javax.swing.ImageIcon;

import main.App;

public class ImageLoader {

    public static ImageIcon fromPath(String path) {
        return new ImageIcon(App.class.getResource(path));
    }

    public static ImageIcon fromPathScaled(String path, int Width, int Height) {
        return new ImageIcon(fromPath(path).getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH));
    }
}