package com.oppensooq.artbook.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.oppensooq.artbook.data.repository.ArtRepository
import com.oppensooq.artbook.data.repository.ArtRepositoryInterface
import com.oppensooq.artbook.presentation.ui.screens.RootScreen
import com.oppensooq.artbook.presentation.viewmodel.ArtViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val artViewModel: ArtViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RootScreen(artViewModel)
        }
    }

}