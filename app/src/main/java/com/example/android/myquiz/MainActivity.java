package com.example.android.myquiz;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<LinearLayout> quizLayouts;

    //Quiz Layouts
    LinearLayout textQuizLayout;
    LinearLayout imageQuizLayout;
    LinearLayout checkBoxQuizLayout;
    LinearLayout radioButtonQuizLayout;

    int quizNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initalize();



    }

    private void initalize(){

        textQuizLayout = (LinearLayout)findViewById(R.id.layout_text_quiz);
        imageQuizLayout =(LinearLayout)findViewById(R.id.layout_image_quiz);
        checkBoxQuizLayout =(LinearLayout)findViewById(R.id.layout_checkbox_quiz);
        radioButtonQuizLayout =(LinearLayout)findViewById(R.id.layout_radiobutton_quiz);


        quizLayouts = new ArrayList<>();
        quizLayouts.add(textQuizLayout);
        quizLayouts.add(imageQuizLayout);
        quizLayouts.add(checkBoxQuizLayout);
        quizLayouts.add(radioButtonQuizLayout);
    }

    public void changeView(View view) {
        switch (quizNumber){
            case 0:
                textQuizLayout.setVisibility(View.GONE);
                imageQuizLayout.setVisibility(View.VISIBLE);
                quizNumber =1;
                break;
            case 1:
                imageQuizLayout.setVisibility(View.GONE);
                checkBoxQuizLayout.setVisibility(View.VISIBLE);
                quizNumber=2;
                break;
            case 2:
                checkBoxQuizLayout.setVisibility(View.GONE);
                radioButtonQuizLayout.setVisibility(View.VISIBLE);
                quizNumber=3;
                break;
        }
    }
}
