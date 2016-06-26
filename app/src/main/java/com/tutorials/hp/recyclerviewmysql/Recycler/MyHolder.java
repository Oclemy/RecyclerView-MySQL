package com.tutorials.hp.recyclerviewmysql.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tutorials.hp.recyclerviewmysql.R;

/**
 * Created by Oclemmy on 3/29/2016 for ProgrammingWizards Channel.
 */
public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView nameTxt;
    ItemClickListener itemClickListener;


    public MyHolder(View itemView) {
        super(itemView);

        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);

        itemView.setOnClickListener(this);
    }

    public  void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(getLayoutPosition());
    }
}
