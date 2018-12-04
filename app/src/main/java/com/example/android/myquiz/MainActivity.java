package com.example.android.myquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<ChooseQuiz> checkboxQuizData;
    ArrayList<ChooseQuiz> radioButtonQuizData;
    ArrayList<TextQuiz> textQuizData;
    ArrayList<ImageQuiz> imageQuizData;

    ArrayList<LinearLayout> quizLayouts;

    //Quiz Layouts
    LinearLayout textQuizLayout;
    LinearLayout imageQuizLayout;
    LinearLayout checkBoxQuizLayout;
    LinearLayout radioButtonQuizLayout;
    LinearLayout endQuizLayout;

    int quizNumber = 0;
    int score = 0;

    Random random = new Random();



    String textQuestion;
    String imageQuestion;
    String checkQuestion;
    String radioQuestion;

    String textAnswer;
    String imageAnswer;
    ArrayList<String> checkboxAnswer;
    String radiobuttonAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initalize();
        setQuestion(0);


    }

    private void initalize() {

        textQuizLayout = (LinearLayout) findViewById(R.id.layout_text_quiz);
        imageQuizLayout = (LinearLayout) findViewById(R.id.layout_image_quiz);
        checkBoxQuizLayout = (LinearLayout) findViewById(R.id.layout_checkbox_quiz);
        radioButtonQuizLayout = (LinearLayout) findViewById(R.id.layout_radiobutton_quiz);
        endQuizLayout =(LinearLayout)findViewById(R.id.quiz_end_layout);


        //Text Quiz Data
        textQuizData = new ArrayList<>();
        textQuizData.add(new TextQuiz(getString(R.string.text_question_one), getString(R.string.text_answer_one)));
        textQuizData.add(new TextQuiz(getString(R.string.text_question_two), getString(R.string.text_answer_two)));
        textQuizData.add(new TextQuiz(getString(R.string.text_question_three), getString(R.string.text_answer_three)));
        textQuizData.add(new TextQuiz(getString(R.string.text_question_four), getString(R.string.text_answer_four)));
        textQuizData.add(new TextQuiz(getString(R.string.text_question_five), getString(R.string.text_answer_five)));
        textQuizData.add(new TextQuiz(getString(R.string.text_question_six), getString(R.string.text_answer_six)));

        //Image Quiz Data
        imageQuizData = new ArrayList<>();
        imageQuizData.add(new ImageQuiz(getString(R.string.image_question_one), getString(R.string.image_answer_one), R.drawable.hollywood));
        imageQuizData.add(new ImageQuiz(getString(R.string.image_question_two), getString(R.string.image_answer_two), R.drawable.epl));
        imageQuizData.add(new ImageQuiz(getString(R.string.image_question_three), getString(R.string.image_answer_three), R.drawable.ferrari));
        imageQuizData.add(new ImageQuiz(getString(R.string.image_question_four), getString(R.string.image_answer_four), R.drawable.ak47));
        imageQuizData.add(new ImageQuiz(getString(R.string.image_question_five), getString(R.string.image_answer_five), R.drawable.dollar));
        imageQuizData.add(new ImageQuiz(getString(R.string.image_question_six), getString(R.string.image_answer_six), R.drawable.cupcake));

        //CheckBox Quiz Data
        checkboxQuizData = new ArrayList<>();
        checkboxQuizData.add(new ChooseQuiz(getString(R.string.check_box_question_one),
                getString(R.string.check_box_answer_one_one), "true",
                getString(R.string.check_box_answer_one_two), "false",
                getString(R.string.check_box_answer_one_three), "false",
                getString(R.string.check_box_answer_one_four), "true",
                getString(R.string.check_box_answer_one_five), "true"));
        checkboxQuizData.add(new ChooseQuiz(getString(R.string.check_box_question_two),
                getString(R.string.check_box_answer_two_one), "false",
                getString(R.string.check_box_answer_two_two), "true",
                getString(R.string.check_box_answer_two_three), "false",
                getString(R.string.check_box_answer_two_four), "true",
                getString(R.string.check_box_answer_two_five), "false"));
        checkboxQuizData.add(new ChooseQuiz(getString(R.string.check_box_question_three),
                getString(R.string.check_box_answer_three_one), "true",
                getString(R.string.check_box_answer_three_two), "false",
                getString(R.string.check_box_answer_three_three), "false",
                getString(R.string.check_box_answer_three_four), "false",
                getString(R.string.check_box_answer_three_five), "false"));
        checkboxQuizData.add(new ChooseQuiz(getString(R.string.check_box_question_four),
                getString(R.string.check_box_answer_four_one), "true",
                getString(R.string.check_box_answer_four_two), "true",
                getString(R.string.check_box_answer_four_three), "false",
                getString(R.string.check_box_answer_four_four), "true",
                getString(R.string.check_box_answer_four_five), "false"));
        checkboxQuizData.add(new ChooseQuiz(getString(R.string.check_box_question_five),
                getString(R.string.check_box_answer_five_one), "false",
                getString(R.string.check_box_answer_five_two), "true",
                getString(R.string.check_box_answer_five_three), "true",
                getString(R.string.check_box_answer_five_four), "true",
                getString(R.string.check_box_answer_five_five), "false"));

        radioButtonQuizData = new ArrayList<>();
        radioButtonQuizData.add(new ChooseQuiz(getString(R.string.radio_button_question_one),
                getString(R.string.radio_button_answer_one_one), "false",
                getString(R.string.radio_button_answer_one_two), "false",
                getString(R.string.radio_button_answer_one_three), "true",
                getString(R.string.radio_button_answer_one_four), "false",
                getString(R.string.radio_button_answer_one_five), "false"));
        radioButtonQuizData.add(new ChooseQuiz(getString(R.string.radio_button_question_two),
                getString(R.string.radio_button_answer_two_one), "false",
                getString(R.string.radio_button_answer_two_two), "true",
                getString(R.string.radio_button_answer_two_three), "false",
                getString(R.string.radio_button_answer_two_four), "false",
                getString(R.string.radio_button_answer_two_five), "false"));
        radioButtonQuizData.add(new ChooseQuiz(getString(R.string.radio_button_question_three),
                getString(R.string.radio_button_answer_three_one), "false",
                getString(R.string.radio_button_answer_three_two), "true",
                getString(R.string.radio_button_answer_three_three), "false",
                getString(R.string.radio_button_answer_three_four), "false",
                getString(R.string.radio_button_answer_three_five), "false"));
        radioButtonQuizData.add(new ChooseQuiz(getString(R.string.radio_button_question_four),
                getString(R.string.radio_button_answer_four_one), "false",
                getString(R.string.radio_button_answer_four_two), "false",
                getString(R.string.radio_button_answer_four_three), "true",
                getString(R.string.radio_button_answer_four_four), "false",
                getString(R.string.radio_button_answer_four_five), "false"));
        radioButtonQuizData.add(new ChooseQuiz(getString(R.string.radio_button_question_five),
                getString(R.string.radio_button_answer_five_one), "false",
                getString(R.string.radio_button_answer_five_two), "false",
                getString(R.string.radio_button_answer_five_three), "false",
                getString(R.string.radio_button_answer_five_four), "false",
                getString(R.string.radio_button_answer_five_five), "true"));


    }

    public void changeView(View view) {
        TextView quizNumberTV =(TextView)findViewById(R.id.tv_quiz_number);
        switch (quizNumber) {
            case 0:
                checkAnswer(0);
                textQuizLayout.setVisibility(View.GONE);
                imageQuizLayout.setVisibility(View.VISIBLE);
                quizNumber = 1;
                quizNumberTV.setText(getString(R.string.question_number)+" 2/4");
                setQuestion(quizNumber);
                break;
            case 1:
                checkAnswer(1);
                imageQuizLayout.setVisibility(View.GONE);
                checkBoxQuizLayout.setVisibility(View.VISIBLE);
                quizNumber = 2;
                quizNumberTV.setText(getString(R.string.question_number)+" 3/4");
                setQuestion(2);
                break;
            case 2:
                checkAnswer(2);
                checkBoxQuizLayout.setVisibility(View.GONE);
                radioButtonQuizLayout.setVisibility(View.VISIBLE);
                quizNumber = 3;
                quizNumberTV.setText(getString(R.string.question_number)+" 4/4");
                setQuestion(3);
                break;
            case 3:
                checkAnswer(3);
                radioButtonQuizLayout.setVisibility(View.GONE);
                endQuizLayout.setVisibility(View.VISIBLE);
                quizNumber=4;
                setEndLayout();
                Button nextButton =(Button)findViewById(R.id.submit_next_button);
                nextButton.setText("New Quiz");
                break;
            case 4:
                clear();
                endQuizLayout.setVisibility(View.GONE);
                textQuizLayout.setVisibility(View.VISIBLE);
                quizNumber=0;
                setQuestion(quizNumber);

        }
    }

    public void setQuestion(int nquiz) {

        switch (nquiz) {
            case 0:
                int textRandomNumber = random.nextInt(textQuizData.size());
                TextView textQTV = (TextView) findViewById(R.id.tv_textquiz_question);
                textQuestion = textQuizData.get(textRandomNumber).getTextQuiz().get(0);
                textQTV.setText(textQuestion);
                textAnswer = textQuizData.get(textRandomNumber).getTextQuiz().get(1);
                break;

            case 1:
                int imageRandomNumber = random.nextInt(imageQuizData.size());
                TextView imageQTV = (TextView) findViewById(R.id.tv_imagequiz_question);
                ImageView imageIV = (ImageView) findViewById(R.id.iv_imagequiz);
                imageQuestion = (String) (imageQuizData.get(imageRandomNumber).getImageQuiz().get(0));
                imageQTV.setText(imageQuestion);
                imageIV.setImageResource((int) (imageQuizData.get(imageRandomNumber).getImageQuiz().get(2)));
                imageAnswer = (String) imageQuizData.get(imageRandomNumber).getImageQuiz().get(1);
                break;

            case 2:
                int checkBoxRandomNumber = random.nextInt(checkboxQuizData.size());
                TextView checkBoxQTV = (TextView) findViewById(R.id.tv_checkbox_question);
                CheckBox answeroneCB = (CheckBox) findViewById(R.id.cb_answer_one);
                CheckBox answertwoCB = (CheckBox) findViewById(R.id.cb_answer_two);
                CheckBox answerthreeCB = (CheckBox) findViewById(R.id.cb_answer_three);
                CheckBox answerfourCB = (CheckBox) findViewById(R.id.cb_answer_four);
                CheckBox answerfiveCB = (CheckBox) findViewById(R.id.cb_answer_five);

                ArrayList<String> checkBoxQuestion = checkboxQuizData.get(checkBoxRandomNumber).getCheckQuiz();
                checkQuestion = checkBoxQuestion.get(0);

                checkBoxQTV.setText(checkBoxQuestion.get(0));
                answeroneCB.setText(checkBoxQuestion.get(1));
                answertwoCB.setText(checkBoxQuestion.get(3));
                answerthreeCB.setText(checkBoxQuestion.get(5));
                answerfourCB.setText(checkBoxQuestion.get(7));
                answerfiveCB.setText(checkBoxQuestion.get(9));

                checkboxAnswer = new ArrayList<>();

                for (int i = 0; i < 5; i++) {
                    int status = 2 + i * 2;
                    String trueOrfalse = checkBoxQuestion.get(status);
                    if (trueOrfalse.equals("true")) {
                        String s =checkBoxQuestion.get(status - 1);
                        checkboxAnswer.add(s.toLowerCase());
                    }
                }
                break;

            case 3:
               int  radioButtonrandomNumber = random.nextInt(radioButtonQuizData.size());
                TextView radioButtonQTV = (TextView) findViewById(R.id.tv_radiobutton_question);
                RadioButton answeroneRB = (RadioButton) findViewById(R.id.rb_answer_one);
                RadioButton answertwoRB = (RadioButton) findViewById(R.id.rb_answer_two);
                RadioButton answerthreeRB = (RadioButton) findViewById(R.id.rb_answer_three);
                RadioButton answerfourRB = (RadioButton) findViewById(R.id.rb_answer_four);
                RadioButton answerfiveRB = (RadioButton) findViewById(R.id.rb_answer_five);

                ArrayList<String> radioButtonQuestion = radioButtonQuizData.get(radioButtonrandomNumber).getCheckQuiz();

                radioQuestion = radioButtonQuestion.get(0);
                radioButtonQTV.setText(radioQuestion);
                answeroneRB.setText(radioButtonQuestion.get(1));
                answertwoRB.setText(radioButtonQuestion.get(3));
                answerthreeRB.setText(radioButtonQuestion.get(5));
                answerfourRB.setText(radioButtonQuestion.get(7));
                answerfiveRB.setText(radioButtonQuestion.get(9));

                for (int i = 0; i < 5; i++) {
                    int status = 2 + i * 2;
                    String trueOrfalse = radioButtonQuestion.get(status);
                    if (trueOrfalse.equals("true")) {
                        radiobuttonAnswer = radioButtonQuestion.get(status - 1);
                    }
                }
                break;

        }
    }

    private void checkAnswer(int quizn) {

        TextView scoreTV = (TextView) findViewById(R.id.tv_score);
        switch (quizn) {
            case 0:
                EditText textAET = (EditText) findViewById(R.id.et_textquiz_answer);
                String textUserAnswer = textAET.getText().toString();
                if (!textUserAnswer.equals("")) {
                    if (textUserAnswer.equalsIgnoreCase(textAnswer)) {
                        score += 1;
                        scoreTV.setText(getString(R.string.score) + score);
                        Toast.makeText(this, getString(R.string.wright_answer), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, getString(R.string.wrong_answer) + " " + textAnswer, Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, getString(R.string.no_enter), Toast.LENGTH_SHORT).show();
                }
                break;

            case 1:
                EditText imageAET = (EditText) findViewById(R.id.et_imagequiz_answer);
                String imageUserAnswer = imageAET.getText().toString();
                if (!imageUserAnswer.equals("")) {
                    if (imageUserAnswer.equalsIgnoreCase(imageAnswer)) {
                        score += 1;
                        scoreTV.setText(getString(R.string.score) + score);
                        Toast.makeText(this, getString(R.string.wright_answer), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, getString(R.string.wrong_answer) + " " + imageAnswer, Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, getString(R.string.no_enter), Toast.LENGTH_SHORT).show();
                }
                break;

            case 2:
                CheckBox checkboxACB1 = (CheckBox) findViewById(R.id.cb_answer_one);
                CheckBox checkboxACB2 = (CheckBox) findViewById(R.id.cb_answer_two);
                CheckBox checkboxACB3 = (CheckBox) findViewById(R.id.cb_answer_three);
                CheckBox checkboxACB4 = (CheckBox) findViewById(R.id.cb_answer_four);
                CheckBox checkboxACB5 = (CheckBox) findViewById(R.id.cb_answer_five);

                ArrayList<CheckBox> ACB = new ArrayList<>();
                ACB.add(checkboxACB1);
                ACB.add(checkboxACB2);
                ACB.add(checkboxACB3);
                ACB.add(checkboxACB4);
                ACB.add(checkboxACB5);

                ArrayList<String> checkboxUserAnswer = new ArrayList<>();
                if(checkboxACB1.isChecked()||checkboxACB2.isChecked()||checkboxACB3.isChecked()||checkboxACB4.isChecked()||checkboxACB5.isChecked()){
                for (CheckBox checkBox : ACB) {
                    if (checkBox.isChecked()) {
                        checkboxUserAnswer.add(checkBox.getText().toString().toLowerCase());
                    }
                }
                if (Arrays.equals(checkboxUserAnswer.toArray(), checkboxAnswer.toArray())) {
                    score += 1;
                    scoreTV.setText(getString(R.string.score) + score);
                    Toast.makeText(this, getString(R.string.wright_answer), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, getString(R.string.wrong_answer), Toast.LENGTH_SHORT).show();
                }}else {
                    Toast.makeText(this, "you did not choose answer", Toast.LENGTH_SHORT).show();
                }
                break;


            case 3:
                RadioGroup RG = (RadioGroup)findViewById(R.id.radio_group);

                try {
                    RadioButton checkedRB = (RadioButton) findViewById(RG.getCheckedRadioButtonId());
                    String radiobuttonUserAnswer = checkedRB.getText().toString().toLowerCase();

                    if (radiobuttonUserAnswer.equalsIgnoreCase(radiobuttonAnswer)) {
                        score += 1;
                        scoreTV.setText(getString(R.string.score) + score);
                        Toast.makeText(this, getString(R.string.wright_answer), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, getString(R.string.wrong_answer) + " " + radiobuttonAnswer, Toast.LENGTH_SHORT).show();
                    }
                }catch( Exception e){
                    Toast.makeText(this, "you did not choose answer", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void setEndLayout(){
        TextView endTextQuestionTV =(TextView)findViewById(R.id.tv_end_text_question);
        TextView endTextAnswerTV =(TextView)findViewById(R.id.tv_end_text_answer);
        TextView endImageQuestionTV =(TextView)findViewById(R.id.tv_end_image_question);
        TextView endImageAnswerTV =(TextView)findViewById(R.id.tv_end_image_answer);
        TextView endCheckQuestionTV =(TextView)findViewById(R.id.tv_end_checkbox_question);
        TextView endCheckeAnswerTV =(TextView)findViewById(R.id.tv_end_checkbox_answer);
        TextView endRadioQuestionTV =(TextView)findViewById(R.id.tv_end_radiobutton_question);
        TextView endRadioAnswerTV =(TextView)findViewById(R.id.tv_end_radiobutton_answer);

        endTextQuestionTV.setText(textQuestion);
        endTextAnswerTV.setText(textAnswer);

        endImageQuestionTV.setText(imageQuestion);
        endImageAnswerTV.setText(imageAnswer);

        endCheckQuestionTV.setText(checkQuestion);
        StringBuilder checkAnswer =new StringBuilder();
        for(String s : checkboxAnswer){
            checkAnswer.append(s+"    ");
        }
        endCheckeAnswerTV.setText(checkAnswer.toString());

        endRadioQuestionTV.setText(radioQuestion);
        endRadioAnswerTV.setText(radiobuttonAnswer);
    }

    private void clear(){
        EditText textETAnswer = (EditText)findViewById(R.id.et_textquiz_answer);
        textETAnswer.setText("");

        EditText imageETAnswer = (EditText)findViewById(R.id.et_imagequiz_answer);
        imageETAnswer.setText("");

        CheckBox answeroneCB = (CheckBox) findViewById(R.id.cb_answer_one);
        answeroneCB.setChecked(false);
        CheckBox answertwoCB = (CheckBox) findViewById(R.id.cb_answer_two);
        answertwoCB.setChecked(false);
        CheckBox answerthreeCB = (CheckBox) findViewById(R.id.cb_answer_three);
        answerthreeCB.setChecked(false);
        CheckBox answerfourCB = (CheckBox) findViewById(R.id.cb_answer_four);
        answerfourCB.setChecked(false);
        CheckBox answerfiveCB = (CheckBox) findViewById(R.id.cb_answer_five);
        answerfiveCB.setChecked(false);

        RadioGroup RG = (RadioGroup)findViewById(R.id.radio_group);
        RG.clearCheck();

        TextView scoreTV = (TextView) findViewById(R.id.tv_score);
        score =0;
        scoreTV.setText(getString(R.string.score) + score);

        TextView quizNumberTV =(TextView)findViewById(R.id.tv_quiz_number);
        quizNumberTV.setText(getString(R.string.question_number)+" 1/4");


    }
}
