package soot.construct.activities.interfaces;

/**
 * Created by Kuba on 24.05.2017.
 */

public interface LoginInterface {

    void onLoginSuccess();
    void onLoginError();
//    void setProgresViewState();
    void showToast(String message);
}
