default: jar
jar: compile
	jar cmf MANIFEST.MF colorprinter.jar \
		-C out/production/ColorPrinter/ ghost/coffee/ColorPrinter/ColorPrinter.class \
		-C out/production/ColorPrinter/ ghost/coffee/ColorPrinter/ANSI_COLOR.class \
		-C out/production/ColorPrinter/ ghost/coffee/ColorPrinter/'ColorPrinter$$1.class'

compile: ColorPrinter.class

clean:
	$(RM) colorprinter.jar
	$(RM) *.class
	$(RM) out/production/ColorPrinter/ghost/coffee/ColorPrinter/*.class

ColorPrinter.class: src/ghost/coffee/ColorPrinter/ColorPrinter.java ANSI_COLOR.class
	javac -cp src \
		  src/ghost/coffee/ColorPrinter/ColorPrinter.java \
		  -d out/production/ColorPrinter/

ANSI_COLOR.class: src/ghost/coffee/ColorPrinter/ANSI_COLOR.java
	javac -cp src \
 		  src/ghost/coffee/ColorPrinter/ANSI_COLOR.java \
 		  -d out/production/ColorPrinter/
