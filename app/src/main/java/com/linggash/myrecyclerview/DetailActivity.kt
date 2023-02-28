package com.linggash.myrecyclerview

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    private lateinit var detailTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

//        val data = intent.getParcelableExtra<Hero>("DATA")                            // deprecated
        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("DATA", Hero::class.java)
        } else {
            intent.getParcelableExtra<Hero>("DATA")
        }
        detailTextView = findViewById(R.id.tv_detail)
        detailTextView.text = "Detail Data ${data?.name.toString()}"
    }
}