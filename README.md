# VerkeersSimulatieUnasat

De werking van de verkeerslichten:

In bovenstaande weergave heb je een kruispunt met verkeerslichten.
Elk wegdek is voorzien van een sensor.

In deze situatie kijken we alleen naar het groen licht.
Het rood en oranje licht zijn BUITEN Beschouwing. De volgorde van de verkeerslichten is Noord-Zuid-Oost-West.
Zonder sensor werking blijft het verkeerslicht op groen per wegdek zodat er maximaal 5 auto's kunnen oprijden.

De tijdsfactor van deze verkeerslichten is evenredig aan 5 auto’s. (Dit heeft als doel ter vereenvoudiging van het beroepsproduct.)
Het aantal voertuigen per wegdek is:
Noord - 4 voertuigen (1 ambulance voertuig(3de) met sirene)
Zuid - 18 voertuigen (1 brandweer voertuig(17de) met sirene)
Oost - 5 voertuigen
West - 14 voertuigen (1 politievoertuig (9de) met sirene)

De volgorde van de speciale voertuigen van hoogste tot laagste prioriteit is: Politie, brandweer, ambulance voertuig(en).

------------------------------------------------------------------------------------------------------------------------------

De werking van de sensoren:
* Indien niet aan de conditie van de sensor wordt voldaan functioneert het verkeerslicht zonder sensor werking.

Oost - Sensor 1 >> Voordat het licht op groen springt bij wegdek Oost wordt sensor 1 geactiveerd.
Deze sensor controleert of er voertuigen aanwezig zijn op dit wegdek.
Indien er geen voertuigen aanwezig zijn wordt de groen licht beurt EENMALIG overgeslagen.

Zuid - Sensor 2 >> Voordat het op groen licht springt bij wegdek Zuid wordt sensor 2 geactiveerd.
Deze sensor controleert of er MEER dan 10 voertuigen aanwezig zijn op dit wegdek.
Indien er meer dan 10 voertuigen aanwezig zijn blijft het licht op groen staan tot dat er 10 voertuigen zijn weggereden.

West- Sensor 3 >> Voordat het licht op groen springt bij wegdek West wordt sensor 3 geactiveerd.
Deze sensor heeft een combinatie van sensor 1 en 2.

Noord - Sensor 4 >> Voordat het licht op groen springt bij wegdek Noord wordt sensor 4 geactiveerd.
Deze sensor controleert of er MINDER dan 5 voertuigen aanwezig zijn op dit wegdek.
Zo JA, dan blijft het licht op groen tot dat alle voertuigen zijn weggereden.
Het verkeerslicht blijft voor een kortere periode op groen t.o.v. de rest.
Zodra alle voertuigen zijn opgereden springt het licht op rood.

------------------------------------------------------------------------------------------------------------------------------

Opdracht:

Schrijf een JAVA programma waarin de bovenstaande informatie verwerkt wordt.
Implementeer de verkeerslichten en alle 4 sensoren.

De implementatie van tenminste 2 datastructuren (geen JAVA collection implementatie toegestaan) naast arrays en arraylist is vereist.
Toegestaan zijn de volgende zelf geïmplementeerde datastructuren: queues, stacks, linked lists en binary trees.

Verder dient er gebruik gemaakt te worden van voertuig objecten die minimaal de volgende informatie bevatten:
- Een volgnummer op het aangegeven wegdek
- Een kentekennummer (conform de Surinaamse combinaties van letters & cijfers)
- Een prioriteit indicator in het geval van speciale voertuigen. B.v politie, ambulance en brandweer voertuigen met sirene.
(Let op! Deze special voertuigen dienen eerst op te rijden volgens prioriteit alvorens de eerste verkeersronden start)

Er dient dynamisch door de applicatie berekent te worden hoeveel keer de verkeerslichten een
ronde moeten maken om alle voertuigen op te laten rijden.

Wanneer alle auto’s zijn opgereden dient de applicatie een “Reverse Playback” te doen waarbij de
voertuigen een voor een terug worden geplaatst op het juiste wegdek met de juiste positie. Kort
gezegd terug spelen naar de beginsituatie.

Optioneel (Hoger Cijfer)
1. Na de reverse playback dienen alle voertuigen opgeslagen te worden in een binary tree.
Achteraf moet men in staat zijn om te zoeken (big O -> log n) naar voertuigen op basis van hun
kenteken (letters & cijfers)
2. Gebruik een linkedlist om de queues en stacks te implementeren.

------------------------------------------------------------------------------------------------------------------------------

Let op:
Twee dagen VÓÓR de (her)presentatie moet het beroepsproduct ingeleverd worden.
Tijdens de presentatie wordt getoetst op het gebruik van algoritmes en datastructuren. Het
belangrijkste aspect is dat je kan aantonen (middels code en onderbouwing van je
argumenten) dat de opdracht en leerdoelen begrepen zijn.

Het beroeps product wordt individueel vervaardigd, gepresenteerd en verdedigd.
ALLE BEROEPSPRODUCT FUNCTIONALITEITEN DIENEN TE WERKEN. INDIEN DIT
NIET HET GEVAL IS WORD DE STUDENT NIET IN DE GELEGENHEID GESTELD OM
HET BEROEPSPRODUCT TE VERDEDIGEN. DE BEURT KOMT DAN TE VERVALLEN.
PLAGIAAT IS TEN STRENGSTE VERBODEN, WAAK ER A.U.B. VOOR!!!
