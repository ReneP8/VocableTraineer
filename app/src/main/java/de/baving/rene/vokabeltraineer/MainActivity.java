package de.baving.rene.vokabeltraineer;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    private boolean firstAppStart;
    DatabaseHelper dbHelper;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.textView);

        dbHelper = new DatabaseHelper(this);

    }

    public void showNewVocAct(View view) {
        Intent newVocable = new Intent(this, NewVocableActivity.class);
        startActivity(newVocable);
    }

    public void showVocables(View view) {


        Cursor cursor = dbHelper.getData();
        cursor.moveToFirst();

//        while (cursor.moveToNext()) {
////            listView.add
//        }

        while (cursor.moveToNext()){
            textView.append(cursor.getString(0) + " --- " + cursor.getString(1) + "\n");
        }

        cursor.close();
    }
}
