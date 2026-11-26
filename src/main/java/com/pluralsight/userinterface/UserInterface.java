package com.pluralsight.userinterface;

import com.pluralsight.canvas.Turtle;
import com.pluralsight.canvas.World;
import com.pluralsight.shapes.Hexagon;

import java.awt.*;

public class UserInterface {
    private World world;
    private Turtle turtle;

    // Creates canvas and turtle, adds backround image
    private void init() {
        this.world = new World(500, 500);
        this.turtle = new Turtle(world, 0, 0);
        world.setBackgroundImage("background_grid.png");
    }

    public void display() {
        init();
        int selectedOption;

        do { // Home screen
            System.out.println("""
                            ⟨ Home screen ⟩        
                    [1] Add shape
                    [2] Save image
                    [0] Exit""");
            selectedOption = Console.promptForInt(
                    "› Select an option [0-2]: ", false);

            switch (selectedOption) { // Process selected menu option
                case 1 -> addShape();
                case 2 -> saveImage();
                case 0 -> {
                    System.out.println("\nHave a good day!");
                    world.dispose(); // Closes the Turtle window
                    System.exit(0); // Terminates the JVM process
                }
                default -> System.out.println("\nInvalid option, please try again.");
            }
        } while(selectedOption != 0);
//        Square square = new Square(turtle, Color.black, 3, 200);
//square.paint();
//        EquilateralTriangle triangle = new EquilateralTriangle(turtle, Color.black, 3, 100);
//        triangle.paint();
//        Circle circle = new Circle(turtle, Color.black, 3, 50);
//        circle.paint();
//        Hexagon hexagon = new Hexagon(turtle, Color.black, 3, 50);
//        hexagon.paint();
    }

    private void addShape() {
    }

    private void saveImage() {
    }

    public static void delay() throws InterruptedException {
        Thread.sleep(500);
    }
}
