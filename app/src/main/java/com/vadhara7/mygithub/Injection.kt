package com.vadhara7.mygithub


import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.vadhara7.mygithub.api.GithubService
import com.vadhara7.mygithub.data.GithubRepository
import com.vadhara7.mygithub.db.RepoDatabase
import com.vadhara7.mygithub.ui.ViewModelFactory


/**
 * Class that handles object creation.
 * Like this, objects can be passed as parameters in the constructors and then replaced for
 * testing, where needed.
 */
object Injection {
    private fun provideGithubRepository(context: Context): GithubRepository {
        return GithubRepository(GithubService.create(), RepoDatabase.getInstance(context))
    }

    fun provideViewModelFactory(context: Context, owner: SavedStateRegistryOwner): ViewModelProvider.Factory {
        return ViewModelFactory(owner, provideGithubRepository(context))
    }
}
