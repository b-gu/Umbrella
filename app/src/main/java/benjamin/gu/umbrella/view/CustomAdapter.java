package benjamin.gu.umbrella.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import benjamin.gu.umbrella.R;
import benjamin.gu.umbrella.model.ListPojo;
import benjamin.gu.umbrella.model.WeatherPojo;

public class CustomAdapter  extends RecyclerView.Adapter<CustomViewHolder> {

    private ArrayList<ListPojo> dataset;
    private Context context;

    public CustomAdapter(Context context){
        this.context = context;
    }

    public void setDataset(ArrayList<ListPojo> dataset){
        this.dataset = dataset;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_layout,
                                parent,
                                false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.time.setText(dataset.get(position).getDate());
        holder.temperature.setText(dataset.get(position).description);
        Glide.with(context)
                .load(dataset.get(position).URL)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
