package com.pluralsight.shapes;

import com.pluralsight.canvas.Turtle;

import java.awt.*;

public class Hexagon extends Shape {
    private double sideLength;
    private final int angle;

    public Hexagon(Turtle turtle, Color color, int border, double sideLength) {
        super(turtle, color, border);
        this.sideLength = sideLength;
        this.angle = 120;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public int getAngle() {
        return angle;
    }

    @Override
    public void paint() {
        double halfHeight = sideLength * Math.sqrt(3) / 2.0; // Flat-to-flat formula
        Turtle turtle = getTurtle();
        turtle.penUp(); // Making sure turtle leaves no trail till it gets to starting point
        turtle.turnLeft(90);
        turtle.goTo(0, halfHeight); // Moves to starting point
        turtle.turnRight(120);
        turtle.penDown(); // Start drawing
        turtle.forward(sideLength);
        turtle.turnRight(60);
        turtle.forward(sideLength);
        turtle.turnRight(60);
        turtle.forward(sideLength);
        turtle.turnRight(60);
        turtle.forward(sideLength);
        turtle.turnRight(60);
        turtle.forward(sideLength);
        turtle.turnRight(60);
        turtle.forward(sideLength);
        turtle.penUp(); // Finish drawing
        turtle.turnRight(120);
        turtle.goTo(0,0);
        turtle.turnLeft(90);
    }
}
