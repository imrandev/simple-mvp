package com.nerdlogs.simplemvp.ui.main;

import com.nerdlogs.simplemvp.adapter.UserAdapter;
import com.nerdlogs.simplemvp.ui.base.BasePresenter;
import com.nerdlogs.simplemvp.ui.base.BaseView;

public class MainContract {
    public interface View extends BaseView<Presenter> {
        void showMessage(String message);
        UserAdapter getAdapterView();
    }

    public interface Presenter extends BasePresenter {
        void addNewUser(String user);
        void deleteUser(String user);
    }
}
