package com.example.movies7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies7.FragmentS.movieS.MoviesViewHolder
import com.example.movies7.Models.Mmodelsi.Resultati
import com.example.movies7.Models.tvModels.ResultA
import com.example.movies7.databinding.MovieitemBinding
import com.example.movies7.databinding.TvitemBinding

class TVadapter(val TvshowsList: MutableList<ResultA>) : RecyclerView.Adapter<TVViewHolder>() {
    private lateinit var itemClickListener: (ResultA, Int) -> Unit
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVViewHolder {

        val binding =
            TvitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVViewHolder(binding)
    }

    fun setOnItemCLickListener(clickListener: (ResultA, Int) -> Unit) {
        itemClickListener = clickListener
    }

    override fun onBindViewHolder(holder: TVViewHolder, position: Int) {
        val movies = TvshowsList[position]
        holder.binding.tvMovieName.text = "Title: \n${movies.name}"
        holder.binding.tvRating.text = movies.vote_average.toString()
        holder.binding.ivImagePoster.setImageURI("https://image.tmdb.org/t/p/w500${movies.poster_path}")
        holder.binding.tvAverageRating.text = "Popularity \n${movies.popularity.toString()}"
        holder.binding.tvReleaseDate.text = "Release Year \n${movies.first_air_date.toString()}"



        holder.binding.tvMovieName.setOnClickListener {
            itemClickListener.invoke(movies,position)
        }
    }

    override fun getItemCount(): Int {
        return TvshowsList.size
    }
    fun updateList(tvShows:List<ResultA>){
        TvshowsList.clear()
        TvshowsList.addAll(tvShows)
        notifyDataSetChanged()
    }
}


class TVViewHolder(val binding: TvitemBinding) :
    RecyclerView.ViewHolder(binding.root) {

}




