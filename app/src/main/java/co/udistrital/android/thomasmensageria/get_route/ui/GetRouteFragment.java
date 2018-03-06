package co.udistrital.android.thomasmensageria.get_route.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import co.udistrital.android.thomasmensageria.R;
import co.udistrital.android.thomasmensageria.domain.FirebaseHelper;
import co.udistrital.android.thomasmensageria.entities.Route;

/**
 * A simple {@link Fragment} subclass.
 */
public class GetRouteFragment extends Fragment implements RouteListView{


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbarLayout)
    AppBarLayout appbarLayout;
    @BindView(R.id.recyclerViewContacts)
    RecyclerView recyclerViewContacts;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    Unbinder unbinder;

    private FirebaseHelper helper;
    private List<Route> routes;

    public GetRouteFragment() {
        this.helper = FirebaseHelper.getInstance();
        routes = new ArrayList<>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_get_route, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DatabaseReference routeReference = helper.getRouteReferents();
        routeReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("tag routeRef", dataSnapshot.toString());
               for(DataSnapshot snapshot:
                   dataSnapshot.getChildren()){
                   Route route =  snapshot.getValue(Route.class);
                   routes.add(route);
                   Log.e("tag f", ""+route.getObservacion());

               }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showList() {

    }

    @Override
    public void hideList() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onRouteAdd(Route route) {

    }

    @Override
    public void onRouteRemoved(Route route) {

    }

    @Override
    public void onRouteError(String error) {

    }

   
}
