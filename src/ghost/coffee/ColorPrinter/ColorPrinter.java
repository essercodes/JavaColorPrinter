package ghost.coffee.ColorPrinter;

import java.io.IOException;

/**
 * ColorPrinter is a class that formats output with things like bold, italics, underline, color,
 * and background color.
 *
 * @author Max Esser max@ghost.coffee
 * @see "https://en.wikipedia.org/wiki/ANSI_escape_code#SGR_(Select_Graphic_Rendition)_parameters"
 * @see "https://stackoverflow.com/a/5762502"
 */
public final class ColorPrinter {
    private final String ANSI_RESET = "\033[0m"; //same as "\u001b[0m" and \u001B[0m"

    private boolean enabled;
    private String  textColor;
    private String  backgroundColor;
    private String  bold;
    private String  italics;
    private String  underline;
    private String  blink;
    private String  negative;
    private String  strike;
    private String  framed;
    private String  overline;

    public ColorPrinter() {
        enabled = true;
        textColor = "";
        backgroundColor = "";
        bold = "";
        italics = "";
        underline = "";
        blink = "";
        negative = "";
        strike = "";
        framed = "";
        overline = "";

    }

    /**
     * clearConsole clears console all output if the terminal emulator supports it.
     * @see "http://techno-terminal.blogspot.com/2014/12/clear-command-line-console-and-bold.html"
     */
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * when called the program will wait for the user to press enter before continuing.
     */
    public static void waitForEnterKey() {
        try {
            //noinspection ResultOfMethodCallIgnored
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * enable the printer object. This is the default.
     */
    public void enable() {
        enabled = true;
    }

    /**
     * disable the printer object.
     * Handy for debugging as output of specific lines
     * can be colored and disabled when not in use.
     */
    public void disable() {
        enabled = false;
    }

    /**
     * Set the text color of all output from this object.
     * @param color is an enum of the available text colors options include: BLACK,
     *              RED, GREEN, YELLOW, BLUE, CYAN, and WHITE.
     */
    public void setTextColor(ANSI_COLOR color) {
        this.textColor = colorSwitch(color);
    }

    /**
     * This private method is a switch that takes the color enum and return text color ANSI code.
     * @param color is a the 8 bit text color desired.
     * @return the ANSI text color code as a String.
     */
    private String colorSwitch(ANSI_COLOR color) {
        return this.colorSwitch(color, false);
    }

    /**
     * This private method is a switch that takes the color enum and return text color ANSI code.
     * @param color is the 8-bit color desired.
     * @param background has the method return the corresponding ANSI code for background text color
     *                  if true.
     * @return the ANSI text color code as a String.
     */
    private String colorSwitch(ANSI_COLOR color, boolean background) {
        if (color == null) throw new IllegalArgumentException("null is not a color!");
        //noinspection EnhancedSwitchMigration
        switch (color) {
            case RED:
                if (background) return "\033[41m";  // ANSI Background Red
                return "\033[31m";                  // ANSI Red
            case GREEN:
                if (background) return "\033[42m";  // ANSI Background Green
                return "\033[32m";                  // ANSI Green
            case YELLOW:
                if (background) return "\033[43m";  // ANSI Background Yellow
                return "\033[33m";                  // ANSI Yellow
            case BLUE:
                if (background) return "\033[44m";  // ANSI Background Blue
                return "\033[34m";                  // ANSI Blue
            case PURPLE:
                if (background) return "\033[45m";  // ANSI Background Purple
                return "\033[35m";                  // ANSI Purple
            case CYAN:
                if (background) return "\033[46m";  // ANSI Background Cyan
                return "\033[36m";                  // ANSI Cyan
            case WHITE:
                if (background) return "\033[47m";  // ANSI Background White
                return "\033[37m";                  // ANSI White
            case BLACK:
                if (background) return "\033[40m";  // ANSI Background Black
                return "\033[30m";                  // ANSI Black
            default:
                throw new IllegalArgumentException(color + " is not a valid color");
        }
    }

    /**
     * removeTextColor resets the text color to the default.
     */
    public void removeTextColor() {
        this.textColor = "";
    }

    /**
     * setBackgroundColor sets the background color of the output from this object.
     * @param backgroundColor is an enum of the available background colors, option include:
     *                        BLACK, RED, GREEN, YELLOW, BLUE, CYAN, and WHITE.
     */
    public void setBackgroundColor(ANSI_COLOR backgroundColor) {
        this.backgroundColor = colorSwitch(backgroundColor, true);
    }

    /**
     * removeBackgroundColor resets the background color of output from the object to default.
     * most terminal emulators support background color.
     */
    public void removeBackgroundColor() {
        this.backgroundColor = "";
    }

    /**
     * sets underline formatting for output from the object.
     * @param enable is true output will be underlined, if false underlining will be disabled.
     */
    public void underline(boolean enable) {
        if (enable) {
            this.underline = "\033[4m";  // ANSI Underline
        } else
            this.underline = "";
    }

    /**
     * sets bold formatting for output from the object.
     * @param enable is true output will be bold, if false bold output will be disabled.
     */
    public void bold(boolean enable) {
        if (enable) {
            this.bold = "\033[1m";  // ANSI Bold
        } else {
            this.bold = "";
        }
    }

    /**
     * sets italics formatting for output from the object.
     * @param enable is true output will be italicized, if false italics output will be disabled.
     */
    public void italics(boolean enable) {
        if (enable) {
            this.italics = "\033[3m";  // ANSI italics
        } else {
            this.italics = "";
        }
    }

    /**
     * sets blinking text if supported by terminal emulator. However, this is not widely supported.
     * @param enable is true text will blink, if false blinking will be disabled.
     */
    public void blink(boolean enable) {
        if (enable) {
            this.blink = "\033[5m";  // ANSI Blink
        } else {
            this.blink = "";
        }
    }

    /**
     * sets negative output, text color and background color will be flipped
     * @param enable is true output will be negative, if false negative output will be disabled.
     */
    public void negative(boolean enable) {
        if (enable) {
            this.negative = "\033[7m";  // ANSI Reverse Video
        } else {
            this.negative = "";
        }
    }

    /**
     * sets crossed out text.
     * @param enable is true output will be croessed out, if false striking will be disabled.
     */
    public void strike(boolean enable) {
        if (enable) {
            this.strike = "\033[9m";  // ANSI Strike
        } else {
            this.strike = "";
        }
    }

    /**
     * sets text framing, text will be circled if supported by terminal emulator. However, this
     * is not widely supported.
     * @param enable is true text will be framed, if false framing will be disabled.
     */
    public void framed(boolean enable) {
        if (enable) {
            this.framed = "\033[51m";  // ANSI Framed
        } else {
            this.framed = "";
        }
    }

    /**
     * sets overline, text will have a line on top if supported by the terminal emulator.
     * However, this is not widely supported.
     * @param enable is true text will have overline, if false it will be disabled.
     */
    public void overline(boolean enable) {
        if (enable) {
            this.overline = "\033[53m";  // ANSI Overline
        } else {
            this.overline = "";
        }
    }

    /**
     * Prints output with enabled color and text formatting.
     * @param output is the byte to be printed.
     */
    public void print(byte output) {
        if (enabled)
            this.print(String.valueOf(output));
    }

    /**
     * Prints output with enabled color and text formatting.
     * @param output is the String to be printed.
     */
    public void print(String output) {
        if (enabled)
            System.out.print(
                    ansiCodes()
                    + output
                    + ANSI_RESET);
    }

    /**
     * Private method that returns all the enabled ANSI codes.
     * @return a concatenated string of all the ansi codes.
     */
    private String ansiCodes() {
        return this.bold + this.underline + this.textColor + this.backgroundColor + this.textColor
               + this.backgroundColor + this.bold + this.italics + this.underline + this.blink
               + this.negative + this.strike + this.overline + this.framed;
    }

    /**
     * Prints output with enabled color and text formatting.
     * @param output is the short to be printed.
     */
    public void print(short output) {
        if (enabled)
            this.print(String.valueOf(output));
    }

    /**
     * Prints output with enabled color and text formatting.
     * @param output is the int to be printed.
     */
    public void print(int output) {
        if (enabled)
            this.print(String.valueOf(output));
    }

    /**
     * Prints output with enabled color and text formatting.
     * @param output is the long to be printed.
     */
    public void print(long output) {
        if (enabled)
            this.print(String.valueOf(output));
    }

    /**
     * Prints output with enabled color and text formatting.
     * @param output is the float to be printed.
     */
    public void print(float output) {
        if (enabled)
            this.print(String.valueOf(output));
    }

    /**
     * Prints output with enabled color and text formatting.
     * @param output is the double to be printed.
     */
    public void print(double output) {
        if (enabled)
            this.print(String.valueOf(output));
    }

    /**
     * Prints output with enabled color and text formatting.
     * @param output is the char to be printed.
     */
    public void print(char output) {
        if (enabled)
            this.print(String.valueOf(output));
    }

    /**
     * Prints output with enabled color and text formatting.
     * @param output is the boolean to be printed.
     */
    public void print(boolean output) {
        if (enabled)
            this.print(String.valueOf(output));
    }

    /**
     * Prints output with enabled color and text formatting.
     * @param output is the String to be printed.
     */
    public void println(String output) {
        if (enabled)
            this.print(output + "\n");
    }

    /**
     * Prints output with enabled color and text formatting.
     * @param output is the byte to be printed.
     */
    public void println(byte output) { //
        if (enabled)
            this.println(output);
    }

    /**
     * Prints output with enabled color and text formatting.
     * @param output is the short to be printed.
     */
    public void println(short output) {
        if (enabled)
            this.println(output);
    }

    /**
     * Prints output with enabled color and text formatting.
     * @param output is the int to be printed.
     */
    public void println(int output) {
        if (enabled)
            this.println(output);
    }

    /**
     * Prints output with enabled color and text formatting.
     * @param output is the long to be printed.
     */
    public void println(long output) {
        if (enabled)
            this.println(output);
    }

    /**
     * Prints output with enabled color and text formatting.
     * @param output is the float to be printed.
     */
    public void println(float output) {
        if (enabled)
            this.println(output);
    }

    /**
     * Prints output with enabled color and text formatting.
     * @param output is the double to be printed.
     */
    public void println(double output) {
        if (enabled)
            this.println(output);
    }

    /**
     * Prints output with enabled color and text formatting.
     * @param output is the char to be printed.
     */
    public void println(char output) {
        if (enabled)
            this.println(output);
    }

    /**
     * Prints output with enabled color and text formatting.
     * @param output is the boolean to be printed.
     */
    public void println(boolean output) {
        if (enabled)
            this.println(output);
    }

    /**
     * Prints output with formatting from this object, and System.out.printf formatting.
     * @param format text with printf placeholder parameters
     * @param args printf values to be filled.
     */
    public void printf(String format, Object... args) {
        System.out.printf(ansiCodes()
                          + format
                          + ANSI_RESET
                , args);
    }
}
