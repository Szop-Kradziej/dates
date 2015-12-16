package com.drabarz.karola.dates;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class StyleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.style_activity);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new StylePagerAdapter());

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private class StylePagerAdapter extends PagerAdapter {

        int[] drawablesIds = {R.drawable.clothes, R.drawable.clothes, R.drawable.clothes, R.drawable.clothes, R.drawable.clothes};
        String[] titles = {"First", "First", "Third", "Last", "Second"};

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView view = (ImageView) LayoutInflater.from(container.getContext()).inflate(R.layout.style_page, container, false);
            view.setImageResource(drawablesIds[position]);
            container.addView(view);
            return view;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }
    }
}
