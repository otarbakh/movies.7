import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies7.FragmentS.movieS.MovieDetailsFragment
import com.example.movies7.FragmentS.movieS.MoviesAdapter
import com.example.movies7.FragmentS.movieS.movieListFragment
import com.example.movies7.Models.Mmodelsi.Resultati
import com.example.movies7.Models.tvModels.ResultA
import com.example.movies7.R
import com.example.movies7.TVadapter
import com.example.movies7.api.movieAPI
import com.example.movies7.api.tvAPI
import com.example.movies7.databinding.MovieslistfragmentBinding
import com.example.movies7.databinding.TvlistfragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TVshowListFragment: Fragment() {
    private var _binding: TvlistfragmentBinding? = null

    private val binding get() = _binding!!
    private lateinit var tvadapter: TVadapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = TvlistfragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()


        val popularsApi = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(tvAPI::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val response = popularsApi.getPopularTv("843c612d1207fdec63f0e6a5fd426d68")
            withContext(Dispatchers.Main){
                tvadapter.updateList(response.result)
            }

        }
    }
    private fun setUpRecyclerView() {
        tvadapter = TVadapter(
            mutableListOf()
        ).apply {
            setOnItemCLickListener { tvItem: ResultA, i ->
                parentFragmentManager.beginTransaction().apply {
                    replace(
                        R.id.flContent, MovieDetailsFragment.newInstance(
                            tvItem.name,
                            tvItem.overview,
                            tvItem.poster_path,
                            tvItem.backdrop_path,
                            tvItem.first_air_date,
                            tvItem.vote_average.toString(),
                            tvItem.popularity.toString(),
                            tvItem.vote_count.toString()
                        )
                    )
                    addToBackStack(MovieDetailsFragment::javaClass.name)
                    commit()
                }
            }

        }
        binding.rvMovies.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvMovies.adapter = tvadapter

        binding.bntMovies.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flContent, movieListFragment())
                addToBackStack(movieListFragment::javaClass.name)
                commit()
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}