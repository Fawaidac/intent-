package com.kelurahankepuharjo.atry;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.kelurahankepuharjo.atry.databinding.ActivityHomepageBinding;

public class HomepageActivity extends AppCompatActivity {

    private ActivityHomepageBinding homepageBinding;
    private UserSessions userSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        homepageBinding = ActivityHomepageBinding.inflate(getLayoutInflater());
        setContentView(homepageBinding.getRoot());
        replaceFragment(new HomeFragment());

        homepageBinding.navView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.navigation_home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.nav_pengajuan:
                    replaceFragment(new PengajuanFragment());
                    break;
                case R.id.navigation_status:
                    replaceFragment(new StatusFragment());
                    break;
            }
            return  true;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_homepage, fragment);
        fragmentTransaction.commit();
    }
}