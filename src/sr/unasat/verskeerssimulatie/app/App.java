package sr.unasat.verskeerssimulatie.app;

import sr.unasat.verskeerssimulatie.models.Voertuig;
import sr.unasat.verskeerssimulatie.models.Wegdek;
import sr.unasat.verskeerssimulatie.services.VerkeerService;
import sr.unasat.verskeerssimulatie.constants.PriorityLevel;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Wegdek wegdekNoord = new Wegdek("Noord");
        wegdekNoord.addVoertuig(new Voertuig(1, PriorityLevel.AUTO));
        wegdekNoord.addVoertuig(new Voertuig(2, PriorityLevel.AUTO));
        wegdekNoord.addVoertuig(new Voertuig(3, PriorityLevel.AMBULANCE));
        wegdekNoord.addVoertuig(new Voertuig(4, PriorityLevel.AUTO));

        Wegdek wegdekZuid = new Wegdek("Zuid");
        wegdekZuid.addVoertuig(new Voertuig(1, PriorityLevel.AUTO));
        wegdekZuid.addVoertuig(new Voertuig(2, PriorityLevel.AUTO));
        wegdekZuid.addVoertuig(new Voertuig(3, PriorityLevel.AUTO));
        wegdekZuid.addVoertuig(new Voertuig(4, PriorityLevel.AUTO));
        wegdekZuid.addVoertuig(new Voertuig(5, PriorityLevel.AUTO));
        wegdekZuid.addVoertuig(new Voertuig(6, PriorityLevel.AUTO));
        wegdekZuid.addVoertuig(new Voertuig(7, PriorityLevel.AUTO));
        wegdekZuid.addVoertuig(new Voertuig(8, PriorityLevel.AUTO));
        wegdekZuid.addVoertuig(new Voertuig(9, PriorityLevel.AUTO));
        wegdekZuid.addVoertuig(new Voertuig(10, PriorityLevel.AUTO));
        wegdekZuid.addVoertuig(new Voertuig(11, PriorityLevel.AUTO));
        wegdekZuid.addVoertuig(new Voertuig(12, PriorityLevel.AUTO));
        wegdekZuid.addVoertuig(new Voertuig(13, PriorityLevel.AUTO));
        wegdekZuid.addVoertuig(new Voertuig(14, PriorityLevel.AUTO));
        wegdekZuid.addVoertuig(new Voertuig(15, PriorityLevel.AUTO));
        wegdekZuid.addVoertuig(new Voertuig(16, PriorityLevel.AUTO));
        wegdekZuid.addVoertuig(new Voertuig(17, PriorityLevel.BRANDWEER));
        wegdekZuid.addVoertuig(new Voertuig(18, PriorityLevel.AUTO));

        Wegdek wegdekOost = new Wegdek("Oost");
        wegdekOost.addVoertuig(new Voertuig(1, PriorityLevel.AUTO));
        wegdekOost.addVoertuig(new Voertuig(2, PriorityLevel.AUTO));
        wegdekOost.addVoertuig(new Voertuig(3, PriorityLevel.AUTO));
        wegdekOost.addVoertuig(new Voertuig(4, PriorityLevel.AUTO));
        wegdekOost.addVoertuig(new Voertuig(5, PriorityLevel.AUTO));

        Wegdek wegdekWest = new Wegdek("West");
        wegdekWest.addVoertuig(new Voertuig(1, PriorityLevel.AUTO));
        wegdekWest.addVoertuig(new Voertuig(2, PriorityLevel.AUTO));
        wegdekWest.addVoertuig(new Voertuig(3, PriorityLevel.AUTO));
        wegdekWest.addVoertuig(new Voertuig(4, PriorityLevel.AUTO));
        wegdekWest.addVoertuig(new Voertuig(5, PriorityLevel.AUTO));
        wegdekWest.addVoertuig(new Voertuig(6, PriorityLevel.AUTO));
        wegdekWest.addVoertuig(new Voertuig(7, PriorityLevel.AUTO));
        wegdekWest.addVoertuig(new Voertuig(8, PriorityLevel.AUTO));
        wegdekWest.addVoertuig(new Voertuig(9, PriorityLevel.POLITIE));
        wegdekWest.addVoertuig(new Voertuig(10, PriorityLevel.AUTO));
        wegdekWest.addVoertuig(new Voertuig(11, PriorityLevel.AUTO));
        wegdekWest.addVoertuig(new Voertuig(12, PriorityLevel.AUTO));
        wegdekWest.addVoertuig(new Voertuig(13, PriorityLevel.AUTO));
        wegdekWest.addVoertuig(new Voertuig(14, PriorityLevel.AUTO));

        Wegdek[] wegdeksArray = {wegdekNoord,wegdekZuid,wegdekOost,wegdekWest};

        VerkeerService verkeerService = new VerkeerService(wegdeksArray);
        verkeerService.startStopLightSequence();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Search voertuig: ");
        String kentekenNumber = scanner.nextLine();
        verkeerService.searchVoertuig(kentekenNumber);

    }
}
