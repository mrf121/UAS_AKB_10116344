package com.example.uas_akb8_10116344.model;

import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

//Nama  : Ilham Maulana Pratama
//NIM   : 10116335
//KLS   : IF 8
//TGL   : 3 Agustus 2019

public class RealmHelper {

    Realm realm;

    public  RealmHelper(Realm realm){
        this.realm = realm;
    }

    public void save(final FriendModel friendModel){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null){
                    Log.e("Created", "Database was created");
                    Number currentIdNum = realm.where(FriendModel.class).max("id");
                    int nextId;
                    if (currentIdNum == null){
                        nextId = 1;
                    }else {
                        nextId = currentIdNum.intValue() + 1;
                    }
                    friendModel.setId(nextId);
                    FriendModel model = realm.copyToRealm(friendModel);
                }else{
                    Log.e("ppppp", "execute: Database not Exist");
                }
            }
        });
    }

    // TO get all data from database
    public List<FriendModel> getAllFriend(){
        RealmResults<FriendModel> results = realm.where(FriendModel.class).findAll();
        return results;
    }

    // To update data from database
    public void update(final Integer id, final String nim, final String nama, final String kelas,
                       final String telp, final String email, final String sosmed){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                FriendModel friendModel = realm.where(FriendModel.class)
                        .equalTo("id", id)
                        .findFirst();
                friendModel.setNim(nim);
                friendModel.setNama(nama);
                friendModel.setKelas(kelas);
                friendModel.setTelp(telp);
                friendModel.setEmail(email);
                friendModel.setSosmed(sosmed);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("pppp", "onSuccess: Update Successfully");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
            }
        });
    }

    public void delete(Integer id){
        final RealmResults<FriendModel> model = realm.where(FriendModel.class).equalTo("id", id).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model.deleteFromRealm(0);
            }
        });
    }
}
