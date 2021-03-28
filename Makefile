run: compile
	java -cp out/production/ColorPrinter TestPrinter

compile: ColorPrinter.class TestPrinter.class

clean:
	$(RM) *.class
	$(RM) out/production/ColorPrinter/*.class

ColorPrinter.class: src/ColorPrinter.java ANSI_COLOR.class
	javac -cp src src/ColorPrinter.java -d out/production/ColorPrinter/

ANSI_COLOR.class: src/ANSI_COLOR.java
	javac -cp src src/ANSI_COLOR.java -d out/production/ColorPrinter/

TestPrinter.class: src/TestPrinter.java ColorPrinter.class
	javac -cp src \
		  src/TestPrinter.java \
 	  	  -d out/production/ColorPrinter/