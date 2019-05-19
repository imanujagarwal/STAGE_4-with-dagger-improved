package com.mindorks.bootcamp.learndagger;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    @Inject
    HomeViewModel homeViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        injectHomeViewModel();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void injectHomeViewModel(){

        DaggerHomeFragmentComponent.builder()
                .applicationComponent(((MyApplication)getContext().getApplicationContext()).applicationComponent)
                .homeFragmentModule(new HomeFragmentModule(this))
                .build()
                .Inject(this);
    }
}
