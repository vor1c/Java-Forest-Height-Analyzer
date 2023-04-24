package Aufgaben_von_Tobi;

import java.util.Scanner;

public class Wald {
    public static char[][] initWald(int laenge, int breite) {
        String baum = "╦";
        char tree = baum.charAt(0);
        char[][] wald = new char[laenge][breite];
        for (int i = 0; i < wald.length; i++) {
            for (int j = 0; j < wald.length; j++) {
                wald[i][j] = tree;
            }
        }
        return wald;
    }

    public static double[][] alterarr (int laenge, int breite, int alter){
        double[][] old = new double[laenge][breite];
        int max = 30;
        int min = 0;
        double e =  2.71828;
        double zwischensumme = Math.pow(e,laenge*breite);
        for (int i = 0; i < old.length; i++) {
            for (int j = 0; j < old.length; j++) {
                double höhe = (int)Math.floor(Math.random()*(max-min+1)+min)*zwischensumme-10/alter;
                while(höhe>100){
                    max = 70;
                    min = 0;
                    höhe = höhe - (int)Math.floor(Math.random()*(max-min+1)+min);
                }
                while(höhe<0){
                    höhe++;
                }

                old[i][j] = höhe;
            }
        }
        return old;
    }

    public static void main(String[] args) {
        int laenge;
        int breite;
        int alter;
        System.out.println("laenge: ");
        Scanner sc = new Scanner(System.in);
        laenge = sc.nextInt();
        System.out.println("breite: ");
        breite = sc.nextInt();
        char [][] forest = initWald(laenge,breite);
        for (int i = 0; i < forest.length; i++) {
            for (int j = 0; j < forest.length; j++) {
                System.out.print(forest[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Alter (in Jahre) : ");
        alter = sc.nextInt();

        double[][] old = alterarr(laenge,breite,alter);

        for (int i = 0; i <old.length ; i++) {
            for (int j = 0; j < old.length; j++) {
                System.out.print(old[i][j]+"\t");
            }
            System.out.println();
        }

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_Red = "\u001B[31m";
        final String ANSI_Orange = "\u001B[33m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[93m";

        for (int i = 0; i < old.length; i++) {
            for (int j = 0; j < old[0].length; j++) {
                if(old[i][j]>=0&&old[i][j]<=10){
                    System.out.print(ANSI_Red + "╦" +"\t");
                }
                if(old[i][j]>10&&old[i][j]<=55){
                    System.out.print(ANSI_YELLOW + "╦" + "\t");
                }
                if(old[i][j]>55&&old[i][j]<=80){
                    System.out.print(ANSI_Orange + "╦" + "\t");
                }
                if(old[i][j]>80&&old[i][j]<=100){
                    System.out.print(ANSI_GREEN + "╦" + "\t");
                }
            }
            System.out.println();
        }




    }
}
