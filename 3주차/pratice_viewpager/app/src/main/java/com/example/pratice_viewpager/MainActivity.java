package com.example.pratice_viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
      private Viewpager_A viewpager_a;
      private Viewpager_B viewpager_b;
      private Viewpager_C viewpager_c;
      private FragmentManager fragmentManager;
      private FragmentTransaction fragmentTransaction;
     private Button buttonA, buttonB, buttonC;

     ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.view_layout);
        viewPager.setAdapter(new  pagerAdpter(getSupportFragmentManager()));
        viewPager.setCurrentItem(0);

        buttonA = (Button)findViewById(R.id.button1);
        buttonA.setOnClickListener(movePageListener);
        buttonA.setTag(0);
        buttonB = (Button)findViewById(R.id.button2);
        buttonB.setOnClickListener(movePageListener);
        buttonB.setTag(1);
        buttonC = (Button)findViewById(R.id.button3);
        buttonC.setOnClickListener(movePageListener);
        buttonC.setTag(2);
    }

    View.OnClickListener movePageListener  = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int tag = (int) v.getTag();
            viewPager.setCurrentItem(tag);
        }
    };
  private  class pagerAdpter extends FragmentStatePagerAdapter{

      public pagerAdpter(FragmentManager fm,int behavior)
      {
          super(fm,behavior);
      }

      public pagerAdpter(FragmentManager fm) {
          super(fm);
      }

      @NonNull
      @Override
      public Fragment getItem(int position) {
          switch (position){
              case  0:
                  return new Viewpager_A();
              case 1:
                  return new Viewpager_B();
              case 2:
                  return new Viewpager_C();

                  default:
                      return null;
          }
      }

      @Override
      public int getCount() {
          return 3;
      }
  }
}

