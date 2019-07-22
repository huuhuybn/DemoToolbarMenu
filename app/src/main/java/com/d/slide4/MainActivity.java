package com.d.slide4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvOpenContextMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        tvOpenContextMenu = findViewById(R.id.tvOpenContextMenu);

        // dang ki context menu cho textView hoac 1 view bat ki

        registerForContextMenu(tvOpenContextMenu);

        tvOpenContextMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopUpMenu();
            }
        });

    }


    public void createPopUpMenu() {

        PopupMenu popupMenu = new PopupMenu(MainActivity.this, tvOpenContextMenu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.menu_one:
                        Toast.makeText(MainActivity.this, "Menu One CLicked", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menu_two:
                        Toast.makeText(MainActivity.this, "Menu Two CLicked", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menu_three:
                        Toast.makeText(MainActivity.this, "Menu Three CLicked", Toast.LENGTH_SHORT).show();
                        break;

                }


                return false;
            }
        });
        popupMenu.show();


    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_one:
                Toast.makeText(this, "Menu One CLicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_two:
                Toast.makeText(this, "Menu Two CLicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_three:
                Toast.makeText(this, "Menu Three CLicked", Toast.LENGTH_SHORT).show();
                break;


        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // khoi tao option menu

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.my_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {

            case R.id.menu_one:
                Toast.makeText(this, "Menu One CLicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_two:
                Toast.makeText(this, "Menu Two CLicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_three:
                Toast.makeText(this, "Menu Three CLicked", Toast.LENGTH_SHORT).show();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    public void opeNew(View view) {

        Intent intent = new Intent(MainActivity.this, SubActivity.class);
        startActivity(intent);


    }
}
