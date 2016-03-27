package com.sg.popupslider.example;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;


/**
 * Fragment dialog displaying tab host...
 */
public class FragmentDialog extends DialogFragment
{
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private SectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager viewPager;

    // ------------------------------------------------------------------------
    // public usage
    // ------------------------------------------------------------------------

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState)
    {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        Window window = getDialog().getWindow();
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        int height = metrics.heightPixels;
        int weight = metrics.widthPixels;
        window.setLayout((int) (weight * 0.9), (int) (height * 0.75));
        window.setGravity(Gravity.CENTER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog, container);
        viewPager = (ViewPager)view.findViewById(R.id.pager);
        // tab slider
        sectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager(),viewPager);

        // Set up the ViewPager with the sections adapter.
        viewPager.setAdapter(sectionsPagerAdapter);

        return view;
    }

    // ------------------------------------------------------------------------
    // inner classes
    // ------------------------------------------------------------------------

    /**
     * Used for tab paging...
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter
    {
        ViewPager vp;
        public SectionsPagerAdapter(FragmentManager fm, ViewPager viewPager) {
            super(fm);
            vp = viewPager;

        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                // find first fragment...
                MyTabZero ft0 = new MyTabZero();
                return ft0;
            }
            if (position == 1) {
                // find first fragment...
                MyTabOne ft1 = new MyTabOne();
                return ft1;
            }
            if (position == 2) {
                // find first fragment...
                MyTabTwo ft2 = new MyTabTwo();
                return ft2;
            }
            return null;
        }



        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Tab 0";
                case 1:
                    return "Tab 1";
                case 2:
                    return "Tab 2";

            }
            return null;
        }
    }


}