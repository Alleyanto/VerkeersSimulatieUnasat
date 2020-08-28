package sr.unasat.verskeerssimulatie.datastructures.stacks;

import sr.unasat.verskeerssimulatie.models.Voertuig;

public class VoertuigNode {
    private Voertuig voertuig;
    private VoertuigNode nextNode;

    public VoertuigNode(Voertuig voertuig) {
        this.voertuig = voertuig;
    }

    public Voertuig getVoertuig() {
        return voertuig;
    }

    public void setVoertuig(Voertuig voertuig) {
        this.voertuig = voertuig;
    }

    public VoertuigNode getNext() {
        return nextNode;
    }

    public void setNext(VoertuigNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return voertuig.toString();
    }
}
