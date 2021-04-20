package edu.uc.hornunjb.weatherwear.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Recommendations")
data class Clothing(@PrimaryKey(autoGenerate = true) var UID:Int, var Name:String, var TempMin:Double, var TempMax:Double, var OtherConditions:String? = "N/A")
