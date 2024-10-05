package com.oppensooq.artbook.presentation.viewmodel

import android.widget.Toast
import androidx.compose.material3.SnackbarHostState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.oppensooq.artbook.data.model.Art
import com.oppensooq.artbook.data.model.ImageResponse
import com.oppensooq.artbook.data.repository.ArtRepositoryInterface
import com.oppensooq.artbook.navigation.ArtBookRoutes
import com.oppensooq.artbook.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtViewModel @Inject constructor(private val repositoryInterface: ArtRepositoryInterface) :
    ViewModel() {

    private val title = MutableStateFlow("")
    val titleState: StateFlow<String> get() = title

    private val arts = MutableStateFlow<List<Art>>(emptyList())
    val artList: StateFlow<List<Art>> get() = arts

    init {
        getArts()
    }

    lateinit var navController: NavHostController

    private val images = MutableStateFlow<Resource<ImageResponse>>(Resource.loading(null))
    val imagesList: StateFlow<Resource<ImageResponse>> get() = images

    private val insetArtMsg = MutableStateFlow<Resource<Art>>(Resource.loading(null))
    val insetArtMessage: StateFlow<Resource<Art>> get() = insetArtMsg

    private val selectedImage = MutableStateFlow("")
    val selectedImageUrl: StateFlow<String> get() = selectedImage

    private val isLoading = MutableStateFlow(false)
    val isLoadingState: StateFlow<Boolean> get() = isLoading


    fun restArtMessage() {
        insetArtMsg.value = Resource.loading(null)
    }

    fun setSelectedImage(url: String) {
        selectedImage.value = url
        navController.popBackStack()
    }

    fun deleteArt(art: Art) = viewModelScope.launch {
        repositoryInterface.deleteArtFromDB(art)
    }

    fun makeArt(name: String, artistName: String, year: String) {
        if (name.isEmpty() || artistName.isEmpty() || year.isEmpty()) {
            insetArtMsg.value = Resource.error("Enter name,artist,year", null)
            showToast(insetArtMsg.value.message)
            return
        }
        try {
            year.toInt()
        } catch (e: Exception) {
            insetArtMsg.value = Resource.error("Year should be number", null)
            showToast(insetArtMsg.value.message)
            return
        }

        val imageUrl = selectedImage.value
        if (imageUrl.isEmpty()) {
            insetArtMsg.value = Resource.error("Please select an image", null)
            showToast(insetArtMsg.value.message)
            return
        }

        val art = Art(name, artistName, year, imageUrl)
        insertArt(art)
        setSelectedImage("")
        insetArtMsg.value = Resource.success(art)
        getArts()
    }

    private fun showToast(message: String?) {
        val safeMessage = message ?: "Unknown error occurred"
        Toast.makeText(navController.context, safeMessage, Toast.LENGTH_SHORT).show()
    }

    fun searchImage(searchQuery: String) {
        if (searchQuery.isEmpty()) {
            return
        }
        images.value = Resource.loading(null)
        isLoading.value = true
        viewModelScope.launch {
            val response = repositoryInterface.getImageAPI(searchQuery)
            images.value = response
            isLoading.value = false

        }
    }

    private fun insertArt(art: Art) = viewModelScope.launch {
        repositoryInterface.addArtToDB(art)
    }

    private fun getArts() {
        arts.value = repositoryInterface.getArtFromDB()
    }

    private fun setAppBarTitle() {
        title.value = "Art Book"
    }
}