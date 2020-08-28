package sr.unasat.verskeerssimulatie.datastructures.queues;

import sr.unasat.verskeerssimulatie.models.Voertuig;
import sr.unasat.verskeerssimulatie.constants.PriorityLevel;

public class PriorityQueue {

    private int maxSize;
    private Voertuig[] voertuigArray;
    private int aantalvoertuigen;
    private int frontQueue;
    private int rearQueue;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        this.voertuigArray = new Voertuig[maxSize];
        this.aantalvoertuigen = 0;
        this.frontQueue = 0;
        this.rearQueue = -1;
    }

    public void insert(Voertuig voertuig){
        int i;
        if (aantalvoertuigen == 0){
            voertuigArray[0] = voertuig;
            aantalvoertuigen++;
        } else {
            for (i = aantalvoertuigen - 1; i >= 0; i--){
                if (isPriority(voertuig.getPriorityLevel())){
                    voertuigArray[i + 1] = voertuigArray[i];
                } else {
                    break;
                }
            }

            voertuigArray[i + 1] = voertuig;
            aantalvoertuigen++;
        }
    }

    private boolean isPriority(PriorityLevel voertuigPriority) {
        return voertuigPriority == PriorityLevel.POLITIE || voertuigPriority == PriorityLevel.AMBULANCE ||
                voertuigPriority == PriorityLevel.BRANDWEER;
    }

    public void printPriorityQueue(){
        for (int i = 0;i < aantalvoertuigen; i++){
            System.out.println(voertuigArray[i]);
        }
    }

    public void printQueue(){
        while( !isEmpty() ) {
            Voertuig n = removeHead();
            System.out.println(n);
            System.out.print(" ");
        }
    }

    // remove end of the voertuigArrayay
    public Voertuig remove (){
        return voertuigArray[--aantalvoertuigen];
    }

    public Voertuig removeHead(){
        Voertuig temp = voertuigArray[frontQueue++]; // get value and incr frontQueue
        if(frontQueue == maxSize) // deal with wraparound
            frontQueue = 0;
        aantalvoertuigen--; // one less item
        return temp;
    }

    public boolean isFull(){
        return aantalvoertuigen == maxSize;
    }

    public boolean isEmpty(){
        return  (aantalvoertuigen == 0);
    }

    // peek end of voertuigArrayay
    public Voertuig getPeek(){
        return voertuigArray[frontQueue];
    }


    public int size() {
        return aantalvoertuigen;
    }
}
