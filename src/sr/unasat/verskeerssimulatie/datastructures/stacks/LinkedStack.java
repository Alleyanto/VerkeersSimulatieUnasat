package sr.unasat.verskeerssimulatie.datastructures.stacks;

import sr.unasat.verskeerssimulatie.models.Voertuig;

public class LinkedStack {

    private VoertuigLinkedList stack;

    public LinkedStack() {
        this.stack = new VoertuigLinkedList();
    }

    public void push(Voertuig voertuig){
        stack.addToFront(voertuig);
    }

    public Voertuig pop(){
        return stack.removeFromFront();
    }

    public Voertuig peek(){
        return stack.peek();
    }

    public int getSize(){
        return stack.getSize();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void printStack(){

        while (!isEmpty()){
            System.out.println(stack.removeFromFront());
        }

    }
}
