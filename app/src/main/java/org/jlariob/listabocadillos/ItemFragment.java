package org.jlariob.listabocadillos;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jlariob.listabocadillos.dummy.Bocadillo;



import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class ItemFragment extends Fragment {

    RecyclerView recyclerView;
    MyItemRecyclerViewAdapter adapterBocadillos;
    List<Bocadillo> BocadillosList;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    public ItemFragment() {
    }


    public static ItemFragment newInstance(int columnCount) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            // LISTA DE RESTAURANTES
            BocadillosList = new ArrayList<>();
            BocadillosList.add(new Bocadillo(getString(R.string.pechuga), "https://milrecetas.net/wp-content/uploads/2017/08/recetas-de-bocadillos-3.jpg", 4.5f));
            BocadillosList.add(new Bocadillo(getString(R.string.lomo), "https://www.lapolleriaoviedo.es/wp-content/uploads/2020/03/3.-BOCADILLO-LOMO-Y-QUESO-min-scaled.jpg", 3.0f));
            BocadillosList.add(new Bocadillo(getString((R.string.bravas)),  "https://m1.paperblog.com/i/280/2803184/bocadillo-patatas-bravas-calamares-L-6etVxk.jpeg", 5.0f));

            //Asignamos el recyclerView al adaptador

            adapterBocadillos = new MyItemRecyclerViewAdapter(getActivity() , BocadillosList);
            recyclerView.setAdapter(adapterBocadillos);
        }
        return view;
    }
}