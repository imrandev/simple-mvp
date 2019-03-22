package com.nerdlogs.simplemvp.ui.main;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainModule {
    @Binds
    abstract MainContract.Presenter bindMainPresenter(MainPresenter mainPresenter);
}
