package fr.indrance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solver {

    public class Boat {

        int charge = -1;
        int speed = 0;
        int distance = 0;

        public Boat(int c) {
            charge = c;
        }

        // calculate the distance
        public void runOneStep() {
            if (charge > 0){
                speed++;
                charge--;
            } else {
             distance+= speed;
            }
        }

        public int getDistance() {
            return distance;
        }

    }

    public class Race {

        int raceID = 0;
        int totalTime = 0;
        int record = 0;
        ArrayList<Boat> allBoat = new ArrayList<>();
        ArrayList<Boat> recordBeater = new ArrayList<>();

        public Race(int ri, int t, int r) {
            raceID = ri;
            totalTime = t;
            record = r;
        }

        public void init() {
            for (int i = 0; i <= totalTime; i++) {
                allBoat.add(new Boat(i));
            }
        }

        public void run() {
            for (int i = 0; i < totalTime; i++){
                for(Boat b : allBoat){
                    b.runOneStep();
                }
            }
            for (Boat b : allBoat){
                if (b.getDistance() > record){
                    recordBeater.add(b);
                }
            }
            System.out.println("Race 1 :" + raceID + " Winner : " + recordBeater.size());
        }

        public int report() {
            return recordBeater.size();
        }

    }

    int nbRace = 4;
    int finalResult = 1;
    public void Solve() throws IOException {


        String file = getClass().getClassLoader().getResource("d4.txt").getFile();
        System.out.println(file);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        // Get the race time
        String currentLine = reader.readLine();
        String[] time = currentLine.split(" ");
        // Get the race record
        currentLine = reader.readLine();
        String[] distance = currentLine.split(" ");
        reader.close();
        for (int i = 0; i < nbRace; i++) {
            Race race = new Race(i, Integer.parseInt(time[i]), Integer.parseInt(distance[i]));
            race.init();
            race.run();
            finalResult*= race.report();
        }
        System.out.println("Final result = " + finalResult);
    }

}
