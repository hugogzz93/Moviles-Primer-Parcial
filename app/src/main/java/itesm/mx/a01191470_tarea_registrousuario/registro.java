package itesm.mx.a01191470_tarea_registrousuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        final Button guardarBT = (Button)findViewById(R.id.guardarBT);
        final EditText fullNameET = (EditText)findViewById(R.id.nameTE);
        final EditText emailET = (EditText)findViewById(R.id.emailTE);
        final EditText passwordET = (EditText)findViewById(R.id.contraseñaTE);
        final EditText confirmationET = (EditText)findViewById(R.id.confirmationTE);
        final TextView warningTV = (TextView)findViewById(R.id.warningTV);

        View.OnClickListener registroGuardar = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = fullNameET.getText().toString();
                String email = emailET.getText().toString();
                String password = passwordET.getText().toString();
                String confirmation = confirmationET.getText().toString();

                if(fullName.length() == 0 || email.length() == 0 || password.length() == 0 || confirmation.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Campos Vacios", Toast.LENGTH_SHORT).show();
                }
                else if( !password.equals(confirmation)) {
                    Toast.makeText(getApplicationContext(), "Clave y confirmacion no concuerdan.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent saveUser = new Intent();
                    Bundle usuarioNuevo = new Bundle();
                    usuarioNuevo.putString("fullName", fullName);
                    usuarioNuevo.putString("email", email);
                    usuarioNuevo.putString("password", password);
                    saveUser.putExtras(usuarioNuevo);
                    setResult(RESULT_OK, saveUser);
                    finish();
                }

            }
        };

        guardarBT.setOnClickListener(registroGuardar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro, menu);
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
