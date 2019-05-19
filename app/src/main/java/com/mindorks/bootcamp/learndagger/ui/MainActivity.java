package com.mindorks.bootcamp.learndagger.ui;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mindorks.bootcamp.learndagger.HomeFragment;
import com.mindorks.bootcamp.learndagger.MyApplication;
import com.mindorks.bootcamp.learndagger.R;
import com.mindorks.bootcamp.learndagger.di.component.DaggerActivityComponent;
import com.mindorks.bootcamp.learndagger.di.module.ActivityModule;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainViewModel viewModel;

    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDependencies();
        setContentView(R.layout.activity_main);

        TextView tvData = findViewById(R.id.tvData);
        tvData.setText(viewModel.getSomeData());

        getSupportFragmentManager().beginTransaction().add(R.id.fl_fragment_container,new HomeFragment());

    }

    public void getDependencies() {
        DaggerActivityComponent
                .builder()
                .applicationComponent(((MyApplication) getApplication()).applicationComponent)
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);

    }
}
