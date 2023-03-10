package com.linggash.myrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.linggash.myrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private lateinit var rvHeroes: RecyclerView                             // changed with binding
    private val list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        rvHeroes = findViewById(R.id.rv_heroes)                               // changed with binding
        binding.rvHeroes.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_list -> {
//                rvHeroes.layoutManager = LinearLayoutManager(this)                // changed with binding
                binding.rvHeroes.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
//                rvHeroes.layoutManager = GridLayoutManager(this, 2)               // changed with binding
                binding.rvHeroes.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListHeroes(): ArrayList<Hero> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listHero = ArrayList<Hero>()
        for (i in dataName.indices) {
            val hero = Hero(dataName[i], dataDescription[i], dataPhoto[i])
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
//        rvHeroes.layoutManager = LinearLayoutManager(this)                                          // changed with binding
        binding.rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list) {
            Toast.makeText(this, "Kamu memilih " + it.name, Toast.LENGTH_SHORT).show()
            val intentToDetail = Intent(this, DetailActivity::class.java)
            intentToDetail.putExtra("DATA", it)
            startActivity(intentToDetail)
        }
//        rvHeroes.adapter = listHeroAdapter                                                          // changed with binding
        binding.rvHeroes.adapter = listHeroAdapter
//
//        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {       // changed with lambda
//            override fun onItemClicked(data: Hero) {
//                showSelectedHero(data)
//            }
//        })
    }

//    private fun showSelectedHero(hero: Hero) {
//        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()                // changed with lambda
//    }
}