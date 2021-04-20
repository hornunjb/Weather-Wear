package edu.uc.hornunjb.weatherwear.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import edu.uc.hornunjb.weatherwear.dto.Clothing
@Dao
interface ILocalClothingDAO {

    @Query("Select * FROM Recommendations")
    suspend fun getAllRecommendations() : List<Clothing>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertALL(clothing:ArrayList<Clothing>)

    @Delete
    suspend fun delete(Clothing: Clothing)

    //Dynamic Query hopefully using the temperature from our API to get appropriate Clothing
    @Query("Select UID, Name, TempMax, TempMin FROM Recommendations Where TempMin < :temp AND TempMax > :temp")
    suspend fun getClothingByTemp(temp:Double): Clothing

}