package com.pluralsight;

import com.pluralsight.canvas.Turtle;
import com.pluralsight.canvas.World;
import com.pluralsight.shapes.Circle;
import com.pluralsight.shapes.EquilateralTriangle;
import com.pluralsight.shapes.Hexagon;
import com.pluralsight.shapes.Square;

import java.awt.*;
import java.awt.geom.Point2D;

public class UserInterface {
    // Create canvas
    public static World world = new World(500, 500);
    // Create turtle
    public static Turtle turtle = new Turtle(world, 0, 0);

    public static void display() throws InterruptedException {
        // Add background image
        world.setBackgroundImage("background_grid.png");
//        Square square = new Square(turtle, Color.black, 3, 200);
//square.paint();
//        EquilateralTriangle triangle = new EquilateralTriangle(turtle, Color.black, 3, 100);
//        triangle.paint();
//        Circle circle = new Circle(turtle, Color.black, 3, 50);
//        circle.paint();
        Hexagon hexagon = new Hexagon(turtle, Color.black, 3, 50);
        hexagon.paint();
    }

    public static void drawCircle() throws InterruptedException {
        int radius = 50;
        int steps = 36;
        double angle = 360.0 / steps; // Angle at which turtle needs to turn for next step
        double stepLength = (2 * Math.PI * radius) / steps; // 10 degrees per step
        delay();
        turtle.penUp();
        turtle.goTo(0, -120); // Move to a starting point so it doesn't overlap the rectangle
        turtle.penDown();
        for (int i = 0; i < steps; i++) {
            turtle.forward(stepLength);
            turtle.turnRight(angle);
        }
        turtle.penUp();
    }

    public static void delay() throws InterruptedException {
        Thread.sleep(500);
    }
}
