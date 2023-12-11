package fr.indrance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solver {
    public void Solve() throws IOException {
        // VARIABLE
        String[] winningNumber;
        List<Long> card = new ArrayList<>();
        long finalResult = 0;

        String file = getClass().getClassLoader().getResource("d4.txt").getFile();
        System.out.println(file);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        while (currentLine != null){
            System.out.println(currentLine);
            String[] tmp = currentLine.split(":");
            tmp = tmp[1].split("\\u007C");
            // Get winningNumber
            winningNumber = tmp[0].split(" ");
            // Get cardNumber
            card = new ArrayList<>();
            for (int i = 0; i < tmp[1].split(" ").length; i++){
                try {
                    card.add(Long.parseLong(tmp[1].split(" ")[i]));
                } catch (Exception e){}
            }
            int score = 0;
            for (String s : winningNumber) {
                try {
                    if (card.contains(Long.parseLong(s))) {
                        if (score == 0) {
                            score = 1;
                        } else {
                            score *= 2;
                        }
                    }
                }
                catch (Exception e){}
            }
            finalResult += score;
            System.out.println(score);
            System.out.println(finalResult);
            currentLine = reader.readLine();
        }
        reader.close();
    }
}
