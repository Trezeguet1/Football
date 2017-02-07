package com.dirmidante.ndd.football.View.Impl;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dirmidante.ndd.football.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FixturesFragment extends Fragment {


    public FixturesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fixtures, container, false);
    }

}
