package com.example.firstapplication.Interfaces;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.firstapplication.Enums.FragmentType;

public interface OnFragmentIteractionListener {

    void onFragmentIteractionChangeFragment(FragmentType fragmentType, boolean addToBackStack, @Nullable Bundle args);

}
