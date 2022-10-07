/*
 * Algebraic Solver
 * Was given this problem on a coding challenge for a job interview and bombed it
 * so I'm giving it another shot.
 * Takes a single-variable binomial algebraic equation as a string and tokenizes it,
 * then solves for x. Tests for edge cases and stuff.
 * Author: Travis Williams (@ShrimpyNobashi)
 * Date: 10/7/2022
 */
public class AlgebraicSolver {
    static double x, val;
    static String term1, operator, term2, result;
    public static void main(String[] args) {
        String eq = "2 -4x =   8";
        String[] tokens = tokenize(eq);
        System.out.println(tokens[0] + " " + tokens[1] + " " + tokens[2] + " = " + tokens[3]);
        if(term1.equals("0x")) {
            System.out.println("False");
        } else {
            x = solve(tokens);
            System.out.println("where x = " + x);
        }
    }

    public static double solve(String[] tokens) {
        if(operator == null) {
            x = Integer.parseInt(tokens[3]) / Integer.parseInt(tokens[0].substring(0,tokens[0].indexOf("x")));
        } else {
            if(operator == "+") {
                x = (Integer.parseInt(tokens[3]) - Integer.parseInt(tokens[2])) /
                        Integer.parseInt(tokens[0].substring(0,tokens[0].indexOf("x")));
            } else {
                x = (Integer.parseInt(tokens[3]) - Integer.parseInt(tokens[2])) /
                        Integer.parseInt(tokens[0].substring(0,tokens[0].indexOf("x")));
            }
        }
        return x;
    }

    public static String[] tokenize(String eq) {
        // tokenizes and cleans initial equation into an array of tokens
        result = eq.substring(eq.indexOf("=") + 1, eq.length()).strip();
        if(!(eq.contains("+") || eq.contains("-"))) {
            operator = "";
            term1 = eq.substring(0,eq.indexOf("=")).strip();
            term2 = "";
        } else {
            if(eq.contains("+")) operator = "+";
            else operator = "-";
            term1 = eq.substring(0, eq.indexOf(operator)).strip();
            term2 = eq.substring(eq.indexOf(operator) + 1, eq.indexOf("=")).strip();
        }
        if(term1.contains("x") && term2.contains("x")) {
            int x1 = Integer.parseInt(term1.substring(0, term1.indexOf("x")));
            int x2 = Integer.parseInt(term2.substring(0, term2.indexOf("x")));
            if(operator == "+") {
                x1 += x2;
                term1 = x1 + "x";
                term2 = "";
                operator = "";
            } else {
                x1 -= x2;
                term1 = x1 + "x";
                term2 = "";
                operator = "";
            }
        }
        if(term2.contains("x") && !(term1.contains("x"))) {
            String tmpval = term1;
            term1 = term2;
            term2 = tmpval;
            if(operator.equals("-")) {
                term1 = "-" + term1;
                operator = "+";
            }
        }
        String[] tokens = {term1,operator,term2,result};
        return tokens;
    }
}

