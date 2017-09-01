package co.udistrital.android.thomasmensageria.login.ui;

/**
 * Created by wisuarez on 01/09/2017.
 */

public interface LoginPresenter {
    void onDestroy();
    void checkForAuthenticatedUser();
    void validateLogin(String email, String password);

}
