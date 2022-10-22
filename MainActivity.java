package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button login_button;
    EditText username_text;
    EditText password_text;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_button = (Button)findViewById(R.id.log_button);
        username_text = (EditText)findViewById(R.id.username_text);
        password_text = (EditText)findViewById(R.id.password_text);
      //   String log = username_text.getText().toString();
     //   String pas = password_text.getText().toString();

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
checkUsername();

               // String log = username_text.getText().toString();
              //  String pas = password_text.getText().toString();
///// te 3 linijki pod spodem dzialaly
            //    Intent intent = new Intent(getApplicationContext(),AdminAC.class);
              //  intent.putExtra("message_key", log);

             //   startActivity(intent);
            }
        });


    }

    void checkUsername()
    {
        boolean validation = true;
        if(isEmpty(username_text)){
username_text.setError("Wprowadz login !");
validation = false;

        }
        if (isEmpty(password_text))
        {
            password_text.setError("Wprowadz haslo");
            validation= false;

        }
        else{
            if(password_text.getText().toString().length() < 5)
            {
                password_text.setError("Haslo musi byc dluzsze niz 5 znakow");
                validation = false;

            }

        }
        if (validation)
        {

            String log = username_text.getText().toString();
            String pas = password_text.getText().toString();
    if(log.equals("admin") && pas.equals("admin1234"))
    {

        Intent intent = new Intent(getApplicationContext(),AdminAC.class);
        intent.putExtra("message_key", log);
        startActivity(intent);
      //  finish();
    }
    else
    {
        Toast t = Toast.makeText(this, "Zly login lub haslo!", Toast.LENGTH_SHORT);
        t.show();
    }

}

    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }


}
