package main.utility;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import main.App;

public class FontLoader {

    public static Font Get(String path, float size) {
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, App.class.getResource(path).openStream()).deriveFont(size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            return customFont;
        } catch (IOException | FontFormatException e) {
            return null;
        }
    }
}
