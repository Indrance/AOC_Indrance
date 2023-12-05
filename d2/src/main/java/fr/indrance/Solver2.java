package fr.indrance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solver2 {

    public void Solve() throws IOException {
        // for example == 8
        // Variable declaration
        int finalResult = 0;

        int maxRed = 0;
        int maxBlue = 0;
        int maxGreen = 0;

        int currentRed = 0;
        int currentBlue = 0;
        int currentGreen = 0;

        String file = getClass().getClassLoader().getResource("d2.txt").getFile();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        while (currentLine != null) {

            String[] lineSplit = currentLine.split(":");
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
                if (currentRed > maxRed){
                    maxRed = currentRed;
                }
                if (currentBlue > maxBlue){
                    maxBlue = currentBlue;
                }
                if (currentGreen > maxGreen){
                    maxGreen = currentGreen;
                }
            }
            finalResult += maxRed*maxGreen*maxBlue;
            maxRed = 0;
            maxBlue = 0;
            maxGreen = 0;

            System.out.println("not Final result : " + finalResult);
            currentLine = reader.readLine();
        }
        System.out.println("Final result : " + finalResult);
        reader.close();
    }

}
