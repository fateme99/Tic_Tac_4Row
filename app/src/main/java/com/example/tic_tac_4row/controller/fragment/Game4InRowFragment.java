package com.example.tic_tac_4row.controller.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tic_tac_4row.R;
import com.example.tic_tac_4row.model.User;
import com.google.android.material.snackbar.Snackbar;

public class Game4InRowFragment extends Fragment {

    ImageView[][] mButtons=new ImageButton[5][5];
    int[][] mArrey_for_check=new int[5][5];
    private TextView mTextView_snackBar;
    private boolean is_one_player;
    private boolean player_one_turn=true;
    private String player_name1;
    private User mUser1,mUser2,mUser;
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
        findViews(view);
        setListeners();
        player_name=getActivity().getIntent().getStringExtra(MenuFragment.EXTRA_NAME_PLAYER);
        player_name1=getActivity().getIntent().getStringExtra(MenuFragment.EXTRA_NAME_PLAYER1);
        player_name2=getActivity().getIntent().getStringExtra(MenuFragment.EXTRA_NAME_PLAYER2);
        isOnePlayer();

        return view;
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
    private void findViews(View view){
        mButtons[0][0]=view.findViewById(R.id.zero_zero);
        mButtons[0][1]=view.findViewById(R.id.zero_one);
        mButtons[0][2]=view.findViewById(R.id.zero_two);
        mButtons[0][3]=view.findViewById(R.id.zero_three);
        mButtons[0][4]=view.findViewById(R.id.zero_four);

        mButtons[1][0]=view.findViewById(R.id.one_zero);
        mButtons[1][1]=view.findViewById(R.id.one_one);
        mButtons[1][2]=view.findViewById(R.id.one_two);
        mButtons[1][3]=view.findViewById(R.id.one_three);
        mButtons[1][4]=view.findViewById(R.id.one_four);

        mButtons[2][0]=view.findViewById(R.id.two_zero);
        mButtons[2][1]=view.findViewById(R.id.two_one);
        mButtons[2][2]=view.findViewById(R.id.two_two);
        mButtons[2][3]=view.findViewById(R.id.two_three);
        mButtons[2][4]=view.findViewById(R.id.two_four);

        mButtons[3][0]=view.findViewById(R.id.three_one);
        mButtons[3][1]=view.findViewById(R.id.three_one);
        mButtons[3][2]=view.findViewById(R.id.three_two);
        mButtons[3][3]=view.findViewById(R.id.three_three);
        mButtons[3][4]=view.findViewById(R.id.three_four);

        mButtons[4][0]=view.findViewById(R.id.four_zero);
        mButtons[4][1]=view.findViewById(R.id.four_one);
        mButtons[4][2]=view.findViewById(R.id.four_two);
        mButtons[4][3]=view.findViewById(R.id.four_three);
        mButtons[4][4]=view.findViewById(R.id.four_four);

        mTextView_snackBar=view.findViewById(R.id.snackBar_container);
    }
    private void setListeners(){
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <5 ; j++) {
                final int finalI = i;
                final int finalJ = j;
                mButtons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mButtons[finalI][finalJ].setClickable(false);
                        if (mUser1.isTurn()){
                            mUser1.setTurn(false);
                            mUser2.setTurn(true);
                            mButtons[finalI][finalJ].setImageResource(R.drawable.ic_circle1);
                            mArrey_for_check[finalI][finalJ]=1;
                            if (checkFinish(finalI,finalJ)){
                                Snackbar.make(mTextView_snackBar,"Game Over "+player_name1+" wone!",Snackbar.LENGTH_LONG).show();
                                getActivity().finish();
                            }

                        }
                        else {
                            mUser1.setTurn(true);
                            mUser2.setTurn(false);
                            mButtons[finalI][finalJ].setImageResource(R.drawable.ic_circle2);
                            mArrey_for_check[finalI][finalJ]=2;
                            if (checkFinish(finalI,finalJ)){
                                Snackbar.make(mTextView_snackBar,"Game Over "+player_name2+" wone!",Snackbar.LENGTH_LONG).show();
                                getActivity().finish();
                            }
                        }



                    }
                });
            }
        }
    }
    private boolean checkFinish(int i , int j){
        int sum=0;
        for (int k = 1; k <=5 ; k++) {
            if (mArrey_for_check[(i+k)%5][j]==mArrey_for_check[i][j])
                sum++;
        }
        if (sum>=4){
            return true;
        }
        sum=0;
        for (int k = 1; k <=5 ; k++) {
            if (mArrey_for_check[i][(j+k)%5]==mArrey_for_check[i][j])
                sum++;
        }
        if (sum>=4){
            return true;
        }
        sum=0;
        for (int k = 1; k <=5 ; k++) {
            if (mArrey_for_check[(i+k)%5][(j+k)%5]==mArrey_for_check[i][j])
                sum++;
        }
        if (sum>=4){
            return true;
        }

        return false;
    }
}