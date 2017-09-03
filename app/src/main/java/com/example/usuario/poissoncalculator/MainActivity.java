package com.example.usuario.poissoncalculator;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String team1, team2;
    private EditText []etVector;
    private EditText etTeam1, etTeam2;
    private String []vectorResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vectorResults = new String[40];
        etVector = new EditText[40];

        //Get instances of all the elements
        TextView title = (TextView)findViewById(R.id.title);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        etTeam1 = (EditText) findViewById(R.id.etTeam1);
        etTeam2 = (EditText) findViewById(R.id.etTeam2);
        etVector[0] = (EditText) findViewById(R.id.et1_1);
        etVector[1] = (EditText) findViewById(R.id.et1_2);
        etVector[2] = (EditText) findViewById(R.id.et1_3);
        etVector[3] = (EditText) findViewById(R.id.et1_4);
        etVector[4] = (EditText) findViewById(R.id.et2_1);
        etVector[5] = (EditText) findViewById(R.id.et2_2);
        etVector[6] = (EditText) findViewById(R.id.et2_3);
        etVector[7] = (EditText) findViewById(R.id.et2_4);
        etVector[8] = (EditText) findViewById(R.id.et3_1);
        etVector[9] = (EditText) findViewById(R.id.et3_2);
        etVector[10] = (EditText) findViewById(R.id.et3_3);
        etVector[11] = (EditText) findViewById(R.id.et3_4);
        etVector[12] = (EditText) findViewById(R.id.et4_1);
        etVector[13] = (EditText) findViewById(R.id.et4_2);
        etVector[14] = (EditText) findViewById(R.id.et4_3);
        etVector[15] = (EditText) findViewById(R.id.et4_4);
        etVector[16] = (EditText) findViewById(R.id.et5_1);
        etVector[17] = (EditText) findViewById(R.id.et5_2);
        etVector[18] = (EditText) findViewById(R.id.et5_3);
        etVector[19] = (EditText) findViewById(R.id.et5_4);
        etVector[20] = (EditText) findViewById(R.id.et6_1);
        etVector[21] = (EditText) findViewById(R.id.et6_2);
        etVector[22] = (EditText) findViewById(R.id.et6_3);
        etVector[23] = (EditText) findViewById(R.id.et6_4);
        etVector[24] = (EditText) findViewById(R.id.et7_1);
        etVector[25] = (EditText) findViewById(R.id.et7_2);
        etVector[26] = (EditText) findViewById(R.id.et7_3);
        etVector[27] = (EditText) findViewById(R.id.et7_4);
        etVector[28] = (EditText) findViewById(R.id.et8_1);
        etVector[29] = (EditText) findViewById(R.id.et8_2);
        etVector[30] = (EditText) findViewById(R.id.et8_3);
        etVector[31] = (EditText) findViewById(R.id.et8_4);
        etVector[32] = (EditText) findViewById(R.id.et9_1);
        etVector[33] = (EditText) findViewById(R.id.et9_2);
        etVector[34] = (EditText) findViewById(R.id.et9_3);
        etVector[35] = (EditText) findViewById(R.id.et9_4);
        etVector[36] = (EditText) findViewById(R.id.et10_1);
        etVector[37] = (EditText) findViewById(R.id.et10_2);
        etVector[38] = (EditText) findViewById(R.id.et10_3);
        etVector[39] = (EditText) findViewById(R.id.et10_4);

        setSupportActionBar(toolbar);//Set toolbar on the screen
        //Set personalized font
        Typeface face=Typeface.createFromAsset(getAssets(),"fonts/Lemonada-Bold.ttf");
        title.setTypeface(face);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressButton();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void backScreen(){
        finish();
    }

    public void onBackPressed(){
        backScreen();
    }

    public void pressButton(){
        team1 = etTeam1.getText().toString();
        team2 = etTeam2.getText().toString();
        for (int i=0; i<40; i++){
            if ((etVector[i].getText().toString()).isEmpty()){
                vectorResults[i] = "0";
            }
            else{
                vectorResults[i] = etVector[i].getText().toString();
            }
        }
        Intent intent = new Intent(this, Results.class);
        intent.putExtra("team1", team1);
        intent.putExtra("team2", team2);
        intent.putExtra("vectorResults", vectorResults);
        startActivity(intent);
    }
}
