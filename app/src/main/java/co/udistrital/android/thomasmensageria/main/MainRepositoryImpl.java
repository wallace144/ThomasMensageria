package co.udistrital.android.thomasmensageria.main;

import co.udistrital.android.thomasmensageria.domain.FirebaseHelper;
import co.udistrital.android.thomasmensageria.entities.Messenger;
import co.udistrital.android.thomasmensageria.lib.EventBus;
import co.udistrital.android.thomasmensageria.main.events.MainEvent;

/**
 * Created by wisuarez on 26/02/2018.
 */

public class MainRepositoryImpl implements MainRepository {

    private FirebaseHelper helper;
    private EventBus eventBus;

    public MainRepositoryImpl() {
        this.helper = FirebaseHelper.getInstance();
    }

    @Override
    public void updateProfileShow() {

    }

    private void post(String error){
        post(null, error);
    }

    private void post(Messenger user){
        post(user, null);
    }
    private void post(Messenger user, String error){
        MainEvent event = new MainEvent();
        event.setError(error);
        event.setUser(user);
        eventBus.post(event);
    }

    @Override
    public void signoff() {
        helper.signOff();

    }


}
