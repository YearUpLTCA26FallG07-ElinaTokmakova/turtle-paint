package com.pluralsight.shapes;

import com.pluralsight.canvas.Turtle;

import java.awt.*;
import java.awt.geom.Point2D;

public class EquilateralTriangle extends Shape {
    private double sideLength;
    private final int angle;

    public EquilateralTriangle(Turtle turtle, Point2D location, Color color, int border, double sideLength) {
        super(turtle, location, color, border);
        this.sideLength = sideLength;
        this.angle = 60;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    public int getAngle() {
        return angle;
    }

    @Override
    public void paint() {
        Turtle turtle = getTurtle();
        turtle.penUp(); // Making sure turtle leaves no trail till it gets to starting point
        turtle.turnRight(120); // Rotates  degrees to the right
        double x =  - sideLength / 2.0;
        double y = - sideLength / 3.0;
        turtle.goTo(x, y); // Moves to starting point
        turtle.turnRight(180);
        turtle.penDown(); // Start drawing
        turtle.forward(sideLength); // First side
        turtle.turnRight(120);
        turtle.forward(sideLength); // Second side
        turtle.turnRight(120);
        turtle.forward(sideLength); // Third side
        turtle.penUp(); // Finish drawing
        turtle.turnRight(135);
        turtle.goTo(0,0); // Return to center
        turtle.turnRight(45);
    }
}
