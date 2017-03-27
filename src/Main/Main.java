package Main;

import Algorithme.*;

import java.util.Scanner;

/**
 * Created by chawki on 21/03/2017.
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choix;

        System.out.println("1-FCFS");
        System.out.println("2-SJF");
        System.out.println("3-RR");
        System.out.println("4-Priority");
        System.out.print("choix: ");

        choix = sc.nextInt();

        switch (choix) {
            case 1:
                FCFS fcfs = new FCFS();
                fcfs.runFCFSmethode();
                break;

            case 2:
                SJF sjf = new SJF();
                sjf.runSJFmethode();
                break;

            case 3:
                Roundrobin roundrobin = new Roundrobin();
                roundrobin.run();
                break;

            case 4:
                Priority p = new Priority();
                p.runPriority();
                break;

            default:
                System.out.println("erreur");
        }


    }
}
