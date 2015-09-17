package itesm.mx.a01191470_tarea_registrousuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class login extends AppCompatActivity {

    ArrayList<User> userList = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        String email = "usuario1@gmail.com";
        String password = "usuario1";
        User newUser = new User( email, password);
        userList.add(newUser);

        email = "usuario2@gmail.com";
        password = "usuario2";
        newUser = new User( email, password);
        userList.add(newUser);

        final EditText emailET = (EditText)findViewById(R.id.emailLoginET);
        final EditText passwordET = (EditText)findViewById(R.id.passwordLoginET);
        final Button loginBT = (Button)findViewById(R.id.startSessionBT);

        View.OnClickListener loginRegister = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailET.getText().toString();
                String password = passwordET.getText().toString();
//                Intent loginUser = new Intent();
//                Bundle info = new Bundle();
//                info.putString("email", email);
//                info.putString("password", password );
//                loginUser.putExtras(info);
//                setResult(RESULT_OK, loginUser);
//                finish();
                User user = new User(email, password);
                boolean found = findUser(user);
                if(found) {
                    Intent intent = new Intent(login.this, lista_articulos.class);
                    startActivity(intent);
                }
            }
        };

        loginBT.setOnClickListener(loginRegister);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    public boolean findUser(User user) {

        boolean found = false;

        for (User x : userList) {
            if (x.email.equals(user.email)) {
                if (x.password.equals(user.password)) {
//                    Intent userProfile = new Intent(login.this, Perfil.class);
//                    Bundle userInfo = new Bundle();
//                    userProfile.putExtras(userInfo);
//                    startActivity(userProfile);
                    found = true;
                }
            }
        }
        if(!found) {
            Toast.makeText(getApplicationContext(), "Correo o Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
        }

        return found;
    }
}
