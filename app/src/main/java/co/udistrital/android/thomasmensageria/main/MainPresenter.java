package co.udistrital.android.thomasmensageria.main;

import co.udistrital.android.thomasmensageria.main.events.MainEvent;

/**
 * Created by wisuarez on 26/02/2018.
 */

public interface MainPresenter {
    void signOff();
    void onEventMainThread(MainEvent event);
}
