# Making-crew
Exercise proposé lors de la phase de recrutement.
La version déployée est visibible ici: (https://the-argo.herokuapp.com/#)

## La quête

### Objectifs
à partir de la maquette disponible sur [codepen](https://codepen.io/wildcodeschool/pen/LYpoBBN)

1.Créer une application web simple dans votre langage de prédilection.
2.Stocker les données de cette application dans une base de donnée.

L'application ne comportera qu'une seule page.
Implémenter les fonctionnalités "Create" et "Read" 
Mettre du style

### Contraintes techniques
 -utiliser n'importe quel système de base de données : SQL (MySQL, PostgreSQL, etc.), NoSQL (MongoDB, etc.), voire Firebase (ou toute autre base de données "serverless")
  -utiliser n'importe quel langage, bibliothèque, framework, voire combinaison de plusieurs technologies 
 - Idéalement, publier votre travail sur un dépôt GitHub, voire déployer votre application (sur Heroku, Netlify, votre propre serveur, etc.).

 ## Proposition de stack

 * Heroku comme plate-forme de dév et de production
 * Jakarta EE
 * JSP ou JSF ? : l'emploi JSF semble ici superflu.
 * Java 11 (le support de Java 8 étant expiré)
 * Maven : voir comment configuer pom.xml pour fonctionner avec Heroku
 * PosgreSQL: requis par Heroku pour un usage avec Java
 * JUNIT 5 : pour faire des tests simples sur les requêtes CRUD
 * JBDC: pour l'accès à la BDD, l'emploi d'un ORM semble également superflu
 * pur CSS? ou un framework minimaliste tel que:
    1. [Knaccss](https://www.knacss.com)
    2. [KickStart](http://www.99lime.com/elements/)
    3. [Skeleton](https://github.com/dhg/Skeleton)
 * NPM ?: si on revient sur la proposition précédente.
 * JavaScript ?: au besoin, si on ajouter un peu de fonctionnalités

## Heroku: Set-up for JEE

* Dévelopement local: [Procfile](https://devcenter.heroku.com/articles/procfile)
* [Connection avec la base de donnée](https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java#using-the-jdbc_database_url)
Heroku privilégie l'emploi des fonctions de la classe java.sql.DriverManager avec JBDC, plutôt que l'interface DataSource (Spring/Hibernate)
* [Déploiement](https://devcenter.heroku.com/articles/war-deployment)
utilisation du plugin heroku pour maven

    
