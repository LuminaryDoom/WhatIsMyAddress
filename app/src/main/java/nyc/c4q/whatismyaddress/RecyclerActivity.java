package nyc.c4q.whatismyaddress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecyclerActivity extends AppCompatActivity {

    private SharedPreferences retrivedPrefs;
    private RecyclerView emailRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Intent intent = getIntent();
        intent.getStringExtra("sharedprefs");

        retrivedPrefs = getApplicationContext().getSharedPreferences(intent.getStringExtra("sharedprefs"), MODE_PRIVATE);
        List<String> arrayofEntries = new ArrayList<>();
        Map<String, ?> allEntries = retrivedPrefs.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            arrayofEntries.add(entry.getValue().toString());
        }

        List<Emails> emailsList = new ArrayList<>();

        for (String temp : arrayofEntries)
        {
            emailsList.add(new Emails(temp));
        }


        emailRecycler = (RecyclerView) findViewById(R.id.emails_recycler_view);
        EmailsAdapter emailsAdapter = new EmailsAdapter(emailsList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        emailRecycler.setAdapter(emailsAdapter);
        emailRecycler.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this));
    }
}
