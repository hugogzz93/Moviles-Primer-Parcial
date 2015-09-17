package itesm.mx.a01191470_tarea_registrousuario;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hugo on 9/17/15.
 */
public class CustomAdapter extends ArrayAdapter<Articulo> {

    private Context context;
    int layoutResourceId;
    List<Articulo> listaArticulos;

    public CustomAdapter(Context context,int idResource, List<Articulo> articulos) {
        super(context, idResource, articulos);

        this.context = context;
        this.layoutResourceId = idResource;
        this.listaArticulos = articulos;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layoutResourceId, parent, false);
        }

        TextView serieTV = (TextView)row.findViewById(R.id.num_serieTV);
        TextView nombreTV = (TextView)row.findViewById(R.id.nombreTV);
        TextView ctdTV = (TextView)row.findViewById(R.id.ctdTV);
        TextView precioTV = (TextView)row.findViewById(R.id.precioTV);
        ImageView articleIV = (ImageView)row.findViewById(R.id.article_poster);

        Articulo articulo = listaArticulos.get(position);
        serieTV.setText(articulo.getNumSerie());
        nombreTV.setText(articulo.getNombre());
        ctdTV.setText(articulo.getCtd());
        precioTV.setText((int) articulo.getPrice());
        articleIV.setImageResource(R.mipmap.ic_launcher);

        return row;
    }
}



