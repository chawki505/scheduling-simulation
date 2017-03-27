package Algorithme;

import java.util.Scanner;

/**
 * Created by chawki on 21/03/2017.
 */
public class FCFS {

    public void runFCFSmethode() {

        Scanner in = new Scanner(System.in);

        //nbr de processus
        int processus;
        //temp1 pour le temp d'attente(waiting time) et temp2 pour le temp d'execution(turn arrond time)
        float temp1 = 0, temp2 = 0;


        System.out.print("entrer le nombre de processus : ");
        processus = in.nextInt();


        //le tab pour sauvguarder les temps CPU  de chaque processus
        int tempCpuProcessus[] = new int[processus]; //la taille du tab = le nombre de processus

        System.out.println("Enter les temps CPU des processus ");
        for (int i = 0; i < processus; i++) {
            System.out.print(" time CPU de P" + (i + 1) + "=  ");
            tempCpuProcessus[i] = in.nextInt();
        }

        //le tab pour calculer le temp d'attente et le sauvgarder pour chaque procesus
        int waitingTimeProcessus[] = new int[processus]; //la taille du tab = le nombre de processus

        //pour p1 le temp d'attente est initaliser a 0
        waitingTimeProcessus[0] = 0;

        //boucle pour le calcule pour chaque processus
        for (int i = 1; i < processus; i++) {
            waitingTimeProcessus[i] = tempCpuProcessus[i - 1] + waitingTimeProcessus[i - 1];// somme : temps CPU + temps d'attente
            temp1 += waitingTimeProcessus[i];   // incrementer le temp  par le resulta de la somme ci desous
        }

        //tab pour calculer le temp d'execusion (turn arround time) et le sauvguarder pour chaque processus
        int turnAroundTimeProcessus[] = new int[processus];//la taille du tab = le nombre de processus

        //boucle pour le calcule pour chaque processus
        for (int i = 0; i < processus; i++) {
            turnAroundTimeProcessus[i] = tempCpuProcessus[i] + waitingTimeProcessus[i];  // somme :  temp CPU + temps d'attente
            temp2 += turnAroundTimeProcessus[i]; // incrementer le temp  par le resulta de cette somme ci dessous
        }


        //affiche du resulta
        System.out.println("Process\t time CPU\t time d'attente \tTurn Around time");
        for (int i = 0; i < processus; i++) {
            System.out.println("P" + (i + 1) + "\t\t   " + tempCpuProcessus[i] + "\t\t     " + waitingTimeProcessus[i] + "\t\t         " + turnAroundTimeProcessus[i]);
        }


        System.out.println("\nmoyenne Waiting time=" + (temp1 / processus));
        System.out.println("moyenne Turn Around time=" + (temp2 / processus));
    }
}
