package com.example.bobo.xamxam.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bobo.xamxam.ChapitresActivity;
import com.example.bobo.xamxam.R;
import com.example.bobo.xamxam.beans.Module;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.MyViewHolder>  {

    private Context mContext;


    private List<Module> mData;


    public ModuleAdapter(Context mContext, List<Module> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;

        LayoutInflater mInflater = LayoutInflater.from(mContext);

        view = mInflater.inflate(R.layout.card_item, viewGroup, false);
        return new ModuleAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {


        myViewHolder.tv_book_title.setText(mData.get(i).getNomModule());

        // myViewHolder.img_book.setImageResource(mData.get(i).getPhotoModule());


        //myViewHolder.img_book.setImageResource(R.drawable.francais);


        Picasso.get().load(mData.get(i).getLienPhoto()).into(myViewHolder.img_book);


        // Picasso.get().load(mData.get(i).getPhotoModule()).into(myViewHolder.img_book);





        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, ChapitresActivity.class);

                //passing data to another activity

                intent.putExtra("idModule", mData.get(i).getIdModule());

                //start activity
                mContext.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv_book_title;
        ImageView img_book;

        CardView cardView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_book_title = itemView.findViewById(R.id.book_title);

            img_book = itemView.findViewById(R.id.book_img);



            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
