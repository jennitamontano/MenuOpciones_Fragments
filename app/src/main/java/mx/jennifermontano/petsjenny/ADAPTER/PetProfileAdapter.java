package mx.jennifermontano.petsjenny.ADAPTER;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.jennifermontano.petsjenny.POJO.Pets;
import mx.jennifermontano.petsjenny.R;

/**
 * Created by Jennifer on 18/10/2017.
 */

public class PetProfileAdapter extends RecyclerView.Adapter<PetProfileAdapter.PerfilViewHolder> {

    ArrayList<Pets> pets;
    Activity activity;

    public PetProfileAdapter(ArrayList<Pets> pets, Activity activity) {
        this.pets       = pets;
        this.activity   = activity;
    }

    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pets_profile_cardview, parent, false);
        return new PerfilViewHolder(view);
        //return null;
    }

    @Override
    public void onBindViewHolder(PetProfileAdapter.PerfilViewHolder perfilViewHolder, int position) {
        final Pets pet = pets.get(position);
        perfilViewHolder.imgPhotoPetProfile.setImageResource(pet.getFoto());
        perfilViewHolder.textViewLike.setText(String.valueOf(pet.getLikes()));
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgPhotoPetProfile;
        private TextView textViewLike;

        public PerfilViewHolder(View itemView) {
            super(itemView);
            imgPhotoPetProfile  = itemView.findViewById(R.id.imgPetProfilePhoto);
            textViewLike        = itemView.findViewById(R.id.tvLike);
        }
    }

}