package co.udistrital.android.thomasmensageria.main;

import org.greenrobot.eventbus.Subscribe;

import co.udistrital.android.thomasmensageria.lib.EventBus;
import co.udistrital.android.thomasmensageria.lib.GreenRobotEventBus;
import co.udistrital.android.thomasmensageria.main.events.MainEvent;
import co.udistrital.android.thomasmensageria.main.ui.MainView;

/**
 * Created by wisuarez on 26/02/2018.
 */

public class MainPresenterImpl  implements MainPresenter{

    private MainInteractor mainInteractor;
    private MainView mainView;
    private EventBus eventBus;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        eventBus = GreenRobotEventBus.getInstance();
        mainInteractor = new MainInteractorImpl();
    }


    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        this.mainView = null;
        eventBus.unregister(this);

    }

    @Override
    public void signOff() {
        mainInteractor.signOff();
    }

    @Override
    public void updateProfileShow() {
        mainInteractor.updateProfileShow();
    }

    @Override  @Subscribe
    public void onEventMainThread(MainEvent event) {

        if(this.mainView !=  null){
            mainView.setUser(event.getUser());
        }

    }
}
