package co.udistrital.android.thomasmensageria.get_route;

import co.udistrital.android.thomasmensageria.get_route.events.RouteListEvent;

/**
 * Created by wisuarez on 26/02/2018.
 */

public interface RouteListPresenter {


    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();

    void removeRoute(String idRoute);
    void onEventMainThread(RouteListEvent event);


}
