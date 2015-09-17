package itesm.mx.a01191470_tarea_registrousuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> userList = new ArrayList<User>();
    User currentUser;
    private static final int REGISTER_CODE = 1;
    private static final int LOGIN_CODE = 2;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




//
        final Button registerBT = (Button)findViewById(R.id.registerBT);
        final Button loginBT = (Button)findViewById(R.id.loginBT);

        View.OnClickListener registerListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, registro.class);
                startActivityForResult(registerIntent, REGISTER_CODE);
            }
        };

        View.OnClickListener logInListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, login.class);
                startActivityForResult(registerIntent, LOGIN_CODE);
            }
        };

        registerBT.setOnClickListener(registerListener);
        loginBT.setOnClickListener(logInListener);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REGISTER_CODE) {
            if (resultCode == RESULT_OK){
                Bundle usuarioNuevo = data.getExtras();
                String fullName = usuarioNuevo.getString("fullName");
                String email = usuarioNuevo.getString("email");
                String password = usuarioNuevo.getString("password");
                User newUser = new User(fullName, email, password);
                userList.add(newUser);
                Toast.makeText(getApplicationContext(), "Usuario Agregado", Toast.LENGTH_SHORT).show();
            }
        } else if(requestCode == LOGIN_CODE) {
            if (resultCode == RESULT_OK) {
                Bundle loginUser = data.getExtras();
                String email = loginUser.getString("email");
                String password = loginUser.getString("password");
                boolean found = false;

                for (User x : userList) {
                    if (x.email.equals(email)) {
                        if (x.password.equals(password)) {
                            Intent userProfile = new Intent(MainActivity.this, Perfil.class);
                            Bundle userInfo = new Bundle();
                            userInfo.putString("fullName",  x.fullName);
                            userInfo.putString("email", x.email);
                            userProfile.putExtras(userInfo);
                            startActivity(userProfile);
                            found = true;
                        }
                    }
                }
                if(!found) {
                    Toast.makeText(getApplicationContext(), "Correo o Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
