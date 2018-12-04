package com.example.android.myquiz;



import java.util.ArrayList;

class TextQuiz {

    private ArrayList<String> list = new ArrayList<>();


    TextQuiz(String question, String answer ){
        list.add(question);
        list.add(answer);

    }

    ArrayList<String> getTextQuiz(){
        return list;
    }
}
