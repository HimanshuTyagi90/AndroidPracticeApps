package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPageMessengerAdapter extends FragmentStateAdapter {


    public ViewPageMessengerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }



    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0){
            return new ChatFragment();
        }else if(position ==1){
            return new StatusFragment();
        }else{
            return new CallsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return  3;
    }


}
