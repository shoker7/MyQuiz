package com.example.android.myquiz;

import java.util.ArrayList;

public class ImageQuiz {

    private ArrayList<Object> list = new ArrayList<>();


    ImageQuiz(String question, String answer ,int image){
        list.add(question);
        list.add(answer);
        list.add(image);

    }

    ArrayList<Object> getImageQuiz(){
        return list;
    }
}
