package com.suhailahnfsella.fudum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.DatePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Date;

public class HistoryOrderan extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_orderan);

        load();

        getSupportActionBar().setTitle("Riwayat Orderan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradientku));
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void load(){
        recyclerView = findViewById(R.id.rcvHistoryOrderan);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RcvHistoryOrderan[] rcvHistoryOrderans = new RcvHistoryOrderan[]{
                new RcvHistoryOrderan("krpktmp",
                        "111",
                        "Suhailah Nuriyah Fahma",
                        "Candiloka sjaifbjsbfjwbfjbwudbwjcbeijbfwbfieubdiwudfbeiubfeiufnkdcbdjvbdjkbvkdjvbkjdbcvkjdbkcjb",
                        "22/01/2020"),

                new RcvHistoryOrderan("krpktmp",
                        "111",
                        "Suhailah Nuriyah Fahma",
                        "Candiloka sjaifbjsbfjwbfjbwudbwjcbeijbfwbfieubdiwudfbeiubfeiufnkdcbdjvbdjkbvkdjvbkjdbcvkjdbkcjb",
                        "22/01/2020"),

                new RcvHistoryOrderan("krpktmp",
                        "111",
                        "Suhailah Nuriyah Fahma",
                        "Candiloka sjaifbjsbfjwbfjbwudbwjcbeijbfwbfieubdiwudfbeiubfeiufnkdcbdjvbdjkbvkdjvbkjdbcvkjdbkcjb",
                        "22/01/2020")

        };

        AdapterHistoryOrderan adapterHistoryOrderan = new AdapterHistoryOrderan(rcvHistoryOrderans, HistoryOrderan.this);
        recyclerView.setAdapter(adapterHistoryOrderan);
    }
}