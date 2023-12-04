package fr.indrance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solver {

    public void Solve() throws IOException {
        // for example == 8
        // Variable declaration
        int finalResult = 0;

        int gameID = -1;

        int maxRed = 12;
        int maxBlue = 13;
        int maxGreen = 14;

        int currentRed = 0;
        int currentBlue = 0;
        int currentGreen = 0;

        String file = getClass().getClassLoader().getResource("d2.txt").getFile();
        System.out.println(file);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        while (currentLine != null) {
            String[] lineSplit = currentLine.split(":");
            // Getting the id
            gameID = Integer.parseInt(lineSplit[0].split(" ")[1]);
            //System.out.println(lineSplit[0].split(" ")[1]);
            try {
                for (String s : lineSplit[1].split(";")) {
                    currentRed = 0;
                    currentBlue = 0;
                    currentGreen = 0;
                    //System.out.println(s);

                    for (String u : s.split(",")) {
                        System.out.println(u);
                        if (u.contains("red")) {
                            currentRed += Integer.parseInt(u.split(" ")[1]);
                        } else if (u.contains("blue")) {
                            currentBlue += Integer.parseInt(u.split(" ")[1]);
                        } else if (u.contains("green")) {
                            currentGreen += Integer.parseInt(u.split(" ")[1]);
                        }
                    }
                    if (currentRed > maxRed || currentBlue > maxBlue || currentGreen > maxGreen){
                        throw new Exception();
                    }
            }
                finalResult += gameID;
            }
            catch (Exception e) {
                currentRed = 0;
                currentBlue = 0;
                currentGreen = 0;
            }

            gameID = -1;
            System.out.println("not Final result : " + finalResult);
            currentLine = reader.readLine();
        }
        System.out.println("Final result : " + finalResult);
        reader.close();
    }

}
