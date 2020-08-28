package sr.unasat.verskeerssimulatie.services;

import sr.unasat.verskeerssimulatie.datastructures.trees.Tree;
import sr.unasat.verskeerssimulatie.models.Voertuig;
import sr.unasat.verskeerssimulatie.models.Wegdek;
import sr.unasat.verskeerssimulatie.constants.PriorityLevel;
import sr.unasat.verskeerssimulatie.constants.WEGDEKCODES;

public class VerkeerService {

    private final Wegdek[] wegdeksArray;

    private Wegdek noordWegdek;
    private Wegdek zuidWegdek;
    private Wegdek oostWegdek;
    private Wegdek westWegdek;

    private Wegdek currentWegdek;
    private int currentWegDekQueueSize;

    private Tree voertuigTree = new Tree();


    public VerkeerService(Wegdek[] wegdeksArray) {
        this.wegdeksArray = wegdeksArray;
    }

    private void scanningWegDek() {
        System.out.println("--------------- Wegdek " + currentWegdek.getWegdekCode() + " wordt gescanned -------------------------"
                + "\n" + "Wegdek " + currentWegdek.getWegdekCode() + " size is: " + currentWegDekQueueSize);
    }

    private void activeSensor(WEGDEKCODES wegdek) {

        switch (wegdek){
            case NOORD:
                System.out.println("--------------- Sensor wegdek Noord wordt geactiveerd ---------------");
                sensorNoord();
                break;
            case OOST:
                System.out.println("--------------- Sensor wegdek Oogst wordt geactiveerd ---------------");
                sensorOost();
                break;
            case ZUID:
                System.out.println("--------------- Sensor wegdek Zuid wordt geactiveerd ----------------");
                sensorZuid();
                break;
            case WEST:
                System.out.println("--------------- Sensor wegdek West wordt geactiveerd ----------------");
                sensorWest();
                break;
        }
    }

    private void sensorNoord() {
        scanningWegDek();
        if (!wegdekIsEmpty() && currentWegdek.getVoertuigPriorityQueue().size() < 5){
            System.out.println("Er zijn minder dan 5 autos op het wegdek..." + "\n"
                    + "Er moeten " + currentWegDekQueueSize + " autos oprijden");
            driveOut(currentWegDekQueueSize);
        } else if (wegdekIsEmpty()){
            System.out.println("Weg dek Noord is leeg... skip naar zuid");
            return;
        } else {
            System.out.println("Iets is fout gegaan op wegdek Noord");
        }
    }

    private void sensorOost() {
        scanningWegDek();
        if (wegdekIsEmpty()){
            System.out.println("Weg dek Oost is leeg... skip naar West");
        } else {
            driveOut(5);
        }
    }

    private void sensorZuid() {
        scanningWegDek();
        if (currentWegDekQueueSize > 10){
            System.out.println("Er zijn meer dan 10 autos op wegdek Zuid... Er kunnen maximaal 10 autos oprijden.");
            driveOut(10);
        } else if (currentWegDekQueueSize > 5){
            System.out.println("Er zijn meer dan 5 autos op wegdek Zuid..... 5 autos kunnen oprijden.");
            driveOut(5);
        } else if(currentWegDekQueueSize < 5){
            System.out.println("Er zijn minder dan 5 autos op wegdek Zuid... Alle autos kunnen oprijden.");
            driveOut(currentWegDekQueueSize);
        } else if (wegdekIsEmpty()){
            System.out.println("Er zijn geen meer autos op wegdek Zuid");
        } else {
            System.out.println(" ***** Iets is verkeerd gegaan op wegdek Zuid ***** ");
        }
    }

    private void sensorWest() {
        scanningWegDek();
        if (wegdekIsEmpty()){
            System.out.println("Wegdek West is leeg... Terug naar wegdek Noord");
        } else if (currentWegDekQueueSize > 10){
            System.out.println("Er zijn meer dan 10 autos op wegdek West... Er kunnen maximaal 10 autos oprijden.");
            driveOut(10);
        } else if (currentWegDekQueueSize > 5){
            System.out.println("Er zijn meer dan 5 autos op wegdek West..... 5 autos kunnen oprijden.");
            driveOut(5);
        } else if(currentWegDekQueueSize < 5){
            System.out.println("Er zijn minder dan 5 autos op wegdek West... Alle autos kunnen oprijden.");
            driveOut(currentWegDekQueueSize);
        }else {
            System.out.println(" ***** Iets is verkeerd gegaan op wegdek West ***** ");
        }
    }

    public void startStopLightSequence(){
        initializeAllWegDeks();
        startSequence();
        ReverseSequence();
    }

    private void startSequence() {
        releasingAllPriorityVoertuigen();
        currentWegdek = noordWegdek;
        int roundCounter = 1;

        //Volgorde wegdek moet zijn Noord - Zuid - Oost - West --> terug naar noord
        while (!allWegDekAreEmpty()){
            currentWegDekQueueSize = currentWegdek.getVoertuigPriorityQueue().size();

            if (currentWegdek == noordWegdek){
                System.out.println("\n----------------Round #" + roundCounter + "-----------------------\n");
                System.out.println("Current Wegdek: " + currentWegdek.getWegdekCode());
                activeSensor(WEGDEKCODES.NOORD);
                goToNextWegDek(zuidWegdek);
            } else if (currentWegdek == zuidWegdek){
                System.out.println("Current Wegdek: " + currentWegdek.getWegdekCode());
                activeSensor(WEGDEKCODES.ZUID);
                goToNextWegDek(oostWegdek);
            }else if (currentWegdek == oostWegdek){
                System.out.println("Current Wegdek: " + currentWegdek.getWegdekCode());
                activeSensor(WEGDEKCODES.OOST); // active sensor before turning green
                goToNextWegDek(westWegdek);
            }else if (currentWegdek == westWegdek){
                System.out.println("Current Wegdek: " + currentWegdek.getWegdekCode());
                activeSensor(WEGDEKCODES.WEST);
                goToNextWegDek(noordWegdek);
                roundCounter++;
            }else {
                System.out.println("wegdek is empty");
            }
        }
        System.out.println("Alle autos zijn al opgereden.");
        System.out.println("Totale rondes gemaakt: " + roundCounter + "\n");
    }

    private void initializeWegdek(Wegdek wegdek) {

        PriorityLevel priorityLevel = wegdek.getVoertuigPriorityQueue().getPeek().getPriorityLevel();

        if (priorityLevel == PriorityLevel.AUTO){
            priorityLevel = null;
            System.out.println("Er zijn " + wegdek.getVoertuigPriorityQueue().size() + " autos op het wegdek "+ wegdek.getWegdekCode() +
                    " en heeft geen priority autos.");
        } else {
            System.out.println("Er zijn " + wegdek.getVoertuigPriorityQueue().size() + " autos op het wegdek "+ wegdek.getWegdekCode() +
                    " en heeft een " + priorityLevel + " als priority auto.");
        }
    }

    private void initializeAllWegDeks() {

        System.out.println("\n ----------------------- Alle wegdekken worden geïnitialiseerd -----------------------\n \n");

        for (Wegdek wegdek : wegdeksArray) {
            switch (wegdek.getWegdekCode()) {
                case "Noord":
                    initializeWegdek(wegdek);
                    noordWegdek = wegdek;
                    break;
                case "Zuid":
                    initializeWegdek(wegdek);
                    zuidWegdek = wegdek;
                    break;
                case "Oost":
                    initializeWegdek(wegdek);
                    oostWegdek = wegdek;
                    break;
                case "West":
                    initializeWegdek(wegdek);
                    westWegdek = wegdek;
                    break;
                default:
                    System.out.println(" ***** Could not initialize all wegdeks *****");
                    break;
            }
        }
    }

    public void searchVoertuig(String fullKentekenNummer){
        int nummer = Integer.parseInt(fullKentekenNummer.substring(3,7));
        voertuigTree.get(nummer);
    }

    private void searchFor(PriorityLevel priorityLevel) {

        for (int i = 0; i < wegdeksArray.length; i++){

            Wegdek wegdek = wegdeksArray[i];
            PriorityLevel wegdekPriorityLevel = wegdeksArray[i].getVoertuigPriorityQueue().getPeek().getPriorityLevel();
            String wegdekCode = wegdeksArray[i].getWegdekCode();

            if (wegdekPriorityLevel == priorityLevel){
                Voertuig voertuig = wegdek.getVoertuigPriorityQueue().removeHead();
                wegdek.getVoertuigStack().push(voertuig);
                System.out.println(voertuig.getPriorityLevel() + " rijdt van wegdek: " + wegdekCode);
            }
        }

    }

    private void releasingAllPriorityVoertuigen() {

        System.out.println("\nAlle wegdekken worden gescanned voor priority autos. Deze autos rijden als eerst op: ");
        searchFor(PriorityLevel.POLITIE);
        searchFor(PriorityLevel.BRANDWEER);
        searchFor(PriorityLevel.AMBULANCE);
        System.out.println("\n Alle priority autos hebben al opgereden");

    }


    private void ReverseSequence() {

        System.out.println("********************* Starting reverse playback sequence *********************");

        while (!playBackIsFinished()){
            for (Wegdek wegdek : wegdeksArray) {
                driveBack(wegdek);
            }
        }

        System.out.println("\n---------------- Reverse sequence is compleet ----------------------------------");
        System.out.println("\n---------------- Alle autos zijn geplaatst in de binary tree -------------------\n");
    }


    private void driveOut(int voertuigen) {

        System.out.println("Het verkeerslicht van wegdek " + currentWegdek.getWegdekCode() + " springt op groen");
        currentWegdek.setGroen(true);
        for (int i = 0; i < voertuigen;i++ ){
            Voertuig voertuig = currentWegdek.getVoertuigPriorityQueue().removeHead();
            currentWegdek.getVoertuigStack().push(voertuig);
            System.out.println(voertuig + " rijdt weg");
        }
        System.out.println("Het verkeerslicht van wegdek " + currentWegdek.getWegdekCode() + " springt op rood");
    }

    private void driveBack(Wegdek wegdek) {

        System.out.println("\n------------- Resetting wegdek: " + wegdek.getWegdekCode() + "---------------------------");

        int sizeStack = wegdek.getVoertuigStack().getSize();
        int sizePriorityQueue = wegdek.getVoertuigPriorityQueue().size();

        for (int i = 0; i < sizeStack ;i++){
            Voertuig voertuig = wegdek.getVoertuigStack().pop();
            voertuigTree.insert(voertuig);
            System.out.println(voertuig + " rijdt terug");
        }
        System.out.println("------------- Wegdek " + wegdek.getWegdekCode() + " reverse simulatie is compleet ---------\n");
        //System.out.println("Weg dek " + wegdek.getWegdekCode() + " starting order: ");
    }

    private boolean wegdekIsEmpty() {
        return currentWegdek.getVoertuigPriorityQueue().size() == 0;
    }

    private boolean allWegDekAreEmpty(){
        return noordWegdek.getVoertuigPriorityQueue().isEmpty() &&
                zuidWegdek.getVoertuigPriorityQueue().isEmpty() &&
                oostWegdek.getVoertuigPriorityQueue().isEmpty() &&
                westWegdek.getVoertuigPriorityQueue().isEmpty();
    }

    private boolean playBackIsFinished() {
        return noordWegdek.getVoertuigStack().isEmpty() &&
                zuidWegdek.getVoertuigStack().isEmpty() &&
                oostWegdek.getVoertuigStack().isEmpty() &&
                westWegdek.getVoertuigStack().isEmpty();
    }

    private void goToNextWegDek(Wegdek wegdek) {

        if (allWegDekAreEmpty()){
            System.out.println("\n***************************** Einde stoplicht simulatie ******************************\n");
        } else {
            currentWegdek = wegdek;
            System.out.println("------------------- Naar de volgende wegdek... Wegdek: " + currentWegdek.getWegdekCode() + "-------------------\n");
        }
    }

}
