package com.nerdlogs.simplemvp.ui.main;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainViewModule {
    @Binds
    abstract MainContract.View bindMainView(MainActivity mainActivity);
}
