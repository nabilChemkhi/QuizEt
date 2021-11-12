package com.example.quizet;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CategoryDAO {

    @Insert
    public void insertCategory(Category C);

    @Query("SELECT * FROM categoryTable WHERE categoryId= :id")
    public Category getCategory(int id);

    @Query("DELETE FROM categoryTable")
    public void deleteCategTable();




    @Query("SELECT * FROM categoryTable")
    public List<Category> getCategories();
}