package com.example.android.android_me.ui;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by macbook on 2/15/19.
 */

public class MasterLisFragment extends Fragment {
 // Mandatory empty constructor
    public MasterLisFragment() {
    }

    // Inflates the GridView of all AndroidMe images
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        // Get a reference to the GridView in the fragment_master_list xml layout file
        GridView gridView = (GridView) rootView.findViewById(R.id.images_grid_view);

        // Create the adapter
        // This adapter takes in the context and an ArrayList of ALL the image resources to display
        MasterListAdapter mAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());

        // Set the adapter on the GridView
        gridView.setAdapter(mAdapter);

        // Return the root view
        return rootView;
    }

}
