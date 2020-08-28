package sr.unasat.verskeerssimulatie.models;

import sr.unasat.verskeerssimulatie.datastructures.queues.PriorityQueue;
import sr.unasat.verskeerssimulatie.datastructures.stacks.LinkedStack;

public class Wegdek {

    private String wegdekCode;
    private Boolean isGroen;
    private PriorityQueue voertuigPriorityQueue;
    private LinkedStack voertuigStack;


    public Wegdek(String wegdekCode) {
        this.wegdekCode = wegdekCode;
        this.voertuigPriorityQueue = new PriorityQueue(20);
        this.voertuigStack = new LinkedStack();
        this.isGroen = false;
    }

    public void addVoertuig(Voertuig voertuig){
        voertuigPriorityQueue.insert(voertuig);
    }

    public String getWegdekCode() {
        return wegdekCode;
    }

    public void setWegdekCode(String wegdekCode) {
        this.wegdekCode = wegdekCode;
    }

    public Boolean getGroen() {
        return isGroen;
    }

    public void setGroen(Boolean groen) {
        isGroen = groen;
    }

    public PriorityQueue getVoertuigPriorityQueue() {
        return voertuigPriorityQueue;
    }

    public void setVoertuigPriorityQueue(PriorityQueue voertuigPriorityQueue) {
        this.voertuigPriorityQueue = voertuigPriorityQueue;
    }

    public LinkedStack getVoertuigStack() {
        return voertuigStack;
    }

    public void setVoertuigStack(LinkedStack voertuigStack) {
        this.voertuigStack = voertuigStack;
    }

    @Override
    public String toString() {
        return "Wegdek{" +
                "wegdekCode='" + wegdekCode + '\'' +
                ", isGroen=" + isGroen +
                ", voertuigPriorityQueue=" + voertuigPriorityQueue +
                ", voertuigStack=" + voertuigStack +
                '}';
    }
}
