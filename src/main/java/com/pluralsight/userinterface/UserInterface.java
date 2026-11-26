package com.pluralsight.userinterface;

import com.pluralsight.canvas.Turtle;
import com.pluralsight.canvas.World;
import com.pluralsight.shapes.Hexagon;
import com.pluralsight.shapes.Square;

import java.awt.*;
import java.awt.geom.Point2D;

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
        int selectedOption; // Home screen
        do {
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
                default -> System.out.println("Invalid option, please try again.");
            }
        } while (selectedOption != 0);
//        EquilateralTriangle triangle = new EquilateralTriangle(turtle, Color.black, 3, 100);
//        triangle.paint();
//        Circle circle = new Circle(turtle, Color.black, 3, 50);
//        circle.paint();
//        Hexagon hexagon = new Hexagon(turtle, Color.black, 3, 50);
//        hexagon.paint();
    }

    private void addShape() {
        int selectedOption;
        do {
            System.out.println("""
                    \n        ⟨ Available shapes ⟩        
                    [1] Square
                    [2] Triangle
                    [3] Circle
                    [4] Hexagon""");
            selectedOption = Console.promptForInt(
                    "› Select a shape [1-4]: ", false);

            switch (selectedOption) { // Process selected menu option
                case 1 -> processPaintSquare();
                case 2 -> processPaintTriangle();
                case 3 -> processPaintCircle();
                case 4 -> processPaintHexagon();
                default -> System.out.println("Invalid option, please try again.");
            }
        } while (selectedOption != 1 && selectedOption != 2 && selectedOption != 3 && selectedOption != 4);
    }

    private void processPaintSquare() {
        double sideLength = Console.promptForDouble( // Prompt user for square size
                "› Square side in pixels (1 - 499): ", false);
        Square square = new Square
                (turtle, promptLocation(), promptBorderColor(), promptBorderWidth(), sideLength);
        square.paint();

    }

    private void processPaintTriangle() {
    }

    private void processPaintCircle() {
        double radius = Console.promptForDouble( // Prompt user for radius
                "› Radius in pixels (1 - 499): ", false);
    }

    private void processPaintHexagon() {
    }

    // Helper method – prompts for border width
    private int promptBorderWidth() {
        int input = Console.promptForInt( // Prompt for border width
                "› Border width (press Enter↵ to skip): ", true);
        return input;
    }

    // Helper method – prompts for border color
    private Color promptBorderColor(){
        int selectedColor; // Prompt for color
        Color color = color = Color.BLACK;;
        do {
            System.out.println("""
                    Available colors:
                    [1] Black
                    [2] Blue
                    [3] Magenta
                    [4] Cyan
                    [5] Red""");
            selectedColor = Console.promptForInt(
                    "› Color (press Enter↵ to skip): ", true);
            switch (selectedColor) {
                case 1 -> {}
                case 2 -> color = Color.BLUE;
                case 3 -> color = Color.MAGENTA;
                case 4 -> color = Color.CYAN;
                case 5 -> color = Color.RED;
                default -> System.out.println("Invalid option, please try again.");
            }
        } while (selectedColor != 1 && selectedColor != 2 && selectedColor != 3 && selectedColor != 4 && selectedColor != 5);
        return color;
    }

    // Helper method – prompts for location of the shape
    private Point2D promptLocation() {
        int x = Console.promptForInt( // Prompt for coordinates - location
                "› x coordinate ((1 - 499), press Enter↵ to skip): ", true);
        int y = Console.promptForInt( // Prompt for coordinates - location
                "› y coordinate (1 - 499): ", false);
        return new Point(x, y);
    }

    private void saveImage() {
    }
}
