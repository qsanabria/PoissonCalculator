package com.example.usuario.poissoncalculator;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.usuario.poissoncalculator.helpClass.PoissonCalculation;


public class Results extends AppCompatActivity implements View.OnClickListener{

    private String []vectorResults = new String[40];
    private int totalGoalsScored1 = 0, totalGoalsScored2 = 0, totalGoalsReceived1 = 0, totalGoalsReceived2 = 0;
    private double averageGoalsScored1, averageGoalsScored2, averageGoalsReceived1, averageGoalsReceived2, numberItems = 10;
    private double[] poissonAverageGoalsScored1, poissonAverageGoalsScored2, poissonAverageGoalsReceived1, poissonAverageGoalsReceived2, vectorTeam1, vectorDraw, vectorTeam2;
    private TableLayout tableTeam1, tableDraw, tableTeam2, table1x2, tableDouble, tableOver, tableUnder;
    private TextView tvProbability00, tvProbability11, tvProbability22, tvProbability33, tvProbability44, tvProbability55, tvProbability66, tvProbability77,
            tvProbability10, tvProbability20, tvProbability21, tvProbability30, tvProbability31, tvProbability32,
            tvProbability40, tvProbability41, tvProbability42, tvProbability43, tvProbability50, tvProbability51,
            tvProbability52, tvProbability53, tvProbability54, tvProbability60, tvProbability61, tvProbability62,
            tvProbability63, tvProbability64, tvProbability65, tvProbability70, tvProbability71, tvProbability72,
            tvProbability73, tvProbability74, tvProbability75, tvProbability76, tvProbability01, tvProbability02,
            tvProbability12, tvProbability03, tvProbability13, tvProbability23, tvProbability04, tvProbability14,
            tvProbability24, tvProbability34, tvProbability05, tvProbability15, tvProbability25, tvProbability35,
            tvProbability45, tvProbability06, tvProbability16, tvProbability26, tvProbability36, tvProbability46,
            tvProbability56, tvProbability07, tvProbability17, tvProbability27, tvProbability37, tvProbability47,
            tvProbability57, tvProbability67, tvProbability1, tvProbabilityX, tvProbability2, tvProbability1X, tvProbability1x2,
            tvProbabilityX2, tvProbabilityOver05, tvProbabilityOver15, tvProbabilityOver25, tvProbabilityOver35, tvProbabilityOver45,
            tvProbabilityOver55, tvProbabilityUnder05, tvProbabilityUnder15, tvProbabilityUnder25, tvProbabilityUnder35, tvProbabilityUnder45,
            tvProbabilityUnder55, tvOdds10, tvOdds20, tvOdds21, tvOdds30, tvOdds31, tvOdds32, tvOdds40, tvOdds41, tvOdds42, tvOdds43, tvOdds50,
            tvOdds51, tvOdds52, tvOdds53, tvOdds54, tvOdds60, tvOdds61, tvOdds62, tvOdds63, tvOdds64, tvOdds65, tvOdds70, tvOdds71, tvOdds72,
            tvOdds73, tvOdds74, tvOdds75, tvOdds76, tvOdds00, tvOdds11, tvOdds22, tvOdds33, tvOdds44, tvOdds55, tvOdds66, tvOdds77,
            tvOdds01, tvOdds02, tvOdds12, tvOdds03, tvOdds13, tvOdds23, tvOdds04, tvOdds14, tvOdds24, tvOdds34, tvOdds05,
            tvOdds15, tvOdds25, tvOdds35, tvOdds45, tvOdds06, tvOdds16, tvOdds26, tvOdds36, tvOdds46, tvOdds56, tvOdds07, tvOdds17, tvOdds27,
            tvOdds37, tvOdds47, tvOdds57, tvOdds67, tvOdds1, tvOddsX, tvOdds2, tvOdds1X, tvOdds1x2, tvOddsX2, tvOddsOver05, tvOddsOver15,
            tvOddsOver25, tvOddsOver35, tvOddsOver45, tvOddsOver55, tvOddsUnder05, tvOddsUnder15, tvOddsUnder25, tvOddsUnder35, tvOddsUnder45, tvOddsUnder55;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        //Get instances of all the elements
        TextView titleExactResults = (TextView)findViewById(R.id.titleExactResults);
        TextView titleSingleAndDouble = (TextView)findViewById(R.id.titleSingleAndDouble);
        TextView titleOverUnder = (TextView)findViewById(R.id.titleOverUnder);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView tvTeam1 = (TextView) findViewById(R.id.tvTeam1);
        TextView tvDraw = (TextView) findViewById(R.id.tvDraw);
        TextView tvTeam2 = (TextView) findViewById(R.id.tvTeam2);
        TextView tv1x2 = (TextView) findViewById(R.id.tv1x2);
        TextView tvDoubleChance = (TextView) findViewById(R.id.tvDoubleChance);
        TextView tvOver = (TextView) findViewById(R.id.tvOver);
        TextView tvUnder = (TextView) findViewById(R.id.tvUnder);
        tvProbability00 = (TextView) findViewById(R.id.tvProbability00);
        tvProbability11 = (TextView) findViewById(R.id.tvProbability11);
        tvProbability22 = (TextView) findViewById(R.id.tvProbability22);
        tvProbability33 = (TextView) findViewById(R.id.tvProbability33);
        tvProbability44 = (TextView) findViewById(R.id.tvProbability44);
        tvProbability55 = (TextView) findViewById(R.id.tvProbability55);
        tvProbability66 = (TextView) findViewById(R.id.tvProbability66);
        tvProbability77 = (TextView) findViewById(R.id.tvProbability77);

        tvOdds00 = (TextView) findViewById(R.id.tvOdds00);
        tvOdds11 = (TextView) findViewById(R.id.tvOdds11);
        tvOdds22 = (TextView) findViewById(R.id.tvOdds22);
        tvOdds33 = (TextView) findViewById(R.id.tvOdds33);
        tvOdds44 = (TextView) findViewById(R.id.tvOdds44);
        tvOdds55 = (TextView) findViewById(R.id.tvOdds55);
        tvOdds66 = (TextView) findViewById(R.id.tvOdds66);
        tvOdds77 = (TextView) findViewById(R.id.tvOdds77);

        tvProbability10 = (TextView) findViewById(R.id.tvProbability10);
        tvProbability20 = (TextView) findViewById(R.id.tvProbability20);
        tvProbability21 = (TextView) findViewById(R.id.tvProbability21);
        tvProbability30 = (TextView) findViewById(R.id.tvProbability30);
        tvProbability31 = (TextView) findViewById(R.id.tvProbability31);
        tvProbability32 = (TextView) findViewById(R.id.tvProbability32);
        tvProbability40 = (TextView) findViewById(R.id.tvProbability40);
        tvProbability41 = (TextView) findViewById(R.id.tvProbability41);
        tvProbability42 = (TextView) findViewById(R.id.tvProbability42);
        tvProbability43 = (TextView) findViewById(R.id.tvProbability43);
        tvProbability50 = (TextView) findViewById(R.id.tvProbability50);
        tvProbability51 = (TextView) findViewById(R.id.tvProbability51);
        tvProbability52 = (TextView) findViewById(R.id.tvProbability52);
        tvProbability53 = (TextView) findViewById(R.id.tvProbability53);
        tvProbability54 = (TextView) findViewById(R.id.tvProbability54);
        tvProbability60 = (TextView) findViewById(R.id.tvProbability60);
        tvProbability61 = (TextView) findViewById(R.id.tvProbability61);
        tvProbability62 = (TextView) findViewById(R.id.tvProbability62);
        tvProbability63 = (TextView) findViewById(R.id.tvProbability63);
        tvProbability64 = (TextView) findViewById(R.id.tvProbability64);
        tvProbability65 = (TextView) findViewById(R.id.tvProbability65);
        tvProbability70 = (TextView) findViewById(R.id.tvProbability70);
        tvProbability71 = (TextView) findViewById(R.id.tvProbability71);
        tvProbability72 = (TextView) findViewById(R.id.tvProbability72);
        tvProbability73 = (TextView) findViewById(R.id.tvProbability73);
        tvProbability74 = (TextView) findViewById(R.id.tvProbability74);
        tvProbability75 = (TextView) findViewById(R.id.tvProbability75);
        tvProbability76 = (TextView) findViewById(R.id.tvProbability76);

        tvOdds10 = (TextView) findViewById(R.id.tvOdds10);
        tvOdds20 = (TextView) findViewById(R.id.tvOdds20);
        tvOdds21 = (TextView) findViewById(R.id.tvOdds21);
        tvOdds30 = (TextView) findViewById(R.id.tvOdds30);
        tvOdds31 = (TextView) findViewById(R.id.tvOdds31);
        tvOdds32 = (TextView) findViewById(R.id.tvOdds32);
        tvOdds40 = (TextView) findViewById(R.id.tvOdds40);
        tvOdds41 = (TextView) findViewById(R.id.tvOdds41);
        tvOdds42 = (TextView) findViewById(R.id.tvOdds42);
        tvOdds43 = (TextView) findViewById(R.id.tvOdds43);
        tvOdds50 = (TextView) findViewById(R.id.tvOdds50);
        tvOdds51 = (TextView) findViewById(R.id.tvOdds51);
        tvOdds52 = (TextView) findViewById(R.id.tvOdds52);
        tvOdds53 = (TextView) findViewById(R.id.tvOdds53);
        tvOdds54 = (TextView) findViewById(R.id.tvOdds54);
        tvOdds60 = (TextView) findViewById(R.id.tvOdds60);
        tvOdds61 = (TextView) findViewById(R.id.tvOdds61);
        tvOdds62 = (TextView) findViewById(R.id.tvOdds62);
        tvOdds63 = (TextView) findViewById(R.id.tvOdds63);
        tvOdds64 = (TextView) findViewById(R.id.tvOdds64);
        tvOdds65 = (TextView) findViewById(R.id.tvOdds65);
        tvOdds70 = (TextView) findViewById(R.id.tvOdds70);
        tvOdds71 = (TextView) findViewById(R.id.tvOdds71);
        tvOdds72 = (TextView) findViewById(R.id.tvOdds72);
        tvOdds73 = (TextView) findViewById(R.id.tvOdds73);
        tvOdds74 = (TextView) findViewById(R.id.tvOdds74);
        tvOdds75 = (TextView) findViewById(R.id.tvOdds75);
        tvOdds76 = (TextView) findViewById(R.id.tvOdds76);

        tvProbability01 = (TextView) findViewById(R.id.tvProbability01);
        tvProbability02 = (TextView) findViewById(R.id.tvProbability02);
        tvProbability12 = (TextView) findViewById(R.id.tvProbability12);
        tvProbability03 = (TextView) findViewById(R.id.tvProbability03);
        tvProbability13 = (TextView) findViewById(R.id.tvProbability13);
        tvProbability23 = (TextView) findViewById(R.id.tvProbability23);
        tvProbability04 = (TextView) findViewById(R.id.tvProbability04);
        tvProbability14 = (TextView) findViewById(R.id.tvProbability14);
        tvProbability24 = (TextView) findViewById(R.id.tvProbability24);
        tvProbability34 = (TextView) findViewById(R.id.tvProbability34);
        tvProbability05 = (TextView) findViewById(R.id.tvProbability05);
        tvProbability15 = (TextView) findViewById(R.id.tvProbability15);
        tvProbability25 = (TextView) findViewById(R.id.tvProbability25);
        tvProbability35 = (TextView) findViewById(R.id.tvProbability35);
        tvProbability45 = (TextView) findViewById(R.id.tvProbability45);
        tvProbability06 = (TextView) findViewById(R.id.tvProbability06);
        tvProbability16 = (TextView) findViewById(R.id.tvProbability16);
        tvProbability26 = (TextView) findViewById(R.id.tvProbability26);
        tvProbability36 = (TextView) findViewById(R.id.tvProbability36);
        tvProbability46 = (TextView) findViewById(R.id.tvProbability46);
        tvProbability56 = (TextView) findViewById(R.id.tvProbability56);
        tvProbability07 = (TextView) findViewById(R.id.tvProbability07);
        tvProbability17 = (TextView) findViewById(R.id.tvProbability17);
        tvProbability27 = (TextView) findViewById(R.id.tvProbability27);
        tvProbability37 = (TextView) findViewById(R.id.tvProbability37);
        tvProbability47 = (TextView) findViewById(R.id.tvProbability47);
        tvProbability57 = (TextView) findViewById(R.id.tvProbability57);
        tvProbability67 = (TextView) findViewById(R.id.tvProbability67);

        tvOdds01 = (TextView) findViewById(R.id.tvOdds01);
        tvOdds02 = (TextView) findViewById(R.id.tvOdds02);
        tvOdds12 = (TextView) findViewById(R.id.tvOdds12);
        tvOdds03 = (TextView) findViewById(R.id.tvOdds03);
        tvOdds13 = (TextView) findViewById(R.id.tvOdds13);
        tvOdds23 = (TextView) findViewById(R.id.tvOdds23);
        tvOdds04 = (TextView) findViewById(R.id.tvOdds04);
        tvOdds14 = (TextView) findViewById(R.id.tvOdds14);
        tvOdds24 = (TextView) findViewById(R.id.tvOdds24);
        tvOdds34 = (TextView) findViewById(R.id.tvOdds34);
        tvOdds05 = (TextView) findViewById(R.id.tvOdds05);
        tvOdds15 = (TextView) findViewById(R.id.tvOdds15);
        tvOdds25 = (TextView) findViewById(R.id.tvOdds25);
        tvOdds35 = (TextView) findViewById(R.id.tvOdds35);
        tvOdds45 = (TextView) findViewById(R.id.tvOdds45);
        tvOdds06 = (TextView) findViewById(R.id.tvOdds06);
        tvOdds16 = (TextView) findViewById(R.id.tvOdds16);
        tvOdds26 = (TextView) findViewById(R.id.tvOdds26);
        tvOdds36 = (TextView) findViewById(R.id.tvOdds36);
        tvOdds46 = (TextView) findViewById(R.id.tvOdds46);
        tvOdds56 = (TextView) findViewById(R.id.tvOdds56);
        tvOdds07 = (TextView) findViewById(R.id.tvOdds07);
        tvOdds17 = (TextView) findViewById(R.id.tvOdds17);
        tvOdds27 = (TextView) findViewById(R.id.tvOdds27);
        tvOdds37 = (TextView) findViewById(R.id.tvOdds37);
        tvOdds47 = (TextView) findViewById(R.id.tvOdds47);
        tvOdds57 = (TextView) findViewById(R.id.tvOdds57);
        tvOdds67 = (TextView) findViewById(R.id.tvOdds67);

        tvProbability1 = (TextView) findViewById(R.id.tvProbability1);
        tvProbabilityX = (TextView) findViewById(R.id.tvProbabilityX);
        tvProbability2 = (TextView) findViewById(R.id.tvProbability2);
        tvProbability1X = (TextView) findViewById(R.id.tvProbability1X);
        tvProbability1x2 = (TextView) findViewById(R.id.tvProbability1x2);
        tvProbabilityX2 = (TextView) findViewById(R.id.tvProbabilityX2);

        tvOdds1 = (TextView) findViewById(R.id.tvOdds1);
        tvOddsX = (TextView) findViewById(R.id.tvOddsX);
        tvOdds2 = (TextView) findViewById(R.id.tvOdds2);
        tvOdds1X = (TextView) findViewById(R.id.tvOdds1X);
        tvOdds1x2 = (TextView) findViewById(R.id.tvOdds1x2);
        tvOddsX2 = (TextView) findViewById(R.id.tvOddsX2);

        tvProbabilityOver05 = (TextView) findViewById(R.id.tvProbabilityOver05);
        tvProbabilityOver15 = (TextView) findViewById(R.id.tvProbabilityOver15);
        tvProbabilityOver25 = (TextView) findViewById(R.id.tvProbabilityOver25);
        tvProbabilityOver35 = (TextView) findViewById(R.id.tvProbabilityOver35);
        tvProbabilityOver45 = (TextView) findViewById(R.id.tvProbabilityOver45);
        tvProbabilityOver55 = (TextView) findViewById(R.id.tvProbabilityOver55);

        tvOddsOver05 = (TextView) findViewById(R.id.tvOddsOver05);
        tvOddsOver15 = (TextView) findViewById(R.id.tvOddsOver15);
        tvOddsOver25 = (TextView) findViewById(R.id.tvOddsOver25);
        tvOddsOver35 = (TextView) findViewById(R.id.tvOddsOver35);
        tvOddsOver45 = (TextView) findViewById(R.id.tvOddsOver45);
        tvOddsOver55 = (TextView) findViewById(R.id.tvOddsOver55);

        tvProbabilityUnder05 = (TextView) findViewById(R.id.tvProbabilityUnder05);
        tvProbabilityUnder15 = (TextView) findViewById(R.id.tvProbabilityUnder15);
        tvProbabilityUnder25 = (TextView) findViewById(R.id.tvProbabilityUnder25);
        tvProbabilityUnder35 = (TextView) findViewById(R.id.tvProbabilityUnder35);
        tvProbabilityUnder45 = (TextView) findViewById(R.id.tvProbabilityUnder45);
        tvProbabilityUnder55 = (TextView) findViewById(R.id.tvProbabilityUnder55);

        tvOddsUnder05 = (TextView) findViewById(R.id.tvOddsUnder05);
        tvOddsUnder15 = (TextView) findViewById(R.id.tvOddsUnder15);
        tvOddsUnder25 = (TextView) findViewById(R.id.tvOddsUnder25);
        tvOddsUnder35 = (TextView) findViewById(R.id.tvOddsUnder35);
        tvOddsUnder45 = (TextView) findViewById(R.id.tvOddsUnder45);
        tvOddsUnder55 = (TextView) findViewById(R.id.tvOddsUnder55);

        tableTeam1 = (TableLayout) findViewById(R.id.contentTeam1);
        tableDraw = (TableLayout) findViewById(R.id.contentDraw);
        tableTeam2 = (TableLayout) findViewById(R.id.contentTeam2);
        table1x2 = (TableLayout) findViewById(R.id.content1x2);
        tableDouble = (TableLayout) findViewById(R.id.contentDoubleChance);
        tableOver = (TableLayout) findViewById(R.id.contentOver);
        tableUnder = (TableLayout) findViewById(R.id.contentUnder);

        setSupportActionBar(toolbar);//Set toolbar on the screen
        //Set personalized font
        Typeface face=Typeface.createFromAsset(getAssets(),"fonts/Lemonada-Bold.ttf");
        titleExactResults.setTypeface(face);
        titleSingleAndDouble.setTypeface(face);
        titleOverUnder.setTypeface(face);

        //Get the 'bag' with the name of teams and vector with the results
        Bundle bag = getIntent().getExtras();
        String team1 = bag.getString("team1");
        String team2 = bag.getString("team2");
        vectorResults = bag.getStringArray("vectorResults");

        //Set the expandable click for the TextView
        tvTeam1.setOnClickListener(this);
        if (team1.isEmpty())
        {
            tvTeam1.setText(R.string.team1);
        }
        else{
            tvTeam1.setText(team1);
        }
        tvDraw.setOnClickListener(this);
        tvTeam2.setOnClickListener(this);
        if (team2.isEmpty())
        {
            tvTeam2.setText(R.string.team2);
        }
        else{
            tvTeam2.setText(team2);
        }
        tv1x2.setOnClickListener(this);
        tvDoubleChance.setOnClickListener(this);
        tvOver.setOnClickListener(this);
        tvUnder.setOnClickListener(this);

        //Call to calculate averages(goals scored team 1, team 2,...)
        calculateAverages();
        //Call to calculate poisson(possibility to score and receive 0,1,...)
        calculatePoisson();
        //Call to calculate possibility of exact results
        calculateExactTeam1();
        calculateExactResultsDraw();
        calculateExactTeam2();
        //Call to calculate 1X2 and double chances
        calculateSingleAndDouble();
        //Call to calculate over and under
        calculateOver();
        calculateUnder();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvTeam1:
                if(tableTeam1.getVisibility() == View.GONE){
                    tableTeam1.setVisibility(View.VISIBLE);
                }
                else{
                    tableTeam1.setVisibility(View.GONE);
                }
                break;
            case R.id.tvDraw:
                if(tableDraw.getVisibility() == View.GONE){
                    tableDraw.setVisibility(View.VISIBLE);
                }
                else{
                    tableDraw.setVisibility(View.GONE);
                }
                break;
            case R.id.tvTeam2:
                if(tableTeam2.getVisibility() == View.GONE){
                    tableTeam2.setVisibility(View.VISIBLE);
                }
                else{
                    tableTeam2.setVisibility(View.GONE);
                }
                break;
            case R.id.tv1x2:
                if(table1x2.getVisibility() == View.GONE){
                    table1x2.setVisibility(View.VISIBLE);
                }
                else{
                    table1x2.setVisibility(View.GONE);
                }
                break;
            case R.id.tvDoubleChance:
                if(tableDouble.getVisibility() == View.GONE){
                    tableDouble.setVisibility(View.VISIBLE);
                }
                else{
                    tableDouble.setVisibility(View.GONE);
                }
                break;
            case R.id.tvOver:
                if(tableOver.getVisibility() == View.GONE){
                    tableOver.setVisibility(View.VISIBLE);
                }
                else{
                    tableOver.setVisibility(View.GONE);
                }
                break;
            case R.id.tvUnder:
                if(tableUnder.getVisibility() == View.GONE){
                    tableUnder.setVisibility(View.VISIBLE);
                }
                else{
                    tableUnder.setVisibility(View.GONE);
                }
                break;
        }
    }

    private void calculateAverages(){
        //Total and average scored goals of team 1
        for (int i=0; i<40; i=i+4){
            totalGoalsScored1 += Integer.parseInt(vectorResults[i]);
        }
        averageGoalsScored1 = totalGoalsScored1/numberItems;
        //Total and average scored goals of team 2
        for (int i=2; i<40; i=i+4){
            totalGoalsScored2 += Integer.parseInt(vectorResults[i]);
        }
        averageGoalsScored2 = totalGoalsScored2/numberItems;
        //Total and average received goals of team 1
        for (int i=1; i<40; i=i+4){
            totalGoalsReceived1 += Integer.parseInt(vectorResults[i]);
        }
        averageGoalsReceived1 = totalGoalsReceived1/numberItems;
        //Total and average received goals of team 2
        for (int i=3; i<40; i=i+4){
            totalGoalsReceived2 += Integer.parseInt(vectorResults[i]);
        }
        averageGoalsReceived2 = totalGoalsReceived2/numberItems;
    }

    private void calculatePoisson(){
        poissonAverageGoalsScored1 = new double[8];
        poissonAverageGoalsScored2 = new double[8];
        poissonAverageGoalsReceived1 = new double[8];
        poissonAverageGoalsReceived2 = new double[8];

        PoissonCalculation poisson = new PoissonCalculation();
        //Part of Poisson for average goals scored team 1(until 7 goals)
        for (int i=0; i<8; i++){
            poissonAverageGoalsScored1[i] = poisson.getPoisson(i,averageGoalsScored1);
        }
        //Part of Poisson for average goals received team 1(until 7 goals)
        for (int i=0; i<8; i++){
            poissonAverageGoalsReceived1[i] = poisson.getPoisson(i,averageGoalsReceived1);
        }
        //Part of Poisson for average goals scored team 2(until 7 goals)
        for (int i=0; i<8; i++){
            poissonAverageGoalsScored2[i] = poisson.getPoisson(i,averageGoalsScored2);
        }
        //Part of Poisson for average goals received team 2(until 7 goals)
        for (int i=0; i<8; i++){
            poissonAverageGoalsReceived2[i] = poisson.getPoisson(i,averageGoalsReceived2);
        }
    }

    public void calculateExactTeam1(){
        int t = 0;
        vectorTeam1 = new double[28];
        for (int i=1; i<poissonAverageGoalsScored1.length; i++){
            for (int j=0; j<i; j++){
                double tmpScored = poissonAverageGoalsScored1[i]*poissonAverageGoalsScored2[j];
                double tmpReceived = poissonAverageGoalsReceived1[j]*poissonAverageGoalsReceived2[i];
                vectorTeam1[t] = ((tmpScored + tmpReceived) / 2) * 100;
                t++;
            }
        }
        tvProbability10.setText(String.format("%.5f", vectorTeam1[0]));
        tvProbability20.setText(String.format("%.5f", vectorTeam1[1]));
        tvProbability21.setText(String.format("%.5f", vectorTeam1[2]));
        tvProbability30.setText(String.format("%.5f", vectorTeam1[3]));
        tvProbability31.setText(String.format("%.5f", vectorTeam1[4]));
        tvProbability32.setText(String.format("%.5f", vectorTeam1[5]));
        tvProbability40.setText(String.format("%.5f", vectorTeam1[6]));
        tvProbability41.setText(String.format("%.5f", vectorTeam1[7]));
        tvProbability42.setText(String.format("%.5f", vectorTeam1[8]));
        tvProbability43.setText(String.format("%.5f", vectorTeam1[9]));
        tvProbability50.setText(String.format("%.5f", vectorTeam1[10]));
        tvProbability51.setText(String.format("%.5f", vectorTeam1[11]));
        tvProbability52.setText(String.format("%.5f", vectorTeam1[12]));
        tvProbability53.setText(String.format("%.5f", vectorTeam1[13]));
        tvProbability54.setText(String.format("%.5f", vectorTeam1[14]));
        tvProbability60.setText(String.format("%.5f", vectorTeam1[15]));
        tvProbability61.setText(String.format("%.5f", vectorTeam1[16]));
        tvProbability62.setText(String.format("%.5f", vectorTeam1[17]));
        tvProbability63.setText(String.format("%.5f", vectorTeam1[18]));
        tvProbability64.setText(String.format("%.5f", vectorTeam1[19]));
        tvProbability65.setText(String.format("%.5f", vectorTeam1[20]));
        tvProbability70.setText(String.format("%.5f", vectorTeam1[21]));
        tvProbability71.setText(String.format("%.5f", vectorTeam1[22]));
        tvProbability72.setText(String.format("%.5f", vectorTeam1[23]));
        tvProbability73.setText(String.format("%.5f", vectorTeam1[24]));
        tvProbability74.setText(String.format("%.5f", vectorTeam1[25]));
        tvProbability75.setText(String.format("%.5f", vectorTeam1[26]));
        tvProbability76.setText(String.format("%.5f", vectorTeam1[27]));

        tvOdds10.setText(String.format("%.2f", (1/vectorTeam1[0])*100));
        tvOdds20.setText(String.format("%.2f", (1/vectorTeam1[1])*100));
        tvOdds21.setText(String.format("%.2f", (1/vectorTeam1[2])*100));
        tvOdds30.setText(String.format("%.2f", (1/vectorTeam1[3])*100));
        tvOdds31.setText(String.format("%.2f", (1/vectorTeam1[4])*100));
        tvOdds32.setText(String.format("%.2f", (1/vectorTeam1[5])*100));
        tvOdds40.setText(String.format("%.2f", (1/vectorTeam1[6])*100));
        tvOdds41.setText(String.format("%.2f", (1/vectorTeam1[7])*100));
        tvOdds42.setText(String.format("%.2f", (1/vectorTeam1[8])*100));
        tvOdds43.setText(String.format("%.2f", (1/vectorTeam1[9])*100));
        tvOdds50.setText(String.format("%.2f", (1/vectorTeam1[10])*100));
        tvOdds51.setText(String.format("%.2f", (1/vectorTeam1[11])*100));
        tvOdds52.setText(String.format("%.2f", (1/vectorTeam1[12])*100));
        tvOdds53.setText(String.format("%.2f", (1/vectorTeam1[13])*100));
        tvOdds54.setText(String.format("%.2f", (1/vectorTeam1[14])*100));
        tvOdds60.setText(String.format("%.2f", (1/vectorTeam1[15])*100));
        tvOdds61.setText(String.format("%.2f", (1/vectorTeam1[16])*100));
        tvOdds62.setText(String.format("%.2f", (1/vectorTeam1[17])*100));
        tvOdds63.setText(String.format("%.2f", (1/vectorTeam1[18])*100));
        tvOdds64.setText(String.format("%.2f", (1/vectorTeam1[19])*100));
        tvOdds65.setText(String.format("%.2f", (1/vectorTeam1[20])*100));
        tvOdds70.setText(String.format("%.2f", (1/vectorTeam1[21])*100));
        tvOdds71.setText(String.format("%.2f", (1/vectorTeam1[22])*100));
        tvOdds72.setText(String.format("%.2f", (1/vectorTeam1[23])*100));
        tvOdds73.setText(String.format("%.2f", (1/vectorTeam1[24])*100));
        tvOdds74.setText(String.format("%.2f", (1/vectorTeam1[25])*100));
        tvOdds75.setText(String.format("%.2f", (1/vectorTeam1[26])*100));
        tvOdds76.setText(String.format("%.2f", (1/vectorTeam1[27])*100));
    }

    public void calculateExactResultsDraw(){
        vectorDraw = new double[8];
        for (int i=0; i<poissonAverageGoalsScored1.length; i++){
            double tmpScored = poissonAverageGoalsScored1[i]*poissonAverageGoalsScored2[i];
            double tmpReceived = poissonAverageGoalsReceived1[i]*poissonAverageGoalsReceived2[i];
            vectorDraw[i] = ((tmpScored + tmpReceived) / 2) * 100;
        }
        tvProbability00.setText(String.format("%.5f", vectorDraw[0]));
        tvProbability11.setText(String.format("%.5f", vectorDraw[1]));
        tvProbability22.setText(String.format("%.5f", vectorDraw[2]));
        tvProbability33.setText(String.format("%.5f", vectorDraw[3]));
        tvProbability44.setText(String.format("%.5f", vectorDraw[4]));
        tvProbability55.setText(String.format("%.5f", vectorDraw[5]));
        tvProbability66.setText(String.format("%.5f", vectorDraw[6]));
        tvProbability77.setText(String.format("%.5f", vectorDraw[7]));

        tvOdds00.setText(String.format("%.2f", (1/vectorDraw[0])*100));
        tvOdds11.setText(String.format("%.2f", (1/vectorDraw[1])*100));
        tvOdds22.setText(String.format("%.2f", (1/vectorDraw[2])*100));
        tvOdds33.setText(String.format("%.2f", (1/vectorDraw[3])*100));
        tvOdds44.setText(String.format("%.2f", (1/vectorDraw[4])*100));
        tvOdds55.setText(String.format("%.2f", (1/vectorDraw[5])*100));
        tvOdds66.setText(String.format("%.2f", (1/vectorDraw[6])*100));
        tvOdds77.setText(String.format("%.2f", (1/vectorDraw[7])*100));
    }

    public void calculateExactTeam2(){
        int t = 0;
        vectorTeam2 = new double[28];
        for (int i=1; i<poissonAverageGoalsScored2.length; i++){
            for (int j=0; j<i; j++){
                double tmpScored = poissonAverageGoalsScored1[j]*poissonAverageGoalsScored2[i];
                double tmpReceived = poissonAverageGoalsReceived1[i]*poissonAverageGoalsReceived2[j];
                vectorTeam2[t] = ((tmpScored + tmpReceived) / 2) * 100;
                t++;
            }
        }
        tvProbability01.setText(String.format("%.5f", vectorTeam2[0]));
        tvProbability02.setText(String.format("%.5f", vectorTeam2[1]));
        tvProbability12.setText(String.format("%.5f", vectorTeam2[2]));
        tvProbability03.setText(String.format("%.5f", vectorTeam2[3]));
        tvProbability13.setText(String.format("%.5f", vectorTeam2[4]));
        tvProbability23.setText(String.format("%.5f", vectorTeam2[5]));
        tvProbability04.setText(String.format("%.5f", vectorTeam2[6]));
        tvProbability14.setText(String.format("%.5f", vectorTeam2[7]));
        tvProbability24.setText(String.format("%.5f", vectorTeam2[8]));
        tvProbability34.setText(String.format("%.5f", vectorTeam2[9]));
        tvProbability05.setText(String.format("%.5f", vectorTeam2[10]));
        tvProbability15.setText(String.format("%.5f", vectorTeam2[11]));
        tvProbability25.setText(String.format("%.5f", vectorTeam2[12]));
        tvProbability35.setText(String.format("%.5f", vectorTeam2[13]));
        tvProbability45.setText(String.format("%.5f", vectorTeam2[14]));
        tvProbability06.setText(String.format("%.5f", vectorTeam2[15]));
        tvProbability16.setText(String.format("%.5f", vectorTeam2[16]));
        tvProbability26.setText(String.format("%.5f", vectorTeam2[17]));
        tvProbability36.setText(String.format("%.5f", vectorTeam2[18]));
        tvProbability46.setText(String.format("%.5f", vectorTeam2[19]));
        tvProbability56.setText(String.format("%.5f", vectorTeam2[20]));
        tvProbability07.setText(String.format("%.5f", vectorTeam2[21]));
        tvProbability17.setText(String.format("%.5f", vectorTeam2[22]));
        tvProbability27.setText(String.format("%.5f", vectorTeam2[23]));
        tvProbability37.setText(String.format("%.5f", vectorTeam2[24]));
        tvProbability47.setText(String.format("%.5f", vectorTeam2[25]));
        tvProbability57.setText(String.format("%.5f", vectorTeam2[26]));
        tvProbability67.setText(String.format("%.5f", vectorTeam2[27]));

        tvOdds01.setText(String.format("%.2f", (1/vectorTeam2[0])*100));
        tvOdds02.setText(String.format("%.2f", (1/vectorTeam2[1])*100));
        tvOdds12.setText(String.format("%.2f", (1/vectorTeam2[2])*100));
        tvOdds03.setText(String.format("%.2f", (1/vectorTeam2[3])*100));
        tvOdds13.setText(String.format("%.2f", (1/vectorTeam2[4])*100));
        tvOdds23.setText(String.format("%.2f", (1/vectorTeam2[5])*100));
        tvOdds04.setText(String.format("%.2f", (1/vectorTeam2[6])*100));
        tvOdds14.setText(String.format("%.2f", (1/vectorTeam2[7])*100));
        tvOdds24.setText(String.format("%.2f", (1/vectorTeam2[8])*100));
        tvOdds34.setText(String.format("%.2f", (1/vectorTeam2[9])*100));
        tvOdds05.setText(String.format("%.2f", (1/vectorTeam2[10])*100));
        tvOdds15.setText(String.format("%.2f", (1/vectorTeam2[11])*100));
        tvOdds25.setText(String.format("%.2f", (1/vectorTeam2[12])*100));
        tvOdds35.setText(String.format("%.2f", (1/vectorTeam2[13])*100));
        tvOdds45.setText(String.format("%.2f", (1/vectorTeam2[14])*100));
        tvOdds06.setText(String.format("%.2f", (1/vectorTeam2[15])*100));
        tvOdds16.setText(String.format("%.2f", (1/vectorTeam2[16])*100));
        tvOdds26.setText(String.format("%.2f", (1/vectorTeam2[17])*100));
        tvOdds36.setText(String.format("%.2f", (1/vectorTeam2[18])*100));
        tvOdds46.setText(String.format("%.2f", (1/vectorTeam2[19])*100));
        tvOdds56.setText(String.format("%.2f", (1/vectorTeam2[20])*100));
        tvOdds07.setText(String.format("%.2f", (1/vectorTeam2[21])*100));
        tvOdds17.setText(String.format("%.2f", (1/vectorTeam2[22])*100));
        tvOdds27.setText(String.format("%.2f", (1/vectorTeam2[23])*100));
        tvOdds37.setText(String.format("%.2f", (1/vectorTeam2[24])*100));
        tvOdds47.setText(String.format("%.2f", (1/vectorTeam2[25])*100));
        tvOdds57.setText(String.format("%.2f", (1/vectorTeam2[26])*100));
        tvOdds67.setText(String.format("%.2f", (1/vectorTeam2[27])*100));
    }

    public void calculateSingleAndDouble(){
        double sum1 = 0;
        double sum2 = 0;
        for (int i=0; i<vectorTeam1.length; i++){
            sum1 += vectorTeam1[i];
            sum2 += vectorTeam2[i];
        }
        tvProbability1.setText(String.format("%.5f", sum1));
        tvProbability2.setText(String.format("%.5f", sum2));

        tvOdds1.setText(String.format("%.2f", (1/sum1)*100));
        tvOdds2.setText(String.format("%.2f", (1/sum2)*100));

        double sumX = 0;
        for (int i=0; i<vectorDraw.length; i++){
            sumX += vectorDraw[i];
        }
        tvProbabilityX.setText(String.format("%.5f", sumX));

        tvOddsX.setText(String.format("%.2f", (1/sumX)*100));

        tvProbability1X.setText(String.format("%.5f", sum1+sumX));
        tvProbability1x2.setText(String.format("%.5f", sum1+sum2));
        tvProbabilityX2.setText(String.format("%.5f", sumX+sum2));

        tvOdds1X.setText(String.format("%.2f", (1/(sum1+sumX)*100)));
        tvOdds1x2.setText(String.format("%.2f", (1/(sum1+sum2)*100)));
        tvOddsX2.setText(String.format("%.2f", (1/(sumX+sum2)*100)));
    }

    public void calculateOver(){
        double over05 = 0;
        for (int i=0; i<vectorTeam1.length; i++){
            over05 += vectorTeam1[i];
            over05 += vectorTeam2[i];
        }
        for (int i=1; i<vectorDraw.length; i++){
            over05 += vectorDraw[i];
        }
        tvProbabilityOver05.setText(String.format("%.5f", over05));

        double over15 = 0;
        for (int i=1; i<vectorTeam1.length; i++){
            over15 += vectorTeam1[i];
            over15 += vectorTeam2[i];
        }
        for (int i=1; i<vectorDraw.length; i++){
            over15 += vectorDraw[i];
        }
        tvProbabilityOver15.setText(String.format("%.5f", over15));

        double over25 = 0;
        for (int i=2; i<vectorTeam1.length; i++){
            over25 += vectorTeam1[i];
            over25 += vectorTeam2[i];
        }
        for (int i=2; i<vectorDraw.length; i++){
            over25 += vectorDraw[i];
        }
        tvProbabilityOver25.setText(String.format("%.5f", over25));

        double over35 = 0;
        for (int i=4; i<vectorTeam1.length; i++){
            over35 += vectorTeam1[i];
            over35 += vectorTeam2[i];
        }
        for (int i=2; i<vectorDraw.length; i++){
            over35 += vectorDraw[i];
        }
        tvProbabilityOver35.setText(String.format("%.5f", over35));

        double over45 = 0;
        for (int i=5; i<vectorTeam1.length; i++){
            over45 += vectorTeam1[i];
            over45 += vectorTeam2[i];
        }
        for (int i=3; i<vectorDraw.length; i++){
            over45 += vectorDraw[i];
        }
        over45 = over45 - (vectorTeam1[6]+vectorTeam2[6]);
        tvProbabilityOver45.setText(String.format("%.5f", over45));

        double over55 = 0;
        for (int i=8; i<vectorTeam1.length; i++){
            over55 += vectorTeam1[i];
            over55 += vectorTeam2[i];
        }
        for (int i=3; i<vectorDraw.length; i++){
            over55 += vectorDraw[i];
        }
        over55 = over55 - (vectorTeam1[10]+vectorTeam2[10]);
        tvProbabilityOver55.setText(String.format("%.5f", over55));

        tvOddsOver05.setText(String.format("%.2f", (1/over05)*100));
        tvOddsOver15.setText(String.format("%.2f", (1/over15)*100));
        tvOddsOver25.setText(String.format("%.2f", (1/over25)*100));
        tvOddsOver35.setText(String.format("%.2f", (1/over35)*100));
        tvOddsOver45.setText(String.format("%.2f", (1/over45)*100));
        tvOddsOver55.setText(String.format("%.2f", (1/over55)*100));
    }

    public void calculateUnder(){

        tvProbabilityUnder05.setText(String.format("%.5f", vectorDraw[0]));

        tvProbabilityUnder15.setText(String.format("%.5f", vectorDraw[0]+vectorTeam1[0]+vectorTeam2[0]));

        double under25 = 0;
        for (int i=0; i<2; i++){
            under25 += vectorTeam1[i];
            under25 += vectorTeam2[i];
        }
        for (int i=0; i<2; i++){
            under25 += vectorDraw[i];
        }
        tvProbabilityUnder25.setText(String.format("%.5f", under25));

        double under35 = 0;
        for (int i=0; i<4; i++){
            under35 += vectorTeam1[i];
            under35 += vectorTeam2[i];
        }
        for (int i=0; i<2; i++){
            under35 += vectorDraw[i];
        }
        tvProbabilityUnder35.setText(String.format("%.5f", under35));

        double under45 = 0;
        for (int i=0; i<5; i++){
            under45 += vectorTeam1[i];
            under45 += vectorTeam2[i];
        }
        for (int i=0; i<3; i++){
            under45 += vectorDraw[i];
        }
        under45 = under45 + (vectorTeam1[6]+vectorTeam2[6]);
        tvProbabilityUnder45.setText(String.format("%.5f", under45));

        double under55 = 0;
        for (int i=0; i<8; i++){
            under55 += vectorTeam1[i];
            under55 += vectorTeam2[i];
        }
        for (int i=0; i<3; i++){
            under55 += vectorDraw[i];
        }
        under55 = under55 + (vectorTeam1[10]+vectorTeam2[10]);
        tvProbabilityUnder55.setText(String.format("%.5f", under55));

        tvOddsUnder05.setText(String.format("%.2f", (1/vectorDraw[0])*100));
        tvOddsUnder15.setText(String.format("%.2f", (1/(vectorDraw[0]+vectorTeam1[0]+vectorTeam2[0]))*100));
        tvOddsUnder25.setText(String.format("%.2f", (1/under25)*100));
        tvOddsUnder35.setText(String.format("%.2f", (1/under35)*100));
        tvOddsUnder45.setText(String.format("%.2f", (1/under45)*100));
        tvOddsUnder55.setText(String.format("%.2f", (1/under55)*100));
    }
}
