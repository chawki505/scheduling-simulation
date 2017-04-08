package Algorithme;

import Interface.Other.Listes;


/**
 * Created by chawki on 21/03/2017.
 */
public class FCFS {

    /**
     * Methodes
     **/

    //methode fsfs
    public void runFCFSmethode() {

        float tempWaitingTime = 0;
        float tempTurnAroundTime = 0;

        //pour p1 le waiting time est initaliser a 0
        Listes.getListProcessusesFCFS().get(0).setWaitTime(0);

        //boucle pour le calcule pour chaque processus
        for (int i = 1; i < Listes.getListProcessusesFCFS().size(); i++) {
            // waiting time : temps CPU precedent + waiting time precedent
            Listes.getListProcessusesFCFS().get(i).setWaitTime
                    (Listes.getListProcessusesFCFS().get(i - 1).getCpuTime() +
                            Listes.getListProcessusesFCFS().get(i - 1).getWaitTime());
            tempWaitingTime += Listes.getListProcessusesFCFS().get(i).getWaitTime();   // incrementer le temp  par le resulta de la somme ci dessous
        }

        //boucle pour le calcule pour chaque processus
        for (int i = 0; i < Listes.getListProcessusesFCFS().size(); i++) {
            // turn arroud time :  temp CPU + waiting time
            Listes.getListProcessusesFCFS().get(i).setTurnAroundTime
                    (Listes.getListProcessusesFCFS().get(i).getCpuTime() +
                            Listes.getListProcessusesFCFS().get(i).getWaitTime());
            tempTurnAroundTime += Listes.getListProcessusesFCFS().get(i).getTurnAroundTime(); // incrementer le temp  par le resulta de cette somme ci dessous
        }

        //save les moyenne dans le tab avg
        Listes.getAvg().add(tempWaitingTime / Listes.getListProcessusesFCFS().size());
        Listes.getAvg().add(tempTurnAroundTime / Listes.getListProcessusesFCFS().size());
    }
}
