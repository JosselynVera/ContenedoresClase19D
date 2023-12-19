package com.example.contenedoresclase19d;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.contenedoresclase19d.Adaptadores.AdaptadorUsuario;
import com.example.contenedoresclase19d.Modelos.Usuario;
import com.example.contenedoresclase19d.WebServices.Asynchtask;
import com.example.contenedoresclase19d.WebServices.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*APLI REST*/
public class MainActivity3 extends AppCompatActivity implements Asynchtask {
    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        lstOpciones = (ListView)findViewById(R.id.lstListaUsuario);

        View header = getLayoutInflater().inflate(R.layout.ly_itemusuario, null);
        lstOpciones.addHeaderView(header);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://reqres.in/api/users",
                datos, MainActivity3.this, MainActivity3.this);
        ws.execute("GET");
    }
    public void processFinish(String result) throws JSONException {
        JSONObject JSONlista = new JSONObject(result);
        JSONArray JSONlistaUsuarios = JSONlista.getJSONArray("data");
        ArrayList<Usuario> lstUsuarios = Usuario.JsonObjectsBuild(JSONlistaUsuarios);

        AdaptadorUsuario adaptadorUsuario = new AdaptadorUsuario(this, lstUsuarios);
        lstOpciones.setAdapter(adaptadorUsuario);
    }
}