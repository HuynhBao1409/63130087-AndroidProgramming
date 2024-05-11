package thick.GBao63130087.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import thick.GBao63130087.Domains.Hourly;
import thick.GBao63130087.Domains.TomorrowDomain;
import thick.GBao63130087.R;


public class TomorrowAdapter extends RecyclerView.Adapter<TomorrowAdapter.ViewHolder> {
    ArrayList<TomorrowDomain> items;
    Context context;

    public TomorrowAdapter(ArrayList<TomorrowDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public TomorrowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // khởi tạo ViewHolder và gán vào layout
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_tomorrow, parent, false);
        context = parent.getContext();
        // trả về ViewHolder và hiển thị các mục trong RecyclerView
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull TomorrowAdapter.ViewHolder holder, int position) {
        // lấy giá trị từ TomorrowDomain
        holder.dayTxt.setText(items.get(position).getDay());
        holder.statusTxt.setText(items.get(position).getStatus());
        holder.highTxt.setText(items.get(position).getHighTemp());
        holder.lowTxt.setText(items.get(position).getLowTemp());

        // định danh ảnh trong drawable, lưu trong list
        int drawableResourceId = context.getResources()
                .getIdentifier(items.get(position).getPicPath(), "drawable", context.getPackageName());
        // thư viện glide tải ảnh lên
        Glide.with(context).load(drawableResourceId).into(holder.pic);
    }

    @Override
    public int getItemCount() {
        // trả về đúng số lương items trong List
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dayTxt,statusTxt,lowTxt,highTxt;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // ánh xạ với các thành phần viewholder_tomorrow
            dayTxt=itemView.findViewById(R.id.dayTxt);
            statusTxt=itemView.findViewById(R.id.statusTxt);
            lowTxt=itemView.findViewById(R.id.lowTxt);
            highTxt=itemView.findViewById(R.id.highTxt);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}
