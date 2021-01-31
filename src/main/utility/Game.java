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

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Game extends Page {
    private static final long serialVersionUID = 1L;
    private ArrayList<Part> Parts = new ArrayList<Part>();
    private Part DragPart;
    private Point DragPnt;
    private Point DragOffset;
    private Project _Project;
    private boolean Dragging = false;
    private boolean Complete = false;
    private boolean Started = false;
    public boolean Started() { return Started; }

    public Game() {
        SetTitle("New Game");
        requestFocus();
        ConfigureMouseListeners();
        ShowTime(true);
        BackBtnAction(() -> DisperseParts(), "Reset");
    }

    public void ConfigureMouseListeners() {
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
                    if(DragPart.GetTargetArea().contains(DragPnt)) {
                        DragPart.MoveToTarget();
                    }
                    Dragging = false;
                    DragPart.setVisible(true);
                    if (!Complete) { CheckComplete(); }
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
        Complete = true;
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
        if (!Started) {
            part.setVisible(false); add(part); Parts.add(part);
        }
    }

    public int RandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private Rectangle RandomRect(Part part) {
        return new Rectangle(
            RandomNumber(0, getSize().width - part.getWidth()),
            RandomNumber(0, getSize().height - part.getHeight()),
            part.getWidth(),
            part.getHeight()
        );
    }

    private boolean Overlapping(Rectangle rect) {
        for (Part part: Parts) {
            if (rect.intersects(part.getBounds())) { return true; }
        } 
        if (rect.intersects(_Project.getBounds())) { return true; }
        if (rect.intersects(GetTopBarBounds())) { return true; }
        return false;
    }

    public void DisperseParts() {
        for (Part part: Parts) {
            Rectangle rect = RandomRect(part);
            while (Overlapping(rect)) {
                rect = RandomRect(part);
            }
            part.Source(rect.x, rect.y);
            part.setVisible(true);
            part.Reset();
        } 
        Started = true;
        Complete = false;
    }

    public void SetProject(Project project) {
        add(project); _Project = project;
        Point point = project.getLocation();
        for (Part part: Parts) {
            part.Target(point.x + part.GetTarget().x, point.y + part.GetTarget().y);
        }
    }
}