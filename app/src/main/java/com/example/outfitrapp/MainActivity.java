package com.example.outfitrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.outfitrapp.databinding.ActivityMainBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // the main activity starts with the tops fragment
        replaceFragment(new TopsFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            int id = item.getItemId();

            // replace fragment depending on which item menu the user clicks on
            if (id == R.id.tops)
                replaceFragment(new TopsFragment());
            else if (id == R.id.bottoms)
                replaceFragment(new BottomsFragment());
            else if (id == R.id.shoes)
                replaceFragment(new ShoesFragment());
            else if (id == R.id.create)
                replaceFragment(new CreateFragment());
            else if (id == R.id.account)
                replaceFragment(new AccountFragment());

            return true;
        });

    }

    // function that handles the replacement of the fragments
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

    public void onBackPressed() {
        finish();
    }
}