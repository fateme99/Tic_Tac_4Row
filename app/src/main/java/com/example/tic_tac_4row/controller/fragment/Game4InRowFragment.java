package com.example.tic_tac_4row.controller.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tic_tac_4row.R;

public class Game4InRowFragment extends Fragment {

    private boolean is_one_player;
    private boolean player_one_turn=true;
    private String player_name1;
    private String player_name2;
    private String player_name;
    public Game4InRowFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_game4_in_row, container, false);
        player_name=getActivity().getIntent().getStringExtra(MenuFragment.EXTRA_NAME_PLAYER);
        player_name1=getActivity().getIntent().getStringExtra(MenuFragment.EXTRA_NAME_PLAYER1);
        player_name2=getActivity().getIntent().getStringExtra(MenuFragment.EXTRA_NAME_PLAYER2);
        isOnePlayer();
        return view;
    }
    private void isOnePlayer(){
        if (player_name==null){
            is_one_player=false;
        }
        else {
            is_one_player=true;
        }
    }
}