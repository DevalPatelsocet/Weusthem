package com.example.weusthem_test.database.dao;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.lifecycle.LiveData;
import com.example.weusthem_test.database.entity.User;
import java.util.List;

public interface Userdao {
    @Dao
    public interface UserDao {

        @Query("SELECT * FROM User")
        LiveData<List<User>> getUsers();

        //@Query("SELECT * FROM User where first_name = :first_name")
        //LiveData<List<User>> getUsersWith(String firstname);

        @Query("SELECT first_name || ' ' || last_name FROM User")
        LiveData<List<String>> getFullNameOfUsers();

        @Query("SELECT * FROM User where id = :id")
        LiveData<User> getUser(int id);

        @Query("SELECT * FROM User WHERE last_name LIKE :letter+'%'")
        LiveData<List<User>> getUsersWithLastNameStarting(char letter);

        @Insert
        void insert(User... user);

        @Update
        void update(User user);

        @Delete
        void delete(User... user);
    }
}
