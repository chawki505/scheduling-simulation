package Algorithme;

import java.util.Scanner;

/**
 * Created by chawki on 21/03/2017.
 */
public class FCFS {

    public void runFCFSmethode() {

        Scanner in = new Scanner(System.in);

        //nbr de processus
        int p;
        //t1 pour le temp d'attente(waiting time) et t2 pour le temp d'execution(turn arrond time)
        float t1 = 0, t2 = 0;


        System.out.print("entrer le nomnre de processus : ");
        p = in.nextInt();


        //le tab pour sauvguarder les temps CPU  de chaque processus
        int bt[] = new int[p]; //la taille du tab = le nombre de p

        System.out.println("Enter les temps CPU des processus ");
        for (int i = 0; i < p; i++) {
            System.out.print(" time CPU de P" + (i + 1) + "=  ");
            bt[i] = in.nextInt();
        }

        //le tab pour calculer le temp d'attente et le sauvgarder pour chaque procesus
        int wt[] = new int[p]; //la taille du tab = le nombre de p

        //pour p1 le temp d'attente est initaliser a 0
        wt[0] = 0;

        //boucle pour le calcule pour chaque p
        for (int i = 1; i < p; i++) {
            wt[i] = bt[i - 1] + wt[i - 1];// somme : temps CPU + temps d'attente
            t1 += wt[i];   // incrementer le temp  par le resulta de la somme ci desous
        }

        //tab pour calculer le temp d'execusion (turn arround time) et le sauvguarder pour chaque processus
        int tat[] = new int[p];//la taille du tab = le nombre de p

        //boucle pour le calcule pour chaque p
        for (int i = 0; i < p; i++) {
            tat[i] = bt[i] + wt[i];  // somme :  temp CPU + temps d'attente
            t2 += tat[i]; // incrementer le temp  par le resulta de cette somme ci dessous
        }


        //affiche du resulta
        System.out.println("Process\t time CPU\t time d'attente \tTurn Around time");
        for (int i = 0; i < p; i++) {
            System.out.println("P" + (i + 1) + "\t\t   " + bt[i] + "\t\t     " + wt[i] + "\t\t         " + tat[i]);
        }


        System.out.println("\nmoyenne Waiting time=" + (t1 / p));
        System.out.println("moyenne Turn Around time=" + (t2 / p));
    }
}
