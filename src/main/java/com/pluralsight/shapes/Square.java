package com.pluralsight.shapes;

import com.pluralsight.canvas.Turtle;
import java.awt.*;
import java.awt.geom.Point2D;

public class Square extends Shape {
    private int sideLength; // Prompt user for this
    private final int angle = 90; // Angle at which turtle needs to turn for drawing next side

    public Square(Turtle turtle, Color color, int border, int sideLength) {
        super(turtle, color, border);
        this.sideLength = sideLength;
        setLocation(new Point2D.Double(0, 0));
    }

    public int getSideLength() {
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
        turtle.turnRight(135); // Rotates  degrees to the right
        int halfSideLength = sideLength / 2;
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
        turtle.turnRight(90);
        turtle.penUp(); // Finish drawing
    }
}
