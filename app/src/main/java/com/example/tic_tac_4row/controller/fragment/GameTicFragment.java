package com.example.tic_tac_4row.controller.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tic_tac_4row.R;
import com.example.tic_tac_4row.model.User;

public class GameTicFragment extends Fragment {
    Button[][] mButtons=new Button[3][3];
    private User mUser1,mUser2;
    public GameTicFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUser1=new User("first user");
        mUser2=new User("second user");
        mUser1.setTurn(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_game_tic, container, false);
        findViews();
        setListeners();
        return view;
    }
    private void findViews(){
        mButtons[0][0]=getActivity().findViewById(R.id.zero_zero_tic);
        mButtons[0][1]=getActivity().findViewById(R.id.zero_one_tic);
        mButtons[0][2]=getActivity().findViewById(R.id.zero_two_tic);

        mButtons[1][0]=getActivity().findViewById(R.id.one_zero_tic);
        mButtons[1][1]=getActivity().findViewById(R.id.one_one_tic);
        mButtons[1][2]=getActivity().findViewById(R.id.one_two_tic);

        mButtons[2][0]=getActivity().findViewById(R.id.two_zero_tic);
        mButtons[2][1]=getActivity().findViewById(R.id.two_one_tic);
        mButtons[2][2]=getActivity().findViewById(R.id.two_two_tic);


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
                            
                        }

                    }
                });
            }
        }
    }
}