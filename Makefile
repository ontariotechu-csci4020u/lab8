cp = /volumes/data/lib/antlr-4.8-complete.jar:$(PWD):$(PWD)/target
jdriver = /volumes/data/bin/jdriver.sh

all: java

java:
	mkdir -p ./target
	javac -cp $(cp) -d target -sourcepath src src/*.java src/numlang/*.java

run:
	java -cp $(cp) Check

clean:
	rm -rf target/* ./report.edn ./output.edn

check:
	$(jdriver) :testdrive expected.edn output.edn >/dev/null
	$(jdriver) :report output.edn report.edn
