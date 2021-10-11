package com.example.karanpractical2.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.karanpractical2.data.repository.room.StudentRoom;
import com.example.karanpractical2.utils.DataConverter;


@Database(entities = {StudentRoom.class}, version = 1, exportSchema = false)
@TypeConverters(DataConverter.class)
public abstract class AppDatabase extends RoomDatabase {
    public abstract StudentDao studentDao();

}