package com.android.dwealthapp.model;

import android.content.Context;

import com.android.dwealthapp.R;

import java.util.ArrayList;
import java.util.List;

public class QuestionsDataModel {

    public static ArrayList<QuestionaryModel> addQuestions(Context context){

        QuestionaryModel questionaryModel;
        ArrayList<QuestionaryModel> questionaryModelArrayList = new ArrayList<>();
        List<QuestionaryModel.Options> optionsArrayList = new ArrayList<>();


        questionaryModel = new QuestionaryModel();
        questionaryModel.setQuestions(context.getResources().getString(R.string.question1));

        QuestionaryModel.Options options = new QuestionaryModel.Options();
        options.setOption1(context.getResources().getString(R.string.ques_1_opt_1));
        options.setOption2(context.getResources().getString(R.string.ques_1_opt_2));
        options.setOption3(context.getResources().getString(R.string.ques_1_opt_3));
        options.setOption4(context.getResources().getString(R.string.ques_1_opt_4));
        optionsArrayList.add(options);
        questionaryModel.setOptionsList(optionsArrayList);
        questionaryModelArrayList.add(questionaryModel);

        optionsArrayList = new ArrayList<>();
        questionaryModel = new QuestionaryModel();
        questionaryModel.setQuestions(context.getResources().getString(R.string.question2));
        QuestionaryModel .Options options1 = new QuestionaryModel.Options();
        options1.setOption1(context.getResources().getString(R.string.ques_2_opt_1));
        options1.setOption2(context.getResources().getString(R.string.ques_2_opt_2));
        options1.setOption3(context.getResources().getString(R.string.ques_2_opt_3));
        options1.setOption4(context.getResources().getString(R.string.ques_2_opt_4));
        optionsArrayList.add(options1);
        questionaryModel.setOptionsList(optionsArrayList);
        questionaryModelArrayList.add(questionaryModel);

        optionsArrayList = new ArrayList<>();
        questionaryModel = new QuestionaryModel();
        questionaryModel.setQuestions(context.getResources().getString(R.string.question3));
        QuestionaryModel .Options options3 = new QuestionaryModel.Options();
        options3.setOption1(context.getResources().getString(R.string.ques_3_opt_1));
        options3.setOption2(context.getResources().getString(R.string.ques_3_opt_2));
        options3.setOption3(context.getResources().getString(R.string.ques_3_opt_3));
        options3.setOption4(context.getResources().getString(R.string.ques_3_opt_4));
        optionsArrayList.add(options3);
        questionaryModel.setOptionsList(optionsArrayList);
        questionaryModelArrayList.add(questionaryModel);

        optionsArrayList = new ArrayList<>();
        questionaryModel = new QuestionaryModel();
        questionaryModel.setQuestions(context.getResources().getString(R.string.question4));
        QuestionaryModel .Options options4 = new QuestionaryModel.Options();
        options4.setOption1(context.getResources().getString(R.string.ques_4_opt_1));
        options4.setOption2(context.getResources().getString(R.string.ques_4_opt_2));
        options4.setOption3(context.getResources().getString(R.string.ques_4_opt_3));
        options4.setOption4(context.getResources().getString(R.string.ques_4_opt_4));
        optionsArrayList.add(options4);
        questionaryModel.setOptionsList(optionsArrayList);
        questionaryModelArrayList.add(questionaryModel);

        optionsArrayList = new ArrayList<>();
        questionaryModel = new QuestionaryModel();
        questionaryModel.setQuestions(context.getResources().getString(R.string.question5));
        QuestionaryModel .Options options5 = new QuestionaryModel.Options();
        options5.setOption1(context.getResources().getString(R.string.ques_5_opt_1));
        options5.setOption2(context.getResources().getString(R.string.ques_5_opt_2));
        options5.setOption3(context.getResources().getString(R.string.ques_5_opt_3));
        options5.setOption4(context.getResources().getString(R.string.ques_5_opt_4));
        optionsArrayList.add(options5);
        questionaryModel.setOptionsList(optionsArrayList);
        questionaryModelArrayList.add(questionaryModel);

        optionsArrayList = new ArrayList<>();
        questionaryModel = new QuestionaryModel();
        questionaryModel.setQuestions(context.getResources().getString(R.string.question6));
        QuestionaryModel .Options options6 = new QuestionaryModel.Options();
        options6.setOption1(context.getResources().getString(R.string.ques_6_opt_1));
        options6.setOption2(context.getResources().getString(R.string.ques_6_opt_2));
        options6.setOption3(context.getResources().getString(R.string.ques_6_opt_3));
        options6.setOption4(context.getResources().getString(R.string.ques_6_opt_4));
        optionsArrayList.add(options6);
        questionaryModel.setOptionsList(optionsArrayList);
        questionaryModelArrayList.add(questionaryModel);

        optionsArrayList = new ArrayList<>();
        questionaryModel = new QuestionaryModel();
        questionaryModel.setQuestions(context.getResources().getString(R.string.question7));
        QuestionaryModel .Options options7 = new QuestionaryModel.Options();
        options7.setOption1(context.getResources().getString(R.string.ques_7_opt_1));
        options7.setOption2(context.getResources().getString(R.string.ques_7_opt_2));
        options7.setOption3(context.getResources().getString(R.string.ques_7_opt_3));
        options7.setOption4(context.getResources().getString(R.string.ques_7_opt_4));
        optionsArrayList.add(options7);
        questionaryModel.setOptionsList(optionsArrayList);
        questionaryModelArrayList.add(questionaryModel);


        return questionaryModelArrayList;
    }


}
