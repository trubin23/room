package ru.trubin23.room;

import android.app.Application;
import android.arch.persistence.room.Room;

public class App extends Application {

    private static App INSTANCE;

    private AppDatabase mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        mDatabase = Room.databaseBuilder(this, AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();
    }

    public static App getInstance() {
        return INSTANCE;
    }

    public AppDatabase getDatabase() {
        return mDatabase;
    }
}
