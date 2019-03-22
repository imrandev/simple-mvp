package com.nerdlogs.simplemvp.di;

import com.nerdlogs.simplemvp.ui.main.MainActivity;
import com.nerdlogs.simplemvp.ui.main.MainModule;
import com.nerdlogs.simplemvp.ui.main.MainViewModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class AppModule {
    @ContributesAndroidInjector(modules = {MainModule.class, MainViewModule.class})
    abstract MainActivity bindMainActivity();
}
