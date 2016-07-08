package com.demo.talentsearch;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.ListView;

/**
 * Created by NikhilB on 5/23/2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                GridFragment tab1 = GridFragment.newInstance("","");
                return tab1;
            case 1:
                ListFragment tab2 = ListFragment.newInstance("","");
                return tab2;
            case 2:
                InfoFragment tab3 = InfoFragment.newInstance("","");
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
