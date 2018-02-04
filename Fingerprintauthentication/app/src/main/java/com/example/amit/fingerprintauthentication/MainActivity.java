package com.example.amit.fingerprintauthentication;

import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.CancellationSignal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import javax.crypto.Cipher;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FingerprintManagerCompat fmc = FingerprintManagerCompat.from(MainActivity.this);
        if(fmc.isHardwareDetected())
        {
            Toast.makeText(this, "Hardware Available", Toast.LENGTH_SHORT).show();
            Cipher c = null;
            FingerprintManagerCompat.CryptoObject oc = new FingerprintManagerCompat.CryptoObject(c);

            fmc.authenticate(oc, 0, new CancellationSignal(), new FingerprintManagerCompat.AuthenticationCallback() {
                @Override
                public void onAuthenticationError(int errMsgId, CharSequence errString) {
                    super.onAuthenticationError(errMsgId, errString);
                    Toast.makeText(MainActivity.this, errString, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAuthenticationHelp(int helpMsgId, CharSequence helpString) {
                    super.onAuthenticationHelp(helpMsgId, helpString);
                    Toast.makeText(MainActivity.this, helpString, Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult result) {
                    super.onAuthenticationSucceeded(result);
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onAuthenticationFailed() {
                    super.onAuthenticationFailed();
                    Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();

                }
            }, null);
        }

        else
        {
            Toast.makeText(this, "hardware unavailavle", Toast.LENGTH_SHORT).show();
        }

    }
}
