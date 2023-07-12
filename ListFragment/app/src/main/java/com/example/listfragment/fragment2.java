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

public class fragment2 extends ListFragment {


   public String[] primeMinisters = {

            "Jawahar Lal Nehru",
            "Gulzarilal Nanda (Acting)",
            "Lal Bahadur Shastri",
            "Indira Gandhi",
            "Morarji Desai",
            "Charan Singh",
            "Rajiv Gandhi",
            "V.P.Singh",
            "Chandra Shekhar",
            "P.V.Narimha Rao",
            "Atal Bihari Vajpayee",
            "H.D. Deve Gowda",
            "Inder Kumar Gujral",
            "Manmohan Singh",
            "Narendra Modi"
    };

   public String[] primeMinisterDob = {
                "14 November 1889",
           "4 July 1898 ",
           "2 October 1904",
           "19 November 1917",
           "29 February 1896",
           "23 December 1902",
           "20 August 1944",
           "25 June 1931",
           "1 July 1927",
           "28 June 1921",
           "25 December 1924",
           "18 May 1933",
           "4 December 1919",
           "26 September 1932",
           "17 September 1950"
   };

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        return (inflater.inflate(R.layout.fragment2,container,false));
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, primeMinisters));
    }

    public void onListItemClick(@NonNull ListView parent, @NonNull View v, int position, long id){
        Toast.makeText(getActivity(), "You have selected "+primeMinisters[position], Toast.LENGTH_SHORT).show();
    }
}
