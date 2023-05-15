WordSquare Maker
Chris Owen

This project has an executable main class called WordSquare that can be run
directly from the IDE (try parameters 3 "aaccrrtty")

To run from a command line:
- cd to project root directory 'WordSquare'
- run 'mvn clean package'
- run java -jar target/WordSquare-jar-with-dependencies.jar  3  "aaccrrtty"
- This should produce a simple 3x3 word square with: act, car and try
- If you use "hhooortty" it should give: rot, ooh, thy
- If you use "aydeiloms" it will tell you it can't form a word square

Chris O
"Happy coding!"
