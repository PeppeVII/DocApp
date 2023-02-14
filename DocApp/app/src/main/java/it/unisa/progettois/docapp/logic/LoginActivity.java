package it.unisa.progettois.docapp.logic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import it.unisa.progettois.docapp.R;
import it.unisa.progettois.docapp.data.StudenteDAO;

public class LoginActivity extends AppCompatActivity {
    Button buttonAccedi;
    EditText emailLogin, passwordLogin;
    private StudenteDAO studenteDAO;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        sharedPreferences = getApplicationContext().getSharedPreferences("MY_SHARED_PREF", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        studenteDAO = new StudenteDAO(getApplicationContext());
        buttonAccedi = findViewById(R.id.buttonAccedi);
        emailLogin = findViewById(R.id.emailLogin);
        passwordLogin = findViewById(R.id.passwordLogin);
    }

    public void effettuaLogin(View view){
        String email = emailLogin.getText().toString();
        String password = passwordLogin.getText().toString();
        try {
            Studente studente = studenteDAO.effettuaLogin(email, password);

            if(studente != null) {
                editor.putBoolean("is_logged", true);
                editor.putString("email", email);
                editor.putString("password", password);
                editor.commit();
                Intent intent = new Intent(getApplicationContext(), HomepageActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(), "Email o password errate", Toast.LENGTH_LONG).show();
                return;
            }

        }catch (Exception exception){
            Toast.makeText(getApplicationContext(), "Errore nell'input", Toast.LENGTH_SHORT).show();
        }
    }
}
