package co.fajri.infokotawisatabatu;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.MenuAwal> {
    public ArrayList<Wisata> listWisata;
    private Context  context;

    public WisataAdapter(ArrayList<Wisata> list){
        this.listWisata = list;
    }

    //menginisiasi adapter ke layout main menu
    @NonNull
    @Override
    public MenuAwal onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_menu, viewGroup, false);
        return new MenuAwal(view);
    }

    //memasaang data ke layout main menu
    @Override
    public void onBindViewHolder(@NonNull final MenuAwal holder, final int position) {
        //mendapat daata dari listWisata <Wisata>
        Wisata wisata = listWisata.get(position);

        //mengambil gambar dari internet dan memasangnya
        Glide.with(holder.itemView.getContext())
                .load(wisata.getPhoto())
                .apply(new RequestOptions().override(100, 100))
                .into(holder.foto);

        //mengambil data dari WisataData dan memasangnya
        holder.tvNama.setText(wisata.getTempat());
        holder.tvHarga.setText(wisata.getAlamat());
        holder.rbWisata.setRating(Float.parseFloat(wisata.getRating()));

        //mengaktifkan onClickListener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = v.getContext();
                //mengaktifkan pindah activity ke DetailActivity
                Intent intent = new Intent(context,DetailActivity.class);
                //melempar data posisi arrat ke DetailActivity
                intent.putExtra(DetailActivity.POSITION, position);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listWisata.size();
    }

    //mengalamatkan tujuan tempat pemasangan
    public class MenuAwal extends RecyclerView.ViewHolder {
        ImageView foto;
        TextView tvNama, tvHarga;
        RatingBar rbWisata;

        public MenuAwal(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.img_foto);
            tvNama = itemView.findViewById(R.id.tempat_wisata);
            tvHarga = itemView.findViewById(R.id.harga_wisata);
            rbWisata = itemView.findViewById(R.id.rating);
        }
    }

}