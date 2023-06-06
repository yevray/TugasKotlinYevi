package com.project.tugaskotlinyevi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.project.tugaskotlinyevi.HomeFragment
import com.project.tugaskotlinyevi.R
import com.project.tugaskotlinyevi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        gantiTampilanFragment(HomeFragment())

        binding.botnavbar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home ->  gantiTampilanFragment(HomeFragment())
                R.id.animasi ->  gantiTampilanFragment(AnimationFragment(applicationContext))
                else -> {

                }
            }
            true
        }

    }

    private fun gantiTampilanFragment(fragment: Fragment){
        val fragManager = supportFragmentManager
        val fragTrasaction = fragManager.beginTransaction()

        fragTrasaction.replace(R.id.container, fragment)
        fragTrasaction.commit()
    }
}