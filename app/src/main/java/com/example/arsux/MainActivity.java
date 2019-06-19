package com.example.arsux;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

import com.rti.dds.domain.DomainParticipant;
import com.rti.dds.domain.DomainParticipantFactory;
import com.rti.dds.infrastructure.StatusKind;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.measure.unit.NonSI;

import MySupportClasses.DDS_Signal;
import MySupportClasses.FragmentsModel;
import de.nitri.gauge.Gauge;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public Fragment_Home fragment_home;
    public Fragment_ARS fragment_ars;

    public FragmentsModel fragmentsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        fragment_home = new Fragment_Home();

        fragmentsModel = fragment_home.getFragmentsModel();
        fragmentsModel.domainId = 1;
        PhysicsCalculator.initDDS(fragmentsModel);

        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_placeholder, fragment_home);
        ft.commit();


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    switch(item.getItemId()) {
            case R.id.nav_home:
                ft.replace(R.id.fragment_placeholder, getFragment_home());
                break;
            case R.id.nav_ARS_A:
                ft.replace(R.id.fragment_placeholder, getFragment_ars());
                break;
            case R.id.nav_ARS_B:
                break;
            case R.id.nav_OGA:
                break;
            case R.id.nav_Sab:
                break;
            case R.id.nav_WPA:
                break;
            case R.id.nav_UPS:
                break;
            case R.id.nav_HMS:
                break;
            case R.id.nav_consumables:
                break;
            case R.id.nav_power:
                break;
            case R.id.nav_Cybernetics:
                break;
            case R.id.nav_Model:
                break;
            case R.id.nav_about:
                break;
            case R.id.nav_logger:
                break;
            case R.id.nav_exit:
                break;
        }
        ft.commit();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public Fragment_Home getFragment_home() {
        if(fragment_home == null) {
            fragment_home = new Fragment_Home();
            fragment_home.setFragmentsModel(fragmentsModel);
        }
        return fragment_home;
    }
    public Fragment_ARS getFragment_ars() {
        if(fragment_ars == null) {
            fragment_ars = new Fragment_ARS();
            fragment_ars.setFragmentsModel(this.fragmentsModel);
        }
        return fragment_ars;
    }

    public void onSensorClick(View view) {

//        System.out.println("********************** clicked on " + view.getId());
//        System.out.println("********************** clicked on " + R.id.ts02_sensor);
        switch (view.getId()) {
            case R.id.ts02_sensor:
                PhysicsCalculator.displaySchematicItemInfo(fragmentsModel.fAsensorsModel.AR_TS02_TP, this);
                break;
            case R.id.ts21_sensor:
                PhysicsCalculator.displaySchematicItemInfo(fragmentsModel.fAsensorsModel.AR_TS21_TP, this);
                break;
            case R.id.ts20_sensor:
                PhysicsCalculator.displaySchematicItemInfo(fragmentsModel.fAsensorsModel.AR_TS20_TP, this);
                break;
            case R.id.ts19_sensor:
                PhysicsCalculator.displaySchematicItemInfo(fragmentsModel.fAsensorsModel.AR_TS19_TP, this);
                break;
            case R.id.ts01_sensor:
                PhysicsCalculator.displaySchematicItemInfo(fragmentsModel.fAsensorsModel.AR_TS01_TP, this);
                break;
            case R.id.ns01_sensor:
                //PhysicsCalculator.displaySchematicItemInfo(signals.ARS_TS02, this);
                break;
            case R.id.ts04_sensor:
                PhysicsCalculator.displaySchematicItemInfo(fragmentsModel.fAsensorsModel.AR_TS04_TP, this);
                break;
            case R.id.co01_sensor:
                PhysicsCalculator.displaySchematicItemInfo(fragmentsModel.fAsensorsModel.AR_CO01_TP, this);
                break;
            case R.id.dp01_sensor:
                PhysicsCalculator.displaySchematicItemInfo(fragmentsModel.fAsensorsModel.AR_DP_01_TP, this);
                break;
            case R.id.ns02_sensor:
                //PhysicsCalculator.displaySchematicItemInfo(signals.ARS_TS02, this);
                break;
            case R.id.ns03_sensor:
                // PhysicsCalculator.displaySchematicItemInfo(signals.ARS_TS02, this);
                break;
            case R.id.ps02_sensor:
                PhysicsCalculator.displaySchematicItemInfo(fragmentsModel.fAsensorsModel.AR_PS02_TP, this);
                break;
            case R.id.ps01_sensor:
                PhysicsCalculator.displaySchematicItemInfo(fragmentsModel.fAsensorsModel.AR_PS01_TP, this);
                break;
            case R.id.sam_sensor:
                //PhysicsCalculator.displaySchematicItemInfo(signals.ARS_TS02, this);
                break;

        }


    }





}
