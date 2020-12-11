package org.jlariob.listabocadillos;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.jlariob.listabocadillos.dummy.Bocadillo;

import java.util.List;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<Bocadillo> mValues;
    private Context ctx;

    public MyItemRecyclerViewAdapter(Context context, List<Bocadillo> items) {
        mValues = items;
        ctx = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //Rescatamos los datos del elemento position
        holder.mItem = mValues.get(position);

        holder.textViewNombre.setText(holder.mItem.getNombre());
        holder.ratingBarValoracion.setRating(holder.mItem.getValoracion());
        //Para la imagen vamos a usar unalibreria externa de imagenes

        Glide
                .with(ctx)
                .load(holder.mItem.getUrlPhoto())
                .centerCrop()
                .into(holder.imageViewPhotoBocadillo);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewNombre;
        public final ImageView imageViewPhotoBocadillo;
        public final RatingBar ratingBarValoracion;

        public Bocadillo mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewNombre = view.findViewById(R.id.textViewNombre2);
            imageViewPhotoBocadillo = view.findViewById(R.id.fotoBocadillo);
            ratingBarValoracion = view.findViewById(R.id.ratingBarValoracion2);
        }

        @Override
        public String toString() {
            return super.toString() + " '";
        }
    }
}