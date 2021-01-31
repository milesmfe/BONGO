package main.utility;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import main.App;

public class FontLoader {

    public static Font Get(String path, float size) {
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(App.class.getResource(path).toURI())).deriveFont(size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            return customFont;
        } catch (IOException | FontFormatException | URISyntaxException e) {
            return null;
        }
    }
}
