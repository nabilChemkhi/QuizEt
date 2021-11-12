package com.example.quizet;

import static android.os.SystemClock.sleep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    private TextView appName;


    private  AppDatabase appDatabase;
    private List<Category> catList = new ArrayList<Category>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        appName = findViewById(R.id.appNameId);
        appDatabase = AppDatabase.getAppDatabase(this);

        //if base empty then charge base
        if(appDatabase.categoryDAO().getCategories() == null) {


         //delete existent base
      /* appDatabase.categoryDAO().deleteCategTable();
        appDatabase.setDAO().deletesetTable();
        appDatabase.questionDAO().deleteQuestionTable();*/
//chargement de base
         Category c1 = new Category(1, "Football", (int) R.drawable.ball);
         Category c2 = new Category(2, "Golf", (int) R.drawable.golf);
         Category c3 = new Category(3, "Geography", (int) R.drawable.g);
         Category c4 = new Category(4, "Cinema", (int) R.drawable.cine);
         Category c5 = new Category(5, "Natation", (int) R.drawable.swimmer17_41361);

         appDatabase.categoryDAO().insertCategory(c1);
         appDatabase.categoryDAO().insertCategory(c2);
         appDatabase.categoryDAO().insertCategory(c3);
         appDatabase.categoryDAO().insertCategory(c4);
         appDatabase.categoryDAO().insertCategory(c5);
         /*******************/


         //sets creation
         //catg1 foot sets
         Set s11 = new Set(1, 1, 0);
         appDatabase.setDAO().insertSet(s11);
         Set s12 = new Set(2, 1, 0);
         appDatabase.setDAO().insertSet(s12);
         Set s13 = new Set(3, 1, 0);
         appDatabase.setDAO().insertSet(s13);
         //appDatabase.setDAO().insertSet(new Set(6,1,0);
         //gateg 2 golf sets
         Set s21 = new Set(4, 2, 0);
         appDatabase.setDAO().insertSet(s21);
         Set s22 = new Set(5, 2, 0);
         appDatabase.setDAO().insertSet(s22);
         appDatabase.setDAO().insertSet(new Set(6, 2, 0));


         //creat quest set1 categ1 foot
         Question Q111 = new Question(1,
                 "Combien d’équipes seront présentes lors de l’Euro 2016 de foot ?",
                 "12", "16", "20", "24",
                 4, 1);
         appDatabase.questionDAO().insertQuestion(Q111);
         Question Q112 = new Question(2, "Quel club de foot anglais joue dans l’enceinte de l’Emirates Stadium ?",
                 "Le FC Porto", "Le Málaga CF", "Le Real Madrid", "Le FC Barcelone",
                 3, 1);
         appDatabase.questionDAO().insertQuestion(Q112);
         Question Q113 = new Question(3, "Quel est le nom du sélectionneur des Bleus en 2016 ?", "Michel Platini", "Didier Deschamps", "Laurent Blanc", "Claude Puel",
                 2, 1);
         appDatabase.questionDAO().insertQuestion(Q113);
         Question Q114 = new Question(4, "De quel pays africain, les Éléphants constituent-ils le nom de l’équipe de foot ?", "ghana", "Tunisie", "Cameroun", "Côte d’Ivoire", 4, 1);
         appDatabase.questionDAO().insertQuestion(Q114);
         Question Q115 = new Question(5, "Quel est le nom du stade de la ville de Bordeaux qui accueillera des matchs de l’Euro 2016 ?", "Allianz Riviera", "Stade Geoffroy-Guichard", "Stade Chaban-Delmas", "Matmut Atlantique", 4, 1);
         appDatabase.questionDAO().insertQuestion(Q115);
         //quest set2 categ1 foot
         Question Q121 = new Question(6, "Quelle équipe a éliminé le PSG en quarts de finale de la Ligue des Champions 2016 ?", "Manchester City", "Chelsea", "Athletico Madrid", "Borussia Dortmund", 1, 2);
         appDatabase.questionDAO().insertQuestion(Q121);
         Question Q122 = new Question(7, "Quel est le nom de la mascotte de l’Euro 2016 ?", "Péno", "Super Victor", "Goalix", "Footix", 2, 2);
         appDatabase.questionDAO().insertQuestion(Q122);
         Question Q123 = new Question(8, "Quel footballeur a été élu Ballon d’or 2015 ?", "Cristiano Ronaldo", "Neymar", "Lionel Messi", "Thomas Müller", 3, 2);
         appDatabase.questionDAO().insertQuestion(Q123);
         //set3
         appDatabase.questionDAO().insertQuestion(new Question(14, "quest1", "A", "B", "C", "O", 2, 3));
         appDatabase.questionDAO().insertQuestion(new Question(15, "quest1", "A", "B", "C", "O", 2, 3));
         appDatabase.questionDAO().insertQuestion(new Question(16, "quest1", "A", "B", "C", "O", 2, 3));
         appDatabase.questionDAO().insertQuestion(new Question(17, "quest1", "A", "B", "C", "O", 2, 3));
         appDatabase.questionDAO().insertQuestion(new Question(18, "quest1", "A", "B", "C", "O", 2, 3));


         Question Q131 = new Question(19, "quest1", "A", "B", "C", "O", 2, 3);
         appDatabase.questionDAO().insertQuestion(Q131);
         Question Q132 = new Question(20, "quest1", "A", "B", "C", "O", 2, 3);
         appDatabase.questionDAO().insertQuestion(Q132);
         Question Q133 = new Question(9, "quest1", "A", "B", "C", "O", 2, 3);
         appDatabase.questionDAO().insertQuestion(Q133);
/***************/
//categ2
         //set1 id-4
         Question Q241 = new Question(10, "Quand se déroule l'Open britannique de golf au Royal and Ancient St Andrews ?", "Tous les ans", "Tous les 2 ans", "Tous les 4 ans", "Tous les 5 ans", 4, 4);
         appDatabase.questionDAO().insertQuestion(Q241);
         Question Q242 = new Question(11, "Quel trophée remporte le vainqueur du Master de Golf ?", "Un club en or", "Une coupe en argent", "Une veste verte", "Un plateau en argent", 3, 4);
         appDatabase.questionDAO().insertQuestion(Q242);
         Question Q243 = new Question(12, "Qu'est-ce qu'un « caddie » ?", "Un assistant du golfeur", "Une cheville de bois sur laquelle repose la balle", "Une voiturette", "Les chaussures de golf", 1, 4);
         appDatabase.questionDAO().insertQuestion(Q243);
         Question Q244 = new Question(13, "Quel président américain aimait jouait au National Golf club d'Augusta ?", "Roosevelt", "Nixon", "Kennedy", "Eisenhower", 1, 4);
         appDatabase.questionDAO().insertQuestion(Q244);

         appDatabase.questionDAO().insertQuestion(new Question(21, "Sur un parcours de golf, de quelle couleur sont les piquets délimitant un obstacle d'eau ?", "vert", "Noir", "Bleu", "jaune", 4, 4));
         //set 5
         appDatabase.questionDAO().insertQuestion(new Question(22, "quest1", "A", "B", "C", "O", 2, 5));
         appDatabase.questionDAO().insertQuestion(new Question(23, "quest1", "A", "B", "C", "O", 4, 5));
         appDatabase.questionDAO().insertQuestion(new Question(24, "quest1", "A", "B", "C", "O", 4, 5));
         appDatabase.questionDAO().insertQuestion(new Question(25, "quest1", "A", "B", "C", "O", 2, 5));
         appDatabase.questionDAO().insertQuestion(new Question(26, "quest1", "A", "B", "C", "O", 3, 5));
         //set 6
         appDatabase.questionDAO().insertQuestion(new Question(27, "Quel golfeur a été classé N° 1 le plus longtemps ?", "Greg Norman", "Tiger Woods", "Nick Faldo", "Severiano Ballesteros", 1, 6));
         appDatabase.questionDAO().insertQuestion(new Question(28, "Quel nom a-t-on donné à l'enchaînement le plus difficile de 3 trous du parcours du Master ?", "Le Prayer", "L'Amen Corner", "Le Jesus Pray", "Hot Corner", 2, 6));
         appDatabase.questionDAO().insertQuestion(new Question(29, "Combien de fois, Tiger Woods a-t-il remporté le Masters ?", "4 fois", "6 fois", "8 fois", "12 fois", 1, 6));
         appDatabase.questionDAO().insertQuestion(new Question(30, "Quand a eu lieu le premier US Open de Golf ?", "1850", "1895", "1912", "1948", 2, 6));
         appDatabase.questionDAO().insertQuestion(new Question(31, "Comment nomme-t-on un bois 3 ?", "Un driver", "Un brassie", "Un spoon", "Un mashie", 3, 6));
//categ3
         appDatabase.setDAO().insertSet(new Set(7, 3, 0));
         appDatabase.setDAO().insertSet(new Set(8, 3, 0));
         appDatabase.setDAO().insertSet(new Set(9, 3, 0));
         appDatabase.setDAO().insertSet(new Set(10, 3, 0));
         appDatabase.setDAO().insertSet(new Set(11, 3, 0));
         //set7
         appDatabase.questionDAO().insertQuestion(new Question(32, "Dans quelle ville italienne se trouve la tour Pirelli?", "Milan", "Florence", "Turin", "Rome", 1, 7));
         appDatabase.questionDAO().insertQuestion(new Question(33, "Quel fleuve franchit le pont Vasco de Gama?", "L’Ebre", "le Douro", "Le Tage", "Le Guadalquivir", 3, 7));
         appDatabase.questionDAO().insertQuestion(new Question(34, "Dans quel arrondissement parisien se trouve l’Opéra Garnier, du nom de son constructeur, le fameux Charles Garnier?", "1er arrondissement", "Le Marais", "9e arrondissement", "11e arrondissement", 3, 7));
         appDatabase.questionDAO().insertQuestion(new Question(35, "Dans quelle ville européenne se trouve le pont Felipe II?", "Barcelone", "Rome", "Madrid", "Lisbonne", 1, 7));
         appDatabase.questionDAO().insertQuestion(new Question(36, "Quelle ville est surnommée la Fiancée de la Méditerranée?", "Alexandrie", "Tel-Aviv", "Tunis", "Marrakech", 2, 7));
         //set7
         appDatabase.questionDAO().insertQuestion(new Question(37, "Dans quelle ville se trouve la Statue de la Liberté?", "Washington", "Chicago", "New York", "Los Angeles", 3, 8));
         appDatabase.questionDAO().insertQuestion(new Question(40, "Quel est le chef-lieu du département de l’Allier?", "Vichy", "Montluçon", "Moulins", "Clermont-Ferrand", 3, 8));
         appDatabase.questionDAO().insertQuestion(new Question(41, "Quelle ville est surnommée la Florence sur l’Elbe?", "Dresde", "Munich", "Stuttgart", "Berne", 1, 8));
         appDatabase.questionDAO().insertQuestion(new Question(42, "Sur quel continent le Nil coule-t-il?", "L’Océanie", "L’Afrique", "L’Europe", "L’Amérique", 2, 8));
         appDatabase.questionDAO().insertQuestion(new Question(43, "Face à quelle grande ville le château d’If se trouve-t-il?", "Perpignan", "Nantes", "Rennes", "Marseille", 4, 8));
         //set7
         appDatabase.questionDAO().insertQuestion(new Question(44, "quest1", "A", "B", "C", "O", 4, 9));
         appDatabase.questionDAO().insertQuestion(new Question(45, "quest1", "A", "B", "C", "O", 1, 9));
         appDatabase.questionDAO().insertQuestion(new Question(46, "quest1", "A", "B", "C", "O", 1, 9));
         appDatabase.questionDAO().insertQuestion(new Question(47, "quest1", "A", "B", "C", "O", 2, 9));
         appDatabase.questionDAO().insertQuestion(new Question(48, "quest1", "A", "B", "C", "O", 3, 9));
         //set7
         appDatabase.questionDAO().insertQuestion(new Question(49, "quest1", "A", "B", "C", "O", 4, 10));
         appDatabase.questionDAO().insertQuestion(new Question(50, "quest1", "A", "B", "C", "O", 1, 10));
         appDatabase.questionDAO().insertQuestion(new Question(51, "quest1", "A", "B", "C", "O", 1, 10));
         appDatabase.questionDAO().insertQuestion(new Question(52, "quest1", "A", "B", "C", "O", 2, 10));
         appDatabase.questionDAO().insertQuestion(new Question(53, "quest1", "A", "B", "C", "O", 3, 10));
         //set7
         appDatabase.questionDAO().insertQuestion(new Question(54, "quest1", "A", "B", "C", "O", 4, 7));
         appDatabase.questionDAO().insertQuestion(new Question(55, "quest1", "A", "B", "C", "O", 1, 7));
         appDatabase.questionDAO().insertQuestion(new Question(56, "quest1", "A", "B", "C", "O", 1, 7));
         appDatabase.questionDAO().insertQuestion(new Question(57, "quest1", "A", "B", "C", "O", 2, 7));
         appDatabase.questionDAO().insertQuestion(new Question(58, "quest1", "A", "B", "C", "O", 3, 7));


        }//












        Typeface typeface= ResourcesCompat.getFont(this, R.font.blacklist);
        appName.setTypeface(typeface);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.myanim);
        appName.setAnimation(anim);

        new Thread(new Runnable() {
            @Override
            public void run() {
        try {
            sleep(3000);
            } catch (Exception e) {
            e.printStackTrace();
        }
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
                finish();

            }
        }).start();
    }
}