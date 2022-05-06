package com.example.movies7.FragmentS.movieS

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies7.Models.MovieModels.popularMovie
import com.example.movies7.R
import com.example.movies7.api.movieAPI
import com.example.movies7.databinding.MovieslistfragmentBinding
import com.example.movies7.models.mModels.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class movieListFragment:Fragment() {
    private var _binding: MovieslistfragmentBinding? = null

    private val binding get() = _binding!!
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MovieslistfragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setUpRecyclerView()
        val moviePopularAPI = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(movieAPI::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val response = moviePopularAPI.getPopularMovies("843c612d1207fdec63f0e6a5fd426d68")
            withContext(Dispatchers.Main){
                moviesAdapter.updateList(response.results)
            }
        }
    }
    private fun setUpRecyclerView() {
        moviesAdapter = MoviesAdapter(
            mutableListOf()
        ).apply {
//            setOnItemCLickListener { movieItem: Result, i ->
//                parentFragmentManager.beginTransaction().apply {
//                    replace(
//                        R.id.flContent, MoviesDetailsFragment.newInstance(
//                        movieItem.original_title,
//                        movieItem.overview,
//                        movieItem.poster_path,
//                        movieItem.backdrop_path,
//                        movieItem.release_date,
//                        movieItem.vote_average.toString(),
//                        movieItem.popularity.toString(),
//                        movieItem.vote_count.toString()
//                    )
//                    )
//                    addToBackStack(MoviesDetailsFragment::javaClass.name)
//                    commit()
//                }
//            }

        }
        binding.rvMovies.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvMovies.adapter = moviesAdapter

//        binding.bntTVShows.setOnClickListener {
//            parentFragmentManager.beginTransaction().apply {
//                replace(R.id.flContent, TvShowsListFragment())
//                addToBackStack(TvShowsListFragment::javaClass.name)
//                commit()
//            }
//        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}


