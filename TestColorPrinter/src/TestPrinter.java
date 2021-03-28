import out.production.ColorPrinter.ANSI_COLOR;
import out.production.ColorPrinter.ColorPrinter;

public class TestPrinter {
    public static void main(String[] args) {
        ColorPrinter debug = new ColorPrinter();

        ColorPrinter.clearConsole();

        debug.negative(true);
        debug.bold(true);
        debug.blink(true);
        debug.setTextColor(ANSI_COLOR.BLUE);
        debug.setBackgroundColor(ANSI_COLOR.RED);

        debug.printf("This is a %s. I have %d tests to run.\n", "Test", 19999);

        debug.println("println test");

        debug.print("TEST PRINT");
        debug.print(" ON THE SAME LINE.");

        ColorPrinter.clearConsole();
    }
}

