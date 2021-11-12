package com.example.quizet;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface SetsFromCategoryDAO {

    @Transaction
    @Query("SELECT * FROM categoryTable WHERE categoryId= :id")
    public List<SetsFromCategory> getSetsFromCategory(int id);
}
