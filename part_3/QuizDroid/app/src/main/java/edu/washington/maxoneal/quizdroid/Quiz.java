package edu.washington.maxoneal.quizdroid;

import java.io.Serializable;


public class Quiz implements Serializable {
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int indexOfCorrect;

    public Quiz() {
    }

    public String getQuestion() {
        return question;
    }

    public String getAns1() {
        return answer1;
    }

    public String getAns2() {
        return answer2;
    }

    public String getAns3() {
        return answer3;
    }

    public String getAns4() {
        return answer4;
    }

    public int getIndexOfCorrect() {
        return indexOfCorrect;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAns1(String answer) {
        this.answer1 = answer;
    }

    public void setAns2(String answer) {
        this.answer2 = answer;
    }

    public void setAns3(String answer) {
        this.answer3 = answer;
    }

    public void setAns4(String answer) {
        this.answer4 = answer;
    }

    public void setIndexOfCorrect(int index) {
        this.indexOfCorrect = index;
    }
}