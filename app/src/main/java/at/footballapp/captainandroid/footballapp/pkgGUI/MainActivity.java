package at.footballapp.captainandroid.footballapp.pkgGUI;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import at.footballapp.captainandroid.footballapp.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Spinner spPlayer = (Spinner) findViewById(R.id.spPlayer);
        ArrayList<String> player = new ArrayList<String>();
        player.add("Player");
        player.add("Some players");
        ArrayAdapter<String> adapterPlayer = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                player
        );

        spPlayer.setAdapter(adapterPlayer);

        Spinner spMatch = (Spinner) findViewById(R.id.spMatch);
        ArrayList<String> match = new ArrayList<String>();
        match.add("Match");
        match.add("Some matches");
        ArrayAdapter<String> adapterMatch = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                match
        );

        spMatch.setAdapter(adapterMatch);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_addPlayer) {

        } else if (id == R.id.nav_removePlayer) {
            startActivity(new Intent(MainActivity.this, RemovePlayerActivity.class));
        } else if (id == R.id.nav_Profile) {
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        } else if (id == R.id.nav_addMatch) {

        } else if (id == R.id.nav_removeMatch) {
            startActivity(new Intent(MainActivity.this, RemoveMatchActivity.class));
        } else if (id == R.id.nav_updateMatch) {
            startActivity(new Intent(MainActivity.this, UpdateMatchActivity.class));
        } else if (id == R.id.nav_showMatch) {
            startActivity(new Intent(MainActivity.this, MatchActivity.class));
        } else if (id == R.id.nav_showStatistic) {
            startActivity(new Intent(MainActivity.this, StatisticActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
