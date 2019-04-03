package com.android.dwealthapp.model;

import java.util.List;

public class QuestionaryModel {

    String questions;
    private List<Options> optionsList = null;

    public QuestionaryModel() {
    }

    public List<Options> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(List<Options> optionsList) {
        this.optionsList = optionsList;
    }

    public String getQuestions() {
        return questions;

    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public static class Options {

        public String option1, option2, option3, option4;

        public String getOption1() {
            return option1;
        }

        public void setOption1(String option1) {
            this.option1 = option1;
        }

        public String getOption2() {
            return option2;
        }

        public void setOption2(String option2) {
            this.option2 = option2;
        }

        public String getOption3() {
            return option3;
        }

        public void setOption3(String option3) {
            this.option3 = option3;
        }

        public String getOption4() {
            return option4;
        }

        public void setOption4(String option4) {
            this.option4 = option4;
        }
    }

}







