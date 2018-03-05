package co.udistrital.android.thomasmensageria.main;

import co.udistrital.android.thomasmensageria.domain.FirebaseHelper;

/**
 * Created by wisuarez on 26/02/2018.
 */

public class MainRepositoryImpl implements MainRepository {

    private FirebaseHelper helper;

    public MainRepositoryImpl() {
        this.helper = FirebaseHelper.getInstance();
    }

    @Override
    public void updateProfileShow() {

    }

    @Override
    public void signoff() {
        helper.signOff();

    }


}
