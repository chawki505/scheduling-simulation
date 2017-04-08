package Interface.Other;

import java.util.Random;

/**
 * Created by chawki on 08/04/2017.
 */
public class Aleatoire {
    private Random random = new Random();


    //le nombre de processus de 1 processus max 20
    private int nbrProcessus = random.nextInt(20) + 1;


    //le cpu time de 1 a 50
    private int cpuTime = random.nextInt(20) + 1;


    //la priority de 1 a 10
    private int priority = random.nextInt(5) + 1;


    public Random getRandom() {
        return random;
    }

    public int getNbrProcessus() {
        return nbrProcessus;
    }

    public int getCpuTime() {
        return cpuTime;
    }

    public int getPriority() {
        return priority;
    }
}
