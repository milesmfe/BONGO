/*
    ------------------------------------------------------
    Name:           Page.java
    Author:         Miles Edwards
    Date:           Jan 2021
    Description:    Parent class for all pages - defined
                    as a glass JPanel divided into 
                    content and top bar
    ------------------------------------------------------
*/

package main.utility;

import javax.swing.JPanel;
import main.App;

public class Page extends JPanel {
    private static final long serialVersionUID = 1L;
    
    public Page() {
        setOpaque(false);
        setSize(App.Size());
    }
}
