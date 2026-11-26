package com.pluralsight.shapes;

import com.pluralsight.canvas.Turtle;

import java.awt.*;
import java.awt.geom.Point2D;

public class Circle extends Shape {
    private double sideLength;
    private double radius;
    private final int steps;
    private final double angle; // Angle at which turtle needs to turn for next step

    public Circle(Turtle turtle, Point2D location, Color color, int border, double radius) {
        super(turtle, location, color, border);
        this.steps = 36;
        this.sideLength = (2 * Math.PI * radius) / steps; // Circumference divided by steps
        this.radius = radius;
        this.angle = 360.0 / steps;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getSteps() {
        return steps;
    }

    public double getAngle() {
        return angle;
    }

    @Override
    public void paint() {
        Turtle turtle = getTurtle();
        turtle.penUp(); // Making sure turtle leaves no trail till it gets to starting point
        turtle.goTo(radius, 0); // Move to a starting point so it doesn't overlap the rectangle
        turtle.turnRight(90);
        turtle.penDown(); // Start drawing
        for (int i = 0; i < steps; i++) {
            turtle.forward(sideLength);
            turtle.turnRight(angle);
        }
        turtle.penUp(); // Stop drawing
        turtle.turnRight(90);
        turtle.goTo(0,0);
        turtle.setHeading(0);
    }
}
