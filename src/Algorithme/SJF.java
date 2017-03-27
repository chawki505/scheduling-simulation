package Algorithme;

import java.util.Scanner;

/**
 * Created by chawki on 21/03/2017.
 */
public class SJF {

    public void runSJFmethode() {

        Scanner sc = new Scanner(System.in);

        int pno[] = new int[10];
        int cpuTime[] = new int[10];
        int watingTimeProcessus[] = new int[10];
        int turnAroundTimeProcessus[] = new int[10];

        int tempwt[] = new int[10];
        int tempno[] = new int[12]; //stores process no temporary

        int temp[] = new int[12]; //represent Gantt chart

        int nbrProcessus, i, j, ptr, t, t2;

        float moyWaitingtime, moyTurnAroundTime, tempWT = 0, tempTAT = 0;

        System.out.println("Enter no of processes(max10):");
        nbrProcessus = sc.nextInt();

        for (i = 0; i < nbrProcessus; i++) {
            System.out.println("Enter the cpu Time time of process " + (i + 1));
            cpuTime[i] = sc.nextInt();

            temp[i] = cpuTime[i];
            pno[i] = i + 1;
            tempno[i] = pno[i];
        }

        for (i = 0; i < nbrProcessus; i++) {
            ptr = 0;

            while (ptr <= nbrProcessus - i) {
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

        for (i = 0; i < nbrProcessus; i++) {
            temp[i] = temp[i + 2];
            tempno[i] = tempno[i + 2];
        }


        tempwt[0] = 0;

        for (i = 1; i < nbrProcessus; i++)
            tempwt[i] = tempwt[i - 1] + temp[i - 1];

        for (i = 0; i < nbrProcessus; i++) {
            j = 0;

            while (tempno[i] != pno[j] && j < nbrProcessus)
                j++;
            watingTimeProcessus[j] = tempwt[i];
        }

        for (i = 0; i < nbrProcessus; i++)
            turnAroundTimeProcessus[i] = watingTimeProcessus[i] + cpuTime[i];

        for (i = 0; i < nbrProcessus; i++) {
            tempWT = tempWT + watingTimeProcessus[i];
            tempTAT = tempTAT + turnAroundTimeProcessus[i];
        }


        moyWaitingtime = tempWT / nbrProcessus;
        moyTurnAroundTime = tempTAT / nbrProcessus;


        System.out.println("Process\tBurst Time\tWaiting Time\tTurnaround Time");


        for (i = 0; i < nbrProcessus; i++)
        {
            System.out.print("P" + pno[i] + "\t     " + cpuTime[i] + "\t\t        " + watingTimeProcessus[i] + "\t\t        " + turnAroundTimeProcessus[i]);
            System.out.println();
        }


        System.out.println("Average Waiting Time=" + moyWaitingtime);
        System.out.println("Average Turnaround Time=" + moyTurnAroundTime);

    }
}


