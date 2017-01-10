# Fuzzer-API

Fuzzer-API est un outil qui testera automatiquement votre API swagger. Pour exécuter le test, Fuzzer-API détectera tous les chemins et les actions (HTTP Methods) de votre API. Et pour chacun d'eux, il enverra un nombre N de requêtes et vérifiera si les réponses correspondent à la spécification du fichier swagger.

## Bibliothèques externes

Les bibliothèques externes utilisées sont :

* Swagger-parser (https://github.com/swagger-api/swagger-parser) : Un outil qui nos permis de lire la description swagger de l'API rest en java.
* Http-request (https://github.com/kevinsawicki/http-request) : Une bibliothèque simple pour faire des requêtes d'une manière assez simple.
* Java-faker (https://github.com/DiUS/java-faker) : Cette bibliothèque génère d'une manière aléatoire des fausses données significatives.

## Usage

Pour lancer le projet, exécutez les commandes suivantes:

    mvn clean

    mvn install

Puis lancer l'application.



    
