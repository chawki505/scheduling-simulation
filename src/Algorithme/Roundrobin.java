package Algorithme;

/**
 * Created by ibtissem on 21/03/2017.
 */

import Interface.AlgorithmeMenu.ControlerMenuRR;
import Interface.Other.Listes;


public class Roundrobin extends Comparator {


    /**
     * Methodes
     **/

    //methode RR
    public void runRRmethode() {

        int quantum = ControlerMenuRR.getQuantum(); //recuperation de la valeur du quantum
        int nbrProcessus = Listes.getListProcessusesRR().size();

        int cpuTime[] = new int[nbrProcessus]; // tab des cpu time
        int waitingTime[] = new int[nbrProcessus]; // tab des waiting time
        int turnAroundtime[] = new int[nbrProcessus]; //tab des turn arround time

        int tempCPUtime[] = new int[nbrProcessus];  //tab temp cpu time


        int tempWT = 0, tempTAT = 0; //temp total des WT et TAT
        boolean status; //condition pour soritre de la boucle switch


        // boucle pour la recuperation des données processus
        for (int i = 0; i < nbrProcessus; i++) {
            cpuTime[i] = Listes.getListProcessusesRR().get(i).getCpuTime();
            tempCPUtime[i] = cpuTime[i]; // save dans le tab temp
        }


        // boucle pour calculer le waiting time en fonction du quantum
        do {
            status = false;

            for (int i = 0; i < nbrProcessus; i++) {

                //calcule du waiting time si cpu time >= quantum
                if (tempCPUtime[i] >= quantum) {
                    for (int j = 0; j < nbrProcessus; j++) {
                        if (j == i) {
                            tempCPUtime[i] = tempCPUtime[i] - quantum;

                        } else if (tempCPUtime[j] > 0) {
                            waitingTime[j] += quantum;
                        }
                    }
                }

                //calcule du waiting time si cpu time < quantum
                else if (tempCPUtime[i] > 0) {
                    for (int j = 0; j < nbrProcessus; j++) {
                        if (j == i) {
                            tempCPUtime[i] = 0;
                        } else if (tempCPUtime[j] > 0) {
                            waitingTime[j] += tempCPUtime[i];
                        }
                    }
                }
            }

            //boucle pour verifier si tous les cpu time ne sont pas encore egale a 0  sinon sortire de la boucle switch
            for (int i = 0; i < nbrProcessus; i++) {
                if (tempCPUtime[i] > 0) {
                    status = true;
                }
            }
        } while (status);


        //boucle pour calculer le turn around
        for (int i = 0; i < nbrProcessus; i++) {
            turnAroundtime[i] = waitingTime[i] + cpuTime[i];
        }


        //boucle pour save les donnée dans la liste et calculer le waiting et arround time total
        for (int i = 0; i < nbrProcessus; i++) {
            Listes.getListProcessusesRR().get(i).setWaitTime(waitingTime[i]);
            Listes.getListProcessusesRR().get(i).setTurnAroundTime(turnAroundtime[i]);
            tempWT += waitingTime[i];
            tempTAT += turnAroundtime[i];
        }


        //calcule de la moy waiting et turnarround et save dans la liste avg
        float moyWait = (tempWT / nbrProcessus);
        float moyTurn = (tempTAT / nbrProcessus);

        Listes.getAvg().add(moyWait);
        Listes.getAvg().add(moyTurn);

    }
}



