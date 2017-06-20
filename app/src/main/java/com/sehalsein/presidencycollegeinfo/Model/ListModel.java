package com.sehalsein.presidencycollegeinfo.Model;

/**
 * Created by sehalsein on 19/06/17.
 */

public class ListModel {
    String quetions;
    String answers;
    int images;

    public ListModel() {
    }


    public String getQuetions() {
        return quetions;
    }

    public void setQuetions(String quetions) {
        this.quetions = quetions;
    }

    public String getAnswers() {
        return answers;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }
}
