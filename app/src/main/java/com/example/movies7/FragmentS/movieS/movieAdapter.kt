package com.example.movies7.FragmentS.movieS

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies7.databinding.MovieitemBinding
import com.example.movies7.models.mModels.Result

class MoviesAdapter(val movieList: MutableList<Result>) : RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding =
            MovieitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }
    fun updateList(movies:List<Result>){
        movieList.clear()
        movieList.addAll(movies)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movieList[position]
        holder.binding.tvMovieName.text = "title: \n${movie.original_title}"
        holder.binding.tvRating.text = movie.vote_average.toString()
        holder.binding.ivImagePoster.setImageURI("https://image.tmdb.org/t/p/w500${movie.poster_path}")
        holder.binding.tvReleaseDate.text = "release date: \n${movie.release_date}"
        holder.binding.tvAverageRating.text = "total votes: \n${movie.vote_count.toString()}"

//        holder.binding.tvMovieName.setOnClickListener {
//            itemClickListener.invoke(movie,position)
//        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}


class MoviesViewHolder(val binding: MovieitemBinding) :
    RecyclerView.ViewHolder(binding.root) {

}