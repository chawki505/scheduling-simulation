package Algorithme;

import java.util.Scanner;

/**
 * Created by chawki on 21/03/2017.
 */
public class SJF {

    public void runSJFmethode() {


        Scanner sc = new Scanner(System.in);

        int pno[] = new int[10];
        int bt[] = new int[10];
        int wt[] = new int[10];
        int tt[] = new int[10];

        int tempwt[] = new int[10];
        int tempno[] = new int[12]; //stores process no temporary

        int temp[] = new int[12]; //represent Gantt chart

        int n, i, j, ptr, t, t2;

        float awt, atat, twt = 0, ttat = 0;

        System.out.println("Enter no of processes(less than 10):");
        n = sc.nextInt();

        for (i = 0; i < n; i++) {
            System.out.println("Enter the burst time of process " + (i + 1));
            bt[i] = sc.nextInt();
            temp[i] = bt[i];
            pno[i] = i + 1;
            tempno[i] = pno[i];
        }

        for (i = 0; i < n; i++) {
            ptr = 0;

            while (ptr <= n - i) {
                if (temp[ptr] > temp[ptr + 1]) {
                    t = temp[ptr];
                    temp[ptr] = temp[ptr + 1];
                    temp[ptr + 1] = t;
                    t2 = tempno[ptr];
                    tempno[ptr] = tempno[ptr + 1];
                    tempno[ptr + 1] = t2;
                }
                ptr++;
            }
        }

        for (i = 0; i < n; i++) {
            temp[i] = temp[i + 2];
            tempno[i] = tempno[i + 2];
        }


        tempwt[0] = 0;

        for (i = 1; i < n; i++)
            tempwt[i] = tempwt[i - 1] + temp[i - 1];

        for (i = 0; i < n; i++) {
            j = 0;

            while (tempno[i] != pno[j] && j < n)
                j++;
            wt[j] = tempwt[i];
        }

        for (i = 0; i < n; i++)
            tt[i] = wt[i] + bt[i];

        for (i = 0; i < n; i++) {
            twt = twt + wt[i];
            ttat = ttat + tt[i];
        }


        awt = twt / n;
        atat = ttat / n;


        System.out.println("Process\tBurst Time\tWaiting Time\tTurnaround Time");


        for (i = 0; i < n; i++)
        {
            System.out.print("P" + pno[i] + "\t" + bt[i] + "\t\t" + wt[i] + "\t\t" + tt[i]);
            System.out.println();
        }


        System.out.println("Average Waiting Time=" + awt);
        System.out.println("Average Turnaround Time=" + atat);

    }
}


