package com.example.unimate;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {
    EditText username, user_email, user_phone, user_password,u_comfirm_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        username = findViewById(R.id.username);
        user_email = findViewById(R.id.user_email);
        user_phone = findViewById(R.id.user_phone);
        user_password = findViewById(R.id.password);
        u_comfirm_password = findViewById(R.id.comfirm_password);

    }

    public void doRegister(View view) {
        String name = username.getText().toString();
        String email = user_email.getText().toString();
        String phone = user_phone.getText().toString();
        String password = user_password.getText().toString();
        String comfirm_password = u_comfirm_password.getText().toString();

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "http://192.168.0.11:8084/First_application/Register",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Registration.this, ""+response, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Registration.this, Login.class);
                        startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Registration.this, ""+error, Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                HashMap hm = new HashMap();
                hm.put("key_name", name);
                hm.put("key_email", email);
                hm.put("key_phone", phone);
                hm.put("key_password", password);
                hm.put("key_confirm_password", comfirm_password);

                return hm;
            }
        };
        requestQueue.add(stringRequest);

    }
}