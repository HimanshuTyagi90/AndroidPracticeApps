package com.example.listfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

public class fragment1 extends ListFragment {

    String [] presidents ={
            "Dr. Rajendra Prasad",
            "Dr Sarvepalli Radhakrishnan",
            "Dr Zakir Hussain",
            "Varahagiri Venkata Giri",
            "Mohammad Hidayatullah",
            "Varahagiri Venkata Giri",
            "Fakhruddin Ali Ahmed",
            "Basappa Danappa Jatti",
            "Neelam Sanjiva Reddy",
            "Giani Zail Singh",
            "Ramaswamy Venkataraman",
            "Shankar Dayal Sharma",
            "Kocheril Raman Narayanan",
            "Dr. A.P.J. Abdul Kalam",
            "Pratibha Patil",
            "Pranab Mukherjee",
            "Shri Ram Nath Kovind",
            "Droupadi Murmu"
    };

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        return (inflater.inflate(R.layout.fragment1,container,false));
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, presidents));
    }

    public void onListItemClick(@NonNull ListView parent, @NonNull View v, int position, long id){
        Toast.makeText(getActivity(), "You have selected "+presidents[position], Toast.LENGTH_SHORT).show();
    }
}
