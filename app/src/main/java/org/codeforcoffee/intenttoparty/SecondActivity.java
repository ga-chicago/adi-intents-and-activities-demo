package org.codeforcoffee.intenttoparty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    private Intent mIntentToBeLame;
    private Intent mIntentToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.activity_second);

        Intent prevActivity = getIntent();
        String name = prevActivity.getStringExtra("NAME");
        int age = prevActivity.getIntExtra("AGE", 0);

        TextView txtFromActivity = (TextView) findViewById(R.id.txt_from_activity);
        txtFromActivity.setText(name);

        Button btnBack = (Button) findViewById(R.id.btn_back);
        Button btnLogin = (Button) findViewById(R.id.btn_sketch);
        mIntentToBeLame = new Intent(SecondActivity.this, MainActivity.class);
        String message = "hey main, plz learn 2 be chill and not call the RA next time";
        mIntentToBeLame.putExtra("MSG", message);
        mIntentToLogin = new Intent(SecondActivity.this, LoginActivity.class);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("SECOND", "click btn_back");
                startActivity(mIntentToBeLame);
            }
        };

        View.OnClickListener sketchyLoginListener = new View.OnClickListener() {
          @Override
            public void onClick(View v) {
              startActivity(mIntentToLogin);
          }
        };

        btnBack.setOnClickListener(listener);
        btnLogin.setOnClickListener(sketchyLoginListener);
    }
}
