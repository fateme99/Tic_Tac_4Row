package com.example.tic_tac_4row.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.tic_tac_4row.R;
import com.example.tic_tac_4row.controller.fragment.MenuFragment;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment fragment=fragmentManager.findFragmentById(R.id.munu_container);
        if (fragment==null){
            MenuFragment menuFragment=new MenuFragment();

            fragmentManager
                    .beginTransaction()
                    .add(R.id.munu_container,menuFragment)
                    .commit();
        }
    }
}