default: run

run: TestPrinter.class
	java out/production/TestColorPrinter TestPrinter

clean:
	$(RM) out/production/TestColorPrinter/*.class

TestPrinter.class: src/TestPrinter.java ../colorprinter.jar
	cp ../colorprinter.jar .
	javac -verbose -cp colorprinter.jar \
		  src/TestPrinter.java \
 	  	  -d out/production/TestColorPrinter/
