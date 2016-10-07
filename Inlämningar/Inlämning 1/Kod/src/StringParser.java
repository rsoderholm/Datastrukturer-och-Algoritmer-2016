import javax.swing.*;

/**
 * Created by Robin on 20160910
 * This class parses a string which the user supplies and parses it. If a bracket is encountered, it is pushed to the
 * stack. It uses the peek method to see if the last object put in is a matching bracket, if it is not, it returns
 * an error message saying that a bracket is either missing or not matching.
 */
public class StringParser {


    private static Stack stack = new Stack();

    /**
     * This method reads the userinput, parses it char by char, creates a switch statement with cases based on the
     * brackets we want to find.
     * It then checks if the brackets match what is expected to be found.
     * @param stringToParse
     * @return
     */

    public static boolean parseString(String stringToParse) {


        for (int i = 0; i < stringToParse.length(); i++) {
            char brackets = stringToParse.charAt(i);
            switch (brackets) {
                case '}':
                    if (stack.isEmpty() || !stack.pop().equals('{')) {

                        return false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || !stack.pop().equals('(')) {

                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || !stack.pop().equals('[')) {

                        return false;
                    }
                    break;
                default:
                    if (brackets == '{' || brackets == '(' || brackets == '[')
                        stack.push(brackets);
            }
        }

        if (!stack.isEmpty()) {

            return false;
        } else {

            return true;
        }
    }

    public static void main(String[] args) {

        String inString;
        String choice;


        do {
            inString = JOptionPane.showInputDialog("Please enter a string! ");
            if (parseString(inString) == true) {
                JOptionPane.showMessageDialog(null, "Text to parse: " + inString + "\nParsing...." + "\nEverything matches!");

            } else if (stack.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Text to parse: " + inString + "\nParsing...." + "\nBrackets do not match");

            } else {
                JOptionPane.showMessageDialog(null, "Text to parse: " + inString + "\nParsing..." + "\nBracket is missing");


            }

            stack.emptyStack();
            choice = JOptionPane.showInputDialog("Would you like to go again? Y/N");
        } while (choice.charAt(0) == 'y' || choice.charAt(0) == 'Y');

    }
}
