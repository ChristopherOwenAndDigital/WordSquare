WordSquare Maker
Chris Owen

This project has an executable main class called WordSquare that can be run directly
from the IDE (try parameters 3 "aaccrrtty")

To run from a command line:
- cd to project root directory 'WordSquare'
- run 'mvn clean package'
- run java -jar target/WordSquare-jar-with-dependencies.jar  3  "aaccrrtty"
- This should produce a simple 3x3 word square with: act, car and try

If you were to use "hhooortty" (for rot, ooh, thy) it would fail politely as
there is not yet the functionality to back out of failed combinations and get
back on track.

Chris O
"Happy coding!"
