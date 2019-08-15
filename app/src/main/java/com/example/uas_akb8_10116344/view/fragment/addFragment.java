package com.example.uas_akb8_10116344.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ilham.uas.R;
import com.example.ilham.uas.model.FriendModel;
import com.example.ilham.uas.model.RealmHelper;

import io.realm.Realm;

//Nama  : Ilham Maulana Pratama
//NIM   : 10116335
//KLS   : IF 8
//TGL   : 3 Agustus 2019
public class addFragment extends Fragment implements View.OnClickListener{

    // Required empty public constructor
    Realm realm;
    EditText nim, nama, kelas, telp, email, sosmed;
    Button simpan, batal;
    RealmHelper realmHelper;
    FriendModel friendModel;

    public addFragment() {
        // Required empty public constructor
    }

/**    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    public void onViewCreated(View view,Bundle savedInstanceState){


        Button simpan = (Button) view.findViewById(R.id.btnSimpan);
        Button batal = (Button) view.findViewById(R.id.btnBatal);
        nim = (EditText) view.findViewById(R.id.editTextNim);
        nama = (EditText) view.findViewById(R.id.editTextNama);
        kelas = (EditText) view.findViewById(R.id.editTextKls);
        telp = (EditText) view.findViewById(R.id.editTextTlp);
        email = (EditText) view.findViewById(R.id.editTextEmail);
        sosmed = (EditText) view.findViewById(R.id.editTextSosmed);

        Realm.init(view.getContext());
        realm = Realm.getDefaultInstance();

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.beginTransaction();

                FriendModel friendModel = realm.createObject(FriendModel.class,nim.getText().toString());
                friendModel.setNim(nim.getText().toString());
                friendModel.setNama(nama.getText().toString());
                friendModel.setKelas(kelas.getText().toString());
                friendModel.setTelp(telp.getText().toString());
                friendModel.setEmail(email.getText().toString());
                friendModel.setSosmed(sosmed.getText().toString());


                //realmHelper = new RealmHelper(realm);
                //realmHelper.save(friendModel);
                realm.commitTransaction();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());

                // set title dialog
                alertDialogBuilder.setTitle("Berhasil Disimpan");
                alertDialogBuilder
                        .setIcon(R.mipmap.ic_launcher)
                        .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // do something
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();

                // menampilkan alert dialog
                alertDialog.show();
                nim.setText("");
                nama.setText("");
                kelas.setText("");
                telp.setText("");
                email.setText("");
                sosmed.setText("");

            }

        });




        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent i = new Intent(AddFriendFragment.this,Test.class);
                //startActivity(i);
            }
        });

    }
}
*/

 @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container,
                          Bundle savedInstanceState) {
     // Inflate the layout for this fragment
     return inflater.inflate(R.layout.fragment_add, container, false);
 }

 public void onViewCreated(View view,Bundle savedInstanceState) {


     simpan = view.findViewById(R.id.btnSimpan);
     batal =  view.findViewById(R.id.btnBatal);
     nim =  view.findViewById(R.id.editTextNim);
     nama =  view.findViewById(R.id.editTextNama);
     kelas =  view.findViewById(R.id.editTextKls);
     telp =  view.findViewById(R.id.editTextTlp);
     email =  view.findViewById(R.id.editTextEmail);
     sosmed =  view.findViewById(R.id.editTextSosmed);

     Realm.init(view.getContext());
     //RealmConfiguration configuration = new RealmConfiguration.Builder().build();
     realm = Realm.getDefaultInstance();

     simpan.setOnClickListener(this);
 }
    public void onClick(View v){
                if (v == simpan){

                    nim.getText().toString();
                    nama.getText().toString();
                    kelas.getText().toString();
                    telp.getText().toString();
                    email.getText().toString();
                    sosmed.getText().toString();


                    if (!nim.equals("")){
                        friendModel = new FriendModel();
                        friendModel.setNim(nim.getText().toString());
                        friendModel.setNama(nama.getText().toString());
                        friendModel.setKelas(kelas.getText().toString());
                        friendModel.setTelp(telp.getText().toString());
                        friendModel.setEmail(email.getText().toString());
                        friendModel.setSosmed(sosmed.getText().toString());


                        //realm.commitTransaction();
                        realmHelper = new RealmHelper(realm);
                        realmHelper.save(friendModel);

                        Toast.makeText(getContext(), "Berhasil Disimpan!", Toast.LENGTH_SHORT).show();

                        nim.setText("");
                        nama.setText("");
                        kelas.setText("");
                        telp.setText("");
                        email.setText("");
                        sosmed.setText("");
                    }else {
                        Toast.makeText(getContext(), "Terdapat inputan yang kosong", Toast.LENGTH_SHORT).show();
                    }
                }
            }

 }



/**
     simpan.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             realm.beginTransaction();

             Friend friend = realm.createObject(Friend.class,nim.getText().toString());
             friend.setNama(nama.getText().toString());
             friend.setKelas(kelas.getText().toString());
             friend.setTelp(telp.getText().toString());
             friend.setEmail(email.getText().toString());
             friend.setSosmed(sosmed.getText().toString());


             realm.commitTransaction();
             AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());

             // set title dialog
             alertDialogBuilder.setTitle("Berhasil Disimpan");
             alertDialogBuilder
                     .setIcon(R.mipmap.ic_launcher)
                     .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {
                             // do something
                         }
                     });
             AlertDialog alertDialog = alertDialogBuilder.create();

             // menampilkan alert dialog
             alertDialog.show();
             nim.setText("");
             nama.setText("");
             kelas.setText("");
             telp.setText("");
             email.setText("");
             sosmed.setText("");

         }

     });




     batal.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             // Intent i = new Intent(AddFriendFragment.this,Test.class);
             //startActivity(i);
         }
     });


 }
}
*/