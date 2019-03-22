package com.nerdlogs.simplemvp.ui.main;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    MainContract.Presenter provideMainPresenter(MainContract.View mainView){
        return new MainPresenter(mainView);
    }
}
