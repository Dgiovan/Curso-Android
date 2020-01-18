package com.example.firstapplication.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.firstapplication.Enums.FragmentType;
import com.example.firstapplication.Interfaces.OnFragmentIteractionListener;
import com.example.firstapplication.R;

public class BaseFragment extends AppCompatActivity implements OnFragmentIteractionListener {

    protected void changeFragment(FragmentType fragmentType, boolean addToBackStack, Bundle args){
        Fragment fragment = new Fragment();

        switch (fragmentType){
            case LOGIN:
                LoginFragment loginFragment = LoginFragment.newInstance(this);
                loginFragment.setArguments(args);
                fragment = loginFragment;
                break;
            case LIST:
                ListFragment listFragment = ListFragment.newInstance(this);
                listFragment.setArguments(args);
                fragment = listFragment;
                break;
            case REGISTER:
                RegisterFragment registerFragment = RegisterFragment.newInstance(this);
                registerFragment.setArguments(args);
                fragment = registerFragment;
                break;
            case PHOTOS:
                PhotosFragment photosFragment = PhotosFragment.newInstance(this);
                photosFragment.setArguments(args);
                fragment = photosFragment;
                break;
            case MAP:
                MapFragment mapFragment = MapFragment.newInstance(this);
                mapFragment.setArguments(args);
                fragment = mapFragment;
                break;
            case SAVE:
                SaveFragment saveFragment = SaveFragment.newInstance(this);
                saveFragment.setArguments(args);
                fragment = saveFragment;
                break;
        }

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.enter_from_right
        );

        if(addToBackStack){
            fragmentTransaction.addToBackStack(fragmentType.name());
        }

        fragmentTransaction.replace(R.id.container, fragment).commitAllowingStateLoss();
    }

    @Override
    public void onFragmentIteractionChangeFragment(FragmentType fragmentType, boolean addToBackStack, @Nullable Bundle args) {
        changeFragment(fragmentType, addToBackStack, args);

    }
}
