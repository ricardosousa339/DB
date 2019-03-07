package db.eng.com.db;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ItemCasaHolder extends RecyclerView.ViewHolder {

    public ImageView iconeComodo;
    public TextView textoPrincipal;
    public TextView textoSecundario;
    public LinearLayout linearLayout;
    public TextView textoExpand1;
    public TextView textoExpand2;
    public TextView textoExpand3;
    public ImageButton imageButtonExpand;
    public CardView cardViewConteiner;
    public ImageView fotoDetalhe;



    public ItemCasaHolder(View itemView) {
        super(itemView);
        this.iconeComodo = itemView.findViewById(R.id.imageViewComodo);
        this.textoPrincipal = itemView.findViewById(R.id.textViewItemPrincipal);
        this.textoSecundario = itemView.findViewById(R.id.textViewItemSecundario);
        this.linearLayout = itemView.findViewById(R.id.linearLayoutHide);
        this.textoExpand1 = itemView.findViewById(R.id.textViewExpand1);
        this.textoExpand2 = itemView.findViewById(R.id.textViewExpand2);
        this.textoExpand3 = itemView.findViewById(R.id.textViewExpand3);
        this.imageButtonExpand = itemView.findViewById(R.id.imageButtonExpand);
        this.cardViewConteiner = itemView.findViewById(R.id.linearLayout);
        this.fotoDetalhe = itemView.findViewById(R.id.imageViewDetalhe);
    }


}
