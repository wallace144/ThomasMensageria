package co.udistrital.android.thomasmensageria;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;


/**
 * Created by wisuarez on 30/08/2017.
 */

public class ThomasMensageriaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setupFirebase();
    }

    private void setupFirebase() {

        //FirebaseDatabase.getInstance().setPersistenceEnabled(true);//Persistencia en disco
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
