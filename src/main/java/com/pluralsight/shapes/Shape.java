package com.pluralsight.shapes;

import com.pluralsight.canvas.Turtle;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Shape {
    private Turtle turtle; // Turtle that is used to paint the shape
    private Point2D.Double location; // x, y coordinate where the shape should be drawn
    private Color color; // Color used for the border
    private int border; // Width of the shape border

    public Shape(Turtle turtle, Point2D location, Color color, int border) {
        this.turtle = turtle;
        this.location = new Point2D.Double(0,0);
        this.color = color;
        this.border = 5;
    }

    public Turtle getTurtle() {
        return turtle;
    }

    public void setTurtle(Turtle turtle) {
        this.turtle = turtle;
    }

    public Point2D.Double getLocation() {
        return location;
    }

    public void setLocation(Point2D.Double location) {
        this.location = location;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getBorder() {
        return border;
    }

    public void setBorder(int border) {
        this.border = border;
    }

    // Method that paints the shape
    public abstract void paint();
}
