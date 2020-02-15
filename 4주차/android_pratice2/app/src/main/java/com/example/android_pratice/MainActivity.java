package com.example.android_pratice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
     private Fragment_a fragment_a;
     private Fragment_b fragment_b;
     private Fragment_c fragment_c;
     private FragmentManager fragmentManager;
     private FragmentTransaction fragmentTransaction;
     private  Button buttonA, buttonB, buttonC;//선언한 이름으로 사용하겠다 선언
     ViewPager viewPager;//객체선언
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//메인화면부터 시작점을 잡겠다

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        viewPager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(0);//0번째 레이아웃부터 화면을 잡겠다.


      buttonA = (Button)findViewById(R.id.button_a);
      buttonA.setOnClickListener(movePageListener);
      buttonA.setTag(0);
      buttonB = (Button)findViewById(R.id.button_b);
      buttonB.setOnClickListener(movePageListener);
      buttonB.setTag(1);
      buttonC = (Button)findViewById(R.id.button_c);
      buttonC.setOnClickListener(movePageListener);
      buttonC.setTag(2);

    }

    View.OnClickListener movePageListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            int tag = (int)v.getTag();
            viewPager.setCurrentItem(tag);
        }
    };

    private class pagerAdapter extends FragmentStatePagerAdapter {

        public pagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public pagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new Fragment_a();
                case 1:
                    return new Fragment_b();
                case 2:
                    return new Fragment_c();

                    default:
                        return null;
            }

        }

        @Override
        public int getCount()
        {
            return 3;
        }
    }
}
