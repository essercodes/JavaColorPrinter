default: build

run: TestPrinter.class
	java -cp out/production/ColorPrinter TestPrinter

jar: ColorPrinter.class
	jar cf colorprinter.jar out/production/ColorPrinter/ColorPrinter.class out/production/ColorPrinter/ANSI_COLOR.class

compile: ColorPrinter.class TestPrinter.class

clean:
	$(RM) ColorPrinter.jar
	$(RM) *.class
	$(RM) out/production/ColorPrinter/*.class

ColorPrinter.class: src/ColorPrinter.java ANSI_COLOR.class
	javac -cp src src/ColorPrinter.java -d out/production/ColorPrinter/

ANSI_COLOR.class: src/ANSI_COLOR.java
	javac -cp src src/ANSI_COLOR.java -d out/production/ColorPrinter/
