package Algorithme;

import Interface.Other.Listes;


/**
 * Created by chawki on 21/03/2017.
 */
public class SJF extends Comparator {


    /**
     * Methodes
     **/

//methode sjf sans temp d'arivé
    public void runSJFmethode() {

        float tempWaitingTime = 0;
        float tempTurnAroundTime = 0;

        //trie la liste selon la priority prioritaire
        Listes.getListProcessusesSJF().sort(comparatorCPUtime);

        //pour le premier le waiting time est initaliser a 0
        Listes.getListProcessusesSJF().get(0).setWaitTime(0);

        //boucle pour le calcule pour chaque processus
        for (int i = 1; i < Listes.getListProcessusesSJF().size(); i++) {
            // waiting time : temps CPU precedent + waiting time precedent
            Listes.getListProcessusesSJF().get(i).setWaitTime
                    (Listes.getListProcessusesSJF().get(i - 1).getCpuTime() +
                            Listes.getListProcessusesSJF().get(i - 1).getWaitTime());

            // incrementer le temp  par le resulta de la somme ci dessous
            tempWaitingTime += Listes.getListProcessusesSJF().get(i).getWaitTime();
        }

        //boucle pour le calcule pour chaque processus
        for (int i = 0; i < Listes.getListProcessusesSJF().size(); i++) {
            // turn arroud time :  temp CPU + waiting time
            Listes.getListProcessusesSJF().get(i).setTurnAroundTime
                    (Listes.getListProcessusesSJF().get(i).getCpuTime() +
                            Listes.getListProcessusesSJF().get(i).getWaitTime());

            // incrementer le temp  par le resulta de cette somme ci dessous
            tempTurnAroundTime += Listes.getListProcessusesSJF().get(i).getTurnAroundTime();
        }

        //remetre l'ordre normal de la liste selon le nom du processus
        // Listes.getListProcessusesSJF().sort(comparatorNum);

        //save les moyennes dans le tab avg
        Listes.getAvg().add(tempWaitingTime / Listes.getListProcessusesSJF().size());
        Listes.getAvg().add(tempTurnAroundTime / Listes.getListProcessusesSJF().size());

    }

    //methode avec temp d'arrivé
    public void runSJFmethode2() {

        float tempWaitingTime = 0;
        float tempTurnAroundTime = 0;
        float horloge;

        //trier par arrive
        Listes.getListProcessusesSJF().sort(comparatorArriveCpuTime);

        //initialiser l'horloge au temp d'arivé du 1er
        horloge = Listes.getListProcessusesSJF().get(0).getArrive();


        // boucle pour calculer le waiting time
        //waitingTime[i] = Horloge - arrivalTime[i];
        // horloge is actually current time.
        for (int i = 0; i < Listes.getListProcessusesSJF().size(); i++) {

            if (horloge - Listes.getListProcessusesSJF().get(i).getArrive() < 0) {
                horloge = Listes.getListProcessusesSJF().get(i).getArrive();
            }

            Listes.getListProcessusesSJF().get(i).setWaitTime(horloge - Listes.getListProcessusesSJF().get(i).getArrive());

            horloge += Listes.getListProcessusesSJF().get(i).getCpuTime();
            tempWaitingTime += Listes.getListProcessusesSJF().get(i).getWaitTime();   // incrementer le temp total du wainting time
        }


        //boucle pour le calcule pour chaque processus
        for (int i = 0; i < Listes.getListProcessusesSJF().size(); i++) {
            // turn arroud time :  temp CPU + waiting time
            Listes.getListProcessusesSJF().get(i).setTurnAroundTime
                    (Listes.getListProcessusesSJF().get(i).getCpuTime() +
                            Listes.getListProcessusesSJF().get(i).getWaitTime());

            tempTurnAroundTime += Listes.getListProcessusesSJF().get(i).getTurnAroundTime(); // incrementer le temp  par le resulta de cette somme ci dessous
        }


        //trier par numero
        Listes.getListProcessusesSJF().sort(comparatorNum);

        //save les moyenne dans le tab avg
        Listes.getAvg().add(tempWaitingTime / Listes.getListProcessusesSJF().size());
        Listes.getAvg().add(tempTurnAroundTime / Listes.getListProcessusesSJF().size());
    }


}



