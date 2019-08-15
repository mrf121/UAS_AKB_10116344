package com.example.uas_akb8_10116344;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ilham.uas.model.RealmHelper;
import com.example.ilham.uas.view.fragment.FriendFragment;

import io.realm.Realm;
import io.realm.RealmConfiguration;


//Nama  : Ilham Maulana Pratama
//NIM   : 10116335
//KLS   : IF 8
//TGL   : 3 Agustus 2019
public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNim, etNama, etKelas, etTelp, etEmail, etSosmed;
    String nim, nama, kelas, telp, email, sosmed;
    Integer id;
    Button btn_ubah, btn_hapus, btn_kembali;
    RealmHelper realmHelper;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //setContentView(R.layout.activity_detail);

        // Set up
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
        ///realm = Realm.getDefaultInstance();
        realmHelper = new RealmHelper(realm);

        // Inisialisasi
        etNim = findViewById(R.id.etNim);
        etNama = findViewById(R.id.etNama);
        etKelas = findViewById(R.id.etKelas);
        etTelp = findViewById(R.id.etTelp);
        etEmail = findViewById(R.id.etEmail);
        etSosmed = findViewById(R.id.etSosmed);
        btn_ubah = findViewById(R.id.btnUpdate);
        btn_hapus = findViewById(R.id.btnHapus);
        btn_kembali = findViewById(R.id.btnCancel);


        //id = Integer.parseInt(getIntent().getStringExtra("id"));
        id = getIntent().getIntExtra("id",0);
        nim = getIntent().getStringExtra("nim");
        nama = getIntent().getStringExtra("nama");
        kelas = getIntent().getStringExtra("kelas");
        telp = getIntent().getStringExtra("telp");
        email = getIntent().getStringExtra("email");
        sosmed = getIntent().getStringExtra("sosmed");

        etNim.setText(nim);
        etNama.setText(nama);
        etKelas.setText(kelas);
        etTelp.setText(telp);
        etEmail.setText(email);
        etSosmed.setText(sosmed);

        btn_kembali.setOnClickListener(this);
        btn_hapus.setOnClickListener(this);
        btn_ubah.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v == btn_ubah){
            realmHelper.update(id,etNim.getText().toString(),etNama.getText().toString(),etKelas.getText().toString(),
                                etTelp.getText().toString(),etEmail.getText().toString(),etSosmed.getText().toString());
            Toast.makeText(DetailActivity.this, "Update Success", Toast.LENGTH_SHORT).show();
            etNim.setText("");
            etNama.setText("");
            etKelas.setText("");
            etTelp.setText("");
            etEmail.setText("");
            etSosmed.setText("");
            finish();
        }else if (v == btn_hapus) {
            realmHelper.delete(id);
            Toast.makeText(DetailActivity.this, "Delete Success", Toast.LENGTH_SHORT).show();
            finish();
        }else if (v == btn_kembali) {
            startActivity(new Intent(DetailActivity.this, FriendFragment.class));
            finish();
        }
    }
}

 /**   public void onClick(View v) {
        if (v == btn_ubah){
            realmHelper.update(id,etNim.getText().toString(),etNama.getText().toString(),etKelas.getText().toString(),etTelp.getText().toString(),etEmail.getText().toString(),etSosmed.getText().toString());
            Toast.makeText(DetailActivity.this, "Update Success", Toast.LENGTH_SHORT).show();
            etNim.setText("");
            etNama.setText("");
            finish();
        }else if (v == btn_hapus) {
            realmHelper.delete(id);
            Toast.makeText(DetailActivity.this, "Delete Success", Toast.LENGTH_SHORT).show();
            finish();
        }else if (v == btn_kembali) {
            startActivity(new Intent(DetailActivity.this, FriendFragment.class));
            finish();
        }
    }
}*/
