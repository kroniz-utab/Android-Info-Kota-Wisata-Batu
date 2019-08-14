package co.fajri.infokotawisatabatu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    public static final String POSITION = "position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //menerima data yang dilempar dari Adapter
        int pos = getIntent().getIntExtra(POSITION,0);

        //mengambil data dari model
        Wisata wisata = WisataData.getListData().get(pos);

        //memasang data pada activity_detail
        TextView alamat = findViewById(R.id.tv_alamat_detail);
        TextView telepon = findViewById(R.id.tv_telepon_detail);
        TextView harga = findViewById(R.id.tv_harga_detail);
        TextView jam = findViewById(R.id.tv_waktu_detail);
        TextView subs = findViewById(R.id.tv_subs_detail);
        TextView ratingtv = findViewById(R.id.tv_rating);
        ImageView photo = findViewById(R.id.img_detail_gambar);
        RatingBar ratingrb = findViewById(R.id.rb_rating_detai);

        //memanggil data dari Wisata
        alamat.setText(wisata.getAlamat());
        telepon.setText(wisata.getTelepon());
        harga.setText(wisata.getHarga());
        jam.setText(wisata.getJam());
        subs.setText(wisata.getSubs());
        ratingtv.setText(wisata.getRating());
        ratingrb.setRating(Float.parseFloat(wisata.getRating()));

        Glide.with(this)
                .load(wisata.getPhoto())
                .apply(new RequestOptions().override(160,250))
                .into(photo);

        //membuat actionBarTitle dari data tempat
        setActionBarTitle(wisata.getTempat());
    }

    //menginisiasi setActionBarTitle
    private void setActionBarTitle(String title){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }
}
