package Bao.ntu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class LandAdapter extends RecyclerView.Adapter<LandAdapter.ItemLandHolder> {
    Context context;
    ArrayList<LandScape> lstData;

    public LandAdapter(Context context, ArrayList<LandScape> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View vItem = cai_bom.inflate(R.layout.item_land, parent, false);
        ItemLandHolder holderCreated = new ItemLandHolder(vItem);
        return holderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        //Lay doi tuong hien thi
        LandScape landScapeHienThi = lstData.get(position);
        //Trich thong tin
        String caption = landScapeHienThi.getLandCaption();
        String tenAnh = landScapeHienThi.getLandimgFileName();
        //Dat cac truong thong tin cua holder
        holder.tvCaption.setText(caption);
        //dat anh
            String packageName = holder.itemView.getContext().getPackageName();
            int imageID = holder.itemView.getResources().getIdentifier(tenAnh,"mipmap", packageName);
        holder.ivLandScape.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvCaption;
        ImageView ivLandScape;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.textViewCation);
            ivLandScape = itemView.findViewById(R.id.imageViewLand);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        //Xu ly code
            int viTriDuocClick = getAdapterPosition();
           LandScape ptuduocchon  = lstData.get(viTriDuocClick);
           //boc ttin
            String ten = ptuduocchon.getLandCaption();
            String tenFile = ptuduocchon.getLandimgFileName();
            //Toast ten
            String chuoiThongBao = "Ban vua chon: " + ten;
            Toast.makeText(v.getContext(), chuoiThongBao, Toast.LENGTH_LONG).show();
        }
    }
}
