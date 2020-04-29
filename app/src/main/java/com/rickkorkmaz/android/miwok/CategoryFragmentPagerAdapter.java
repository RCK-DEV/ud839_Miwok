package com.rickkorkmaz.android.miwok;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class CategoryFragmentPagerAdapter extends FragmentPagerAdapter {


    public CategoryFragmentPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new NumbersFragment();
            case 1: return new FamilyFragment();
            case 2: return new ColorsFragment();
            case 3: return new PhrasesFragment();
            default: return new NumbersFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "Numbers";
            case 1: return "Family";
            case 2: return "Colors";
            case 3: return "Phrases";
            default: return "Numbers";
        }
    }
}
