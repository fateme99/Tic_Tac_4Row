package com.example.tic_tac_4row.controller.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.tic_tac_4row.R;
import com.example.tic_tac_4row.controller.activity.GameActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MenuFragment extends Fragment {
    private Button mButton_onePlayer,mButton_twoPlayer;
    private static String EXTRA_NAME_PLAYER="com.example.tic_tac_4row_playerName";
    private TextInputLayout mTextInputLayout_name;
    private TextInputEditText mTextInputEditText_name;
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
                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                LayoutInflater inflater=requireActivity().getLayoutInflater();
                View view1=inflater.inflate(R.layout.signup_one,null);
                mTextInputEditText_name=view1.findViewById(R.id.edit_text_name);
                mTextInputLayout_name=view1.findViewById(R.id.edit_layout_name);
                builder.setView(view1)
                        .setPositiveButton(R.string.submit, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent=new Intent(getActivity(), GameActivity.class);
                                intent.putExtra(EXTRA_NAME_PLAYER,mTextInputEditText_name.getText().toString());
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });


    }
}