package Algorithme;

/**
 * Created by ibtissem on 21/03/2017.
 */

import java.util.*;

public class Priority {


    public void runPriority() {
        Scanner sc = new Scanner(System.in);

        int i = 0, n;
        int watingT1[];

        System.out.print("entrer le nombre de processus : ");
        n = sc.nextInt();
        int timeCPU[] = new int[n];
        int n1 = n;

        //pr c'est la prioritée
        int priority[] = new int[n];

        // pr1 la priority
        int priority1[] = new int[n];
        //temps globale
        float time = 0;
        // temps pour sauvgarder une donnée
        int temp;

        int turnaround[] = new int[n];
        int p[] = new int[n];
        float time2 = 0;

        watingT1 = new int[n + 1];
        watingT1[0] = 0;

        for (i = 0; i < n; i++) {
            System.out.println("ENTER time CPU for each process: p" + (i + 1));
            // la lecture temps CPU
            timeCPU[i] = sc.nextInt();
        }

// le lecture des priorité pour chaque processus
        for (i = 0; i < n; i++) {
            System.out.println("Enter the priority for p" + (i + 1));
            priority[i] = sc.nextInt();
        }
// la copie des priorité dans priority1
        for (i = 0; i < n; i++) {
            priority1[i] = priority[i];
        }
// ordonner le tableau des prioritée du min au max( on considere que la petite priorité c'est  elle qui domine )
        for (i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (priority1[i] > priority1[j]) {
                    temp = priority1[i];
                    priority1[i] = priority1[j];
                    priority1[j] = temp;
                }
// comparer l'ancien tablaux avec le nouveux pour voir si on a des prioritée egaux
        for (i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (priority1[i] == priority[j])
                    p[i] = j + 1;

        for (i = 0; i < n; i++) {
            int k = p[i];
            watingT1[i + 1] = timeCPU[k - 1] + watingT1[i];
        }

        for (i = 0; i < n; i++) {
            System.out.println("indivisual waiting time for process p" + p[i]+" " + "is" +" " + watingT1[i] + " ");
        }

        for (i = 0; i < n; i++)
            time += watingT1[i];
        float watingTimeMoyenne = time / n;
        System.out.println("average waiting time is:" +" " + watingTimeMoyenne);


        for (i = 0; i < n; i++) {
            int k = p[i];
            turnaround[i] = timeCPU[k - 1] + watingT1[i];
            System.out.println("turnaround time for process p" + p[i] +" "+ "is" +" "+ turnaround[i] + " ");
        }


        for (i = 0; i < n; i++)
            time2 += turnaround[i];

        float turnaroudMoyenne = time2 / n;
        System.out.println("average turn-around time is:" +" " +turnaroudMoyenne);


    }


}
