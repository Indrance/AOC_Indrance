package fr.indrance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solver {
    public class Boat{
        int charge = -1;
        int speed = 0;
        int distance = 0;

        public Boat(int c){
            charge = c;
        }

        // calculate the distance
        public int runOneStep(){
            return -99;
        }
    }

    public class Race{
        int totalTime = 0;
        int record = 0;
        ArrayList<Boat> allBoat = new ArrayList<>();
        ArrayList<Boat> recordBeater = new ArrayList<>();

        public Race(int t, int r){
            totalTime = t;
            record = r;
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
        for (int i = 0; i < nbRace; i++){

        }
    }
}
