package com.example.movie.di.inject

import com.example.movie.di.module.ProvideViewModel
import com.example.movie.ui.fragment.search.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/* Install module responsible for providing ViewModel into parent component */
@Module(includes = [ProvideViewModel::class])
abstract class InjectSearchModule {

    /* Install module into subcomponent to have access to bound fragment instance */
    @ContributesAndroidInjector(modules = [
        InjectViewModel::class
    ])
    abstract fun bind(): SearchFragment

}