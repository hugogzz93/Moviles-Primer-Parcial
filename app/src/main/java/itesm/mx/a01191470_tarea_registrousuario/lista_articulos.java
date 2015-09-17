package itesm.mx.a01191470_tarea_registrousuario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class lista_articulos extends AppCompatActivity {

    int[] articulosIDs = new int []{

            R.mipmap.plumaazul,

            R.mipmap.sharpierojo,

            R.mipmap.sharpieazul,

            R.mipmap.sharpieverde,

            R.mipmap.sharpienegro,

            R.mipmap.plumanegra,

            R.mipmap.lapiz,

            R.mipmap.legajooficio

    };

    // inicializa lista de Artículos
    public List<Articulo> getDataForListView()
    {
        Articulo articulo;

        List<Articulo> listaArticulos = new ArrayList<Articulo>();

        articulo = new Articulo(2345, "Pluma Azul",150, 4.20, articulosIDs[0]);
        listaArticulos.add(articulo);

        articulo = new Articulo(3456,"Sharpie Rojo",11,11.10, articulosIDs[1]);
        listaArticulos.add(articulo);

        articulo = new Articulo(3457, "Sharpie Azul", 11, 11.10, articulosIDs[2]);
        listaArticulos.add(articulo);

        articulo = new Articulo(3458, "Sharpie Verde",11, 11.50, articulosIDs[3]);
        listaArticulos.add(articulo);

        articulo = new Articulo(3459, "Sharpie Negro",11,11.50, articulosIDs[4]);
        listaArticulos.add(articulo);

        articulo = new Articulo(4356, "Pluma negra",234,10.20, articulosIDs[5]);
        listaArticulos.add(articulo);

        articulo = new Articulo(12345, "Lápiz #2",100,3.50, articulosIDs[6]);
        listaArticulos.add(articulo);

        articulo = new Articulo(678909, "Legajo oficio",60,10.00, articulosIDs[7]);
        listaArticulos.add(articulo);

        return listaArticulos;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_articulos);

        final CustomAdapter articleAdapter = new CustomAdapter(getApplicationContext(), R.layout.row_layout, getDataForListView());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_articulos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
