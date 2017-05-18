package com.example.luchobolivar.hospitaleleden;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.luchobolivar.hospitaleleden.HttpURLConnection.HttpConnection;
import com.example.luchobolivar.hospitaleleden.modelo.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etPass;
    private String enlace;
    private String usuario;
    private String password;
    private HttpConnection connection;
    private Usuario user;


    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = (EditText) findViewById(R.id.etNombreUsuario);
        etPass = (EditText) findViewById(R.id.etPassword);

        connection = new HttpConnection();

    }

    public void validarUsuario(View v){
        usuario = etUsuario.getText().toString();
        password = etPass.getText().toString();
        enlace = "http://192.168.43.17:8888/serviciosWebHospital/login.php?username="+ usuario +"&password=" + password + "";
        new loginUsuario().execute(enlace);
    }

    public void ventanaRegistro(View v){

        intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }

    public void LogInRol (){
        if(user.getRol().equals("admin")){
            Intent i = new Intent(getApplicationContext(), AdministradorActivity.class);
            startActivity(i);

        } else if (user.getRol().equals("paciente")){

            Intent i = new Intent(getApplicationContext(), PacienteActivity.class);
            startActivity(i);

        } else if (user.getRol().equals("personalMedico")){

            Intent i = new Intent(getApplicationContext(), PersonalMedicoActivity.class);
            startActivity(i);

        }
    }

    class loginUsuario extends AsyncTask<String, Float, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String resultado) {
            super.onPostExecute(resultado);
            int r = obtenerDatosJSON(resultado);
            if (r>0){
                LogInRol();
            } else {
                Toast.makeText(getApplicationContext(), "Usuario o Password incorrecto", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected String doInBackground(String... strings) {
            String resultado = connection.enviarDatosGet(enlace);
            return resultado;
        }
    }

    public int obtenerDatosJSON (String respuesta){
        Log.e("Respuesta", respuesta);
        int resultado = 0;
        try{
            JSONArray json = new JSONArray(respuesta);
            //Verficamos que el tamaño del json sea mayor que 0
            if (json.length()>0){
                resultado = 1;
                JSONObject row = json.getJSONObject(0);
                UsuarioLogIn.setIdentificacion(row.getInt("NUMERO_IDENTIFICACION"));
                UsuarioLogIn.setNombre(row.getString("NOMBRE"));
                UsuarioLogIn.setApellido(row.getString("APELLIDO"));
                UsuarioLogIn.setTelefono(row.getString("TELEFONO"));
                UsuarioLogIn.setEmail(row.getString("EMAIL"));
                UsuarioLogIn.setDireccion(row.getString("DIRECCION"));
                UsuarioLogIn.setUsername(row.getString("USER_NAME"));
                UsuarioLogIn.setGenero(row.getInt("GENERO_ID"));
                UsuarioLogIn.setPassword(row.getString("PASSWORD"));
                UsuarioLogIn.setRol(row.getString("ROL"));

                Log.e("usuario ", user.getNombre());

            }
        } catch (JSONException e){
            e.printStackTrace();
        }
        return resultado;
    }


}
