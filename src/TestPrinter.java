public class TestPrinter {
    public static void main(String[] args) {
        ColorPrinter debug = new ColorPrinter();

        ColorPrinter.clearConsole();

        debug.negative(true);
        debug.bold(true);
        debug.blink(true);
        debug.setTextColor(ANSI_COLOR.BLUE);
        debug.setBackgroundColor(ANSI_COLOR.RED);

        debug.printf("This is a %s. I have %.8f tests to run.\n", "Test", 19999f);

        debug.println("println test");

        debug.print("TEST PRINT");
        debug.print(" ON THE SAME LINE.");
    }
}

