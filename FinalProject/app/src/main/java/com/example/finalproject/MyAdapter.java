package com.example.finalproject;

//import androidx.fragment.app.FragmentManager;
//import androidx.lifecycle.Lifecycle;
//import androidx.recyclerview.widget.RecyclerView;
//
//public class MyAdapter extends RecyclerView.Adapter {
//    public MyAdapter(FragmentManager supportFragmentManager, Lifecycle lifecycle) {
//    }
//}

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapter extends FragmentStateAdapter {
    public MyAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new alphabet();
            case 1: return new fruit();
            case 2: return new animal();

        }

        return new alphabet();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
