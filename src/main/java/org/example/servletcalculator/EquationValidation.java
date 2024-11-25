package org.example.servletcalculator;

public class EquationValidation {
    private static String errorMsg;

    public static boolean validateEquation(String equation) {
        int parenthesisCounter = 0;
        for (int counter = 0; counter < equation.length(); counter++) {
            if (isMathOperation(equation.charAt(counter)) && counter == 0) {
                setErrorMsg("Can not place math operations before numbers");
                return false;
            }

            if (equation.charAt(counter) == ')' && counter == 0) {
                setErrorMsg("Can not place closing parenthesis as a first character");
                return false;
            }

            if (counter != equation.length() - 1 && isMathOperation(equation.charAt(counter)) && isMathOperation(equation.charAt(counter + 1))) {
                setErrorMsg("Can not place two math operations alongside");
                return false;
            }

            if (equation.charAt(counter) == '(') {
                parenthesisCounter++;
                if (counter != 0 && !isMathOperation(equation.charAt(counter - 1))) {
                    setErrorMsg("Can not place digits alongside opening parenthesis");
                    return false;
                } else if (counter != equation.length() - 1 && isMathOperation(equation.charAt(counter + 1))) {
                    setErrorMsg("Can not place math operations alongside opening parenthesis");
                    return false;
                }

            }

            if (equation.charAt(counter) == ')' && parenthesisCounter == 0) {
                setErrorMsg("Can not place closing parenthesis not opening it");
                return false;
            }

            if (equation.charAt(counter) == ')') {
                parenthesisCounter--;
                if (isMathOperation(equation.charAt(counter - 1))) {
                    setErrorMsg("Can not place math operations alongside closing parenthesis");
                    return false;
                } else if (counter != equation.length() - 1 && !isMathOperation(equation.charAt(counter + 1))) {
                    setErrorMsg("Can not place digits alongside closing parenthesis");
                    return false;
                }
            }

            if (counter == equation.length() - 1 && parenthesisCounter != 0) {
                setErrorMsg("You need to double-check the brackets");
                return false;
            }

            if (counter == equation.length() - 1 && isMathOperation(equation.charAt(counter))) {
                setErrorMsg("Can not end your equation with math operations");
                return false;
            }

        }
        return true;
    }

    public static String getErrorMsg() {
        return errorMsg;
    }

    private static void setErrorMsg(String errorMsg) {
        EquationValidation.errorMsg = errorMsg;
    }

    private static boolean isMathOperation(char symbol) {
        return symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/';
    }
}
