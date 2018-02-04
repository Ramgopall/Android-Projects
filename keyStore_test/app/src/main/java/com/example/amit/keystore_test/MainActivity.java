package com.example.amit.keystore_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class MainActivity extends AppCompatActivity {
    EditText inputt,passwordd;
    Button encryptt,decryptt;
    TextView tv;
    String outputString;
    String AES = "AES";


    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputt = (EditText) findViewById(R.id.txt1);
        passwordd = (EditText) findViewById(R.id.txt2);
        encryptt = (Button) findViewById(R.id.encrypt);
        decryptt = (Button) findViewById(R.id.decrypt);
        tv= (TextView) findViewById(R.id.tv1);

        encryptt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    outputString = encrypt(inputt.getText().toString(),passwordd.getText().toString());
                    tv.setText(outputString);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "1111", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        decryptt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    outputString = decrypt(outputString,passwordd.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "wrong password", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                tv.setText(outputString);
            }
        });



    }

    private String decrypt(String outputString, String password) throws Exception {
        SecretKeySpec key = generateKey(password);
        Cipher c = Cipher.getInstance(AES);
        c.init(Cipher.DECRYPT_MODE,key);
        byte[] decryptedvalue = Base64.decode(outputString,Base64.DEFAULT);
        byte[] decValue = c.doFinal(decryptedvalue);
        String decryptValue = new String (decValue);
        return decryptValue;
    }

    private String encrypt(String data, String password) throws Exception {

        SecretKeySpec key = generateKey(password);
        Cipher c = Cipher.getInstance(AES);
        c.init(Cipher.ENCRYPT_MODE,key);
        byte[] encValue = c.doFinal(data.getBytes());
        String encryptedValue = Base64.encodeToString(encValue,Base64.DEFAULT);
        return encryptedValue;
    }

    private SecretKeySpec generateKey(String password) throws Exception {
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = password.getBytes("UTF-8");
        digest.update(bytes,0,bytes.length);
        byte[] key = digest.digest();
        SecretKeySpec secretKeySpec = new SecretKeySpec(key,"AES");
        return secretKeySpec;
    }

}
