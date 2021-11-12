package com.example.quizet;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface QuestionFromSetDAO {
    @Transaction
    @Query("SELECT * FROM setTable WHERE setId= :id")
    public List<QuestionFromSet> getQuestionFromSet(int id);
}
