package com.nerdlogs.simplemvp.ui.main;

import android.support.annotation.NonNull;

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View mMainView;

    MainPresenter(@NonNull MainContract.View mainView) {
        this.mMainView = mainView;
        mMainView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void addNewUser(String user) {
        mMainView.getAdapterView().addUser(user);
        mMainView.showMessage("Added New User!");
    }

    @Override
    public void deleteUser(String user) {
        mMainView.getAdapterView().removeUser(user);
        mMainView.showMessage("Deleted User!");
    }
}
