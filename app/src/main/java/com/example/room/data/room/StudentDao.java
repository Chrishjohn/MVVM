package com.example.room.data.room;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.room.data.repository.room.StudentRoom;

import java.util.List;


@Dao
public interface StudentDao {

    @Query("SELECT * FROM studentroom")
    List<StudentRoom> getAll();

  /*  @Query("SELECT * FROM studentroom WHERE firstName LIKE '%' || :name || '%'")
     List<StudentRoom> findUsersByName(String name);
  */  @Insert
    void insert(StudentRoom studentRoom);

    @Query("UPDATE  studentroom SET product_id=:value1,product_name=:value2,seller_name=:value3,email=:value4,mobile=:value5 WHERE product_id = :value1")
    int updateUser(String value1,
                   String value2,
                   String value3,
                   String value4,
                   String value5);
}