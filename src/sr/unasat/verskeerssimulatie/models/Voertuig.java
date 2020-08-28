package sr.unasat.verskeerssimulatie.models;

import sr.unasat.verskeerssimulatie.constants.PriorityLevel;

public class Voertuig {

    private int volgNummer;
    private String kentekenNummer;
    private PriorityLevel priorityLevel;

    public Voertuig(int volgNummer, PriorityLevel priorityLevel) {
        this.volgNummer = volgNummer;
        this.kentekenNummer = generateKentekenNummer(priorityLevel);
        this.priorityLevel = priorityLevel;
    }

    private String generateKentekenNummer(PriorityLevel priorityLevel) {

        switch (priorityLevel){
            case AUTO:
                return createKentekenNumber("AU");
            case POLITIE:
                return createKentekenNumber("PO");
            case AMBULANCE:
                return createKentekenNumber("AM");
            case BRANDWEER:
                return createKentekenNumber("BR");
        }
        return null;
    }

    private String createKentekenNumber(String letters) {
        int eerste2nummers = (int) Math.round((Math.random() * (100 - 10)) + 10);
        int laatse2nummers = (int) Math.round((Math.random() * (100 - 10)) + 10);
        kentekenNummer = letters + " " + eerste2nummers + laatse2nummers;
        return kentekenNummer;
    }

    public int getVolgNummer() {
        return volgNummer;
    }

    public void setVolgNummer(int volgNummer) {
        this.volgNummer = volgNummer;
    }

    public String getKentekenNummer() {
        return kentekenNummer;
    }

    public void setKentekenNummer(String kentekenNummer) {
        this.kentekenNummer = kentekenNummer;
    }

    public PriorityLevel getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(PriorityLevel priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    @Override
    public String toString() {
        return "Voertuig{" +
                "volgNummer=" + volgNummer +
                ", kentekenNummer='" + kentekenNummer + '\'' +
                ", priorityLevel=" + priorityLevel +
                '}';
    }


}


