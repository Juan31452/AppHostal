package com.example.apphostal.Fragments.Lavanderia;

import com.example.apphostal.Activitys.LavanderiaActivity;
import com.example.apphostal.Clases.BaseFragments;
import com.example.apphostal.Entity.Lavanderia;
import com.example.apphostal.Logica.Lavanderia.AdicionarLavanderia;
import com.example.apphostal.R;

public class LavanderiaFragment1 extends BaseFragments<Lavanderia> {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_lavanderia;
    }

    @Override
    protected Class<?> getActivityClass() {
        return LavanderiaActivity.class;
    }

    @Override
    protected Lavanderia createEntity(String fecha, int bajera, int encimera, int fundaA, int protectorA, int nordica, int colchav, int toallaD, int toallaL, int alfombrin, int paid, int protectorC, int rellenoN) {
        return new Lavanderia(fecha, bajera, encimera, fundaA, protectorA, nordica, colchav, toallaD, toallaL, alfombrin, paid, protectorC, rellenoN);
    }

    @Override
    protected void insertEntity(Lavanderia entity) {
        AdicionarLavanderia adicionarLavanderia = new AdicionarLavanderia(getContext());
        adicionarLavanderia.insertarLavanderia(entity);
    }

    public static LavanderiaFragment newInstance() {
        return new LavanderiaFragment();
    }
}

