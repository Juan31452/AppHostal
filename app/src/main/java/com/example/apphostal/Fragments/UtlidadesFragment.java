package com.example.apphostal.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apphostal.R;

public class UtlidadesFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_utlidades, container, false);

        return view;
    }

    public static UtlidadesFragment newInstance() {
        UtlidadesFragment fragment = new UtlidadesFragment();
        return fragment;
    }
}