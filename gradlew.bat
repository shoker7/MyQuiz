package com.example.shoker.footballscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_HGoal;
    TextView tv_HYellow;
    TextView tv_HRed;
    TextView tv_HSubt;

    TextView tv_AGoal;
    TextView tv_AYellow;
    TextView tv_ARed;
    TextView tv_ASubt;

    int hGoals=0;
    int hYellow=0;
    int hRed=0;
    int hSubt=0;

    int aGoals=0;
    int aYellow=0;
    int aRed=0;
    int aSubt=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_HGoal = findViewById(R.id.tv_homegoal);
        tv_HYellow = findViewById(R.id.tv_homeyellow);
        tv_HRed = findViewById(R.id.tv_homered);
        tv_HSubt = findViewById(R.id.tv_homesubt);

        tv_AGoal = findViewById(R.id.tv_awaygoal);
        tv_AYellow = findViewById(R.id.tv_awayyellow);
        tv_ARed = findViewById(R.id.tv_awayred);
        tv_ASubt = findViewById(R.id.tv_awaysubt);

    }


    public void hGoalDec(View view) {
        if(hGoals>0){
            hGoals = hGoals-1;
          publish(tv_HGoal,hGoals);
        }

    }

    public void hGoalInc(View view) {
        hGoals=hGoals+1;
        publish(tv_HGoal,hGoals);
    }




    public void hYellowDec(View view) {
        if(hYellow>0){
            hYellow=hYellow-1;
            publish(tv_HYellow,hYellow);
        }
    }

    public void hYellowInc(View view) {
        hYellow=hYellow+1;
        publish(tv_HYellow,hYellow);
    }


    public void hRedDec(View view) {
        if(hRed>0){
            hRed=hRed-1;
            publish(tv_HRed,hRed);
        }
    }

    public void hRedInc(View view) {
        hRed=hRed+1;
        publish(tv_HRed,hRed);
    }

    public void hSubtDec(View view) {
        if(hSubt>0){
            hSubt=hSubt-1;
            publish(tv_HSubt,hSubt);
        }

    }

    public void hSubtInc(View view) {
        hSubt=hSubt+1;
        publish(tv_HSubt,hSubt);
    }

    public void aGoal