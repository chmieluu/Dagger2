package soot.construct.activities.controller;

import android.support.annotation.Nullable;
import android.util.Log;

import javax.inject.Inject;

import soot.construct.activities.BaseController;
import soot.construct.activities.interfaces.LoginInterface;
import soot.construct.activities.sqlite.repository.UserRepository;
import soot.construct.models.User;

/**
 * Created by Kuba on 26.04.2017.
 */

public class LoginController extends BaseController<LoginInterface> {

    @Inject
    LoginController()
    {
        super();
    }
    @Inject
    protected UserRepository mUserRepository;
    private String login;
    private String password;
    private User mUser;

    @Override
    public void onCreate(LoginInterface mView)
    {
        super.onCreate(mView);
        mUser = mUserRepository.findLastLoginUser();
        mUser = mUserRepository.findUserByLogin(login);

    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
    }

    public boolean checkLogin(String login) {
      //  return login.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        //return login.matches("[a-z0-9A-Z]{0,10}");
    return true;
    }

    public boolean checkPassword(String password) {
        //return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$\n");
        //return password.matches("^(?=.*[0-9])(?=.*[a-z])$\n");
            return true;
    }

    public void login(@Nullable String login, @Nullable String password) {
        if (!checkLogin(login)) {
            if (isViewPresent())
                getView().onLoginError();

        } else if (!checkPassword(password)) {
            if (isViewPresent())
                getView().onLoginError();
        } else {
            getView().onLoginSuccess();
            mUser = new User(login, password);
            mUserRepository.create(mUser);
            if (mUserRepository.isEmpty()){
                Log.e("LoginController", "Error Creating User in Repository");
            }
        }


    }
}
