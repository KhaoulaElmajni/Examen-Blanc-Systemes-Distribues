# <strong style="color:blue; opacity: 0.80">Examen Systèmes Distribués</strong> :mortar_board:

## <span style="color:green "> 1.Project Presentation</span>
 * <strong style="color:dark">On souhaite créer un système distribué basé sur les micro-services en utilisant une architecture pilotée
par les événements respectant les deux patterns Event Sourcing et CQRS. Cette application devrait
permettre de gérer les infractions concernant des véhicules suites à des dépassement de vitesses
détectés par des radars automatiques. Le système se compose de trois micro-services :

	1. 	Le micro-service qui permet de gérer les radars
	1. 	Le micro-service d’immatriculation qui permet de gérer des véhicules appartenant des
	propriétaires
	1. 	Le micro-service qui permet de gérer les infractions.

# <span style="color:green "> Réalisation</span>
	
1.	Etablir une architecture technique du projet 
Architecture CQRS :
	
 ![](https://i.imgur.com/VLLGS4v.png)

# Architecture du système :  
	
![](https://i.imgur.com/cNb4IUC.png)

	
2.	Etablir un diagramme de classe global du projet 
 
	![](https://i.imgur.com/unw6DZj.png)


3.	Développer le micro-service Radar 
 
	![](https://i.imgur.com/Py9jmpq.png)


Le service « radar-commands-service » :

![](https://i.imgur.com/lNGGOzz.png)

Les détails du micro service dans AXON : 
	
![](https://i.imgur.com/i7D6YtR.png)

 
Le service « radar-query-service » : 
	
![](https://i.imgur.com/Kt4GNEI.png)

 
Les détails du micro service dans AXON : 
	
![](https://i.imgur.com/J4Ixnvd.png)

 
Lancement de Axon dans Docker compose :  
	
![](https://i.imgur.com/DMMfQYo.png)

 
Axon dashboard : 
 
![](https://i.imgur.com/TiRWe05.png)

![](https://i.imgur.com/Uo6OxFN.png)

![](https://i.imgur.com/KOin9om.png)

![](https://i.imgur.com/74BEnvo.png)
	
 
4.	Développer le micro-service Immatriculation
	
![](https://i.imgur.com/EzTCq0d.png)

 
Le service « Immatriculation-commands-service » :
 
![](https://i.imgur.com/NlqFeMo.png)

	
Les détails du micro service dans AXON :
 
![](https://i.imgur.com/5zyHxcT.png)


Le service « Immatriculation-query-service » :
 
![](https://i.imgur.com/QPdWRRw.png)

	
Les détails du micro service dans AXON :
 
![](https://i.imgur.com/bkkxC2A.png)


5.	Développer le micro-service Infractions 
	
![](https://i.imgur.com/L2rTirz.png)

 
Le service « Infractions-commands-service » : 
	
![](https://i.imgur.com/wKe3TPM.png)

 
Les détails du micro service dans AXON : 
	
![](https://i.imgur.com/HvHCeoD.png)

 
Le service « Infractions -query-service » : 
![](https://i.imgur.com/mSJspB8.png)
 
Les détails du micro service dans AXON : 
	
![](https://i.imgur.com/egaTM99.png)


6.	Mettre en place les services techniques de l’architecture micro-service (Gateway, Eureka Discovery service) 
Le service « Eureka-discovery-service » :
 
![](https://i.imgur.com/vZ8D8Pb.png)


Le service « Gateway-service » :
 
![](https://i.imgur.com/JY6M7xp.png)


7.	Développer votre application Frontend avec Angular ou React 
 
![](https://i.imgur.com/kWJ8d3z.png)

	
Les composants :
 
![](https://i.imgur.com/dzPLgOn.png)

	
La listes des radars :
 
![](https://i.imgur.com/CsoaXIY.png)


Les événements passés sur un radar :
 
![](https://i.imgur.com/Vq8Sfhf.png)


8.	Sécuriser votre système avec un système de d’authentification OAuth2 comme Keycloak 
	
![](https://i.imgur.com/JPdymwV.png)

Création d’un realm : 
	
![](https://i.imgur.com/K7r4Bi3.png)
 
Création d’un client :
 
![](https://i.imgur.com/XvUt97u.png)

![](https://i.imgur.com/npiEdNh.png)

Création des utilisateurs :
 
![](https://i.imgur.com/yAUBzUa.png)

 ![](https://i.imgur.com/mg00Zcr.png)

 ![](https://i.imgur.com/Fpp3Gqt.png)
	
![](https://i.imgur.com/F3PSjzx.png)

 ![](https://i.imgur.com/f91M5nf.png)

	
Création des roles :
 
![](https://i.imgur.com/RsTzDFK.png)
	
![](https://i.imgur.com/gXefD7g.png)

![](https://i.imgur.com/1iATwFK.png)

 
Assignation des roles aux utilisateurs :
 
 ![](https://i.imgur.com/2ICDr4B.png)

 ![](https://i.imgur.com/UjyKUeO.png)

	![](https://i.imgur.com/h6F2aDl.png)

	
Ajouter les dépendances suivantes dans les 6 micro services:

```java!
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<dependency>
    <groupId>org.keycloak</groupId>
    <artifactId>keycloak-spring-boot-starter</artifactId>
    <version>20.0.1</version>
</dependency>
```

Après, la partie de sécurité dans chaque micro-service :
 ![](https://i.imgur.com/7vPMyvs.png)

La partie front « Authentification pour accéder » :

![](https://i.imgur.com/f3ogtqG.png)


9.	Ecrire un script docker-compose.yml pour le déploiement de ce système distribué dans des conteneurs docker.
Le script docker-compose :

```shell!
version: '3'
services:
  eureka-service:
    build: ./discovery-service/
    hostname: discovery-service
    ports:
      - "8761:8761"
    networks:
      - default-network

  immatriculation-commands-service:
    build: ./immatriculation-commands-service/
    hostname: immatriculation-commands-service
    ports:
      - "8081:8081"
    depends_on:
      - eureka-service
    environment:
      - eureka.client.service-url.defaultZone=http://discovery-service:8761
    networks:
      - default-network

  immatriculation-query-service:
    build: ./immatriculation-query-service/
    hostname: immatriculation-query-service
    ports:
      - "8082:8082"
    restart: on-failure
    depends_on:
      - eureka-service
    environment:
      - eureka.client.service-url.defaultZone=http://discovery-service:8761
    networks:
      - default-network

  infraction-command-service:
    build: ./infraction-command-service/
    hostname: infraction-command-service
    ports:
      - "8090:8090"
    restart: on-failure
    depends_on:
      - eureka-service
    environment:
      - eureka.client.service-url.defaultZone=http://discovery-service:8761
    networks:
      - default-network

  infraction-query-service:
    build: ./infraction-query-service/
    hostname: infraction-query-service
    ports:
      - "8091:8091"
    restart: on-failure
    depends_on:
      - eureka-service
    environment:
      - eureka.client.service-url.defaultZone=http://discovery-service:8761
    networks:
      - default-network

  radar-command-service:
    build: ./radar-command-service/
    hostname: radar-command-service
    ports:
      - "8181:8181"
    restart: on-failure
    depends_on:
      - eureka-service
    environment:
      - eureka.client.service-url.defaultZone=http://discovery-service:8761
    networks:
      - default-network

  radar-query-service:
    build: ./radar-query-service/
    hostname: radar-query-service
    ports:
      - "8883:8883"
    restart: on-failure
    depends_on:
      - eureka-service
    environment:
      - eureka.client.service-url.defaultZone=http://discovery-service:8761
    networks:
      - default-network

  gateway-service:
    build: ./gateway-service/
    hostname: gateway-service
    ports:
      - "9999:9999"
    depends_on:
      - eureka-service
      - immatriculation-query-service
      - immatriculation-command-service
      - infraction-command-service
      - infraction-query-service
      - radar-command-service
      - radar-query-service
    environment:
      - eureka.client.service-url.defaultZone=http://discovery-service:8761/eureka
    networks:
      - default-network

networks:
  default-network:
    driver: bridge

```

la documentation swagger du « radar-command-service » : 
 
![](https://i.imgur.com/arkb3Fo.png)

	
la documentation swagger du « infraction-command-service » : 
	
![](https://i.imgur.com/Rfr6KlC.png)

 
 
La documentation swagger du « infraction-query-service » :
  


![](https://i.imgur.com/8IX1Pux.png)


	
la documentation swagger du « immatriculation-command-service » :
 
![](https://i.imgur.com/U4FIGIY.png)


La documentation swagger du « immatriculation-query-service » : 

![](https://i.imgur.com/U0hVvnF.png)

 
La liste des dépassements de vitesse : 
	
![](https://i.imgur.com/SPApCoO.png)

 
La liste des dépassements de vitesse :

![](https://i.imgur.com/40QD1rU.png)
 
La liste des radars :
 
![](https://i.imgur.com/Zn51eXw.png)

La liste des événements dans AXON:
 
![](https://i.imgur.com/Y1plicw.png)

Les détails d’un événement :
 
![](https://i.imgur.com/feAOxCg.png)

Les commandes
 
![](https://i.imgur.com/suKCU8B.png)

La listes des queries des micro-services :
 
![](https://i.imgur.com/elKH4tq.png)

