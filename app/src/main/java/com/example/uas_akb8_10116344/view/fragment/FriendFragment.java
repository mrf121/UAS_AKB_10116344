package com.example.uas_akb8_10116344.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ilham.uas.R;
import com.example.ilham.uas.model.FriendModel;
import com.example.ilham.uas.model.RealmHelper;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

//Nama  : Ilham Maulana Pratama
//NIM   : 10116335
//KLS   : IF 8
//TGL   : 3 Agustus 2019

public class FriendFragment extends Fragment {
    Realm realm;
    RealmHelper realmHelper;
    RecyclerView recyclerView;
    FriendAdapter friendAdapter;
    //FriendModel friendModel;
    List<FriendModel> friendModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_friend_fragment, container, false);
        return view;

    }


    public void onViewCreated(View view, Bundle savedInstanceState) {
        //TextView textView = (TextView) view.findViewById(R.id.textVIewFriend);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // Setup Realm
        Realm.init(view.getContext());
        realm = Realm.getDefaultInstance();
        // RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        //realm = Realm.getInstance(configuration);

        realmHelper = new RealmHelper(realm);

        //friendModel = new ArrayList<>();

        //friendModel = realmHelper.getAllFriend();


        List<FriendModel> friendModel = new ArrayList<>();

        friendModel = realmHelper.getAllFriend();

        friendAdapter = new FriendAdapter(getContext(), friendModel);
        recyclerView.setAdapter(friendAdapter);
       // show();
    }
    //public void show() {
        //friendAdapter = new FriendAdapter(getContext(), friendModel);
       // recyclerView.setAdapter(friendAdapter);
    //}
}
   /** public void onViewCreated(View view, Bundle savedInstanceState) {
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        TextView textView = (TextView) view.findViewById(R.id.textVIewFriend);
        Realm.init(getContext());
        Realm realm = Realm.getDefaultInstance();
        RealmResults<FriendModel> results = realm.where(FriendModel.class).findAll();
        String text = "";
        for (FriendModel c:results){
            text = text+"NIM :"+c.getNim()+"\n";
            text = text+"Nama :"+c.getNama()+"\n";
            text = text+"Kelas :"+c.getKelas()+"\n";
            text = text+"Telp :"+c.getTelp()+"\n";
            text = text+"Email :"+c.getEmail()+"\n";
            text = text+"Instagram :"+c.getSosmed()+"\n\n";
        }
        textView.setText(text);
    }

}
    */
