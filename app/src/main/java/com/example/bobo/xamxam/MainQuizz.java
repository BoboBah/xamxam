package com.example.bobo.xamxam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bobo.xamxam.beans.Module;
import com.example.bobo.xamxam.database.AppDatabase;

import java.util.List;

public class MainQuizz extends AppCompatActivity {

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String MODULE_ID = "ModuleID";
    public static final String MODULE_NOM = "ModuleNom";

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView textViewHighscore;

    private int highscore;


    private Spinner spinnerCategory;

    private AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quizz);

        spinnerCategory = findViewById(R.id.spinner_category);

        Button buttonStartQuiz = findViewById(R.id.button_start_quiz);

        textViewHighscore = findViewById(R.id.text_view_highscore);

        db = AppDatabase.getInstance(this);

        loadCategories();
        loadHighscore();

    }

    private void loadCategories() {

        List<Module> modules = db.moduleDao().getAllModules();

        ArrayAdapter<Module> moduleArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, modules);

        moduleArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCategory.setAdapter(moduleArrayAdapter);


    }

    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("Score Max: " + highscore);
    }

    public void startQuizz(View view) {


        Module moduleSelected = (Module) spinnerCategory.getSelectedItem();

        int idModule = moduleSelected.getIdModule();

        String moduleNom = moduleSelected.getNomModule();



        Intent intent = new Intent(this, QuizActivity.class);


        intent.putExtra(MODULE_ID, idModule);

        intent.putExtra(MODULE_NOM, moduleNom);

        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizActivity.EXTRA_SCORE, 0);
                if (score > highscore) {
                    updateHighscore(score);
                }
            }
        }
    }

    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        textViewHighscore.setText("Highscore: " + highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }
}
