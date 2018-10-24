package com.example.bobo.xamxam.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bobo.xamxam.R;
import com.example.bobo.xamxam.VideoActivity;
import com.example.bobo.xamxam.beans.Chapitre;
import com.example.bobo.xamxam.beans.Module;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class ChapitreAdapter extends RecyclerView.Adapter<ChapitreAdapter.MyViewHolder> {


    private Context mContext;

    private List<Chapitre> mData;


    private Module module;


    public ChapitreAdapter(Context mContext, List<Chapitre> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    public ChapitreAdapter(Context mContext, List<Chapitre> mData, Module module) {
        this.mContext = mContext;
        this.mData = mData;
        this.module = module;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;

        LayoutInflater mInflater = LayoutInflater.from(mContext);

        view = mInflater.inflate(R.layout.card_item, viewGroup, false);
        return new ChapitreAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {


        myViewHolder.tv_book_title.setText(mData.get(i).getTitre());

        // myViewHolder.img_book.setBackgroundResource(module.getLienPhoto());

        //---------bon

        // Picasso.get().load(module.getLienPhoto()).into(myViewHolder.img_book);



        Picasso.get().load(module.getLienPhoto()).into(new Target() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

                myViewHolder.img_book.setBackground(new BitmapDrawable(mContext.getResources(), bitmap));
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });



        myViewHolder.img_book.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);


        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Toast.makeText(mContext, String.valueOf(mData.get(i).getIdChapitre()), Toast.LENGTH_LONG).show();


              Intent intent = new Intent(mContext, VideoActivity.class);

                //passing date to video

                intent.putExtra("idChapitre", mData.get(i).getIdChapitre());

                intent.putExtra("lien", mData.get(i).getLien());

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
