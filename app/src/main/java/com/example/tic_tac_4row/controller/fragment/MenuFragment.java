package com.example.tic_tac_4row.controller.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tic_tac_4row.R;

public class MenuFragment extends Fragment {
    private Button mButton_onePlayer,mButton_twoPlayer;


    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_menu, container, false);
        findViews(view);
        setListeners();
        return view;
    }
    private void findViews(View view){
        mButton_onePlayer=view.findViewById(R.id.one_player_btn);
        mButton_twoPlayer=view.findViewById(R.id.two_player_btn);
    }
    private void setListeners(){
        mButton_twoPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mButton_onePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}