package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int[] viewIds = {R.id.a,R.id.b,R.id.c,R.id.d,R.id.e,R.id.f};
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDelegateClick(this,viewIds);
    }

    public void setDelegateClick (MainActivity view, int... ids)
    {
        for (int i=0; i<viewIds.length;i++)
        {
            view.findViewById(ids[i]).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
     switch (view.getId()){
         case R.id.a:
             intent = new Intent(MainActivity.this,actividadB.class);
             /*Bundle args = new Bundle();
             args.putString("h","hola");*/
             intent.putExtra("h","hola");
            // startActivity(intent);
             break;
         case R.id.b:
             intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:5587026781"));
             break;
         case R.id.c:
             String cdna="http://google.com.mx/";
             intent = new Intent(Intent.ACTION_SEND);
             intent.setType("text/plain");
             intent.putExtra(Intent.EXTRA_TEXT, cdna  );

             boolean appFound = false;
             List<ResolveInfo> matches = this.getPackageManager().queryIntentActivities(intent, 0);
             for (ResolveInfo info : matches) {
                 if (info.activityInfo.packageName.toLowerCase(Locale.getDefault()).startsWith("com.facebook.katana")) {
                     intent.setPackage(info.activityInfo.packageName);
                     appFound = true;
                     break;
                 }
             }

             if (!appFound) {
                 intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/sharer/sharer.php?u=" + cdna));
             }
             break;
             case R.id.d:
             intent = new Intent("android.intent.action.actividad");
             break;
         case R.id.e:
             intent = getPackageManager().getLaunchIntentForPackage("com.Dgio.f.funapp123click");
             break;
         case R.id.f:
             intent = new Intent(Intent.ACTION_SEND);
             intent.setType("text/plain");
             intent.putExtra(Intent.EXTRA_TEXT, "hola que tal" );
             intent.setPackage("com.whatsapp");
             break;
     }
     if (intent!=null) startActivity(intent);

    }

/**para twiter
 * Constants.KiwilimonUrl + mData.getString("ruta"), "https://twitter.com/intent/tweet?url=", "com.twitter.android");**/
   /* public static void shareCompat(Activity context, String url, String sharer, String packageSearched)
    {
        try {
            Intent normalIntent = new Intent(Intent.ACTION_SEND);
            normalIntent.setType("text/plain");
            normalIntent.putExtra(Intent.EXTRA_TEXT, url );

            boolean appFound = false;
            List<ResolveInfo> matches = context.getPackageManager().queryIntentActivities(normalIntent, 0);
            for (ResolveInfo info : matches) {
                if (info.activityInfo.packageName.toLowerCase(Locale.getDefault()).startsWith(packageSearched)) {
                    normalIntent.setPackage(info.activityInfo.packageName);
                    appFound = true;
                    break;
                }
            }

            if (!appFound) {
                normalIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(sharer + url));
            }

            KiwilimonUtils.startActivityAnimated( context, Intent.createChooser(normalIntent, context.getString(R.string.share_intent)) );

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }*/
}
