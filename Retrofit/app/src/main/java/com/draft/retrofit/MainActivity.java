package com.draft.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.draft.retrofit.Models.aaa;
import com.draft.retrofit.Models.feedKiwi;
import com.draft.retrofit.Models.rsponseclasification;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    tv = findViewById(R.id.text);
    //https://gr.kiwilimon.com/v6/recipeclassification?key=48&full=yes&language=es&device=android&human=1


    AuthApiService authApiService = RetrofitClient.sharedInstance().getAuthApiService();
    final Call<aaa> feed = authApiService.Feeds(48,"yes","es","android",1);

    feed.enqueue(new Callback<aaa>() {
        @Override
        public void onResponse(Call<aaa> call, Response<aaa> response) {
            StringBuilder io = new StringBuilder();
            for (rsponseclasification res : response.body().getClassifications()){
                Log.e("arto estoy",res.getImage()+"\n"+response.body().getFamily());
                io.append(res.getImage());
            }
            tv.setText(io.toString());

        }

        @Override
        public void onFailure(Call<aaa> call, Throwable t) {
            Log.e("none",t.toString());
        }
    });
}
}
