package com.pluralsight;

import com.pluralsight.canvas.Turtle;
import com.pluralsight.canvas.World;

public class UserInterface {
    // Create canvas
    public static World world = new World(500, 500);
    // Create turtle
    public static Turtle turtle = new Turtle(world, 0, 0);

    public static void display() throws InterruptedException {
        // No trail by default
        turtle.penUp();

        drawRectangle();
        drawCircle();
    }

    public static void drawRectangle() throws InterruptedException {
        delay();
        turtle.turnRight(90); // rotates 90 degrees to the right
        turtle.forward(50); // moves 50 "steps" forward
        // Start drawing
        turtle.penDown();
        turtle.turnRight(90);
        turtle.forward(50);

        turtle.turnRight(90);
        turtle.forward(100);
        turtle.turnRight(90);

        turtle.forward(100);
        turtle.turnRight(90);
        turtle.forward(100);

        turtle.turnRight(90);
        turtle.forward(50);
    }

    public static void drawCircle() {
        int steps = 24;
        double stepLength = 10; // controls circle size
        double angle = 360.0 / steps; // 10 degrees per step

        turtle.penUp();
        turtle.goTo(0, -120); // move to a starting point so it doesn't overlap the rectangle
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
