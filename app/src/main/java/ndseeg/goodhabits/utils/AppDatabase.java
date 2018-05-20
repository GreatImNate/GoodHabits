package ndseeg.goodhabits.utils;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import ndseeg.goodhabits.profile.goodhabit.GoodHabitItem;

@Database(entities = {GoodHabitItem.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract DatabaseDao dao();

    private static AppDatabase appDatabaseInstance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (appDatabaseInstance == null) {
            appDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "AppDatabase").allowMainThreadQueries().build();
        }
        return appDatabaseInstance;
    }

}
