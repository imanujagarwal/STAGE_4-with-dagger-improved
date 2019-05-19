package com.mindorks.bootcamp.learndagger;

import android.content.Context;

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.di.qualifier.ActivityContext;
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper;

import androidx.fragment.app.Fragment;
import dagger.Module;
import dagger.Provides;

@Module
public class HomeFragmentModule {

    Fragment fragment;

    HomeFragmentModule(Fragment fragment){
        this.fragment =  fragment;
    }

//    @Provides
//    HomeViewModel providesHomeViewModel(DatabaseService databaseService, NetworkService networkService, NetworkHelper networkHelper){
//        return  new HomeViewModel(databaseService, networkService, networkHelper);
//    }

    @ActivityContext
    @Provides
    Context providesContext() {
        return fragment.getContext();
    }
}
