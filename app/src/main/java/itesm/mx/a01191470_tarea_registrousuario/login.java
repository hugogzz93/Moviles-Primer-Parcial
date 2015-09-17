package itesm.mx.a01191470_tarea_registrousuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText emailET = (EditText)findViewById(R.id.emailLoginET);
        final EditText passwordET = (EditText)findViewById(R.id.passwordLoginET);
        final Button loginBT = (Button)findViewById(R.id.startSessionBT);

        View.OnClickListener loginRegister = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailET.getText().toString();
                String password = passwordET.getText().toString();
                Intent loginUser = new Intent();
                Bundle info = new Bundle();
                info.putString("email", email);
                info.putString("password", password );
                loginUser.putExtras(info);
                setResult(RESULT_OK, loginUser);
                finish();
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
}
