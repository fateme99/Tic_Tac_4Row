package com.example.tic_tac_4row.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tic_tac_4row.R;

public class MainActivity extends AppCompatActivity {
    private Button mButton_tic,mButton_row;
    private FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListeners();



    }
    private void findViews(){
        mButton_tic=findViewById(R.id.tic_btn);
        mButton_row=findViewById(R.id.four_in_row_btn);
        mFragmentManager=getSupportFragmentManager();
    }
    private void setListeners(){
        mButton_tic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=mFragmentManager.findFragmentById(R.id.container_game);
                GameTicFragment gameTicFragment=new GameTicFragment();
                mButton_tic.setClickable(false);
                mButton_row.setClickable(true);
                if (fragment==null){
                    mFragmentManager
                            .beginTransaction()
                            .add(R.id.container_game,gameTicFragment)
                            .commit();

                }
                else {
                    mFragmentManager
                            .beginTransaction()
                            .replace(R.id.container_game,gameTicFragment)
                            .commit();
                }
            }
        });
        mButton_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=mFragmentManager.findFragmentById(R.id.container_game);
                Game4InRowFragment game4InRowFragment=new Game4InRowFragment();
                mButton_row.setClickable(false);
                mButton_tic.setClickable(true);
                if (fragment==null){
                    mFragmentManager
                            .beginTransaction()
                            .add(R.id.container_game,game4InRowFragment)
                            .commit();
                }
                else{
                    mFragmentManager
                            .beginTransaction()
                            .replace(R.id.container_game,game4InRowFragment)
                            .commit();
                }
            }
        });
    }
}