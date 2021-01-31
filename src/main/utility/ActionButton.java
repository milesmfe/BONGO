/*
    ------------------------------------------------------
    Name:           ActionButton.java
    Author:         Miles Edwards
    Date:           Jan 2021
    Description:    Defines custom JButton object
    ------------------------------------------------------
*/

package main.utility;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ActionButton extends JButton {
    private static final long serialVersionUID = 1L;
    private Action _Action;
    
    public ActionButton() {
        addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                _Action.run();
            }
        });
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
