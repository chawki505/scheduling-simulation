package Interface.Model;

import javafx.beans.property.*;

/**
 * Created by chawki on 28/03/2017.
 */
public class Processus {

    /**
     * Attribut
     **/

    private final StringProperty nom;
    private final IntegerProperty num;
    private final IntegerProperty cpuTime;
    private final IntegerProperty priority;
    private final FloatProperty waitTime;
    private final FloatProperty turnAroundTime;


    /**
     * Constructeur
     **/

    //par default
    public Processus() {
        this(0, 0, 0, 0, 0);
    }

    //pour fcfs , sjf et rr
    public Processus(int num, int cpuTime) {
        this.num = new SimpleIntegerProperty(num);
        this.nom = new SimpleStringProperty("P" + num);
        this.cpuTime = new SimpleIntegerProperty(cpuTime);
        this.priority = new SimpleIntegerProperty(0);
        this.waitTime = new SimpleFloatProperty(0);
        this.turnAroundTime = new SimpleFloatProperty(0);
    }

    //pour priority
    public Processus(int num, int cpuTime, int priority) {
        this.num = new SimpleIntegerProperty(num);
        this.nom = new SimpleStringProperty("P" + num);
        this.cpuTime = new SimpleIntegerProperty(cpuTime);
        this.priority = new SimpleIntegerProperty(priority);
        this.waitTime = new SimpleFloatProperty(0);
        this.turnAroundTime = new SimpleFloatProperty(0);
    }

    //pour linisialisation avec celui par deflault
    public Processus(int num, int cpuTime, int priority, float waitTime, float turnAroundTime) {
        this.num = new SimpleIntegerProperty(num);
        this.nom = new SimpleStringProperty("P" + num);
        this.cpuTime = new SimpleIntegerProperty(cpuTime);
        this.priority = new SimpleIntegerProperty(priority);
        this.waitTime = new SimpleFloatProperty(waitTime);
        this.turnAroundTime = new SimpleFloatProperty(turnAroundTime);
    }


    /**
     * Gutters and Setters
     **/

    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public int getNum() {
        return num.get();
    }

    public IntegerProperty numProperty() {
        return num;
    }

    public void setNum(int num) {
        this.num.set(num);
    }

    public int getCpuTime() {
        return cpuTime.get();
    }

    public IntegerProperty cpuTimeProperty() {
        return cpuTime;
    }

    public void setCpuTime(int cpuTime) {
        this.cpuTime.set(cpuTime);
    }

    public int getPriority() {
        return priority.get();
    }

    public IntegerProperty priorityProperty() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority.set(priority);
    }

    public float getWaitTime() {
        return waitTime.get();
    }

    public FloatProperty waitTimeProperty() {
        return waitTime;
    }

    public void setWaitTime(float waitTime) {
        this.waitTime.set(waitTime);
    }

    public float getTurnAroundTime() {
        return turnAroundTime.get();
    }

    public FloatProperty turnAroundTimeProperty() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(float turnAroundTime) {
        this.turnAroundTime.set(turnAroundTime);
    }
}
