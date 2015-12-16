package com.drabarz.karola.dates;

import android.os.Bundle;
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
    }

    private class StylePagerAdapter extends PagerAdapter {

        int[] drawablesIds = {R.drawable.clothes, R.drawable.clothes, R.drawable.clothes, R.drawable.clothes, R.drawable.clothes};

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView view = (ImageView) LayoutInflater.from(container.getContext()).inflate(R.layout.style_page, container,false);
            view.setImageResource(drawablesIds[position]);
            container.addView(view);
            return view;
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
