package fr.indrance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Solver {


    public static class locks{

        int nbThread = 5;

        List<Boat> boats = new ArrayList<>();

        public synchronized void removeThread(){
            nbThread--;
        }
        public synchronized void addBoat(Boat b){
            boats.add(b);
        }

    }

    public class Boat {

        int charge = -1;
        int speed = 0;
        long distance = 0;

        long trueTotalTime = -1;
        public Boat(int c, long time) {

            charge = c;
            trueTotalTime = time-c;
        }

        public void runOnce(){
            speed = charge;
            distance = speed*trueTotalTime;
        }
        // calculate the distance
        public synchronized void runOneStep() {
            if (charge > 0){
                speed++;
                charge--;
            } else {
             distance+= speed;
            }
        }

        public long getDistance() {
            return distance;
        }

    }

    public class Race {
        Logger logger = Logger.getLogger("race");
        int raceID = 0;
        long totalTime = 0;
        long record = 0;
        ArrayList<Boat> allBoat = new ArrayList<>();
        ArrayList<Boat> recordBeater = new ArrayList<>();

        locks lock = new locks();

        public Race(int ri, long t, long r) {
            raceID = ri;
            totalTime = t;
            record = r;
        }

        public void init() {
            System.out.println("Starting init");
            for (int i = 0; i <= totalTime; i++) {
                allBoat.add(new Boat(i,totalTime));
            }
            System.out.println("init finished");
        }

        public void runOneStep() {
            for (int i = 0; i < totalTime; i++){

                for(Boat b : allBoat){
                    b.runOneStep();
                }
                logger.info(i+"/"+totalTime);
               // System.out.println(i+"/"+totalTime);
            }
            for (Boat b : allBoat){
                if (b.getDistance() > record){
                    recordBeater.add(b);
                }
            }
            //System.out.println("Race 1 :" + raceID + " Winner : " + recordBeater.size());
        }
        public void runOnce() {
            for (int i = 0; i < totalTime; i++){
                    allBoat.get(i).runOnce();
                logger.info(i+"/"+totalTime);
                // System.out.println(i+"/"+totalTime);
            }
            for (Boat b : allBoat){
                if (b.getDistance() > record){
                    recordBeater.add(b);
                }
            }
            //System.out.println("Race 1 :" + raceID + " Winner : " + recordBeater.size());
        }


        public void threadedRun() throws InterruptedException {
            long start = 1;
            long part = totalTime/9;
            Thread newThread1 = new Thread(() -> {
                for (int i = (int) start; i < part; i++){
                    for(int y = (int) start; y < part; y++){
                        allBoat.get(i).runOneStep();
                    }
                    logger.info(i + "/" + part);
                }
                lock.removeThread();
            });
            Thread newThread2 = new Thread(() -> {
                for (int i = (int) part; i < part*2; i++){
                    for(int y = (int) part; y < part*2; y++){
                        allBoat.get(i).runOneStep();
                    }
                    logger.info(i + "/" + part*2);
                }
                lock.removeThread();
            });
            Thread newThread3 = new Thread(() -> {
                for (int i = (int) part*2; i < part*3; i++){
                    for(int y = (int) part*2; y < part*3; y++){
                        allBoat.get(i).runOneStep();
                    }
                    logger.info(i + "/" + part*3);
                }
                lock.removeThread();
            });
            Thread newThread4 = new Thread(() -> {
                for (int i = (int) part*3; i < part*4; i++){
                    for(int y = (int) part*3; y < part*4; y++){
                        allBoat.get(i).runOneStep();
                    }
                    logger.info(i + "/" + part*4);
                }
                lock.removeThread();
            });
            Thread newThread5 = new Thread(() -> {
                for (int i = (int) part*4; i < part*5; i++){
                    for(int y = (int) part*4; y < part*5; y++){
                        allBoat.get(i).runOneStep();
                    }
                    logger.info(i + "/" + part*5);
                }
                lock.removeThread();
            });
            newThread1.start();
            newThread2.start();
            newThread3.start();
            newThread4.start();
            newThread5.start();

            while (lock.nbThread != 0){
                System.out.println("waiting");
                Thread.sleep(500);
            }
            for (Boat b : allBoat){
                if (b.getDistance() > record){
                    recordBeater.add(b);
                }
            }
            System.out.println(report());
        }



        public int report() {
            return recordBeater.size();
        }

    }

    int nbRace = 1;
    Long finalResult = 1L;
    public void Solve() throws IOException, InterruptedException {
        String file = getClass().getClassLoader().getResource("d42.txt").getFile();
        System.out.println(file);
        long start = System.currentTimeMillis();
        System.out.println(start);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        // Get the race time
        String currentLine = reader.readLine();
        String[] time = currentLine.split(" ");
        // Get the race record
        currentLine = reader.readLine();
        String[] distance = currentLine.split(" ");
        reader.close();
        for (int i = 0; i < nbRace; i++) {
            Race race = new Race(i, Long.parseLong(time[i]), Long.parseLong(distance[i]));
            race.init();
            race.runOnce();
            finalResult*= race.report();
        }
        long stop = System.currentTimeMillis();
        System.out.println("Final result = " + finalResult);
        System.out.println(stop-start);
    }

}
