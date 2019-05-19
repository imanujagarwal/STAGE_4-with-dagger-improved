package com.mindorks.bootcamp.learndagger;

import com.mindorks.bootcamp.learndagger.di.component.ApplicationComponent;
import com.mindorks.bootcamp.learndagger.di.module.ApplicationModule;
import com.mindorks.bootcamp.learndagger.di.scope.FragmentScope;

import dagger.Component;

@FragmentScope
@Component(dependencies = {ApplicationComponent.class}, modules = {HomeFragmentModule.class})
public interface HomeFragmentComponent {

    void Inject(HomeFragment homeFragment);

}
