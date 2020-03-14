package com.example.notificationcompactexample;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

public class FirebaseInstanceIdService extends com.google.firebase.iid.FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String recent_token = FirebaseInstanceId.getInstance().getToken();
        Log.e("Token", recent_token);

    }
}
