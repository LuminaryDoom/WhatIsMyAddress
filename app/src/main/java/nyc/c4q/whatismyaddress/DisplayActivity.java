package nyc.c4q.whatismyaddress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView view01;

    TextView view02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        String userMail = intent.getStringExtra("emailaddress");

        view01 = (TextView) findViewById(R.id.textView4);
        view02 = (TextView) findViewById(R.id.textView5);

        view01.setText("itemvalue "+userMail);
        String numlength = "number of chars: ";
         numlength += Integer.toString(userMail.length());
        view02.setText(numlength);

    }
}
