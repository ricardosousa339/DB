package db.eng.com.db;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;
import java.util.logging.Handler;

public class ItemCasaRecyclerAdapter extends RecyclerView.Adapter<ItemCasaHolder> {

    private List<ItemCasa> mLista;
    private Context mContext;

    private static int currentPosition = -1;
    private LinearLayout tempLinearLayout = null;

    public ItemCasaRecyclerAdapter(Context context,
                                   List<ItemCasa> lista){
        mLista = lista;
        mContext = context;
    }

    @NonNull
    @Override
    public ItemCasaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_casa, parent,false);
        return new ItemCasaHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemCasaHolder holder,  int position) {

        ItemCasa itemCasa = mLista.get(position);
        holder.textoPrincipal.setText(itemCasa.getNome());
        holder.textoSecundario.setText("Concluído:"+itemCasa.getQuantidadeConcluida()+"/"+itemCasa.getQuantidadeTotal());

        holder.textoExpand1.setText(itemCasa.getDetalhes1());
        holder.textoExpand2.setText(itemCasa.getDetalhes2());
        holder.textoExpand3.setText(itemCasa.getDetalhes3());

        holder.linearLayout.setVisibility(View.GONE);
        holder.imageButtonExpand.setVisibility(View.VISIBLE);

        switch (itemCasa.getIcone()){
            case ItemCasa.BANHEIRO: holder.iconeComodo.setImageResource(R.drawable.banheiro);break;
            case ItemCasa.QUARTO: holder.iconeComodo.setImageResource(R.drawable.quarto);break;
            case ItemCasa.AREA_DE_SERVICO:holder.iconeComodo.setImageResource(R.drawable.hall);break;
            case ItemCasa.COZINHA:holder.iconeComodo.setImageResource(R.drawable.cozinha);break;
            case ItemCasa.SALA:holder.iconeComodo.setImageResource(R.drawable.saladeestar);break;
            default: holder.iconeComodo.setImageResource(R.drawable.escrivaninha);
        }

        if (currentPosition == position) {
            //toggling visibility
            holder.linearLayout.setVisibility(View.VISIBLE);
            holder.cardViewConteiner.setElevation(20);
            holder.cardViewConteiner.setZ(20);

            //adding sliding effect
            //holder.linearLayout.startAnimation(slideDown);
        }



        holder.imageButtonExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (currentPosition != holder.getAdapterPosition()){
                    holder.linearLayout.setVisibility(View.INVISIBLE);
                    holder.cardViewConteiner.setElevation(3);
                    holder.linearLayout.refreshDrawableState();
                    notifyItemChanged(currentPosition);
                }

                //getting the position of the item to expand it
                currentPosition = holder.getAdapterPosition();
                tempLinearLayout = holder.linearLayout;
               // holder.imageButtonExpand.setVisibility(View.GONE);
                //reloding the list
                notifyItemChanged(currentPosition);


            }
        });
    }

    @Override
    public int getItemCount() {
        return mLista.size();
    }
    public ItemCasa getItem(int position){
        return mLista.get(position);
    }
}
