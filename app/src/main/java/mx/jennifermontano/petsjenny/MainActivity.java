package mx.jennifermontano.petsjenny;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

import mx.jennifermontano.petsjenny.ADAPTER.PageAdaptador;
import mx.jennifermontano.petsjenny.FRAGMENTS.PetPerfilFragment;
import mx.jennifermontano.petsjenny.FRAGMENTS.PetRecyclerViewFragment;
import mx.jennifermontano.petsjenny.MENU_OPCIONES.ActivityAbout;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar   = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        //Validación:
        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }

        //Se manda a llamar al actionbar : APPBAR

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
    }
    //Método para agregar los Fragments a la lista:
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new PetRecyclerViewFragment());
        fragments.add(new PetPerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdaptador(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.doghouse);
        tabLayout.getTabAt(1).setIcon(R.drawable.footprint);
    }

    //Inflar el layout del recurso menu_opciones:
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    //Para controlar las acciones del menú de opciones:

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()){
        case R.id.mAbout:
            Intent intent_a = new Intent(this,ActivityAbout.class);
            startActivity(intent_a);
            break;
        case R.id.mContacto:
            Intent intent_c = new Intent(this,FavoritePets.ActivityContacto.class);
            startActivity(intent_c);
            break;
        case R.id.mFavorite:
            startActivity(new Intent(this, FavoritePets.class));
            break;
    }
        return super.onOptionsItemSelected(item);
    }
}
