# Temperature
Assignment #5 ("Temperature") for CS111B
#Todo:#
- [X] make Temperature.java
-     [X] variables:
-       [X] double degrees
-       [X] char temperature ('C' Celsius 'F' for Fahrenheit)
-     [X] 4 constructors:
-       [X] (degree, type)
-       [X] (degree) initiallize type to 'C'
-       [X] (type) initialize degree to 0.0
-       [X] () initialize type 'C' and degree 0.0
-     [X] Methods:
-         [X] writeOutput() display both variables
-         [X] writeC() display value in Celsius
-         [X] writeF() display value in Farenheit
-       [X] Accessor:
-         [X] getC return value in C even if value is in F
-         [X] getF return value in F even if value is in C
-       [X] Mutator:  
-         [X] set(Degrees)
-         [X] set(Type)
-         [X] set(Both)
-         [X] overload param
-       [X] equals()
-         [X] 32F == 0C
-       [X] toString()
-         [X] Whatever we want to output
- [ ] Extra credit
-   [ ] readInput() to promp user to write degrees and type

Important:
  Problem: Test case 2
           using readInput()
             I entered 0 for degrees
             F for type
           output:
             <32.0> degrees Celsius, <0.0> degrees Fahrenheit
           Should:
             <32.0> degrees Celsius, <-17.8> degrees Fahrenheit
           Possible cause:
             Math logic
             Wrong order
             Math
  Problem: Test case 4 and 5
           program printed out "<0.0> degree Celsius, <0.0> degree Fahrenheit
           The problem is that 0.0 degree Celsius is not equals to 0.0 degree Fahrenheit
           Possible cause:
            Constructor(type) in line 20
            writeOutput() in line 33
            getC() in line 37
            getF() in line 57
