default: run

run: compile
	java -cp out/production/TestColorPrinter:colorprinter.jar TestPrinter

compile: TestPrinter.class

clean:
	$(RM) out/production/TestColorPrinter/*.class
	$(RM) colorprinter.jar

TestPrinter.class: src/TestPrinter.java ../colorprinter.jar
	cd .. && $(MAKE) jar
	cp ../colorprinter.jar .
	javac -cp colorprinter.jar \
		  src/TestPrinter.java \
 	  	  -d out/production/TestColorPrinter/
