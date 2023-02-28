package com.linggash.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    private lateinit var detailTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<Hero>("DATA")
        detailTextView = findViewById(R.id.tv_detail)
        detailTextView.text = "Detail Data ${data?.name.toString()}"
    }
}