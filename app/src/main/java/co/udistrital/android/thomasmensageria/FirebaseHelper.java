package co.udistrital.android.thomasmensageria;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by wisuarez on 30/08/2017.
 */

public class FirebaseHelper {
    private FirebaseDatabase dataReference;
    private final static String PRODUCT_PATH = "products";
    private final static String ROUTE_PATH = "routes";
    private final static String MESSENGER_PATH = "messengers";

    private final static String FIREBASE_URL = "https://mensajeria-20caa.firebaseio.com";

    public FirebaseHelper() {
        //this.dataReference = new FirebaseDatabase(FIREBASE_URL);
    }

    public FirebaseDatabase getDataReference() {
        return dataReference;
    }
}
