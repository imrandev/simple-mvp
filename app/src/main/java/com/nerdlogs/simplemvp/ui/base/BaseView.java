package com.nerdlogs.simplemvp.ui.base;

public interface BaseView<T> {
    void setPresenter(T presenter);
    void showMessage(String message);
}
