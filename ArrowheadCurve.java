package cop2513.arrowhead;

import edu.support.AnimatedTurtle;
import edu.support.EndWorld;

public class ArrowheadCurve {
    /**
     * Given the character, return the appropriate production for that character.
     * Implements the Sierpinski Arrowhead Curve refer to
     * https://en.wikipedia.org/wiki/L-system#Example_5:_Sierpinski_triangle
     * (make sure to scroll down to the part about the Sierpinski Arrowhead Curve).
     *
     * @param c the character to expand.
     * @return the appropriate production for the given character.
     */
    public static String getProd(char c) {
        // TODO: replace with your implementation
        String str = ""; // Initialized empty string.

        if (c == '+') { // Sets production rule for "+".
            str = "+";
        }
        if (c == '-') { // Sets production rule for "-".
            str = "-";
        }
        if (c == 'A') { // Sets production rule for "A".
            str = "+B-A-B+";
        }
        if (c == 'B') { // Sets production rule for "B".
            str = "-A+B+A-";
        }

        return str; // Returns appropriate production.
    } // end getProd

    /**
     * Given the String representing the current generation, return a new
     * String that is the result of applying the getProd rules to each
     * character in the current generation.
     * @param curGen a String that is the current generation.
     * @return a new String that is the result of applying the
     *         getProd rules to each character in the current generation.
     */
    public static String nextGen(String curGen) {
        // TODO: replace with your implementation
        String str = ""; // Initialized empty string.
        // For loop goes through curGen and creates the next generation.
        for (int i = 0; i < curGen.length(); i++) {
            str = str + getProd(curGen.charAt(i)); // Adds the appropriate strings together.
        }

        return str; // Returns the desired string value.
    } // end nextGen

    /**
     * Draw the given current generation using the given turtle and amount
     * for forward steps.
     *
     * @param curGen a String representing the current generation.
     * @param t the turtle to use for drawing.
     * @param forwardSteps the amount of steps to move on a forward.
     */
    public static void draw(String curGen, AnimatedTurtle t, int forwardSteps) {
        // TODO: replace with your implementation
        // For loop to go through the string and draws the appropriate line or turn.
        for(int i = 0; i < curGen.length(); i++) {
            if (curGen.charAt(i) == '+') { // Turns the turtle 60 degrees to the left.
                t.turn(-60);
            }
            if (curGen.charAt(i) == '-') { // Turns the turtle 60 degrees to the right.
                t.turn(60);
            }
            if (curGen.charAt(i) == 'A') { // Moves the turtle forward "forwardSteps".
                t.forward(forwardSteps);
            }
            if (curGen.charAt(i) == 'B') { // Moves the turtle forward "forwardSteps".
                t.forward(forwardSteps);
            }
        }
    } // end draw

    /**
     * Given the initial generation, and number of reps, advance the initGen
     * numRep times.  Then create an EndWorld and AnimatedTurtle and
     * draw the results using the given forwardSteps value.
     *
     * @param initGen the initial or starting String
     * @param numReps the number of times to run nextGen on initGen
     * @param forwardSteps the number of forward steps to use when drawing.
     */
    public static void demo(String initGen, int numReps, int forwardSteps) { // Only works for numReps 2 through 8.
        // TODO: replace with your implementation
        EndWorld w = new EndWorld(800, 1000); // Creates a world with width 800 and height 1000.
        AnimatedTurtle t = new AnimatedTurtle(w); // Creates an animated turtle.
        t.turnRight(); t.penUp(); t.moveTo(25,650); t.penDown(); // Positions the turtle in the bottom left corner.

        String str, str2, str3, str4, str5, str6, str7, str8; // Initializes strings.
        str = nextGen(initGen); // Runs nextGen once.

        if (initGen == "B") { // Moves turtle to top left corner if "B" is the initGen.
            t.penUp(); t.moveTo(25,50); t.penDown();
        }
        str2 = nextGen(str); // In order to avoid recursion.
        if (numReps == 2) { // Draws desired shape if numReps is 2.
            str2 = nextGen(str); // Equivalent to nextGen being called 2 times.
            draw(str2, t, 50);
        }
        str3 = nextGen(str2); // In order to avoid recursion.
        if (numReps == 3) { // Draws desired shape if numReps is 3.
            str3 = nextGen(str2); // Equivalent to nextGen being called 3 times.
            draw(str3, t, 45);
        }
        str4 = nextGen(str3); // In order to avoid recursion.
        if (numReps == 4) { // Draws desired shape if numReps is 4.
            str4 = nextGen(str3); // Equivalent to nextGen being called 4 times.
            draw(str4, t, 30);
        }
        str5 = nextGen(str4); // In order to avoid recursion.
        if (numReps == 5) { // Draws desired shape if numReps is 5.
            str5 = nextGen(str4); // Equivalent to nextGen being called 5 times.
            draw(str5, t, 20);
        }
        str6 = nextGen(str5); // In order to avoid recursion.
        if (numReps == 6) { // Draws desired shape if numReps is 6.
            str6 = nextGen(str5); // Equivalent to nextGen being called 6 times.
            draw(str6, t, 10);
        }
        str7 = nextGen(str6); // In order to avoid recursion.
        if (numReps == 7) { // Draws desired shape if numReps is 7.
            str7 = nextGen(str6); // Equivalent to nextGen being called 7 times.
            draw(str7, t, 5);
        }
        if (numReps == 8) { // Draws desired shape if numReps is 8.
            str8 = nextGen(str7); // Equivalent to nextGen being called 8 times.
            draw(str8, t, 3);
        }
    } // end demo

    public static void main(String[] args) {
        //  for your own use (and the TAs when grading)
/*
        // Checks if getProd is working correctly.
        String alpha = "+-AB";
        for (int i = 0; i < alpha.length(); i++) {
           System.out.println("getProd(" + alpha.charAt(i) + ") = " + getProd(alpha.charAt(i)));
        }
*/
/*
        // Checks if nextGen is working correctly.
        System.out.println("nextGen(A) = " + nextGen("A"));
        String gen = nextGen("A");
        System.out.println("nextGen(" + gen + ") = " + nextGen(gen));
*/
/*
        // Checks if draw is working correctly.
        EndWorld w = new EndWorld();
        AnimatedTurtle t = new AnimatedTurtle(w);
        t.turnRight();
        //draw("A+B-B", t,50);
        //draw(nextGen("A"), t, 50);
        String gen2 = nextGen("A");
        //draw(nextGen(gen2), t, 50);
*/
/*
        // Checks if demo is working correctly. forwardSteps is already determined in demo in order for the turtle to
        // not hit any walls. Only works for numReps 2 through 8.
        demo("A", 2, 50);
*/
    } // end main
} // end ArrowheadCurve
