package com.example.quizet;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "setTable")
public class Set {
    @PrimaryKey//(autoGenerate = true)
    private int setId;
    @ColumnInfo(name = "setCategoryId")
    private  int setCategoryId;
    @ColumnInfo(name = "bestScore")
    private  int bestScore;


    public Set(int setId, int setCategoryId, int bestScore) {
        this.setId = setId;
        this.setCategoryId = setCategoryId;
        this.bestScore = bestScore;
    }

    @Override
    public String toString() {
        return "Set{" +
                "setId=" + setId +
                ", setCategoryId=" + setCategoryId +
                ", bestScore=" + bestScore +
                '}';
    }

    public int getSetId() {
        return setId;
    }

    public void setSetId(int setId) {
        this.setId = setId;
    }

    public int getSetCategoryId() {
        return setCategoryId;
    }

    public void setSetCategoryId(int setCategoryId) {
        this.setCategoryId = setCategoryId;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }
}
