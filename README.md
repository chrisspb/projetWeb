# Site Web pour les JNMs 2018


### Membres du groupe : Perle Oualid et Christian Pagh-Birk


### Les fonctionnalités qui ont été implémentées :
- Le formulaire de participation d'un étudiant ou d'une entreprise (si le mail est déjà enregistré alors le formulaire n'est pas validé)
- L'enseignant est enregistré par un administrateur
- L'enseignant peut valider les étudiants inscrits dans sa miage
- Les étudiants peuvent voter pour le concours de tee shirt et de vidéo (maximum 3 votes)
- Chaque participant peut voir le trombinoscope des étudiants par miage
- Un étudiant peut acheter un pack (simulation de l'achat grâce à PayPal)


### Le processus de déploiement : 
- La base de données à créer s'appelle "etudiants" avec comme nom d'administrateur et mot de passe root
- Exécuter le fichier InsertRecords, qui se trouve dans le package jdbc.records, afin de créer un administrateur et la liste des miages (à exécuter qu'une seule fois car le persistence.xml est en mode create)
- Exécuter le projet



### Le processus de test : 
Dans la page d'accueil, on peut soit se connecter soit participer à l'évènement. On a également accès au planning et aux informations pratiques.
Si on clique sur l'onglet "participer" on est redirigé vers une page avec un formulaire à remplir. Seul un étudiant ou une entreprise doit remplir ce formulaire.
On vérifie que l'adresse mail ne soit pas déjà utilisée avant de valider la participation et de le connecter automatiquement.
Une fois que l'on est connecté (en tant qu'étudiant) on n'a pas encore accès aux votes ou au trombinoscope tant que l'enseignant ne l'a pas validé.
S'il s'agit d'une entreprise partenaire que est connectée, elle a accès au trombinoscope.
