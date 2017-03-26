package Algorithme;

/**
 * Created by chawki on 21/03/2017.
 */

import java.util.*;

public class Priority {


    public void runPriority() {
        Scanner sc = new Scanner(System.in);


        int i = 0, n;
        int apw1[];

        System.out.print("entrer le nombre de processus : ");
        n = sc.nextInt();
        int bt[] = new int[n];
        int n1 = n;

        //pr c'est la prioritée
        int pr[] = new int[n];

        // pr1 la priority
        int pr1[] = new int[n];

        float t = 0;

        // temps pour sauvgarder une donnée
        int temp;

        // le turnaround
        int turn[] = new int[n];
        int p[] = new int[n];
        float tu = 0;

        apw1 = new int[n + 1];
        apw1[0] = 0;

        for (i = 0; i < n; i++) {
            System.out.println("ENTER burst time for each process: p" + (i + 1));
            // la lecture temps CPU
            bt[i] = sc.nextInt();
        }

// le lecture des priorité pour chaque processus
        for (i = 0; i < n; i++) {
            System.out.println("Enter the priority for p" + (i + 1));
            pr[i] = sc.nextInt();
        }
// la copie des priorité dans pr1
        for (i = 0; i < n; i++) {
            pr1[i] = pr[i];
        }
// ordonner le tableau des prioritée du min au max( on considere que la petite priorité c'est  elle qui domine )
        for (i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (pr1[i] > pr1[j]) {
                    temp = pr1[i];
                    pr1[i] = pr1[j];
                    pr1[j] = temp;
                }
// comparer l'ancien tablaux avec le nouveux pour voir si on a des prioritée egaux
        for (i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (pr1[i] == pr[j])
                    p[i] = j + 1;

        for (i = 0; i < n; i++) {
            int k = p[i];
            apw1[i + 1] = bt[k - 1] + apw1[i];
        }

        for (i = 0; i < n; i++) {
            System.out.println("indivisual waiting time for process p" + p[i] + "is" + apw1[i] + " ");
        }

        for (i = 0; i < n; i++)
            t += apw1[i];
        float avg = t / n;
        System.out.println("average waiting time is:" + avg);


        for (i = 0; i < n; i++) {
            int k = p[i];
            turn[i] = bt[k - 1] + apw1[i];
            System.out.println("turnaround time for process p" + p[i] + "is" + turn[i] + " ");
        }


        for (i = 0; i < n; i++)
            tu += turn[i];

        float avg1 = tu / n;
        System.out.println("average turn-around time is:" + avg1);


    }


}
