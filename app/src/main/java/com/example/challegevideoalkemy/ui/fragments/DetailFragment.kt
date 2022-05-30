package com.example.challegevideoalkemy.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.challegevideoalkemy.R
import com.example.challegevideoalkemy.data.retrofit.Constants
import com.example.challegevideoalkemy.databinding.FragmentDetailBinding
import com.example.challegevideoalkemy.domain.model.Movie
import com.example.challegevideoalkemy.ui.viewModel.DetailViewModel
import com.example.challegevideoalkemy.ui.viewModel.HomeViewModel
import com.squareup.picasso.Picasso


class DetailFragment() : Fragment() {


    private lateinit var detailBinding: FragmentDetailBinding


    private val modelDetail: DetailViewModel by viewModels() { HomeViewModel.Factory() }
    private val args : DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        detailBinding = FragmentDetailBinding.bind(view)
        setDetail()

    }



            private fun setDetail () {

                detailBinding.txtTitleDetail.text = "Title: ${args.movieTitle}"
                detailBinding.txtSynopsisDetail.text = args.movieDescription
                detailBinding.txtIdiomaDetail.text = "Lenguaje: ${args.movieLenguaje.uppercase()}"
                detailBinding.txtDurationMovie.text= "Duration: ${args.movieDuration}"
                detailBinding.txtPremiereDetail.text = "Premiere: ${args.moviePremiere}"

                Picasso.get()
                    .load("${Constants.IMG_API_PATH}${args.movieImage}")
                    .placeholder(R.color.purple_200)
                    .into(detailBinding.imageView2)

            }


}

