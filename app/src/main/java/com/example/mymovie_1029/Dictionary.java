package com.example.mymovie_1029;

public class Dictionary {
    private String userID;
    private String comment;

    public Dictionary(String userID, String comment) {
        this.userID = userID;
        this.comment = comment;
    }
    public String getUserID() {

        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}
