package com.example.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int [] viewIds={R.id.a,R.id.b,R.id.c,R.id.d,R.id.e,R.id.f,R.id.g,R.id.h};
    Intent intent;
    public List<ResolveInfo> maches;
    boolean appFound=false;
    TextView tv;
    int request=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tvResult);
        setDegateClick(this,viewIds);
    }


    public void setDegateClick(MainActivity view,int ... ids)
    {
        for (int i = 0 ; i<ids.length;i++)
        {
            view.findViewById(ids[i]).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.a:
                intent = new Intent(MainActivity.this,Actividadb.class);
                intent.putExtra("key","hola que tal");
                break;
            case R.id.b:
                intent = new Intent("android.intent.action.B");
                intent.putExtra("key","hola que tal desde un action");
                break;
            case R.id.c:
                intent = getPackageManager().getLaunchIntentForPackage("com.example.myapplication");
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("hola ximena"));
                intent.putExtra("k","hola");
                break;
            case R.id.d:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:5587026781"));
                break;
            case R.id.e:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"HOLA XIMENA");
                intent.setPackage("com.whatsapp");
                break;
            case R.id.f:
                String data = "http://google.com.mx/";

                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,data);



                maches= this.getPackageManager().queryIntentActivities(intent,0);
                for (ResolveInfo info : maches ){
                    if (info.activityInfo.packageName.toLowerCase(Locale.getDefault()).startsWith("com.twitter.android"
                            //"com.facebook.katana"
                            )){
                        intent.setPackage(info.activityInfo.packageName);
                        appFound= true;
                        break;
                    }
                }
                if (!appFound){
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                            "https://twitter.com/intent/tweet?url="
                           // "https://www.facebook.com/sharer/sharer.php?u="
                                    +data));
                }

                break;
                case R.id.g:
                    String datas = "http://google.com.mx/";

                    intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,datas);



                    maches= this.getPackageManager().queryIntentActivities(intent,0);
                    for (ResolveInfo info : maches ){
                        if (info.activityInfo.packageName.toLowerCase(Locale.getDefault()).startsWith("com.gio.mscuentas"
                                //"com.facebook.katana"
                        )){
                            intent.setPackage(info.activityInfo.packageName);
                            appFound= true;
                            break;
                        }
                    }
                    if (!appFound){
                        intent = new Intent(Intent.ACTION_VIEW);
                                     intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.gio.mscuentas"));
                                     intent.setPackage("com.android.vending");
                    }
                    break;
                case R.id.h:
                    intent = new Intent("android.intent.action.B");
                    //new Intent(MainActivity.this,Actividadb.class);
                    //startActivityForResult(intent,2);
                    request = 2;
                    break;
        }

       if (intent!=null){
           if (request!=0){
               startActivityForResult(intent,request);
           }else {startActivity(intent);}
       }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==2){
            String resultado = data.getStringExtra("resultado");
            tv.setText(resultado);
        }
    }
}
