package mx.jennifermontano.petsjenny.ADAPTER;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Jennifer on 16/10/2017.
 */

public class PageAdaptador extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;

    public PageAdaptador(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    //Devuelve el fragment:
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    //Devuelve el tamaño de la lista de fragments:
    @Override
    public int getCount() {
        return fragments.size();
    }
}
