package com.revolve44.fragment15;

import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.revolve44.fragment15.ui.home.HomeFragment;
import com.revolve44.fragment15.ui.home.HomeViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    HomeViewModel myViewModel;
    Handler handler;
    String lol = "LOL";
    String blyat = "bl";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        handler = new Handler();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment, HomeFragment.newInstance())
                .addToBackStack(null);

        HomeSweetHome();
    }

    public void HomeSweetHome(){

        //Make View Holder Object
        myViewModel= ViewModelProviders.of(this).get(HomeViewModel.class);
        myViewModel.init();
        myViewModel.sendData(lol);
        myViewModel.sendData(blyat);

        // Make thread to send data again
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        myViewModel.sendData("How are You?");
                    }
                });

            }
        }).start();

    }


}
