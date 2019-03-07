package db.eng.com.db;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ActivityAndamento extends AppCompatActivity{


    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private ItemCasaRecyclerAdapter mAdapter;
    private DatabaseReference myRef;
    private DatabaseReference myRefCPF;
    private List <ItemCasa> coisas;
    private ProgressBar progressBarAndamento;
    private FirebaseUser user;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andamento);

        atribuir();

        myRefCPF.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String cpf = dataSnapshot.getValue(String.class);
                myRef = database.getReference("Projetos").child(cpf).child("comodos");

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        progressBarAndamento.setVisibility(View.VISIBLE);
                        recyclerView.setVisibility(View.GONE);
                        coisas.clear();
                        for (DataSnapshot a : dataSnapshot.getChildren()) {

                            coisas.add(a.getValue(ItemCasa.class));

                        }
                        mAdapter.notifyDataSetChanged();
                        progressBarAndamento.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        Toast.makeText(ActivityAndamento.this, "Oops...", Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void atribuir(){
        mAuth =  FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        myRefCPF = database.getReference("Usuarios").child(user.getUid()).child("cpf");

        progressBarAndamento = findViewById(R.id.progressBarAndamento);
        coisas = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerViewAndamento);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        mAdapter = new ItemCasaRecyclerAdapter(this,coisas);
        recyclerView.setAdapter(mAdapter);
    }
}
