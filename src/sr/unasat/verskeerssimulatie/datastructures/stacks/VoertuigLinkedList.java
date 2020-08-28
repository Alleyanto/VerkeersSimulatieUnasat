package sr.unasat.verskeerssimulatie.datastructures.stacks;

import sr.unasat.verskeerssimulatie.models.Voertuig;

public class VoertuigLinkedList {

    private VoertuigNode head;
    private int size;

    public void addToFront(Voertuig voertuig){
        VoertuigNode node = new VoertuigNode(voertuig);
        node.setNext(head);
        head = node;
        size++;
    }

    public Voertuig removeFromFront(){
        if (isEmpty()){
            return null;
        }
        VoertuigNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode.getVoertuig();
    }

    public Voertuig peek(){
        return head.getVoertuig();
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void print(){

        VoertuigNode current = head;
        System.out.print("Head -> ");
        while (current != null){
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.print("null");
    }
}
