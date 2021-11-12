package com.example.quizet;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QuestionDAO {

    @Insert
    public void insertQuestion(Question Q);

    @Query("SELECT * FROM questionTable")
    public List<Question> getQuestions();

    @Query("SELECT * FROM questionTable WHERE questionSetId= :id")
    public List<Question> getQuestionsBySetId(int id);

    @Query("DELETE FROM questionTable")
    public void deleteQuestionTable();
}
