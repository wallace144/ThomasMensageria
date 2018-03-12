package co.udistrital.android.thomasmensageria.get_route;

import co.udistrital.android.thomasmensageria.get_route.events.RouteListEvent;
import co.udistrital.android.thomasmensageria.get_route.ui.RouteListView;
import co.udistrital.android.thomasmensageria.lib.EventBus;
import co.udistrital.android.thomasmensageria.lib.GreenRobotEventBus;

/**
 * Created by wisuarez on 08/03/2018.
 */

public class RouteListPresenterImpl implements RouteListPresenter {

    private RouteListInteractor interactor;
    private RouteListView routeListView;
    private EventBus eventBus;

    public RouteListPresenterImpl(RouteListView routeListView) {
        this.routeListView = routeListView;
        eventBus = GreenRobotEventBus.getInstance();
        this.interactor = new RouteListInteractorImpl();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        routeListView = null;
        eventBus.unregister(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void removeRoute(String idRoute) {

    }

    @Override
    public void onEventMainThread(RouteListEvent event) {

    }
}
