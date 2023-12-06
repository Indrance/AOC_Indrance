package fr.indrance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solver {
    public void Solve() throws IOException {
        // Variable declaration
        int hM = 10;
        int wM = 10;

        String[][] matrice = new String[hM][wM];

        int posY = 0;
        int posX = 0;



        String file = getClass().getClassLoader().getResource("example.txt").getFile();
        System.out.println(file);

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String currentLine = reader.readLine();
        while (posY < hM){
            for (posX = 0; posX < wM; posX++){
                matrice[posY][posX] = String.valueOf(currentLine.charAt(posX));
            }
            System.out.println(currentLine);
            currentLine = reader.readLine();
            posY++;
        }
        System.out.println("----------------");
        reader.close();
        matriceReader(matriceSolver(matrice));


    }

    public String[][] matriceSolver(String[][] matrice){
        Boolean notCheckedEverything = true;
        boolean gettingDigitB = false;
        boolean gettingDigitF = false;
        boolean isDigit = false;
        int finalResult = 0;
        String tmpResult = "";

        for (int i =0; i < matrice.length; i++){
            for (int j = 0; j < matrice[i].length; j++){
                if (!Character.isDigit(matrice[i][j].charAt(0)) && !matrice[i][j].equals(".") && !matrice[i][j].equals("I"))
                {
                    tmpResult = "";
                    // GEAR SPOTTED
                    // GATHERING THE DIGIT
                   /* for (int g = -1; g < 2; g++){
                        for (int h = -1; h < 2; h++) {
                            if (!(g == 0 && h == 0)) {
                                try {
                                    notCheckedEverything = true;
                                    gettingDigitB = false;
                                    gettingDigitF = false;
                                    if(Character.isDigit(matrice[i + g][j + h].charAt(0))){
                                        while (notCheckedEverything){
                                            while(gettingDigitB){
                                                try{

                                                } catch (Exception e){

                                                }
                                            }
                                            while(gettingDigitF){

                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                }
                            }
                        }
                    }*/
                    gettingDigitB = true;
                    gettingDigitF = true;
                    int x = 0;
                    int y = 0;

                    isDigit = false;
                    // Going North
                    x=0;
                    y = -1;
                    try {
                        if (Character.isDigit(matrice[i+y][j].charAt(0)))
                        {
                            tmpResult = matrice[i+y][j];
                            isDigit = true;
                        }
                        // going left
                        try {
                            while (gettingDigitB){
                                x--;
                                if (Character.isDigit(matrice[i+y][j].charAt(0))){
                                    if (isDigit){

                                    } else {
                                        tmpResult = matrice[i+y][j]+tmpResult;
                                    }
                                } else {
                                    gettingDigitB = false;
                                }
                            }

                        } catch (Exception ignored){}
                        x = 0;
                        // going right
                        try {
                            while (gettingDigitF){
                                x++;
                                if (Character.isDigit(matrice[i+y][j].charAt(0))){
                                    tmpResult = tmpResult+matrice[i+y][j];
                                } else {
                                    gettingDigitF = false;
                                }
                            }
                        } catch (Exception ignored){}
                        x = 0;
                    } catch (Exception ignored){}
                    System.out.println(finalResult);
                }
            }
        }
        System.out.println("----------------");
        return matrice;
    }

    public void matriceReader(String[][] matrice){
        for (int i = 0; i< matrice.length; i++){
            for (int j = 0; j < matrice[i].length; j++){
                System.out.print(matrice[i][j]);
            }
            System.out.println("");
        }
    }
}
