package com.example.quizet;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(version = 5, entities = {Category.class, Set.class,Question.class},exportSchema = true)
abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;


    // BookDao is a class annotated with @Dao.
    abstract public QuestionDAO questionDAO();
    abstract public QuestionFromSetDAO questionFromSetDAO();
    // BookDao is a class annotated with @Dao.
    abstract public CategoryDAO categoryDAO();
    // UserDao is a class annotated with @Dao.
    abstract public SetDAO setDAO();
    // UserBookDao is a class annotated with @Dao.
    abstract public SetsFromCategoryDAO setsFromCategoryDAO();

    public static AppDatabase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "room_test_db")//.fallbackToDestructiveMigration()

                    .allowMainThreadQueries()
                    .build();

        }
        return instance;
    }
}
