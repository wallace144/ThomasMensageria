package co.udistrital.android.thomasmensageria.get_route;

/**
 * Created by wisuarez on 26/02/2018.
 */

public interface RouteListInteractor {
    void subscribe();
    void unsubscribe();
    void destroyListener();
    void removeRoute(String idRoute);
}
