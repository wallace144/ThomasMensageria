package co.udistrital.android.thomasmensageria.get_route;

/**
 * Created by wisuarez on 06/03/2018.
 */

public interface RouteListRepository {
    void subscribe();
    void unsubscribe();
    void removeRoute(String idRoute);//Route route
}
