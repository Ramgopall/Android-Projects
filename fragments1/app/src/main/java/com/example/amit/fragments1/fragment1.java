package com.example.amit.fragments1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class fragment1 extends Fragment implements View.OnClickListener {
Button b4;
    FragmentManager fmm;
    FragmentTransaction ftt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_fragment1,container,false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        b4= (Button) getActivity().findViewById(R.id.b4);
        b4.setOnClickListener(this);
        fmm = getFragmentManager();
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getActivity(), "fragment1", Toast.LENGTH_SHORT).show();
        ftt = fmm.beginTransaction();
        ftt.addToBackStack(null);
        ftt.replace(R.id.ll3,new fragment2());
        ftt.commit();
    }
}
