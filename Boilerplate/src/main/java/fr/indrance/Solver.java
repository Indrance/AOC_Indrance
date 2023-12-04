package fr.indrance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solver {
    public void Solve() throws IOException {
        String file = getClass().getClassLoader().getResource("test.txt").getFile();
        System.out.println(file);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        while (currentLine != null){
            System.out.println(currentLine);
            currentLine = reader.readLine();
        }
        reader.close();
    }
}
