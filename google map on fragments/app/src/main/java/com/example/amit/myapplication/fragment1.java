package com.example.amit.myapplication;


import android.app.FragmentTransaction;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class fragment1 extends Fragment implements View.OnClickListener {

Button b1;

    FragmentManager fm = getFragmentManager();
    android.support.v4.app.FragmentTransaction ft;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_fragment1, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        b1= (Button) getActivity().findViewById(R.id.b2);

        b1.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

//        ft = fm.beginTransaction();
//        ft.replace(R.id.tab2,new Main2Activity());
//        ft.commit();



    }




}
