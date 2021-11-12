package com.example.quizet;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class QuestionFromSet {

    @Embedded
    public Set set;
    @Relation(
            parentColumn = "setId",
            entityColumn = "questionSetId"
    )
    public List<Question> questions;
}
