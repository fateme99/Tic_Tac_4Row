package com.example.tic_tac_4row.controller.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.tic_tac_4row.R;
import com.example.tic_tac_4row.model.User;

public class GameTicFragment extends Fragment {
    ImageButton[][] mButtons=new ImageButton[3][3];
    private User mUser1,mUser2,mUser;
    private boolean is_one_player;
    private String player_name;
    private String player_name1;
    private String player_name2;

    public GameTicFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_game_tic, container, false);
        findViews(view);
        setListeners();
        player_name=getActivity().getIntent().getStringExtra(MenuFragment.EXTRA_NAME_PLAYER);
        player_name1=getActivity().getIntent().getStringExtra(MenuFragment.EXTRA_NAME_PLAYER1);
        player_name2=getActivity().getIntent().getStringExtra(MenuFragment.EXTRA_NAME_PLAYER2);
        isOnePlayer();
        return view;
    }
    private void findViews(View view){
        mButtons[0][0]=view.findViewById(R.id.zero_zero_tic);
        mButtons[0][1]=view.findViewById(R.id.zero_one_tic);
        mButtons[0][2]=view.findViewById(R.id.zero_two_tic);

        mButtons[1][0]=view.findViewById(R.id.one_zero_tic);
        mButtons[1][1]=view.findViewById(R.id.one_one_tic);
        mButtons[1][2]=view.findViewById(R.id.one_two_tic);

        mButtons[2][0]=view.findViewById(R.id.two_zero_tic);
        mButtons[2][1]=view.findViewById(R.id.two_one_tic);
        mButtons[2][2]=view.findViewById(R.id.two_two_tic);


    }
    private void setListeners(){
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                final int finalI = i;
                final int finalJ = j;
                mButtons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mButtons[finalI][finalJ].setClickable(false);
                        if (mUser1.isTurn()){
                            mUser1.setTurn(false);
                            mUser2.setTurn(true);
                            mButtons[finalI][finalJ].setBackground(getActivity().getResources().getDrawable(R.drawable.ic_launcher_background));
                        }
                        else {
                            mUser1.setTurn(true);
                            mUser2.setTurn(false);
                            mButtons[finalI][finalJ].setBackgroundResource(R.drawable.ic_launcher_background);
                        }

                    }
                });
            }
        }
    }
    private void isOnePlayer(){
        if (player_name==null){
            is_one_player=false;
            mUser1=new User(player_name1);
            mUser2=new User(player_name2);
            mUser1.setTurn(true);
        }
        else {
            is_one_player=true;
            mUser=new User(player_name);
            mUser.setTurn(true);
        }
    }
}