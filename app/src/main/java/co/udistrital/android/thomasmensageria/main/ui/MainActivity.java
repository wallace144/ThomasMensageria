package co.udistrital.android.thomasmensageria.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.udistrital.android.thomasmensageria.R;
import co.udistrital.android.thomasmensageria.close_route.CloseRouteFragment;
import co.udistrital.android.thomasmensageria.domain.FirebaseHelper;
import co.udistrital.android.thomasmensageria.get_route.GetRouteFragment;
import co.udistrital.android.thomasmensageria.login.ui.LoginActivity;
import co.udistrital.android.thomasmensageria.services_route.ServicesRouteFragment;
import co.udistrital.android.thomasmensageria.summary_route.SummaryRouteFragment;
import co.udistrital.android.thomasmensageria.validate_route.ValidateRouteFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    /*@BindView(R.id.fab)
    FloatingActionButton fab;*/
    private FirebaseHelper helper;


    public MainActivity() {
        this.helper = FirebaseHelper.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content, new MainFragment()).commit();
        getSupportActionBar().setTitle(R.string.menu_icon_main);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {

            helper.signOff();
            //presenter.signOff();
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_NEW_TASK
                    | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        ActionBar actionBar = getSupportActionBar();
        FragmentManager fragmentManager = getSupportFragmentManager();
        int id = item.getItemId();


        if (id == R.id.main) {
           fragmentManager.beginTransaction().replace(R.id.content, new MainFragment()).commit();
           actionBar.setTitle(R.string.menu_icon_main);
        } else if (id == R.id.get_route) {
            fragmentManager.beginTransaction().replace(R.id.content, new GetRouteFragment()).commit();
            actionBar.setTitle(R.string.menu_icon_get_route);
        } else if (id == R.id.validate_route) {
            fragmentManager.beginTransaction().replace(R.id.content, new ValidateRouteFragment()).commit();
            actionBar.setTitle(R.string.menu_icon_validate_route);
        } else if (id == R.id.services_route) {
            fragmentManager.beginTransaction().replace(R.id.content, new ServicesRouteFragment()).commit();
            actionBar.setTitle(R.string.menu_icon_services_route);
        } else if (id == R.id.summary_route) {
            fragmentManager.beginTransaction().replace(R.id.content, new SummaryRouteFragment()).commit();
            actionBar.setTitle(R.string.menu_icon_summary_route);
        } else if (id == R.id.close_route) {
            fragmentManager.beginTransaction().replace(R.id.content, new CloseRouteFragment()).commit();
            actionBar.setTitle(R.string.menu_icon_close_route);
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
