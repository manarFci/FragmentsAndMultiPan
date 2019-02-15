package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macbook on 2/14/19.
 */


public class BodyPartFragment extends Fragment {

    private List<Integer> mImagesIds;
    private int mListIndex;
    private static final String TAG="Body Part Fragment";
    private static final String Image_ID_List="image_ids";
    private static final String List_Index="list_index";


    public BodyPartFragment(){

    }
    public void setmImagesIds(List<Integer> mImagesIds) {
        this.mImagesIds = mImagesIds;
    }
    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(savedInstanceState !=null){
            mImagesIds=savedInstanceState.getIntegerArrayList(Image_ID_List);
            mListIndex=savedInstanceState.getInt(List_Index);

        }
        View rootView=inflater.inflate(R.layout.fragment_body_part,container,false);
        final ImageView imageView=(ImageView) rootView.findViewById(R.id.body_part_image_view);
        if(mImagesIds != null){
            imageView.setImageResource(mImagesIds.get(mListIndex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListIndex < mImagesIds.size()-1){
                        mListIndex++;
                    }
                    else {
                        mListIndex=1;
                    }
                    imageView.setImageResource(mImagesIds.get(mListIndex));
                }
            });

        }
        else {
            Log.v(TAG,"this Fragment hase no Images list");
        }
       // imageView.setImageResource(AndroidImageAssets.getHeads().get(0));
        return rootView;

    }
    //this method to save my cureent state which image in the current index


    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(Image_ID_List, (ArrayList<Integer>) mImagesIds);
        currentState.putInt(List_Index,mListIndex);
    }
}
