package co.udistrital.android.thomasmensageria.main;

import org.greenrobot.eventbus.Subscribe;

import co.udistrital.android.thomasmensageria.main.events.MainEvent;

/**
 * Created by wisuarez on 26/02/2018.
 */

public class MainPresenterImpl  implements MainPresenter{
    @Override
    public void signOff() {

    }

    @Override  @Subscribe
    public void onEventMainThread(MainEvent event) {

    }
}
