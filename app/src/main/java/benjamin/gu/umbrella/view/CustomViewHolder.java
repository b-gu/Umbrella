package benjamin.gu.umbrella.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import benjamin.gu.umbrella.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {


    ImageView imageView;
    TextView time;
    TextView temperature;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.forecast_condition);
        time = itemView.findViewById(R.id.forecast_time);
        temperature = itemView.findViewById(R.id.forecast_temp);
    }
}
