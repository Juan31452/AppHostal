package com.example.apphostal.Fragments.Lavanderia;

import com.example.apphostal.Activitys.LavanderiaActivity;
import com.example.apphostal.Clases.BaseFragments;
import com.example.apphostal.Logica.Lavanderia.AdicionarLavanderia;
import com.example.apphostal.R;

public class LavanderiaFragment1 extends BaseFragments {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_lavanderia;
    }

    @Override
    protected Class<?> getActivityClass() {
        return LavanderiaActivity.class;
    }

    @Override
    protected AdicionarLavanderia createAdicionarLavanderia() {
        return new AdicionarLavanderia(getContext());
    }

    public static LavanderiaFragment newInstance() {
        return new LavanderiaFragment();
    }
}
