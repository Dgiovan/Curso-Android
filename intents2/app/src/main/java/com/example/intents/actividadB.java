package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class actividadB extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_b);
        tv = findViewById(R.id.tv);
       /* Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
            String datos = parametros.getString("h");
            tv.setText(datos);
        }*/
       onNewIntent(getIntent());
        //inited= true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent==null)return;
        String action = intent.getAction();
        String data = intent.getDataString();




        if (Intent.ACTION_VIEW.equals(action) && data != null)
        {

           // String recipeId = data.substring(data.lastIndexOf("/") + 1);
          //  if(recipeId.contains("?")) {
           //     recipeId = recipeId.substring(0, recipeId.lastIndexOf("?"));
        //}
          //  String[] part    = image.split("/");
            //String urlPrimary = part[0]+"/"+part[1]+"/"+part[2]+"/"+part[3]+"/";
            //String imgs		  = part[4];
            //String keys		  = part[5];
            // Isolated case
            tv.setText(data);
        }else{
            tv.setText(intent.getStringExtra("h"));
        }
    }
}
/*
hhh
public class Article extends BaseActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    */
/**
     * Clave de articulo Actual
     *//*

    protected String currentArtitleKey = "";
    private LinearLayout containerTip;
    adapterContent_Whit_HTML adapter;
    private int Counter=0;
    JSONArray step;
    View UpperLevel,Content=null;
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        KiwilimonUtils.cancelRequests(
                KiwiLimon.Requests.LOAD_ARTITLE_REQUEST, KiwiLimon.Requests.LOAD_CHEF_COOKBOOK_REQUEST, KiwiLimon.Requests.ADD_COOKBOOK_TO_COLLECTION_REQUEST,
                KiwiLimon.Requests.ADD_COOKBOOK_TO_SUPER_LIST_REQUEST, KiwiLimon.Requests.ADD_COOKBOOK_TO_COLLECTION_REQUEST,
                KiwiLimon.Requests.COLLECTION_SELECTOR_REQUEST);
    }

    @Override
    protected void onResume() {
        super.onResume();

        AdWordsConversionReporter.registerReferrer( getApplicationContext(), this.getIntent().getData() );
    }



    private boolean isPurchased = false;

    @Override
    protected void onNewIntent(final Intent intent)
    {
        super.onNewIntent(intent);

        if(intent == null ) return;

        String action = intent.getAction();
        String data = intent.getDataString();

        if (Intent.ACTION_VIEW.equals(action) && data != null)
        {
            */
/* Handle Deep Link *//*


            String recipeId = data.substring(data.lastIndexOf("/") + 1);

            // Isolated case
            try {
                if(recipeId.contains("?")) {
                    recipeId = recipeId.substring(0, recipeId.lastIndexOf("?"));
                }
            } catch (Exception e) {}
            mUrl = Api.url("receta", recipeId + (Login.isLogged(this) ? ("/" + Login.getToken(this)) : ""), getResource(Api.Resource.MData, Api.Format.Json), Get, Api.INVALID_OFFSET);
            showProgress();
            KiwilimonUtils.cancelRequests( KiwiLimon.Requests.LOAD_COOKBOOK_REQUEST );

            // JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, mUrl, null, this, this);

            //  KiwiLimon.getInstance().addToRequestQueue(request, KiwiLimon.Requests.LOAD_COOKBOOK_REQUEST);
        }
        else
        {
            if(inited)
            {
                if( TextUtils.equals(currentArtitleKey, intent.getStringExtra("clave"))) {
                    Tools.toast(this, getString(R.string.action_open_article_onnewintent_already)); return;
                }

                Tools.showPrompt(this, null, getString(R.string.action_open_cookbook_onnewintent), getString(R.string.action_openl), new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        currentArtitleKey = intent.getStringExtra("clave");
                        mData = null;
                        load(false, true, true);

                    }
                }, getString(R.string.action_cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
            }
            else {
                currentArtitleKey = intent.getStringExtra("clave");
                load(false, true, true);
            }
        }
    }



    */
/**
     * Start
     *//*

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_nestedscrooll);
        containerTip = findViewById(R.id.TipContainer);
        onNewIntent( getIntent() );
        inited = true;
        Log.e("Current",currentArtitleKey);


    }

    @Override
    public void load(boolean usesCache, boolean showProgress, boolean withInternetComprobation) {
        if (mData==null) {
            boolean local = getIntent().getBooleanExtra("local", false);
            if (local && !InternetConnection.isOnline(this)){

            }else {
                super.load(usesCache, showProgress, withInternetComprobation);

                KiwilimonUtils.cancelRequests(KiwiLimon.Requests.LOAD_ARTITLE_REQUEST);
                */
/**deleat the harcode*//*

                mUrl = "https://develgr.kiwilimon.com:83/v6/tip?key=" + currentArtitleKey + "&language=es&device=android&human=1";
                Log.e("MIURL",mUrl);
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, mUrl, null, this, this);
                KiwiLimon.getInstance().addToRequestQueue(request, KiwiLimon.Requests.LOAD_ARTITLE_REQUEST);
            }

        }else {

        }

    }

    @Override
    public void onResponse(JSONObject response) {
        mData = response;
        if (mData!=null){
            publishView();
        }
    }
    @Override
    public void onErrorResponse(VolleyError error) {
        */
/**llamar metodo para poder cargar desde JSON*//*

        String jsondata = null;
        try {
            jsondata = readJsonDataFromFile();
            mData = new JSONObject(jsondata);
            publishView();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    */
/**Empieza metodo para leer desde Json borrar terminando pruebas*//*

    private String readJsonDataFromFile() throws IOException
    {
        */
/**       InputStream inputStream = null;
         StringBuilder builder = new StringBuilder();

         String jsonDataString = null;
         inputStream = getResource()*//*

        //BufferedReader
        Log.e("ENTRE","si");
        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try {
            String jsonDataString = null;
            inputStream = getResources().openRawResource(R.raw.responseon);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));
            while ((jsonDataString = bufferedReader.readLine()) != null) {
                builder.append(jsonDataString);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        Log.e("ENTRE",builder.toString());
        return new String(builder);
    }
    */
/**Termina metodo de lectra Json*//*

    private void publishView() {
        if (UpperLevel==null)
        {
            UpperLevel = this.getLayoutInflater().inflate(R.layout.upperlevel, containerTip, false);
        }
        getUpperlevel(UpperLevel);
        containerTip.addView(UpperLevel);
        containerTip.addView(getContert());
    }



    private void getUpperlevel(View v) {
        TextView likes,description,client,title;
        ImageView uperimage,hasVideo;
        uperimage    = v.findViewById(R.id.imageuperleve);
        hasVideo     = v.findViewById(R.id.hasVideo);
        likes        = v.findViewById(R.id.numer_likes);
        title        = v.findViewById(R.id.upperTitle);
        description  = v.findViewById(R.id.descriptionuperleve);
        client       = v.findViewById(R.id.upperClient);
        String url="";
        try {

            url =Api.getImageURL(mData.getString("image"), "ss_secreto", mData.getString("key"), false);
            likes.setText(mData.getString("favoritos"));
            description.setText(mData.getString("desciption"));
            JSONObject objet = mData.getJSONObject("clientdata");
            client.setText(objet.getString("firstname")+" "+objet.getString("lastname"));
            title.setText(mData.getString("h1title"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Glide.clear(uperimage);
        Log.e("IMAGEN",url);
        Glide.with(Article.this)
                .load(url)
                .placeholder(R.drawable.ic_placeholder)
                .into(uperimage);
        try {
            if (mData.getJSONObject("video")!=null){
                hasVideo.setVisibility(View.VISIBLE);
                final JSONObject HasVideo = mData.getJSONObject("video");
                uperimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            CookBookPlayer.openUrl(Article.this, HasVideo.getString("videoid") );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private View getContert() {
        if (Content==null){
            Content = this.getLayoutInflater().inflate(R.layout.recyclerviewgeneral, containerTip, false);
        }
        try {
            step = mData.getJSONArray("pasos");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RecyclerView rcv = Content.findViewById(R.id.rcv);
        List<adapterContent_Whit_HTML.itemContent> Mitems = new ArrayList<>();
        LinearLayoutManager manager= getTypeRecycler() ?
                new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL, false):
                new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false)  ;

        rcv.setLayoutManager(manager);
        rcv.setHasFixedSize(true);
        if (getTypeRecycler()){
            for (int i = 0; i <step.length();i++)
            {
                try {
                    Mitems.add(new adapterContent_Whit_HTML.itemContent(step.getJSONObject(i)).withPhoto());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }else {
            for (int i = 0; i <step.length();i++)
            {
                try {
                    Mitems.add(new adapterContent_Whit_HTML.itemContent(step.getJSONObject(i)).noPhoto());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        adapter = new adapterContent_Whit_HTML(Mitems,getApplicationContext());
        rcv.setAdapter(adapter);
        return Content;
    }

    private boolean getTypeRecycler() {
        boolean type= false;
        Counter=0;
        for (int i = 0; i <step.length();i++)
        {
            try {
                if (!step.getJSONObject(i).getString("imagen").equals("")&&!step.getJSONObject(i).getString("imagen").equals("null"))
                {
                    Counter++;
                }

            } catch (JSONException e) {
                Log.e("Erro",e.toString());
            }
        }
        return type = Counter >= step.length()/2 ? true : false ;
    }


}*/
