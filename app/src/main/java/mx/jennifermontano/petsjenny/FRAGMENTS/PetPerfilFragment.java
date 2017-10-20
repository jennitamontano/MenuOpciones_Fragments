package mx.jennifermontano.petsjenny.FRAGMENTS;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.jennifermontano.petsjenny.ADAPTER.PetProfileAdapter;
import mx.jennifermontano.petsjenny.POJO.Pets;
import mx.jennifermontano.petsjenny.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PetPerfilFragment extends Fragment {

    ArrayList<Pets> pets;
    private RecyclerView listPet;
    //private IMascotasFragmentPresenter presenter;
    public PetProfileAdapter adapterProfile;

    public PetPerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_pet_perfil, container, false);
        View v = inflater.inflate(R.layout.fragment_pet_perfil, container, false);
        listPet = v.findViewById(R.id.rvPetPerfil);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        listPet.setLayoutManager(gridLayoutManager);
        beginPetProfile();
        beginAdapter();
        return v;
    }

    public void beginAdapter() {
        adapterProfile = new PetProfileAdapter(pets, getActivity());
        listPet.setAdapter(adapterProfile);
    }

    public void beginPetProfile() {
        pets = new ArrayList<>();
        pets.add(new Pets(R.drawable.perro6, "Kiwi", 2));
        pets.add(new Pets(R.drawable.perro6_ball, "Kiwi con Pelota", 1));
        pets.add(new Pets(R.drawable.perro6_bone, "Kiwi con Hueso", 1));
        pets.add(new Pets(R.drawable.perro6_brushhair, "Kiwi con Cepillo", 1));
        pets.add(new Pets(R.drawable.perro6_house, "Kiwi en Casa", 1));
        pets.add(new Pets(R.drawable.perro6_newspaper, "Kiwi con Periódico", 1));
        pets.add(new Pets(R.drawable.perro6_ribbon, "Kiwi con Moño", 2));
        pets.add(new Pets(R.drawable.perro6_tie, "Kiwi con Corbata", 1));
        pets.add(new Pets(R.drawable.perro6_vaccine, "Kiwi Vacunándose", 0));
    }
}