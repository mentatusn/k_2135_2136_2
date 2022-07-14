package com.gb.k_2135_2136_2.view.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.gb.k_2135_2136_2.databinding.FragmentDetailsBinding
import com.gb.k_2135_2136_2.domain.Weather
import com.gb.k_2135_2136_2.viewmodel.details.DetailsFragmentAppState
import com.gb.k_2135_2136_2.viewmodel.details.DetailsViewModel
import kotlinx.android.synthetic.main.activity_webview.*


class DetailsFragment : Fragment() {


    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding
        get() {
            return _binding!!
        }

    lateinit var weatherLocal: Weather

    private val viewModel by lazy {
        ViewModelProvider(this).get(DetailsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }


    // TODO 5 HW  создать DetailsListViewModel + RepositoryRemoteImpl
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weather = arguments?.let { arg ->
            arg.getParcelable<Weather>(BUNDLE_WEATHER_EXTRA)
        }

        weather?.let { weatherLocal ->
            this.weatherLocal = weatherLocal
            viewModel.getWeather(weatherLocal.city.lat, weatherLocal.city.lon)
            viewModel.getLiveData().observe(viewLifecycleOwner) {
                renderData(it)
            }
        }
    }


    // FIXME диссонанс this - как бы приемник?
    private fun renderData(detailsFragmentAppState: DetailsFragmentAppState) {

        when (detailsFragmentAppState) {
            is DetailsFragmentAppState.Error -> {}
            DetailsFragmentAppState.Loading -> {}
            is DetailsFragmentAppState.Success -> {
                with(binding) {
                    val weatherDTO = detailsFragmentAppState.weatherData
                    cityName.text = weatherLocal.city.name
                    temperatureValue.text = weatherDTO.fact.temp.toString()
                    feelsLikeValue.text = weatherDTO.fact.feelsLike.toString()
                    cityCoordinates.text = "${weatherLocal.city.lat}/${weatherLocal.city.lon}"


                    //icon.load("https://c1.staticflickr.com/1/186/31520440226_175445c41a_b.jpg"){
                    /*icon.load(R.drawable.loadingfast){
                        error(R.drawable.ic_earth)
                        placeholder(R.drawable.loadingfast)
                        transformations(CircleCropTransformation())
                    }*/

                    /*Glide.with(this.root)
                        .load("https://freepngimg.com/thumb/city/36275-3-city-hd.png")
                        .into(icon)

                    Picasso.get().load("https://freepngimg.com/thumb/city/36275-3-city-hd.png")
                        .into(icon)*/


                    icon.loadUrl("https://yastatic.net/weather/i/icons/funky/dark/${weatherDTO.fact.icon}.svg")
                }
            }
        }
    }

    fun ImageView.loadUrl(url: String) {

        val imageLoader = ImageLoader.Builder(this.context)
            .componentRegistry{add(SvgDecoder(this@loadUrl.context))}
            .build()

        val request = ImageRequest.Builder(this.context)
            .crossfade(true)
            .crossfade(500)
            .data(url)
            .target(this)
            .build()

        imageLoader.enqueue(request)
    }


    companion object {
        const val BUNDLE_WEATHER_EXTRA = "sgrrdfge"
        fun newInstance(weather: Weather): DetailsFragment {
            val fr = DetailsFragment()

            fr.arguments = Bundle().apply {
                putParcelable(BUNDLE_WEATHER_EXTRA, weather)
                putParcelable(BUNDLE_WEATHER_EXTRA, weather)
            }
            fr.arguments = Bundle().also {
                it.putParcelable(BUNDLE_WEATHER_EXTRA, weather)
                it.putParcelable(BUNDLE_WEATHER_EXTRA, weather)
            }

            return fr
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
