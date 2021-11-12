package com.example.quizet;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "categoryTable")
public class Category {
    @PrimaryKey//(autoGenerate = true)
    @ColumnInfo(name = "categoryId")
    private int categoryId;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "imageCateg")
    private  int imageCateg;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageCateg() {
        return imageCateg;
    }

    public void setImageCateg(int imageCateg) {
        this.imageCateg = imageCateg;
    }

    public Category(int categoryId, String name, int imageCateg) {
        this.categoryId = categoryId;
        this.name = name;
        this.imageCateg = imageCateg;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", imageCateg=" + imageCateg +
                '}';
    }
}
