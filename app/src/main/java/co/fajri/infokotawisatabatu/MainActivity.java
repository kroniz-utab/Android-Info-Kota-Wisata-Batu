package co.fajri.infokotawisatabatu;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvWisata;
    private ArrayList<Wisata> list = new ArrayList<>();
    private String judul = "Info Wisata Kota Batu";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //memasang recycler view pada activity_main
        rvWisata = findViewById(R.id.rv_wisata);
        rvWisata.setHasFixedSize(true);
        
        list.addAll(WisataData.getListData());
        showMenu();

        //memberi judul pada ActionBar
        setActionBarTitle(judul);
    }

    //menginisiasi menampilkan adapter ke rvWisata
    private void showMenu() {
        rvWisata.setLayoutManager(new LinearLayoutManager(this));
        WisataAdapter wisataAdapter = new WisataAdapter(list);
        rvWisata.setAdapter(wisataAdapter);
    }

    //menginisiasi setActionBarTitle untuk memberi judul pada ActionBar
    private void setActionBarTitle(String title){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    //membuat option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //membuat item dalam option menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    //menginisiasi aktifitas dalam option menu
    private void setMode(int selectedMode) {
        switch (selectedMode){
            case R.id.about:
            Intent intent = new Intent(MainActivity.this, About.class);
            startActivity(intent);
            break;
        }
    }

}
