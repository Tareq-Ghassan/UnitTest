package com.oppensooq.artbook.presentation.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oppensooq.artbook.navigation.ArtBookRoutes
import com.oppensooq.artbook.presentation.ui.theme.ArtBookTheme
import com.oppensooq.artbook.presentation.viewmodel.ArtViewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun RootScreen(artViewModel: ArtViewModel) {
    //ArtsScreen
    val artList by artViewModel.artList.collectAsState()

    //AddArtsScreen
    val selectedImage by artViewModel.selectedImageUrl.collectAsState()

    //SearchImageScreen
    val isLoading by artViewModel.isLoadingState.collectAsState()
    val images by artViewModel.imagesList.collectAsState()

    //RootScreen
    artViewModel.navController = rememberNavController()
    val title by artViewModel.titleState.collectAsState()
    val navController = artViewModel.navController

    ArtBookTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(
                        text = title
                    )
                }, navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                })
            },
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = ArtBookRoutes.ArtsScreen,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(ArtBookRoutes.ArtsScreen) {
                    ArtsScreen(
                        deleteArt = { art ->
                            artViewModel.deleteArt(art)
                        },
                        artList,
                        onNavigateToAdd = {
                            navController.navigate(ArtBookRoutes.AddArtsScreen)
                        },
                    )
                }
                composable(ArtBookRoutes.SearchImageScreen) {
                    SearchImageScreen(
                        images.data?.hits ?: emptyList(),
                        isLoading,
                        searchImage = { searchQuery ->
                            artViewModel.searchImage(searchQuery)
                        },
                        setSelectedImage = { url ->
                            artViewModel.setSelectedImage(url)
                        }
                    )
                }
                composable(ArtBookRoutes.AddArtsScreen) {
                    AddArtsScreen(
                        selectedImage,
                        makeArt = { name, artistName, year ->
                            artViewModel.makeArt(name, artistName, year)
                        },
                        onNavigateToSearch = {
                            navController.navigate(ArtBookRoutes.SearchImageScreen)
                        }
                    )
                }
            }
        }
    }
}