package com.example.movies7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movies7.FragmentS.movieS.movieListFragment
import com.example.movies7.databinding.ActivityMainBinding
import com.facebook.drawee.backends.pipeline.Fresco

class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            Fresco.initialize(this)
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flContent, movieListFragment())
                addToBackStack(movieListFragment::javaClass.name)
                commit()
            }
        }
}
