package co.udistrital.android.thomasmensageria.main;

import android.util.Log;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import co.udistrital.android.thomasmensageria.domain.FirebaseHelper;
import co.udistrital.android.thomasmensageria.entities.Messenger;
import co.udistrital.android.thomasmensageria.lib.EventBus;
import co.udistrital.android.thomasmensageria.lib.GreenRobotEventBus;
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
        String currentEmail =helper.getAuthUserEmail().toString();
        DatabaseReference profile = helper.getUserReferents(currentEmail);

        profile.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Messenger messenger = dataSnapshot.getValue(Messenger.class);
                post(messenger);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                post(databaseError.toString());
            }
        });

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
        eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(event);
    }

    @Override
    public void signoff() {
        helper.signOff();

    }


}
