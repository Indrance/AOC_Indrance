package fr.indrance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solver {

    public void Solve() throws IOException {
        // Variable definition
        int finalNumber = 0;
        int firstNumber = -1;
        int lastNumber = -1;
        String finalLine = "";

        // Boilerplate file reader
        String file = getClass().getClassLoader().getResource("d1.txt").getFile();
        System.out.println(file);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        // MAIN LOOP
        String currentLine = reader.readLine();
        while (currentLine != null) {
            System.out.println("current line : " +currentLine);
            // Remplacing every number string by a number
            /*currentLine = currentLine.toLowerCase();
            currentLine = currentLine.replace("one","1");
            currentLine = currentLine.replace("two","2");
            currentLine = currentLine.replace("three","3");
            currentLine = currentLine.replace("four","4");
            currentLine = currentLine.replace("five","5");
            currentLine = currentLine.replace("six","6");
            currentLine = currentLine.replace("seven","7");
            currentLine = currentLine.replace("eight","8");
            currentLine = currentLine.replace("nine","9");
            System.out.println(currentLine);*/
            // and that didn't work thanks to oneight... thx

            // SCANNING FOR EACH NUMBER, very ugly solution, but on paper should work
            for (int i = 0; i < currentLine.length(); i++) {
                if (Character.isLetter(currentLine.charAt(i))) {
                    switch (currentLine.charAt(i)) {
                        case 'o':
                            try {
                                // One
                                if (currentLine.charAt(i + 1) == 'n' && currentLine.charAt(i + 2) == 'e') {

                                    finalLine = finalLine + "1";
                                }
                                break;
                            } catch (Exception e) {
                                break;
                            }
                        case 't':
                            try {
                                // Two
                                if (currentLine.charAt(i + 1) == 'w' && currentLine.charAt(i + 2) == 'o') {

                                    finalLine = finalLine + "2";
                                } // Three
                                else if (currentLine.charAt(i + 1) == 'h' && currentLine.charAt(i + 2) == 'r'
                                        && currentLine.charAt(i + 3) == 'e' && currentLine.charAt(i + 4) == 'e') {

                                    finalLine = finalLine + "3";
                                }
                                break;
                            } catch (Exception e) {
                                break;
                            }
                        case 'f':
                            try {
                                // Four
                                if (currentLine.charAt(i + 1) == 'o' && currentLine.charAt(i + 2) == 'u' && currentLine.charAt(i + 3) == 'r') {

                                    finalLine = finalLine + "4";
                                }
                                // Five
                                if (currentLine.charAt(i + 1) == 'i' && currentLine.charAt(i + 2) == 'v'
                                        && currentLine.charAt(i + 3) == 'e') {

                                    finalLine = finalLine + "5";
                                }
                                break;
                            } catch (Exception e) {
                                break;
                            }
                        case 's':
                            try {
                                // Six
                                if (currentLine.charAt(i + 1) == 'i' && currentLine.charAt(i + 2) == 'x'){

                                    finalLine = finalLine + "6";
                                }
                                // Seven
                                else if (currentLine.charAt(i + 1) == 'e' && currentLine.charAt(i + 2) == 'v' && currentLine.charAt(i + 3) == 'e' && currentLine.charAt(i + 4) == 'n'){

                                    finalLine = finalLine + "7";
                                }
                                break;
                            } catch (Exception e) {
                                break;
                            }
                        case 'e':
                            try {
                                // Eight
                                if (currentLine.charAt(i + 1) == 'i' && currentLine.charAt(i + 2) == 'g' && currentLine.charAt(i + 3) == 'h' && currentLine.charAt(i + 4) == 't'){

                                    finalLine = finalLine + "8";
                                }
                                break;
                            } catch (Exception e) {
                                break;
                            }
                        case 'n':
                            try {
                                // Nine
                                if (currentLine.charAt(i + 1) == 'i' && currentLine.charAt(i + 2) == 'n'
                                        && currentLine.charAt(i + 3) == 'e') {

                                    finalLine = finalLine + "9";
                                }
                                break;
                            } catch (Exception e) {
                                break;
                            }
                    }
                } else if (Character.isDigit(currentLine.charAt(i))){
                    finalLine = finalLine + currentLine.charAt(i);
                }
            }
            // Getting the first and last number on each line
            for (int i = 0; i < finalLine.length(); i++) {
                if (Character.isDigit(finalLine.charAt(i))) {
                    if (firstNumber == -1) {
                        firstNumber = Character.getNumericValue(finalLine.charAt(i));
                    }
                    lastNumber = Character.getNumericValue(finalLine.charAt(i));
                }
            }System.out.println("all number in string : " + finalLine);
            System.out.println("first number : " +firstNumber + " last number : " + lastNumber);
            finalNumber += Integer.parseInt(firstNumber + "" + lastNumber);
            firstNumber = -1;
            lastNumber = -1;
            finalLine = "";
            System.out.println( "result for now : " + finalNumber);
            System.out.println("--------------------");
            currentLine = reader.readLine();
        }
        reader.close();
        System.out.println("result : "+finalNumber);
    }

}
