package com.example.bobo.xamxam;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import com.example.bobo.xamxam.adapters.ModuleAdapter;
import com.example.bobo.xamxam.beans.Chapitre;
import com.example.bobo.xamxam.beans.Module;
import com.example.bobo.xamxam.beans.Question;
import com.example.bobo.xamxam.database.AppDatabase;
import com.example.bobo.xamxam.events.ModulesEvent;
import com.squareup.picasso.Picasso;


import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "Main";


    private RecyclerView recyclerView;

    private List<Module> modules;

    private AppDatabase db;


    private ImageView imageView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //-----------------picasso------------------------------



        //------------beggining of custom code happy codin-------------------------------

        db = AppDatabase.getInstance(this);
        int nb = db.moduleDao().totalModule();



        if (nb == 0) {


            //--------------------insertion des modules---------------------------------------


            db.moduleDao().insert(new Module(1, "Anglais","file:///android_asset/english.png" ));
            db.moduleDao().insert(new Module(2, "Economie","file:///android_asset/economie.png" ));
            db.moduleDao().insert(new Module(3, "Géographie","file:///android_asset/geo.png" ));
            db.moduleDao().insert(new Module(4, "Mathématiques","file:///android_asset/maths.jpg" ));
            db.moduleDao().insert(new Module(5, "Musique","file:///android_asset/musique.jpg" ));
            db.moduleDao().insert(new Module(6, "Français","file:///android_asset/francais.jpg" ));
            db.moduleDao().insert(new Module(7, "Informatiques","file:///android_asset/inf.gif" ));
            db.moduleDao().insert(new Module(8, "Sciences","file:///android_asset/sciences.jpg" ));
            db.moduleDao().insert(new Module(9, "Espagnol","file:///android_asset/espagnol.png" ));
            db.moduleDao().insert(new Module(10, "Histoire","file:///android_asset/histoire.jpg" ));



            //-----------------------------insertion des chapitres-------------------------------------

           db.chapitreDao().insert(new Chapitre(1, "lesson 1", "phrasals", "tacoma_narrows", 1));
            db.chapitreDao().insert(new Chapitre(2, "lesson 2", "modals", "tacoma_narrows", 1));
            db.chapitreDao().insert(new Chapitre(3, "lesson 3", "verbs", "tacoma_narrows", 1));
            db.chapitreDao().insert(new Chapitre(4, "lesson 4", "grammar", "tacoma_narrows", 1));


            db.chapitreDao().insert(new Chapitre(5, "lesson 1", "addition", "tacoma_narrows", 4));
            db.chapitreDao().insert(new Chapitre(6, "lesson 2", "soustraction", "tacoma_narrows", 4));
            db.chapitreDao().insert(new Chapitre(7, "lesson 3", "multiplication", "tacoma_narrows", 4));
            db.chapitreDao().insert(new Chapitre(8, "lesson 4", "division", "tacoma_narrows", 4));


            db.chapitreDao().insert(new Chapitre(9, "lesson 1", "La terre", "tacoma_narrows", 3));
            db.chapitreDao().insert(new Chapitre(10, "lesson 2", "Le soleil", "tacoma_narrows", 3));
            db.chapitreDao().insert(new Chapitre(11, "lesson 3", "les océans", "tacoma_narrows", 3));
            db.chapitreDao().insert(new Chapitre(12, "lesson 4", "les continents", "tacoma_narrows", 3));


            db.chapitreDao().insert(new Chapitre(13, "lesson 1", "les atomes", "tacoma_narrows", 8));
            db.chapitreDao().insert(new Chapitre(14, "lesson 2", "les alcanes", "tacoma_narrows", 8));
            db.chapitreDao().insert(new Chapitre(15, "lesson 3", "les hydrocarbures", "tacoma_narrows", 8));
            db.chapitreDao().insert(new Chapitre(16, "lesson 4", "les alcynes", "tacoma_narrows", 8));

            db.chapitreDao().insert(new Chapitre(17, "lesson 1", "la finance", "tacoma_narrows", 2));
            db.chapitreDao().insert(new Chapitre(18, "lesson 2", "la monnaie", "tacoma_narrows", 2));
            db.chapitreDao().insert(new Chapitre(19, "lesson 3", "les entreprises", "tacoma_narrows", 2));
            db.chapitreDao().insert(new Chapitre(20, "lesson 4", "les instutions", "tacoma_narrows", 2));




            //-----------------------------insertion des question-----------------------------------



db.questionDao().insert(new Question("What is Diane's address ?",

        "His address is 45 King Street",
        "Its address is 45 King Street",
        "She is 45 King Street",
        1,
        1
        ));
db.questionDao().insert(new Question("Quelle question poseriez-vous à votre nouveau collègue ?",

                    "Where you are from ?",
                    "Where from you are ?",
                    "Where are you from ?",
                    3,
                    1
            ));
db.questionDao().insert(new Question("Quel mot n'a pas de lien avec : TRAVEL AGENCY ?",

                    "Plane",
                    "Singer",
                    "hotel",
                    2,
                    1
            ));
db.questionDao().insert(new Question("Would you like anything to drink ?",

                    "Just water please.",
                    "Don't worry",
                    "No thanks, I'm thirsty",
                    1,
                    1
            ));
db.questionDao().insert(new Question("Comment demandez-vous à votre homologue américain, si une personne que vous n'avez jamais vue auparavant, travaille dans leur entreprise ?",

                    "Is she working here ?",
                    "Does she work here ?",
                    "Works she here ?",
                    1,
                    1
            ));



            db.questionDao().insert(new Question("Quelle est la capitale du senegal", "dakar", "abidjan", "abuja", 1, 3));
            db.questionDao().insert(new Question("Quelle est la capitale de la France", "paris", "abidjan", "abuja", 1, 3));
            db.questionDao().insert(new Question("Quelle est la capitale du Maroc", "casablanca", "abidjan", "abuja", 1, 3));
            db.questionDao().insert(new Question("Quelle est la capitale du Mali", "bamako", "abidjan", "abuja", 1, 3));
            db.questionDao().insert(new Question("Quelle est la capitale du Niger", "niamey", "abidjan", "abuja", 1, 3));


            db.questionDao().insert(new Question("2 + 2 = ?", "1", "2", "4", 3, 4));
            db.questionDao().insert(new Question("3 * 3 = ?", "9", "5", "3", 1, 4));
            db.questionDao().insert(new Question("5 - 2 = ?", "3", "7", "9", 1, 4));
            db.questionDao().insert(new Question("4 % 2 = ?", "2", "5", "3", 1, 4));
            db.questionDao().insert(new Question("3 / 3 = ?", "1", "5", "3", 1, 4));


            db.questionDao().insert(new Question("Qui a inventé le stéthoscope ?", "Claude Bernard", "Alexander Flemming", "Rene Laenec", 1, 8));
            db.questionDao().insert(new Question("Quel est le trajet effectué par le premier à vapeur ?", "Lyon-Saint etienne", "Metz-Nancy", "Paris-Lille", 1, 8));
            db.questionDao().insert(new Question("Qui a inventé la pile électrique ?", "Becquerel", "Edison", "Volta", 1, 8));
            db.questionDao().insert(new Question("Quelle est la plus vieille centrale nucléaire de France ?", "Cattenon", "Fessenheim", "Tricastin", 1, 8));
            db.questionDao().insert(new Question("Qu'est-ce qui est concerné par le théorème de Pythagore ?", "carre", "cercle", "Triangle", 1, 8));


            db.questionDao().insert(new Question("Comment appelle-t-on les personnes qui n'ont pas d'emploi mais en recherchent un ?", "les sans-emploi", "les employes", "les exclus", 2, 2));
            db.questionDao().insert(new Question("Qui a écrit La richesse des nations en 1776 ?", "adam smith", "auguste compte", "thomas malthus", 1, 2));
            db.questionDao().insert(new Question("Quand les prix chutent, l'augmentation de la valeur réelle de l'épargne fait dépenser plus, augmentant ainsi le PIB. C'est...", "la courbe de philip", "le laisse-faire", "la volatilite", 1, 2));
            db.questionDao().insert(new Question("Comment appelle-t-on les biens et services produits dans un pays, mais vendus dans un autre pays ?", "les exportations", "les déportations", "les coloportations", 1, 2));
            db.questionDao().insert(new Question("Quelle étude porte sur les ressources d'une société, sa production, sa consommation et son transfert de richesse ?", "economie", "statistiques", "la sociologie", 1, 2));


            db.questionDao().insert(new Question("Quel est le nom du système d'exploitation mis au point par Google ?", "chrome os", "ubuntu", "chrome", 1, 7));
            db.questionDao().insert(new Question("Pour dessiner, les pros préfèrent utiliser, à la place d'une souris...", "tablette", "palette", "tabulette", 1, 7));
            db.questionDao().insert(new Question("Mon écran affiche 1280 pixels en largeur et 1024 pixels en hauteur, ça s'appelle", "sa resolution", "definition", "revolution", 1, 7));
            db.questionDao().insert(new Question("Un domaine c'est :", "Une propriété sur un disque dur.", "Un ensemble d'adresses faisant l'objet d'une gestion commune.", "Un réseau informatique privé.", 2, 7));
            db.questionDao().insert(new Question("Une adresse IP est le numéro qui identifie chaque ordinateur connecté à Internet mais ça signifie :", "Internet Postal", "Internet Pratique", "Internet Protocol", 3, 7));














            Log.i(TAG, "data inserted");
        }

        else {















            Log.i(TAG, "data already existed");

        }


        modules = db.moduleDao().getAllModules();



        recyclerView = findViewById(R.id.recyclerView);
        ModuleAdapter adapter = new ModuleAdapter(this, modules);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);












    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //return true;

            Intent intent = new Intent(this, MainQuizz.class);

            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {

        super.onStop();
    }


    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();

        super.onDestroy();
    }


}
