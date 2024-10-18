package com.oppensooq.artbook.presentation.viewmodel

import androidx.navigation.NavHostController
import com.google.common.truth.Truth.assertThat
import com.oppensooq.artbook.data.repository.FakeArtRepository
import com.oppensooq.artbook.util.Status
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class ArtViewModelTest {

    lateinit var viewModel: ArtViewModel
    private lateinit var mockNavController: NavHostController

    @Before
    fun setup() {
        // Test Doubles (Fakes)
        mockNavController = mock()
        viewModel = ArtViewModel(FakeArtRepository())
        viewModel.navController = mockNavController
    }

    @Test
    fun `insert art without year returns error`() = runTest {
        viewModel.makeArt("Mona Lisa", "Da Vinci", "")
        val value = viewModel.insetArtMessage.first()
        assertThat(value.status).isEqualTo(Status.ERROR)

    }

    @Test
    fun `insert art without name returns error`() = runTest {
        viewModel.makeArt("", "Da Vinci", "2020")
        val value = viewModel.insetArtMessage.first()
        assertThat(value.status).isEqualTo(Status.ERROR)

    }
    @Test
    fun `insert art without artistName returns error`()= runTest {
        viewModel.makeArt("Mona Lisa", "", "2020")
        val value = viewModel.insetArtMessage.first()
        assertThat(value.status).isEqualTo(Status.ERROR)

    }


}