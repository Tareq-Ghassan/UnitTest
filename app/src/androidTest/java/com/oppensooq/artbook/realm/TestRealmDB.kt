package com.oppensooq.artbook.realm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.oppensooq.artbook.data.model.Art
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import com.google.common.truth.Truth.assertThat

@SmallTest
@ExperimentalCoroutinesApi
class TestRealmDB {
    private lateinit var realm: Realm


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setup() {
        val config = RealmConfiguration.Builder(
            schema = setOf(
                Art::class
            )
        ).name("artBook.realm")
            .schemaVersion(1)
            .deleteRealmIfMigrationNeeded()
            .build()
        realm = Realm.open(config)
    }

    fun tearDown() {
        realm.close()
    }

    @Test
    fun testAddArtInDB () = runTest{
        val art = Art("Mona Lisa", "Da Vinci", "1503", "https://cdn.pixabay.com/user/2014/12/02/13-42-55-167_250x250.jpg")
        realm.writeBlocking {
            copyToRealm(art)
        }

        // Query Realm to check if the object was added
        val result = realm.query(Art::class, "name == $0", "Mona Lisa").first().find()

        // Validate that the result is not null and matches the inserted art
        assertThat(result).isNotNull()
        assertThat(result?.name).isEqualTo("Mona Lisa")
        assertThat(result?.artistName).isEqualTo("Da Vinci")
        assertThat(result?.year).isEqualTo("1503")
        assertThat(result?.imageUrl).isEqualTo("https://cdn.pixabay.com/user/2014/12/02/13-42-55-167_250x250.jpg")
    }


    @Test
    fun testDeleteArtInDB() = runTest{
        val art = Art("Mona Lisa", "Da Vinci", "1503", "https://cdn.pixabay.com/user/2014/12/02/13-42-55-167_250x250.jpg")
        realm.writeBlocking {
            copyToRealm(art)
        }
        realm.writeBlocking {
            val cachedArt = query(Art::class, "name == $0", "Mona Lisa").find()
            delete(cachedArt)
        }
        // Query Realm to check if the object was deleted
        val resultDelete = realm.query(Art::class, "name == $0", "Mona Lisa").first().find()

        // Validate that the result is null and deleted
        assertThat(resultDelete).isNull()
    }

}