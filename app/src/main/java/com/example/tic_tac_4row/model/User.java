package com.example.tic_tac_4row.model;

import java.util.UUID;

public class User {
    private UUID mId;
    private String mUserName;
    private boolean turn;
    private int mScore;

    public User(String userName) {
        mUserName = userName;
        mScore=0;
        mId=UUID.randomUUID();
    }

    public User() {
        mId=UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public int getScore() {
        return mScore;
    }

    public void setScore(int score) {
        mScore = score;
    }
}
