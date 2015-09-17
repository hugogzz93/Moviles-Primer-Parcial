package itesm.mx.a01191470_tarea_registrousuario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        Bundle loginUser = getIntent().getExtras();
        String fullName = loginUser.getString("fullName");
        String email = loginUser.getString("email");

        final TextView fullNameTV = (TextView)findViewById(R.id.fullNameTV);
        final TextView emailTV = (TextView)findViewById(R.id.emailTV);
        final TextView welcomeTV = (TextView)findViewById(R.id.welcomeTV);
        final Button logoutBT = (Button)findViewById(R.id.backBT);

        String welcomeMessage = "Bienvenido " + fullName;
        welcomeTV.setText(welcomeMessage);
        fullNameTV.setText(fullName);
        emailTV.setText(email);

        View.OnClickListener logoutRegister = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        };

        logoutBT.setOnClickListener(logoutRegister);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_perfil, menu);
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
