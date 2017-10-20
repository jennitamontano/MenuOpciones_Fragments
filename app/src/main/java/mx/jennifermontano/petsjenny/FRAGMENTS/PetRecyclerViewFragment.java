package mx.jennifermontano.petsjenny.FRAGMENTS;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

import mx.jennifermontano.petsjenny.ADAPTER.PetsAdapter;
import mx.jennifermontano.petsjenny.POJO.Pets;
import mx.jennifermontano.petsjenny.R;

import static mx.jennifermontano.petsjenny.R.id.rvPets;

/**
 * A simple {@link Fragment} subclass.
 */
public class PetRecyclerViewFragment extends Fragment {

    ArrayList<Pets> pets;
    private RecyclerView petlist;

    public PetRecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_pet_recycler_view, container, false);

        View v = inflater.inflate(R.layout.fragment_pet_recycler_view,container,false);

        petlist=(RecyclerView) v.findViewById(rvPets);

        //LA FORMA EN CÒMO SE MOSTRARÁ EL RECYCLERVIEW:
        LinearLayoutManager linlama= new LinearLayoutManager(getActivity());
        linlama.setOrientation(LinearLayoutManager.VERTICAL);
        petlist.setLayoutManager(linlama);
        beginPetList();
        beginAdapter();

        return v;
    }
    public void beginPetList(){
        pets=new ArrayList<Pets>();

        // Se crean lista con 5 mascotas
        pets.add(new Pets(R.drawable.perro,"Doki",4));
        pets.add(new Pets(R.drawable.perro2,"Tuxie",6));
        pets.add(new Pets(R.drawable.perro3,"Príncipe",3));
        pets.add(new Pets(R.drawable.perro4,"Lucky",3));
        pets.add(new Pets(R.drawable.perro5,"Chiquis",9));
        pets.add(new Pets(R.drawable.perro6,"Kiwi",10));
        pets.add(new Pets(R.drawable.perro7,"Ronny",4));
        pets.add(new Pets(R.drawable.perro8,"Shoko",12));
        pets.add(new Pets(R.drawable.perro9,"Scottie",3));
        pets.add(new Pets(R.drawable.perro10,"Kiara",15));

    }


    public PetsAdapter adaptador;

    public void beginAdapter(){
        PetsAdapter adaptador = new PetsAdapter(pets,getActivity()); //(contactos, getActivity());
        petlist.setAdapter(adaptador);
    }

}
