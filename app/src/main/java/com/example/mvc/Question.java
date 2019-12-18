package com.example.mvc;

public class Question {

    private int resid;///0 ques//1
    private boolean answer;//true

    public Question(int a,boolean b) {
        resid=a;
        answer=b;

    }

    public int getResid() {

        return resid;
    }

    public void setResid(int resid) {

        this.resid = resid;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {

        this.answer = answer;
    }
}
