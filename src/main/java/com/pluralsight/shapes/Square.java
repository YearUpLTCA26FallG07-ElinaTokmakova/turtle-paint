package com.pluralsight.shapes;

import com.pluralsight.canvas.Turtle;
import java.awt.*;
import java.awt.geom.Point2D;

public class Square extends Shape {
    private double sideLength; // Prompt user for this
    private final int angle = 90; // Angle at which turtle needs to turn for drawing next side

    public Square(Turtle turtle, Point2D location, Color color, int border, double sideLength) {
        super(turtle, location, color, border);
        this.sideLength = sideLength;
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
        double halfSideLength = sideLength / 2.0;
        Turtle turtle = getTurtle();
        turtle.penUp(); // Making sure turtle leaves no trail till it gets to starting point
        turtle.turnRight(135); // Rotates  degrees to the right
        turtle.goTo(-halfSideLength, -halfSideLength); // Moves to starting point
        turtle.turnRight(135);
        turtle.penDown(); // Start drawing
        turtle.forward(sideLength); // First side
        turtle.turnRight(90);
        turtle.forward(sideLength); // Second side
        turtle.turnRight(90);
        turtle.forward(sideLength); // Third side
        turtle.turnRight(90);
        turtle.forward(sideLength); // Fourth side
        turtle.penUp(); // Finish drawing
        turtle.turnRight(135);
        turtle.goTo(0,0); // Return to center
        turtle.turnRight(45);
    }
}
