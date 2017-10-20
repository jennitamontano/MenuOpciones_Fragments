package mx.jennifermontano.petsjenny.ADAPTER;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.jennifermontano.petsjenny.POJO.Pets;
import mx.jennifermontano.petsjenny.R;

/**
 * Created by Jennifer on 16/10/2017.
 */

public class PetsAdapter  extends RecyclerView.Adapter<PetsAdapter.PetsViewHolder>{

    ArrayList<Pets> pet; //Objeto global
    Activity activity;


    //Se genera el método constructor de PetsAdapter:
    public PetsAdapter(ArrayList<Pets> pet,Activity activity){
        //Se pasa la lista al Objeto global con el método adaptador. Construye la lista de contactos
        this.pet=pet;
        this.activity = activity;
    }

    @Override
    public PetsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.pets_cardview,parent,false);
        return new PetsViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(PetsViewHolder petsViewHolder, int position) {
        final Pets pets= pet.get(position);

        petsViewHolder.imgFoto.setImageResource(pets.getFoto());
        petsViewHolder.tvNombreCV.setText(pets.getNombre());
        petsViewHolder.tvNumBones.setText(pets.getLikes());
        petsViewHolder.imgBone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "LIKE" + pets.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pet.size();
    }

    public class PetsViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private ImageButton imgBone;
        private TextView tvNumBones;
        private ImageButton btnLikeYellow;

        public PetsViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            imgBone = (ImageButton) itemView.findViewById(R.id.imgBone);
            tvNumBones = (TextView) itemView.findViewById((R.id.tvNumBones));
            btnLikeYellow = itemView.findViewById(R.id.btnLikeYellow);
        }
    }
}
