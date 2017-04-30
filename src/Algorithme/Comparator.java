package Algorithme;

import Interface.Model.*;


/**
 * Created by chawki on 08/04/2017.
 */
class Comparator {


    //methode de comparaison pour le trie d'une liste selon le num du processus
    java.util.Comparator<Processus> comparatorNum = new java.util.Comparator<Processus>() {
        @Override
        public int compare(Processus o1, Processus o2) {
            if (o1.getNum() == o2.getNum())
                return 0;

            else if (o1.getNum() < o2.getNum())
                return -1;
            else
                return 1;
        }
    };


    //methode de comparaison pour le trie d'une liste selon le cpu time
    java.util.Comparator<Processus> comparatorCPUtime = new java.util.Comparator<Processus>() {
        @Override
        public int compare(Processus o1, Processus o2) {
            if (o1.getCpuTime() == o2.getCpuTime())
                return 0;

            else if (o1.getCpuTime() < o2.getCpuTime())
                return -1;
            else
                return 1;
        }
    };


    //methode de comparaison pour le trie d'une liste selon le temp arrive
    java.util.Comparator<Processus> comparatorArrive = new java.util.Comparator<Processus>() {
        @Override
        public int compare(Processus o1, Processus o2) {
            if (o1.getArrive() == o2.getArrive())
                return 0;

            else if (o1.getArrive() < o2.getArrive())
                return -1;
            else
                return 1;
        }
    };


    //methode de comparaison pour le trie d'une liste selon la priority
    java.util.Comparator<Processus> comparatorPriority = new java.util.Comparator<Processus>() {
        @Override
        public int compare(Processus o1, Processus o2) {
            if (o1.getPriority() == o2.getPriority())
                return 0;

            else if (o1.getPriority() < o2.getPriority())
                return -1;
            else
                return 1;

        }
    };


    //methode de comparaison pour le trie d'une liste selon le temp d'arriver et le cpu time
    java.util.Comparator<Processus> comparatorArriveCpuTime = new java.util.Comparator<Processus>() {
        @Override
        public int compare(Processus o1, Processus o2) {
            if (o1.getArrive() == o2.getArrive())
                return comparatorCPUtime.compare(o1, o2);
            else
                return comparatorArrive.compare(o1, o2);
        }
    };


    //methode de comparaison pour le trie d'une liste selon le temp d'arriver et la priority
    java.util.Comparator<Processus> comparatorArrivePriority = new java.util.Comparator<Processus>() {
        @Override
        public int compare(Processus o1, Processus o2) {
            if (o1.getArrive() == o2.getArrive())
                return comparatorPriority.compare(o1, o2);
            else
                return comparatorArrive.compare(o1, o2);
        }
    };


}
