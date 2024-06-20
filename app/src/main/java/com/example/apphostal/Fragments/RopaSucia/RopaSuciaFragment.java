package com.example.apphostal.Fragments.RopaSucia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.apphostal.Fragments.Registros.ConsultaPorFechasFragment;
import com.example.apphostal.R;


public class RopaSuciaFragment extends Fragment {

    private Button btnFragmentCerrar;

    public RopaSuciaFragment() {
        // Required empty public constructor
    }



    public static RopaSuciaFragment newInstance() {
        RopaSuciaFragment fragment = new RopaSuciaFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ropa_sucia, container, false);

        btnFragmentCerrar = view.findViewById(R.id.btnFragmentCerrar);

        btnFragmentCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction().remove(RopaSuciaFragment.this).commit();
            }
        });
        return view;
    }
}