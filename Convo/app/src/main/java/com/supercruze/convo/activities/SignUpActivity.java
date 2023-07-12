package com.supercruze.convo.activities;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.supercruze.convo.utilities.PreferenceManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.supercruze.convo.databinding.ActivitySignUpBinding;
import com.supercruze.convo.utilities.Constants;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;


public class SignUpActivity extends AppCompatActivity {


    private PreferenceManager preferenceManager;
    private ActivitySignUpBinding binding;
    private  String encodedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        preferenceManager = new PreferenceManager(getApplicationContext());
        setContentView(binding.getRoot());
        setListners();
    }

    private void setListners(){

        binding.textExistingAccount.setOnClickListener(v -> onBackPressed());

        binding.buttonSignUp.setOnClickListener(v -> {
            if(isvalidSignUpdetails()) {
                signUp();
            }

        });

        binding.layoutImage.setOnClickListener(v -> {
            Intent imageintent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            pickImage.launch(imageintent);
        });
    }

    private void showToast(String message) {

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }




    private void signUp(){

        loading(true);
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        HashMap<String,Object>user = new HashMap<>();
        user.put(Constants.KEY_NAME,binding.inputName.getText().toString());
        user.put(Constants.KEY_EMAIL,binding.inputemail.getText().toString());
        user.put(Constants.KEY_PASSWORD,binding.inputPassword.getText().toString());
        user.put(Constants.KEY_IMAGE,encodedImage);

        database.collection(Constants.KEY_COLLECTION_USERS)
                .add(user)
                .addOnSuccessListener(documentReference -> {
            loading(false);
            preferenceManager.putBoolean(Constants.KEY_IS_SIGNED_IN,true);
            preferenceManager.putString(Constants.KEY_USER_ID,documentReference.getId());
            preferenceManager.putString(Constants.KEY_NAME,binding.inputName.getText().toString());
            preferenceManager.putString(Constants.KEY_IMAGE,encodedImage);

            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }).addOnFailureListener(exception ->{
            loading(false);
            showToast(exception.getMessage());
        });
    }


    private Boolean isvalidSignUpdetails(){

    if(encodedImage == null){
        showToast("Pick Image Please");
        return false;
    }else if(binding.inputName.getText().toString().trim().isEmpty()){
        showToast("Enter Name");
        return false;
    }else if(binding.inputemail.getText().toString().trim().isEmpty()){
        showToast("Enter Email");
        return false;
    }else if(binding.inputPassword.getText().toString().trim().isEmpty()){
        showToast("Enter Password");
        return false;
    }else if(binding.inputConfirmPassword.getText().toString().trim().isEmpty()){
        showToast("Re-enter the password");
        return false;
    }else if(!binding.inputPassword.getText().toString().equals(binding.inputConfirmPassword.getText().toString())){
        showToast("Password and Confirm Password Do not match!");
        return false;
    }else{
        return true;
    }
  }


  private void loading(Boolean isloading){
    if(isloading){
        binding.buttonSignUp.setVisibility(View.INVISIBLE);
        binding.progressBar.setVisibility(View.VISIBLE);
    }else{
        binding.buttonSignUp.setVisibility(View.VISIBLE);
        binding.progressBar.setVisibility(View.INVISIBLE);
    }
  }


  private String encodeImage(Bitmap bitmap){

    int previewWidth = 150;
    int previewHeight = bitmap.getHeight() * previewWidth/ bitmap.getWidth();

    Bitmap preViewBitmap = Bitmap.createScaledBitmap(bitmap,previewWidth,previewHeight,false);

      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      preViewBitmap.compress(Bitmap.CompressFormat.JPEG,50,byteArrayOutputStream);

      byte[] bytes = byteArrayOutputStream.toByteArray();
      return(Base64.encodeToString(bytes,Base64.DEFAULT));
  }


  private final ActivityResultLauncher<Intent> pickImage = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
          result -> {
           if(result.getResultCode() == RESULT_OK){
               if(result.getData() != null){
                   Uri imageUri = result.getData().getData();
                   try {
                       InputStream inputStream = getContentResolver().openInputStream(imageUri);

                       Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                       binding.textAddImage.setVisibility(View.GONE);
                       binding.imageProfile.setImageBitmap(bitmap);
                       encodedImage = encodeImage(bitmap);

                   }catch (FileNotFoundException e){
                       e.printStackTrace();
                   }
               }
           }
  });

}