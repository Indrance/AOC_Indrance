package fr.indrance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solver {
    public class Boat{
        int charge = -1;
        int speed = 0;
        int distance = -1;
        int totalTime = 0;

        public Boat(int c, int tt){
            charge = c;
            totalTime = tt;
        }

        // calculate the distance
        public int run(){
            return -99;
        }
    }

    int nbRace = 3;
    public void Solve() throws IOException {
        String file = getClass().getClassLoader().getResource("example.txt").getFile();
        System.out.println(file);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        // Get the race time
        String currentLine = reader.readLine();
        String[] time = currentLine.split(" ");
        // Get the race record
        currentLine = reader.readLine();
        String[] distance = currentLine.split(" ");
        reader.close();
    }
}
