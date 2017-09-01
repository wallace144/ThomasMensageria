package co.udistrital.android.thomasmensageria.login.ui;

/**
 * Created by wisuarez on 31/08/2017.
 */

public interface LoginView {
    void enableInputs();
    void disableInputs();
    void showProgress();
    void hidProgress();

    void handleSingIn();

    void navigateToMainScreen();
    void loginError(String error);
}
