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

Wanneer alle auto’s zijn opgereden dient de applicatie een “Reverse Playback” te doen waarbij de
voertuigen een voor een terug worden geplaatst op het juiste wegdek met de juiste positie. Kort
gezegd terug spelen naar de beginsituatie.

Optioneel (Hoger Cijfer)
1. Na de reverse playback dienen alle voertuigen opgeslagen te worden in een binary tree.
Achteraf moet men in staat zijn om te zoeken (big O -> log n) naar voertuigen op basis van hun
kenteken (letters & cijfers)
2. Gebruik een linkedlist om de queues en stacks te implementeren.


