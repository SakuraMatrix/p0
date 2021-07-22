#!/bin/bash
# Intro to build tools, soon to be replaced by Maven
# Usage:
#   chmod +x build.sh
#   ./build.sh package

# Wiping a project folder of generated code
clean() {
    rm -f *.class *.jar
}

# Compiling code
compile() {
    javac Scrabble.java
}

package() {
    jar cfe app.jar Scrabble Scrabble.class
}

for step in "$@"
do
    "$step"
done