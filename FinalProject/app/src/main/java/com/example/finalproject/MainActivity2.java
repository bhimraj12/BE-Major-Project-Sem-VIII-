package com.example.finalproject;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity2 extends AppCompatActivity {

    String tabTitle[] = {"Alphabets", "Fruits", "Animals"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TabLayout t1 = findViewById(R.id.tabLayout);
        ViewPager2 pager2 = findViewById(R.id.viewPager2);
        pager2.setOffscreenPageLimit(3);
        pager2.setAdapter(new MyAdapter(getSupportFragmentManager(), getLifecycle()));

        TabLayoutMediator tm = new TabLayoutMediator(t1, pager2, true,
                (tab, position) -> {
                    tab.setText(tabTitle[position]);
                }
        );
        tm.attach();
    }
}