package com.example.quizet;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class SetsFromCategory {
    @Embedded
    public Category category;
    @Relation(
            parentColumn = "categoryId",
            entityColumn = "setCategoryId"
    )
    public List<Set> sets;
}