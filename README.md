# Site Web pour les JNMs 2018


### Membres du groupe : Perle Oualid et Christian Pagh-Birk 


### Les fonctionnalités qui ont été implémentées :
- Le formulaire de participation d'un étudiant ou d'une entreprise (si le mail est déjà enregistré alors le formulaire n'est pas validé)
- L'enseignant est enregistré par un administrateur
- L'enseignant peut valider les étudiants inscrits dans sa miage
- L'enseignant peut ajouter une miage à la liste déjà existante
- Les étudiants peuvent voter pour le concours de tee shirt et de vidéo (maximum 3 votes)
- Chaque participant peut voir le trombinoscope des étudiants par miage
- Un étudiant peut acheter un pack (simulation de l'achat grâce à PayPal)


### Le processus de déploiement : 
- La base de données à créer s'appelle "etudiants" avec comme nom d'administrateur et mot de passe root
- Exécuter le projet
- Exécuter le fichier InsertRecords, qui se trouve dans le package jdbc.records, afin de créer un administrateur et la liste des miages (à exécuter qu'une seule fois car le persistence.xml est en mode create)



### Le processus de test : 
1. Dans la page d'accueil, on peut soit se connecter soit participer à l'évènement. On a également accès au planning et aux informations pratiques.
2. Si on clique sur l'onglet "participer" on est redirigé vers une page avec un formulaire à remplir. Seul un étudiant ou une entreprise doit remplir ce formulaire.
3. On vérifie que l'adresse mail ne soit pas déjà utilisée avant de valider la participation et de le connecter automatiquement.
4. Une fois que l'on est connecté (en tant qu'étudiant) on n'a pas encore accès aux votes ou au trombinoscope tant que l'enseignant ne l'a pas validé.
5. S'il s'agit d'une entreprise partenaire qui est connectée, elle n'a accès qu'au trombinoscope.
6. L'administrateur par défaut, contenu dans le fichier InsertRecords, permet de se connecter et d'inscrire un enseignant à l'évènement.
7. Une fois l'enseignant inscrit par l'administrateur, il peut se connecter et confirmer la participation des étudiants inscrits dans sa miage. Il peut aussi ajouter une miage dans la liste.
8. Tous les étudiants validés ont alors accès à l'onglet de vote pour le concours de tee shirt et de vidéo. Ils peuvent voter pour trois miages maximum pour chaque concours. Une fois que le vote est pris en compte, il est automatiquement grisé afin qu'il ne puisse plus voter. 
9. Ils peuvent également acheter un pack, avec une simulation de paiement avec PayPal. 
10. Tous les participants à l'évènement ont accès au trombinoscope.

### git : https://github.com/christpb/projetWeb
