package com.foundfunapps.geolocalizacio2;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LocationListener {

    //Costantes para parametros de el escuchador de la actualizacion de ubicacion
    static final long TIEMPO_MIN = 10*100;//segundos
    static final long DISTANCIA_MIN = 5;

    /**Todo valores a los que estan ligados nuestros estados de los provedores de ubicacion
     * @paman A = Acurraci latencia de nuestra ubicacion presisa o no
     * @param P = Potential de provedor
     * @param E = Status de provedor*/

    static final String[] A={"n/d","presiso","impreciso"};
    static final String[] P={"n/d","bajo","medio","alto"};
    static final String[] E={"fuera de servicio","temporalmente no disponible","disponible"};

    /**@link MainActivity.log detalles no tendra remplazo de texto (setText) en cambio se ira concatenando informacion
     * al view detalles
     * */
    TextView detallates;
    LocationManager manejador;
    String provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instancia de la clase location manager
        //casteo implicito requiere espesificar de que tipo de dato se tratara

        manejador = (LocationManager) getSystemService(LOCATION_SERVICE);

        detallates = findViewById(R.id.localizacion1);
        Criteria criteria = new Criteria();
        criteria.setCostAllowed(false);
        criteria.setAltitudeRequired(false);
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        provider = manejador.getBestProvider(criteria,true);
        log("El mejor Proveedor de localizacion es "+provider);
        log("ultima localizacion conocida");

        Location location = manejador.getLastKnownLocation(provider);

        muestraLocalizacion(location);

        log("detalles de los servicion de localizacion");

        muestraProvedores();

    }

    private void muestraProvedores() {
        log("provedores de localizacion:\n");
        List<String> proveedores = manejador.getAllProviders();
        for (String proveedor : proveedores)
        {
            muestraProvedor(proveedor);
        }
    }

    private void muestraProvedor(String proveedor) {
        LocationProvider info = manejador.getProvider(proveedor);

        log("Proveedor de localizacion"+"Nombre "+ info.getName()
        +", Provedor Abilitado = "
        +manejador.isProviderEnabled(proveedor)+", Obtener latencia= "
        +A[Math.max(0,info.getAccuracy())]+ ", Potencia "
        +P[Math.max(0,info.getPowerRequirement())]
        +", Costo de localizacion "+info.hasMonetaryCost()
        +", requiere cel"+ info.requiresCell()
        +", requiere internet"+ info.requiresNetwork()
        +", requiere satelite"+ info.requiresSatellite()
        +", soporta altitud" +  info.supportsAltitude()
        +", soporta velocidad" + info.supportsSpeed()+"\n");
    }

    private void muestraLocalizacion(Location location) {
        if (location ==null){
            log("Localizacion desconosida \n");
        }else {
            log(location.toString()+"\n");
        }
    }

    private void log(String cadena){
        detallates.append(cadena+ "\n" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        manejador.requestLocationUpdates(provider,TIEMPO_MIN,DISTANCIA_MIN,this);
    }
    /**
     @onviewCreate*/

    @Override
    protected void onPause() {
        super.onPause();
        manejador.removeUpdates(this);
    }
    /**El equivalente en Fragmenten es
     * @onViewDestroy*/

    @Override
    public void onLocationChanged(Location location) {
        log("nueva localizacion ");
        muestraLocalizacion(location);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        log("El provedor Cambio de estado"+ provider+ ", estado ="
        +E[Math.max(0,i)]);
    }

    @Override
    public void onProviderEnabled(String s) {
        log("provedor abilitado "+ provider);
    }

    @Override
    public void onProviderDisabled(String s) {
        log("provedor desabilitado "+ provider);
    }
}
