package db.eng.com.db;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class FotosActivity extends AppCompatActivity {

    private StorageReference storageRef;
    private ImageView imageViewFoto;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotos2);

        imageViewFoto = findViewById(R.id.imageViewFotos);

        mAuth =  FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        FirebaseStorage storage = FirebaseStorage.getInstance();

        StorageReference storageRef = storage.getReference();

        StorageReference pathReference = storageRef.child("images/"+user.getUid()+"/endereco.jpg");


        StorageReference gsReference = storage.getReferenceFromUrl("gs://dbfirebaseproject-8cd25.appspot.com/images/doctorwho.jpg");

        StorageReference httpsReference = storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/b/dbfirebaseproject-8cd25.appspot.com/o/images%20doctorwho.jpg");


        final long ONE_MEGABYTE = 1024 * 1024;
        pathReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                // Data for "images/island.jpg" is returns, use this as needed
                Toast.makeText(FotosActivity.this, "Sucesso", Toast.LENGTH_SHORT).show();
                imageViewFoto.setImageBitmap(new BitmapFactory().decodeByteArray(bytes,0,bytes.length));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
    }
}
