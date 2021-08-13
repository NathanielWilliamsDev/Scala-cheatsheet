object Main{ 
    def main (args : Array[String]) {

        //------------------------------------------------------//
        //                     Basic Intro                      //
        //------------------------------------------------------//
        // Some handy things to know before you dive in.

        // Where you would normally use 'void' in Java, we use 'Unit' in Scala
        // Using == is like java's .equals() method

        // Everything is an object,
        // 3 + 4 is the same as 3.+(4)

        // "hello" take 3
        // produces "hel"

        //------------------------------------------------------//
        //                      Variables                       //
        //------------------------------------------------------//
        // var is a variable that can be updated and changed
        // val is a variable that is immutable
        // Variable types are declared with a ':'
        // However types in Scala are generally inferred so this is not usually necessary
        // - val x: Int
        // - val xyz = 13 // Type is inferred here, Scala knows it is an Int

        //------------------------------------------------------//
        //                 Arrays and Lists                     //
        //------------------------------------------------------//
        val a = Array(2, 3, 4)
        val b = List("aye", "bee")

        // Like other variables, you can explicitly list the type
        val listStrings: List[String] = List("Avocado ","is ","expensive")
        
        // A List or Array can contain many different types
        val randomList = List(1, "two", false, 4.0)

        // This is the same as declaring a list or array of type 'Any'
        val anyList : List[Any] = List("any ", "type ", "you", "like")

        // Both lists and arrays can also hold anonymous functions
        val funcList = List(() => "anonymous function returning this string")
        
        // Add item to the front
        666 +: randomList //(666, 1, "two", false, 4.0)
        
        //------------------------------------------------------//
        //                      If, Else                        //
        //------------------------------------------------------//
        val myInt = 2
        val smallerThan7 = if(myInt > 7) 3 else 4
        // Or use block form by wrapping the if and else statements with {}

        //------------------------------------------------------//
        //                     Functions                        //
        //------------------------------------------------------//
        // val name = (input: type) => block
        // can also write with backets {} around block
        // e.g. function
        val addOne = (x : Int) => {
            x + 1
        }
        def max(a: Int, b: Int): Int = {
            if(a > b) a else b
        }

        // Anonymous functions:
        // (x: Int) => x + 42
        
        // You can assign this function to a variable
         val add42 = (x: Int) => x + 42
        // add42(10) produces 52
        
        // functions can also have multiple parameters
        val add = (x : Int, y : Int) => {
            x + y
        }
        
        // or no parameters
        val weatherToday = () => "19 degrees celsius"

        //------------------------------------------------------//
        //                      Methods                         //
        //------------------------------------------------------//
        // Similar to functions but are defined with 'def'
        // def name(input: type) : return type = block
        // can also write with backets {} around block

        // Can write as a simple one-line
        def add2(x: Int): Int = x + 2
        // Or multi-line using a block
        def add3(x: Int): Int = {
            x + 3
        }
        // A method can take more than one parameter list
        // In this case, takes parameters (one, tw) then parameter (multiplier)
        def addThenMultiply(one : Int, two : Int)(multiplier : Int) : Int = {
            (one + two) * multiplier
            // adds one and two, then * multiplier
        }
        // println(addThenMultiply(1, 2)(3)) //(1 + 2) * (3)
        
        // Or no parameters
        def name: String = System.getProperty("user.name")
        // println("Hello, " ++ name ++ "!") // -> "Hello, Nathaniel!" Nathaniel is computer name

        // Methods can have default parameters
        // The 'level' parameter has a default value of "INFO"
        def log(message: String, level: String = "INFO") = {
            println(s"$level: $message")
        }
        //println(log("System Starting")) // uses default value "INFO"
        //println(log("User not found", "WARNING")) // uses "WARNING" instead

        // Using return type 'Unit' (or void)
        def show(s: String): Unit = {
            println(s)
        }
        //show("hi")

        //------------------------------------------------------//
        //                     For Loops                        //
        //------------------------------------------------------//
        val arr = Array(1,2,3)
        //for(i <- arr) println(i)
        //for(i <- 0 to 2) println(arr(i)) // indexes 0, 1, 2
        //arr.foreach(println)
        //for(i <- 0 until 2) println(arr(i)) //indexes 0, 1

        //------------------------------------------------------//
        //                      Objects                         //
        //------------------------------------------------------//

        // Objects are singleton's -> essentially everything is static
        object topTier{
            var list = List("David", "Jeff", "Jason")
        }
        println(topTier.list) // You can access things inside with '.'

        //------------------------------------------------------//
        //                     Traits                           //
        //------------------------------------------------------//
        // Traits are abstract, they can contain methods etc.
        // In Scala inheritance, a class can only extend one class
        // but can inherit many traits

        trait Greeter {
            def greet(name : String) : Unit =// Unit is like void
                println("Hello, " + name + "!")
        }
        
        //------------------------------------------------------//
        //                      Tuples                          //
        //------------------------------------------------------//
        // A value that contains a fixed number of elements
        // Tuples are immutable
        // Handy for returning multiple values from a method

        val ability = ("Zenitsu", "Thunder breathing first form")
        // prints (Zenitsu, Thunder breathing first form)

        val diffTypes = (true, 12, "string", 1.12345)
        // prints (true, 12, string, 1.12345)

        // Accessing tuple items
        // ability._1 is the first item
        // ability._2 is the second item, etc.

        // ----------Pattern Matching on tuples----------

        val userData = ("neeko", "neeko@battlenet.com")
        // prints (neeko, neeko@battlenet.com)

        val(userName, userEmail) = userData
        // Assigns val userName to the first item in the tuple,
        // val userEmail to the second item in the tuple
        //println(userName) //neeko
        //println(userEmail) //neeko@battlenet.com

        //e.g. 2
        val characterAbilities = ("Stun", "Pool", "Shield", "Stun/Damage")
        val(q, w, e, r) = characterAbilities
        //println(w) //prints "Pool"
    
        // Another example of Pattern Matching Tuples
        val numPairs = List((2, 5), (3, -7), (20, 56))
        for ((a, b) <- numPairs){
            //println(a * b) // prints 2*5, then 3*-7, then 20*56
        }

        //-------- Tuples vs. Case Classes --------
        // Case classes have named elements,
        //    - This can improve readability
        
        //------------------------------------------------------//
        //                    map Function                      //
        //------------------------------------------------------//
        // Applies whatever is inside the brackets to the data structure
        // e.g. we have a list 
        val lst = List(2, 3, 4)
        lst.map(_*2) // multiplies each item in the list by the passed instructions (*2)
        // the _ means do it for all items

        //------------------------------------------------------//
        //               Higher Order Functions                 //
        //------------------------------------------------------//
        // Functions (and methods) that take other functions as parameters
        //  - or return a function as a result

        // A variable containing a champion's levels
        val champLevel = Seq(8, 12, 16)

        // A function to double the item passed
        val doubleLevel = (x: Int) => x * 2
        
        // Calls map on the champLevel Seq, passing our doubleLevel function
        val newChampLevel = champLevel.map(doubleLevel) 
        // Using map applies the function (doubleLevel) to each item in the Seq
        
        
        //------- Shrink this code down -------
        val newCLevel = champLevel.map(x => x * 2) 
        // pass an anonymous function into map that does the same thing as 'doubleLevel'
        // x's type is inferred, doesn't need to be declared as Int

        //------- Another way to make it concise --------
        val newChLevel = champLevel.map(_ * 2)
        // this is the same as the anonymous function specified above but you're
        // pattern matching _ (each item) rather than assigning each item to x, then operating

        //------------------------------------------------------//
        //                      Match                           //
        //------------------------------------------------------//

        // This method takes a string as a parameter, and returns a string
        // we're calling match on the parameter string (animal)
        // if "Chicken" is passed, we return "bWaaaaaAAAK!!"
        // if "chicken" is passed, we return "shhh bwaaaaak!"
        // whatever else is passed, we return "No chicken"
        def hiddenChicken(animal: String) : String = {
            animal match{ // animal is the passed parameter
                case "Chicken" => "bWaaaaaAAAK!!"
                case "chicken" => "shhh bwaaaaak!"
                case _ => "No chicken"
            }
        }

        //------------------------------------------------------//
        //                      Option                          //
        //------------------------------------------------------//
        // Computes average
        val nums = Array(3, 6, 5)
        def avg(temp: Array[Int]): Int = {
            (temp reduce(_ + _))/temp.size
        }

        println("avg " + avg(nums))

        // Using Option
        def opAvg(a: Array[Int]): Option[Int] = {
            if(a.size == 0){
                None
            }
            else{
                Some((a reduce(_ + _))/a.size)
            }
        }
        // If you can possibly get a value passed through
        // that you shouldn't, use an option

        //------------------------------------------------------//
        //                Map Data Collection                   //
        //------------------------------------------------------//
        val romanNumeral = Map(1 -> "I", 2 -> "II", 3 -> "III", 
        4 -> "IV", 5 -> "V", 6 -> "VI")
        //println(romanNumeral) //prints the map, like most languages it is not displayed in order
        //println(romanNumeral(4)) //prints "IV"
        // Map acts as key -> value pairs and therefore you can only call on the key to return the value,
        // not the other way around

        // They can also contain any combination of types for keys and values
        val weirdMap = Map("TwentyOne" -> 10101, 3.14 -> "Pi", 'c' -> false)
        
        // .get function returns an option, Some if the item exists (with its value),
        // None otherwise.
        romanNumeral.get(4) // returns Some(IV), can be shortened to romanNumeral get 4
        
        //.apply function returns the value without wrapping it in a Some
        romanNumeral.apply(4) // returns "IV" 
        // However this throws an exception if the key doesn't exist

        //.contains does the same thing but returns a boolean
        romanNumeral.contains(15) //returns false

        //.keys returns an Iterable of all keys, .keySet returns a Set
        // There is also a .values
        romanNumeral.keySet //Set(5, 1, 6, 2, 3, 4) // it isn't in order

        //------------------------------------------------------//
        //                      Yield                           //
        //------------------------------------------------------//
        // Instead of looping through to create a collection
        // You can use Yield instead
        for(value <- 1 to 5) yield(2 * value)
        // prints 2, 4, 6, 8, 10)


        //------------------------------------------------------//
        //                     Reduce                           //
        //------------------------------------------------------//
        // takes all the elements in a collection and combines them using 
        // a binary operation to produce a single value
        
        // Left hand side is a collection
        // Right hand side is the operation on that collection
        
        val collec = List(9, 10, 9)
        // println(collec reduce (_+_)) // to plus all items

        // More advanced
        // List(3, 5, 7) reduce (2*_+_)
        // Giving 29, 2 * (2 * 3 + 5) + 7

        //------------------------------------------------------//
        //              Regular Expressions                     //
        //------------------------------------------------------//
        // Regular expressions (pattern matching)











    }
    
}


