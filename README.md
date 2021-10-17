# Java Color Printer

Add `colorprinter.jar` to your class path to print the Java stdout with formatting and color.

## How to use

```java
import ghost.coffee.ColorPrinter.ColorPrinter;
import static ghost.coffee.ColorPrinter.ANSI_COLOR.*;

public class JarTest {
    public static void main(String[] args) {

        // Print formatted text
        ColorPrinter cp = new ColorPrinter();
        cp.setTextColor(WHITE);
        cp.negative(true);
        cp.italics(true);
        cp.underline(true);
        cp.println("Hello World!");

        // Create Simple Debugs
        ColorPrinter debug = new ColorPrinter();
        debug.setTextColor(GREEN);
        debug.disable();
        debug.print("DEBUG: I'm disabled");

        ColorPrinter warning = new ColorPrinter();
        warning.setTextColor(YELLOW);
        warning.printf("%d yellow warnings", 1000);

    }
}
```

## Creating the Jar

If you would like to compile the jar from scratch run the make command.
```bash
make jar
```
