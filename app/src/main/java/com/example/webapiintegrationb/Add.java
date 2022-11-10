package com.example.webapiintegrationb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Add extends AppCompatActivity {
    EditText name,phno,address;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name=findViewById(R.id.name);
        phno=findViewById(R.id.phno);
        address=findViewById(R.id.address);
        save=findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringRequest request=new StringRequest(
                        Request.Method.POST, "http://192.168.137.222/smdb/insert.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject object=new JSONObject(response);
                                    if(object.getInt("resultcode")==1)
                                    {
                                        finish();
                                    }
                                    else{
                                        Toast.makeText(Add.this,object.get("msg").toString(),Toast.LENGTH_LONG).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Toast.makeText(Add.this,"Cannot Parse JOSN",Toast.LENGTH_LONG).show();

                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Add.this,"Cannot Connect to the Server",Toast.LENGTH_LONG).show();

                            }
                        })
                {
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params=new HashMap<>();
                        params.put("name",name.getText().toString());
                        params.put("phno",phno.getText().toString());
                        params.put("address",address.getText().toString());
                        return params;
                    }
                };
                RequestQueue queue= Volley.newRequestQueue(Add.this);
                queue.add(request);

            }
        });
    }
}