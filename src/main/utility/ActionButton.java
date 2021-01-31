/*
    ------------------------------------------------------
    Name:           ActionButton.java
    Author:         Miles Edwards
    Date:           Jan 2021
    Description:    Defines custom JButton object
    ------------------------------------------------------
*/

package main.utility;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class ActionButton extends JLabel {
    private static final long serialVersionUID = 1L;
    private Action _Action;
    
    public ActionButton() {
        super("Action", SwingConstants.CENTER);
        setFont(FontLoader.Get("resources/fonts/AGENCYB.TTF", 15f));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                _Action.run();
            }
        });
    }

    public ActionButton Icon(String path, int width, int height) {
        setIcon(ImageLoader.fromPathScaled(path, width, height));
        return this;
    }

    public ActionButton Text(String text) {
        setText(text);
        return this;
    }

    public ActionButton Action(Action action) {
        _Action = action;
        return this;
    }
}
