package com.example.contenedoresclase19d.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.contenedoresclase19d.Modelos.Noticias;
import com.example.contenedoresclase19d.Modelos.Usuario;
import com.example.contenedoresclase19d.R;

import java.util.ArrayList;

public class AdaptadorUsuario extends ArrayAdapter<Usuario> {
    public AdaptadorUsuario(Context context, ArrayList<Usuario> datos) {
        super(context, R.layout.ly_itemusuario, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.ly_itemusuario, null);

        TextView lblNombre = (TextView)item.findViewById(R.id.lblNombre);
        lblNombre.setText(getItem(position).getNombres());
        TextView lblemail = (TextView)item.findViewById(R.id.lblEmail);
        lblemail.setText(getItem(position).getEmail());
        TextView lblweb = (TextView)item.findViewById(R.id.lblweb);
        lblweb.setText(getItem(position).getWebsite());

        ImageView imageView = (ImageView)item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext())
                .load(getItem(position).getUrlavatar())
                .into(imageView);

        return(item);
    }
}

