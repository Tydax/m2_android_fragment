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
Il est possible d’intégrer un Fragment dans une Activity de deux manières
différentes, soit en le déclarant directement dans le layout de l’Activity, soit
à l’ajoutant de manière programmatique.

#### En configuration
L'avantage principal de déclarer le Fragment dans le fichier .xml est qu'on a
un meilleur aperçu de où il sera placé dans le layout. C'est surtout
intéressant si on a plusieurs Fragments dans un même layout.

Voici par exemple comment insérer une instance de la classe `ExempleFragment`
dont le nom de classe complet est `fr.lille1.univ.ExempleFragment` :

```xml
<fragment
  android:name="fr.lille1.univ.ExempleFragment"
  android:id="@+id/fragex1"
  android:layout_width="0dp"
  android:layout_height="match_parent" />
```

Plutôt clair, non ?

#### De manière programmatique
Ajouter un Fragment de manière programmatique présente l'énorme avantage de
pouvoir modifier l'interface durant l'exécution. Il est cependant nécessaire
d'avoir un **ViewGroup** déclaré dans le layout où l'on souhaite ajouter le
Fragment.

L'ajout de Fragment requiert l'utilisation de **FragmentTransaction**, qui
représente une action de manipulation de Fragment (ajout, suppression,
remplacement). Voici un exemple où on ajoute notre `ExempleFragment` précédent
à une `ViewGroup` dont l'id est `exemple_container` :

```java
final FragmentManager fragMgr = getFragmentManager();
final FragmentTransaction fragTrans = fragMgr.beginTransaction();
final ExempleFragment exFrag = new ExempleFragment();
fragTrans.add(R.id.exemple_container, exFrag); // Ajout du Fragment
// On peut faire autant d'opérations sur les Fragments que souhaitées avant de commit
fragTrans.commit(); // On valide les modifications
```

## Pour aller plus loin
Voici quelques liens, notament vers la documentation d'Android, afin d'avoir des
informations plus complètes sur les Fragments.
* [EN] [Présentation des Fragments](https://developer.android.com/guide/components/fragments.html)
* [EN] [Building a Dynamic UI with Fragments](https://developer.android.com/training/basics/fragments/index.html)
* [EN] [Communicating with Other Fragments](https://developer.android.com/training/basics/fragments/communicating.html)
[Retour à l'accueil](https://github.com/Tydax/m2_android_fragment)
