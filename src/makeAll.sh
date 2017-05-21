javac -cp ./java-cup-11b-runtime.jar:. microjs/jcompiler/frontend/ast/*.java
./jflex-1.6.1/bin/jflex microjs/jcompiler/frontend/lexer/lexer.flex 
(cd microjs/jcompiler/frontend/parser ;   java -jar ../../../.././java-cup-11b.jar -locations -interface -parser Parser parser.cup)
javac -cp ./java-cup-11b-runtime.jar:. microjs/jcompiler/frontend/parser/Parser.java
javac -cp ./java-cup-11b-runtime.jar:. microjs/jcompiler/main/Main.java
