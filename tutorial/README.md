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
création. Et là où les Fragments présentent un intérêt, c’est qu'ils constituent
de véritables composants réutilisables à travers l’application vu qu’ils peuvent
être intégrés comme on le souhaite dans une Activity. C’est cette fonctionnalité
qui fournit la flexibilité recherchée dans leur design.

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
* `onActivityCreated()`, etc.

### Layout
Représentant un élément d’interface utilisateur, on aimerait bien pouvoir lier
un layout à notre Fragment ! Pour cela, pas le choix, on va devoir le faire en
programmation, c’est-à-dire directement en Java depuis notre classe Fragment.
Rien de bien compliqué, il suffit de créer un fichier layout, par exemple
`exemple_de_fragment.xml`, et depuis la méthode `onCreateView()` de notre
Fragment, on inflate la vue et on la retourne :

```java
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.exemple_de_fragment, container, false);
}
```

### L’intégration d’un fragment au sein d’une Activity
Il est possible d’intégrer un Fragment dans une Activity de deux manières différentes,
soit en l’intégrant directement dans le layout de l’Activity, soit à l’ajoutant
de
#### En configuration


[Retour à l'accueil](https://github.com/Tydax/m2_android_fragment)
