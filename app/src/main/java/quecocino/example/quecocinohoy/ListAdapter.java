package quecocino.example.quecocinohoy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quecocinohoy.R;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    Context context;
    ArrayList<Receta> list;

    public ListAdapter(Context context, ArrayList<Receta> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_element, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.MyViewHolder holder, int position) {
        Receta receta = list.get(position);
        holder.nombre.setText(receta.getNombre());
        holder.descripcion.setText(receta.getDescripcion());
        holder.tipo.setText(receta.getTipo());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nombre, descripcion, tipo;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            nombre = itemView.findViewById(R.id.nameTextView);
            descripcion = itemView.findViewById(R.id.descripcionTextView);
            tipo = itemView.findViewById(R.id.tipoTextView);
        }
    }
}
