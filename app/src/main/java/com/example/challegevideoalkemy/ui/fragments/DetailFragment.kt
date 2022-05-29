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
import com.example.challegevideoalkemy.R
import com.example.challegevideoalkemy.databinding.FragmentDetailBinding
import com.example.challegevideoalkemy.domain.model.Movie
import com.example.challegevideoalkemy.ui.viewModel.DetailViewModel
import com.example.challegevideoalkemy.ui.viewModel.HomeViewModel
import com.squareup.picasso.Picasso


class DetailFragment() : Fragment() {


    private lateinit var detailBinding: FragmentDetailBinding

    private val modelDetail: DetailViewModel by viewModels() { HomeViewModel.Factory() }


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


    }

}

