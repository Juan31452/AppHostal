package com.example.apphostal.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.apphostal.R;

public class LavanderiaFragment extends Fragment {

   private Button btnMenu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lavanderia, container, false);
        // Inicializar EditTexts y Botones
        btnMenu = view.findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //Obtener el FragmentManager y quitar el fragment actual
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction().remove(LavanderiaFragment.this).commit();
            }
        });
        return view;


    }

    public static LavanderiaFragment newInstance() {
        LavanderiaFragment fragment = new LavanderiaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

}