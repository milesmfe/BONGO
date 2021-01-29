/*
    ------------------------------------------------------
    Name:           Game.java
    Author:         Miles Edwards
    Date:           Jan 2021
    Description:    Parent class for all gamemodes
                    with drag and drop functionality
    ------------------------------------------------------
*/

package main.utility;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import main.App;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Game extends JPanel {
    private static final long serialVersionUID = 1L;
    private ArrayList<Part> Parts;
    private Part DragPart;
    private Point DragPnt;
    private Point DragOffset;
    private Project _Project;
    private boolean Dragging;
    private boolean ProjectSet = false;

    public Game() {
        Parts = new ArrayList<Part>();
        Dragging = false;
        setLayout(null);
        requestFocus();
        BuildUI();
    }

    public void BuildUI() {
        setBackground(Color.decode("#EDF0E8"));

        // Disperse Parts Button
        JButton Btn = new JButton("Disperse Parts");
        Btn.setBounds(App.Size().width / 2 - 60, 5, 120, 30);
        add(Btn);
        Btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                DisperseParts();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                Point point = e.getPoint();
                Part part = FindPart(point);

                if (part != null) {
                    DragPart = part;
                    DragPnt = point;
                    DragOffset = part.getMousePosition();
                    Dragging = true;
                    part.setVisible(false);
                    repaint();
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (Dragging) {
                    if(DragPart.GetTarget().contains(DragPnt)) {
                        DragPart.MoveToTarget();
                    }
                    Dragging = false;
                    DragPart.setVisible(true);
                    CheckComplete();
                    repaint();
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if (Dragging) {
                    DragPnt = e.getPoint();
                    repaint();
                }
            }
        });
    }

    private Part FindPart(Point point) {
        for (Part part: Parts) {
            if (part.getBounds().contains(point)) { return part; }
        } return null;
    }

    private boolean CheckComplete() {
        for (Part part: Parts) {
            if (!part.InPosition()) { return false; }
        } 
        System.out.println("Project is complete! Well Done.");
        return true;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (Dragging) {
            DragPart.getIcon().paintIcon(this, g, DragPnt.x - DragOffset.x, DragPnt.y - DragOffset.y);
        }
    }

    public void AddPart(Part part) {
        if (!ProjectSet) {
            add(part); Parts.add(part);
        }
    }

    public int RandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private void DisperseParts() {
        for (Part part: Parts) {
            Rectangle rect = new Rectangle(
                RandomNumber(0, App.Size().width - part.getWidth()),
                RandomNumber(0, App.Size().height - part.getHeight()), 
                part.getWidth(),
                part.getHeight()
            );
            while (rect.intersects(_Project.getBounds())) {
                rect = new Rectangle(RandomNumber(0, App.Size().width), RandomNumber(0, App.Size().height), part.getWidth(), part.getHeight());
            } 
            part.Source(rect.x, rect.y);
            part.Reset();
        }
    }

    public void SetProject(Project project) {
        add(project); _Project = project;
        Point point = project.getLocation();
        for (Part part: Parts) {
            part.Target(point.x + part.GetTarget().x, point.y + part.GetTarget().y);
        }
        DisperseParts();
        ProjectSet = true;
    }
}