package db.eng.com.db;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MainMenu extends AppCompatActivity {

    private FirebaseAuth mAuth;
    FirebaseUser currentUser;
    CardView cardViewAndamento;
    CardView cardViewPrazos;
    CardView cardViewFotos;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();
         currentUser = mAuth.getCurrentUser();

        if (currentUser == null){
            Intent intentLogin = new Intent(MainMenu.this, GoogleSignInActivity.class);
            startActivity(intentLogin);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);



        cardViewAndamento = findViewById(R.id.cardViewAndamento);
        cardViewPrazos = findViewById(R.id.cardViewPrazos);
        cardViewFotos = findViewById(R.id.cardViewFotos);


        cardViewAndamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAndamento = new Intent(MainMenu.this, ActivityAndamento.class);
                startActivity(toAndamento);
            }
        });
        cardViewPrazos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPrazos = new Intent(MainMenu.this, GoogleSignInActivity.class);
                startActivity(toPrazos);
            }
        });
        cardViewFotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toFotos = new Intent(MainMenu.this, FotosActivity.class);
                startActivity(toFotos);
            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menuItemLogin:
                Intent intentLogin = new Intent(MainMenu.this, GoogleSignInActivity.class);
                startActivity(intentLogin);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
