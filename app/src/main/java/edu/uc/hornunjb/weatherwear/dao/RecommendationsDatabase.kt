package edu.uc.hornunjb.weatherwear.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import edu.uc.hornunjb.weatherwear.dto.Clothing
import edu.uc.hornunjb.weatherwear.dto.DataGenerator
import java.util.concurrent.Executors

@Database(entities=arrayOf(Clothing::class), version = 1)
abstract class RecommendationsDatabase : RoomDatabase(){
    abstract fun localClothingDAO() : ILocalClothingDAO

    companion object {
        @Volatile private var instance: RecommendationsDatabase? = null

        fun getInstance(context: Context): RecommendationsDatabase{
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): RecommendationsDatabase {
            return Room.databaseBuilder(context, RecommendationsDatabase::class.java, "Recommendations" )
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        //pre-populate data
                        Executors.newSingleThreadExecutor().execute {
                            instance?.let {
                                it.localClothingDAO().insertALL(DataGenerator.getUsers() as ArrayList<Clothing>)
                            }
                        }
                    }
                })
                .build()

    }
}
}

