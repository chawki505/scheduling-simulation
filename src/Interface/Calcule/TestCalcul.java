package Interface.Calcule;

import Interface.ControlerMenuRR;
import Interface.Listes;


/**
 * Created by chawki on 06/04/2017.
 */
public class TestCalcul {


    public void runFCFSmethode() {

        float temp1 = 0;
        float temp2 = 0;
        //pour p1 le temp d'attente est initaliser a 0
        Listes.getListProcessusesFCFS().get(0).setWaitTime(0);


        //boucle pour le calcule pour chaque processus
        for (int i = 1; i < Listes.getListProcessusesFCFS().size(); i++) {
            // somme : temps CPU + temps d'attente
            Listes.getListProcessusesFCFS().get(i).setWaitTime(Listes.getListProcessusesFCFS().get(i - 1).getCpuTime() + Listes.getListProcessusesFCFS().get(i - 1).getWaitTime());
            temp1 += Listes.getListProcessusesFCFS().get(i).getWaitTime();   // incrementer le temp  par le resulta de la somme ci desous
        }


        //boucle pour le calcule pour chaque processus
        for (int i = 0; i < Listes.getListProcessusesFCFS().size(); i++) {
            // somme :  temp CPU + temps d'attente
            Listes.getListProcessusesFCFS().get(i).setTurnAroundTime(Listes.getListProcessusesFCFS().get(i).getCpuTime() + Listes.getListProcessusesFCFS().get(i).getWaitTime());
            temp2 += Listes.getListProcessusesFCFS().get(i).getTurnAroundTime(); // incrementer le temp  par le resulta de cette somme ci dessous
        }


        Listes.getAvg().add(temp1 / Listes.getListProcessusesFCFS().size());
        Listes.getAvg().add(temp2 / Listes.getListProcessusesFCFS().size());
    }


    public void runSJFmethode() {


        int pNum[] = new int[10];
        int cpuTime[] = new int[10];
        int watingTimeProcessus[] = new int[10];
        int turnAroundTimeProcessus[] = new int[10];


        int tempwaitTime[] = new int[10];
        int tempNum[] = new int[12]; //stores process no temporary

        int tempCPUtime[] = new int[12]; //represent Gantt chart

        int nbrProcessus, i, j;

        int temp1, temp2, ptr; //permutation trie

        float moyWaitingtime, moyTurnAroundTime, tempWT = 0, tempTAT = 0;

        nbrProcessus = Listes.getListProcessusesSJF().size();


        for (i = 0; i < nbrProcessus; i++) {

            cpuTime[i] = Listes.getListProcessusesSJF().get(i).getCpuTime();

            tempCPUtime[i] = cpuTime[i];
            pNum[i] = i + 1;
            tempNum[i] = pNum[i];
        }


        for (i = 0; i < nbrProcessus; i++) {
            ptr = 0;

            while (ptr <= nbrProcessus - i) {
                if (tempCPUtime[ptr] > tempCPUtime[ptr + 1]) {
                    temp1 = tempCPUtime[ptr];
                    tempCPUtime[ptr] = tempCPUtime[ptr + 1];
                    tempCPUtime[ptr + 1] = temp1;
                    temp2 = tempNum[ptr];
                    tempNum[ptr] = tempNum[ptr + 1];
                    tempNum[ptr + 1] = temp2;
                }
                ptr++;
            }

        }

        for (i = 0; i < nbrProcessus; i++) {
            tempCPUtime[i] = tempCPUtime[i + 2];
            tempNum[i] = tempNum[i + 2];
        }


        tempwaitTime[0] = 0;


        for (i = 1; i < nbrProcessus; i++)
            tempwaitTime[i] = tempwaitTime[i - 1] + tempCPUtime[i - 1];

        for (i = 0; i < nbrProcessus; i++) {
            j = 0;

            while (tempNum[i] != pNum[j] && j < nbrProcessus)
                j++;
            watingTimeProcessus[j] = tempwaitTime[i];
            Listes.getListProcessusesSJF().get(j).setWaitTime(tempwaitTime[i]);
        }

        for (i = 0; i < nbrProcessus; i++) {
            turnAroundTimeProcessus[i] = watingTimeProcessus[i] + cpuTime[i];
            Listes.getListProcessusesSJF().get(i).setTurnAroundTime(Listes.getListProcessusesSJF().get(i).getWaitTime() + Listes.getListProcessusesSJF().get(i).getCpuTime());
        }
        for (i = 0; i < nbrProcessus; i++) {
            tempWT = tempWT + watingTimeProcessus[i];
            tempTAT = tempTAT + turnAroundTimeProcessus[i];
        }


        moyWaitingtime = tempWT / nbrProcessus;
        moyTurnAroundTime = tempTAT / nbrProcessus;

        Listes.getAvg().add(moyWaitingtime);
        Listes.getAvg().add(moyTurnAroundTime);


        System.out.println("Process\tBurst Time\tWaiting Time\tTurnaround Time");


        for (i = 0; i < nbrProcessus; i++) {
            System.out.print("P" + pNum[i] + "\t     " + cpuTime[i] + "\t\t        " + watingTimeProcessus[i] + "\t\t        " + turnAroundTimeProcessus[i]);
            System.out.println();
        }


        System.out.println("Average Waiting Time=" + moyWaitingtime);
        System.out.println("Average Turnaround Time=" + moyTurnAroundTime);

    }


    public void runPriority() {


        int i = 0, processus;
        int watingT1[];


        processus = Listes.getListProcessusesPriority().size();
        int timeCPU[] = new int[processus];
        int n1 = processus;

        //pr c'est la prioritée
        int priority[] = new int[processus];

        // pr1 la priority
        int priority1[] = new int[processus];
        //temps globale
        float time = 0;
        // temps pour sauvgarder une donnée
        int temp;

        int turnaround[] = new int[processus];
        int p[] = new int[processus];
        float time2 = 0;

        watingT1 = new int[processus + 1];
        watingT1[0] = 0;
        // Listes.getListProcessusesPriority().get(0).setWaitTime(0);

        for (i = 0; i < processus; i++) {
            // la lecture temps CPU
            timeCPU[i] = Listes.getListProcessusesPriority().get(i).getCpuTime();
        }

// le lecture des priorité pour chaque processus
        for (i = 0; i < processus; i++) {
            priority[i] = Listes.getListProcessusesPriority().get(i).getPriority();
        }
// la copie des priorité dans priority1
        for (i = 0; i < processus; i++) {
            priority1[i] = priority[i];
        }
// ordonner le tableau des prioritée du min au max( on considere que la petite priorité c'est  elle qui domine )
        for (i = 0; i < processus; i++)
            for (int j = i + 1; j < processus; j++)
                if (priority1[i] > priority1[j]) {
                    temp = priority1[i];
                    priority1[i] = priority1[j];
                    priority1[j] = temp;
                }
// comparer l'ancien tablaux avec le nouveux pour voir si on a des prioritée egaux
        for (i = 0; i < processus; i++)
            for (int j = 0; j < processus; j++)
                if (priority1[i] == priority[j])
                    p[i] = j + 1;

        for (i = 0; i < processus; i++) {
            int k = p[i];
            watingT1[i + 1] = timeCPU[k - 1] + watingT1[i];
        }

        for (i = 0; i < processus; i++) {
            Listes.getListProcessusesPriority().get(i).setWaitTime(watingT1[i]);
            System.out.println("indivisual waiting time for process p" + p[i] + " " + "is" + " " + watingT1[i] + " ");
        }

        for (i = 0; i < processus; i++)
            time += watingT1[i];
        float watingTimeMoyenne = time / processus;
        Listes.getAvg().add(watingTimeMoyenne);
        System.out.println("average waiting time is:" + " " + watingTimeMoyenne);


        for (i = 0; i < processus; i++) {
            int k = p[i];
            turnaround[i] = timeCPU[k - 1] + watingT1[i];

            System.out.println("turnaround time for process p" + p[i] + " " + "is" + " " + turnaround[i] + " ");
        }


        for (i = 0; i < processus; i++) {
            time2 += turnaround[i];
            Listes.getListProcessusesPriority().get(i).setTurnAroundTime(turnaround[i]);
        }
        float turnaroudMoyenne = time2 / processus;
        Listes.getAvg().add(turnaroudMoyenne);
        System.out.println("average turn-around time is:" + " " + turnaroudMoyenne);


    }


    public void runRR() {

        int[] tempCPU, tempsCPU1, waitingT, turnAround;
        int size, quantum, b = 0, t = 0, flag = 0;


        size = Listes.getListProcessusesRR().size();
        tempCPU = new int[size];
        waitingT = new int[size];
        turnAround = new int[size];
        tempsCPU1 = new int[size];


        // enter le le temps cpu pour chaque processus et le quantum


        for (int i = 0; i < size; i++) {
            tempCPU[i] = tempsCPU1[i] = Listes.getListProcessusesRR().get(i).getCpuTime();
        }

        quantum = ControlerMenuRR.getQuantum();


        // calculer le turnaround et le waiting time pour chaque processus

        // claculer le waiting time dans le cas de temps cpu >= le quantum

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

        for (int i = 0; i < size; i++) {
            turnAround[i] = waitingT[i] + tempCPU[i];
        }

        for (int i = 0; i < size; i++) {
            Listes.getListProcessusesRR().get(i).setWaitTime(waitingT[i]);
            Listes.getListProcessusesRR().get(i).setTurnAroundTime(turnAround[i]);
        }

        // l'affichage de tous les processus avec leur waiting time et le turnaround

        System.out.println("\nProcess\tBurst\tWaiting\tTurnaround");
        for (int i = 0; i < size; i++) {
            System.out.println("P" + (i + 1) + "\t" + tempCPU[i] + "\t" + waitingT[i] + "\t" + turnAround[i]);
            b += waitingT[i];
            t += turnAround[i];
        }

        float moyWait = (b / size);
        float moyTurn = (t / size);

        Listes.getAvg().add(moyWait);
        Listes.getAvg().add(moyTurn);
        System.out.println("Average waiting time:" + moyWait);
        System.out.println("Average Turnaround time:" + moyTurn);


    }
}



