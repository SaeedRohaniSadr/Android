package com.saeed.best_banks;
/* Saeed */

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements listAdapter.ListItemClickListener {
    private static final int NUM_LIST_ITEMS = 10;
    private listAdapter mAdapter;
    private RecyclerView mNumbersList;

    private Toast mToast;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumbersList = (RecyclerView) findViewById(R.id.rv_numbers);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNumbersList.setLayoutManager(layoutManager);
        mNumbersList.setHasFixedSize(true);
        mAdapter = new listAdapter(NUM_LIST_ITEMS, this);
        mNumbersList.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();

        switch (itemId) {
            case R.id.action_refresh:
                mAdapter = new listAdapter(NUM_LIST_ITEMS, this);
                mNumbersList.setAdapter(mAdapter);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onListItemClick(int clickedItemIndex , View itemView) {
        Uri webpage;
        Intent intent;
        if(mToast!=null){
            mToast.cancel();
        }
        itemView.setBackgroundColor(188000000);
        String toastMessage = " Item#" + clickedItemIndex + "clicked.";
        mToast= Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);
        mToast.show();
       switch(clickedItemIndex){
           case 0:
            webpage = Uri.parse("https://www.bankofamerica.com");
            intent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(intent);
            break;
           case 1:
               webpage = Uri.parse("https://www.usbank.com");
               intent = new Intent(Intent.ACTION_VIEW, webpage);
               startActivity(intent);
               break;
           case 2:
               webpage = Uri.parse("https://www.chase.com");
               intent = new Intent(Intent.ACTION_VIEW, webpage);
               startActivity(intent);
               break;
           case 3:
               webpage = Uri.parse("https://www.keybank.com");
               intent = new Intent(Intent.ACTION_VIEW, webpage);
               startActivity(intent);
               break;
           case 4:
               webpage = Uri.parse("https://www.wellsfargo.com");
               intent = new Intent(Intent.ACTION_VIEW, webpage);
               startActivity(intent);
               break;
           case 5:
               webpage = Uri.parse("https://www.becu.com");
               intent = new Intent(Intent.ACTION_VIEW, webpage);
               startActivity(intent);
               break;
           case 6:
               webpage = Uri.parse("https://www.capitalone.com");
               intent = new Intent(Intent.ACTION_VIEW, webpage);
               startActivity(intent);
               break;
           case 7:
               webpage = Uri.parse("https://www.alaskausa.com");
               intent = new Intent(Intent.ACTION_VIEW, webpage);
               startActivity(intent);
               break;
           case 8:
               webpage = Uri.parse("https://www.umpquahbank.com");
               intent = new Intent(Intent.ACTION_VIEW, webpage);
               startActivity(intent);
               break;
           case 9:
               webpage = Uri.parse("https://www.discover.com");
               intent = new Intent(Intent.ACTION_VIEW, webpage);
               startActivity(intent);
               break;
        }

    }

}