package de.baving.rene.vokabeltraineer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewVocableActivity extends AppCompatActivity {
    EditText vocableInput;
    EditText translationInput;
    MainActivity mainActivity;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mainActivity = new MainActivity();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neue_vokabel);
        dbHelper = new DatabaseHelper(this);

        //Prepare all Inputs on the activity.
        vocableInput = findViewById(R.id.vocableInput);
        translationInput = findViewById(R.id.translationInput);

        Button save = findViewById(R.id.btnVokabelSpeichern);
    }

    public void saveNewVocabulary(View view) {
        String vocable = vocableInput.getText().toString();
        String translation = translationInput.getText().toString();

        dbHelper.addData(vocable, translation);

    }
}
