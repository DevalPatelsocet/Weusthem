package com.example.weusthem_test.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.weusthem_test.database.dao.Userdao;
import com.example.weusthem_test.database.entity.User;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract Userdao.UserDao userDao();

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static volatile AppDatabase instance;

    public static AppDatabase getDatabaseInstance(final Context context){
        if (instance == null){  //Lazy Loading Design Pattern.
            synchronized (AppDatabase.class){
                if (instance == null){
                    instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "2091458_database") //Name of Database in SQL Database
                            .fallbackToDestructiveMigration()
//                            .allowMainThreadQueries()// Migration is database modified/changed
                            .build();

                }
            }
        }
        return instance;
    }
}
