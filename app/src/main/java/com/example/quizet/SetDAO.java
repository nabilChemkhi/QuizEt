package com.example.quizet;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SetDAO {


    @Insert
    public void insertSet(Set S);

    @Query("SELECT * FROM setTable")
    public List<Set> getSets();

    @Query("SELECT * FROM setTable WHERE setCategoryId= :id")
    public List<Set> getSets(int id);

    @Query("SELECT * FROM setTable WHERE setId= :id")
    public List<Set> getSetById(int id);

    @Query("UPDATE setTable SET bestScore = :bsc  WHERE setId =:id")
    void update(int bsc, int id);

    @Query("DELETE FROM setTable")
    public void deletesetTable();
}
