package ndseeg.goodhabits.utils;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import ndseeg.goodhabits.profile.goodhabit.GoodHabitItem;

@Dao
public interface DatabaseDao {

    @Query("SELECT * FROM goodhabititem")
    public GoodHabitItem[] getAllGoodHabits();

    @Insert
    void insertGoodHabit(final GoodHabitItem goodHabitItem);

    @Delete
    void deleteGoodHabitItem(final GoodHabitItem goodHabitItem);
}
