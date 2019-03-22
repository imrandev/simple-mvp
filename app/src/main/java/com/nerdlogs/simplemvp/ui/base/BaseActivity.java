package com.nerdlogs.simplemvp.ui.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

@SuppressLint("Registered")
public abstract class BaseActivity extends AppCompatActivity {

    private BasePresenter basePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
    }

    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void setBasePresenter(BasePresenter presenter) {
        basePresenter = presenter;
    }

    public abstract  @LayoutRes int setLayout();
}
