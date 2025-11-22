🏦 Bankati – Application Web de Gestion Bancaire

Bankati est une application web développée avec Spring Boot, Spring MVC, Thymeleaf et Spring Data JPA, permettant de gérer de manière simple et sécurisée les opérations d’une banque fictive.
Le projet propose deux types d’utilisateurs : Clients et Administrateurs, chacun avec des fonctionnalités dédiées.

🚀 Fonctionnalités principales
👤 Clients

Authentification sécurisée via Spring Security

Consultation du solde et des informations de compte

Gestion des demandes de crédit :

Ajouter une demande

Supprimer une demande non traitée

Suivre l’état (en attente, acceptée, refusée)

Modification des informations personnelles

Changement de mot de passe

🛠️ Administrateurs

Gestion complète des utilisateurs (CRUD)

Gestion et validation des demandes de crédit

Consultation des statistiques générales

Consultation des profils clients et de leurs comptes

🏗️ Architecture Technique

L’application suit une architecture 3-tiers :

Présentation :

Spring MVC

Thymeleaf (templates HTML dynamiques)

Logique métier :

Services Spring

Gestion des opérations bancaires et des demandes de crédit

Persistance :

Spring Data JPA

Base de données MySQL

Entités : User, Client, Compte, CreditRequest

🔐 Sécurité

Spring Security assure :

Authentification et rôles (ADMIN / CLIENT)

Filtrage des accès aux pages sensibles

Gestion des sessions

🛠️ Technologies utilisées

Java 11+

Spring Boot

Spring MVC

Spring Security

Spring Data JPA

Thymeleaf

MySQL

IntelliJ IDEA / Eclipse

📊 Base de données

Les tables principales :

users

clients

comptes

credit_requests

Le mapping est géré via Spring Data JPA.

▶️ Lancer le projet

Cloner le projet

Configurer la base de données MySQL

Mettre à jour le fichier application.properties

Lancer le projet avec l’IDE ou via Maven
