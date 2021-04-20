package edu.uc.hornunjb.weatherwear

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_create_recommendation.*

class CreateRecommendationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_recommendation)

        //Clicking the 'cancel' button will return you to the RecommendationsListActivity
        btnCancel.setOnClickListener{
            val intent = Intent(this, RecommendationsListActivity::class.java)
            startActivity(intent)
        }

    }
}