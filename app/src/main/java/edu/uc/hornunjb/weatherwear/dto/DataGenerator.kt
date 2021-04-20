package edu.uc.hornunjb.weatherwear.dto

class DataGenerator {
    companion object {
        fun getUsers(): List<Clothing>{
            return listOf(
                Clothing(1, "Shorts", 60.0, 110.0),
                Clothing(2, "Pants", 0.0, 0.0),
                Clothing(3, "T-Shirt", 70.0, 100.0),
                Clothing(4, "Long Sleeve", 45.0, 60.0),
                Clothing(5, "Wind Breaker", 0.0, 0.0, "Windy"),
                Clothing(6, "Sweater", 30.0, 60.0),
                Clothing(7, "Tank Top", 75.0, 110.0),
                Clothing(8, "Winter Coat", -20.0, 30.0, "Snow"),
                Clothing(9, "Scarf", 0.0, 60.0, "Windy, Snow"),
                Clothing(10, "Earmuffs", -20.0, 40.0, "Windy, Snow")
            )
        }
    }

}