package co.udistrital.android.thomasmensageria.get_route;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import co.udistrital.android.thomasmensageria.R;
import co.udistrital.android.thomasmensageria.domain.FirebaseHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class GetRouteFragment extends Fragment {


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

    public GetRouteFragment() {
        this.helper = FirebaseHelper.getInstance();
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
        routeReference.

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
