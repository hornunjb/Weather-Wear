package edu.uc.hornunjb.weatherwear

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class RecommendationsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendations_list)

        val button = findViewById<ImageButton>(R.id.imgBtnAdd)
        button.setOnClickListener{
            val intent = Intent(this, CreateRecommendationActivity::class.java)
            startActivity(intent)
        }
    }
}