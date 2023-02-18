package com.example.finalproject;

import android.content.Context;
import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link animal#newInstance} factory method to
 * create an instance of this fragment.
 */
public class animal extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    int animal[] = {R.drawable.a0,R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6};
    MediaPlayer mp = new MediaPlayer();
    int itemBackground=0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public animal() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment animal.
     */
    // TODO: Rename and change types and number of parameters
    public static animal newInstance(String param1, String param2) {
        animal fragment = new animal();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_animal, container, false);

        TypedArray a = getActivity().obtainStyledAttributes(R.styleable.MyGallery);
        itemBackground = a.getResourceId(R.styleable.MyGallery_android_galleryItemBackground, 0);
        ImageView iv = v.findViewById(R.id.imageView3);
        iv.setImageResource(animal[0]);

        iv.setBackgroundResource(itemBackground);


        GridView gv = v.findViewById(R.id.gridview2);
        gv.setNumColumns(animal.length);
        gv.setAdapter(new ImageAdapter(getContext()));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                iv.setImageResource(animal[position]);

                int mid = getResources().getIdentifier("a"+position,"raw",getActivity().getPackageName());
                if(mp.isPlaying())
                    mp.stop();
                mp = MediaPlayer.create(getContext(), mid);
                mp.start();
            }
        });

        return v;
    }

    class ImageAdapter extends BaseAdapter {
        Context context;
        public ImageAdapter(Context context) {
            this.context = context;

        }

        @Override
        public int getCount() {
            return animal.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup Parent) {
            ImageView iv = new ImageView(context);
            iv.setImageResource(animal[position]);
            iv.setLayoutParams(new ViewGroup.LayoutParams(200,200));
            iv.setBackgroundResource(itemBackground);


            return iv;
        }
    }
}