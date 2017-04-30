package Algorithme;

import Interface.Other.Listes;


/**
 * Created by chawki on 21/03/2017.
 */
public class FCFS extends Comparator {

    /**
     * Methodes
     **/

    //methode fsfs sans temp d'arrivé
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


    //methode fsfs avec temp d'arrivé
    public void runFCFSmethode2() {

        float tempWaitingTime = 0;
        float tempTurnAroundTime = 0;
        float horloge;

        //trier par arrive
        Listes.getListProcessusesFCFS().sort(comparatorArrive);

        //initialiser l'horloge au temp d'arivé du 1er
        horloge = Listes.getListProcessusesFCFS().get(0).getArrive();


        // boucle pour calculer le waiting time
        //waitingTime[i] = Horloge - arrivalTime[i];
        // horloge is actually current time.
        for (int i = 0; i < Listes.getListProcessusesFCFS().size(); i++) {

            if (horloge - Listes.getListProcessusesFCFS().get(i).getArrive() < 0) {
                horloge = Listes.getListProcessusesFCFS().get(i).getArrive();
            }

            Listes.getListProcessusesFCFS().get(i).setWaitTime(horloge - Listes.getListProcessusesFCFS().get(i).getArrive());

            horloge += Listes.getListProcessusesFCFS().get(i).getCpuTime();
            tempWaitingTime += Listes.getListProcessusesFCFS().get(i).getWaitTime();   // incrementer le temp total du wainting time
        }


        //boucle pour le calcule pour chaque processus
        for (int i = 0; i < Listes.getListProcessusesFCFS().size(); i++) {
            // turn arroud time :  temp CPU + waiting time
            Listes.getListProcessusesFCFS().get(i).setTurnAroundTime
                    (Listes.getListProcessusesFCFS().get(i).getCpuTime() +
                            Listes.getListProcessusesFCFS().get(i).getWaitTime());

            tempTurnAroundTime += Listes.getListProcessusesFCFS().get(i).getTurnAroundTime(); // incrementer le temp  par le resulta de cette somme ci dessous
        }


        //trier par numero
        Listes.getListProcessusesFCFS().sort(comparatorNum);

        //save les moyenne dans le tab avg
        Listes.getAvg().add(tempWaitingTime / Listes.getListProcessusesFCFS().size());
        Listes.getAvg().add(tempTurnAroundTime / Listes.getListProcessusesFCFS().size());
    }
}
