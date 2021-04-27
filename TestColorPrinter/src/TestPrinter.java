import ghost.coffee.ColorPrinter.ANSI_COLOR;
import ghost.coffee.ColorPrinter.ColorPrinter;
import static ghost.coffee.ColorPrinter.ANSI_COLOR.*;

public class TestPrinter {
    public static void main(String[] args) {
        ColorPrinter debug = new ColorPrinter();

        ColorPrinter.clearConsole();

        System.out.println(ANSI_COLOR.BLUE);
        debug.negative(true);
        debug.bold(true);
        debug.blink(true);
        debug.setTextColor(BLUE);
        debug.setBackgroundColor(RED);

        debug.printf("This is a %s. I have %d tests to run.\n", "Test", 19999);

        debug.println("println test");

        debug.print("TEST PRINT");
        debug.print(" ON THE SAME LINE.");

        ColorPrinter.clearConsole();
    }
}

