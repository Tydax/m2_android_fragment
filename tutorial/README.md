# Introduction aux Fragments sous Android
## Origine et définition des Fragments
Pour mieux comprendre l’intérêt des Fragments, étudions leur origine. Les
Fragments ont été introduits avec la version *Honeycomb 3.0* d’Android (API 11),
version introduisant le système Android aux tablettes. Et c’est exactement pour
ces dernières que les Fragments ont été créés : afin de donner plus de
flexibilité lors de la création d’interfaces utilisateur Android.

Concrètement, les Fragments donnent la possibilité d’être séparés en plusieurs
écrans sur mobile et d’être combinés sur un seul écran sur tablette, comme
illustré ci-dessous :

![Figure illustrant l’utilisation de Fragments dans une UI "Les Fragments dans
une interface mobile et tablette"](img/01_uifrag.png)

Un **Fragment** représente une partie comportementale et/ou d’interface
utilisateur dans un **Activity**. On pourrait les définir comme une portion
d’**Activity**, vu qu’ils sont obligatoirement liés à une Activity à leur
création.

## Détails techniques
### Classe
Étant des portions d’Activity, les Fragments possèdent un cycle de vie similaire
. Pour créer un Fragment, il suffit de créer une classe héritant de la classe
`Fragment`. Il existe également des classes filles de `Fragment` utilisables
comme classe mère :
* `DialogFragment` pour afficher une fenêtre de dialogue ;
* `ListFragment` pour afficher une liste gérée par un adapter, similaire à
`ListActivity` ;
* `PreferenceFragment` pour afficher une liste d’objets `Preference`, similaire
à `PreferenceActivity`.

Pour associer un comportement à des moment-clefs du cycle de vie du Fragment, on
retrouve des méthodes à surcharger similaires celles présentes dans la classe
`Activity`, telles que :
* `onCreate()`, à la création du Fragment ;
* `onCreateView()`, lorsqu’Android dessine l’interface du Fragment ;
* `onPause()` ;
* `onStop()` ;
* `onActivityCreated()` ;
* etc.

###

[Retour à l'accueil](https://github.com/Tydax/m2_android_fragment)
