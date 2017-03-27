package Algorithme;

/**
 * Created by ibtissem on 21/03/2017.
 */

import java.util.*;

public class Roundrobin {

    Scanner sc = new Scanner(System.in);
    int[] tempCPU, tempsCPU1, waitingT, teurnaround;
    int size, quantum, b = 0, t = 0, flag = 0;


    public Roundrobin() {
    }


    Roundrobin(int size) {
        this.size = size;
        tempCPU = new int[size];
        waitingT = new int[size];
        teurnaround = new int[size];
        tempsCPU1 = new int[size];
    }



    // enter le le temps cpu pour chaque processus et le quantum
    void get() {
        for (int i = 0; i < size; i++) {
            System.out.print("Enter burst time of P" + (i + 1) + ":");
            tempCPU[i] = tempsCPU1[i] = sc.nextInt();
        }

        System.out.print("Enter quantum time:");
        quantum = sc.nextInt();
    }



    // calculer le turnaround et le waiting time pour chaque processus
    void round()

    // claculer le waiting time dans le cas de temps cpu >= le quantum
    {
        do {
            flag = 0;
            for (int i = 0; i < size; i++) {
                if (tempsCPU1[i] >= quantum) {
                    System.out.print("P" + (i + 1) + "\t");
                    for (int j = 0; j < size; j++) {
                        if (j == i)
                            tempsCPU1[i] = tempsCPU1[i] - quantum;
                        else if (tempsCPU1[j] > 0)
                            waitingT[j] += quantum;
                    }
                }
                // calculer le waiting time dans le cas de temps CPU >0 et < quantum
                else if (tempsCPU1[i] > 0) {
                    System.out.print("P" + (i + 1) + "\t");
                    for (int j = 0; j < size; j++) {
                        if (j == i)
                            tempsCPU1[i] = 0;
                        else if (tempsCPU1[j] > 0)
                            waitingT[j] += tempsCPU1[i];
                    }
                }
            }
            // calculer le turnaround de chaque processus à partir du waiting time et time CPU
            for (int i = 0; i < size; i++)
                if (tempsCPU1[i] > 0)
                    flag = 1;

        } while (flag == 1);

        for (int i = 0; i < size; i++)
            teurnaround[i] = waitingT[i] + tempCPU[i];
    }

    // l'affichage de tous les processus avec leur waiting time et le turnaround
    void display() {
        System.out.println("\nProcess\tBurst\tWaiting\tTurnaround");
        for (int i = 0; i < size; i++) {
            System.out.println("P" + (i + 1) + "\t" + tempCPU[i] + "\t" + waitingT[i] + "\t" + teurnaround[i]);
            b += waitingT[i];
            t += teurnaround[i];
        }
        System.out.println("Average waiting time:" + (b / size));
        System.out.println("Average Turnaround time:" + (t / size));
    }

    public void run() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the no of process:");
        int n = s.nextInt();
        Roundrobin obj = new Roundrobin(n);
        obj.get();
        obj.round();
        obj.display();
    }
}



