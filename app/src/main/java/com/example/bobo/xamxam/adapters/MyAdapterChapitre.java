package com.example.bobo.xamxam.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
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

public class MyAdapterChapitre extends RecyclerView.Adapter<MyAdapterChapitre.MyViewHolder> {


    private Context mContext;

    private List<Chapitre> mData;


    private Module module;




    public MyAdapterChapitre(Context mContext, List<Chapitre> mData, Module module) {
        this.mContext = mContext;
        this.mData = mData;
        this.module = module;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;

        LayoutInflater mInflater = LayoutInflater.from(mContext);

        view = mInflater.inflate(R.layout.list_item, viewGroup, false);

        return new MyAdapterChapitre.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {


        final Chapitre chapitre = mData.get(i);

        myViewHolder.textView.setText(mData.get(i).getTitre());

        Picasso.get().load(module.getLienPhoto()).into(new Target() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

                //myViewHolder.imageView.setBackground(new BitmapDrawable(mContext.getResources(), bitmap));

                myViewHolder.imageView.setBackground(new BitmapDrawable(mContext.getResources(), bitmap));
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });

        myViewHolder.imageView.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);


        myViewHolder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, VideoActivity.class);

                //passing date to video


                intent.putExtra("idChapitre", chapitre.getIdChapitre());

                intent.putExtra("lien", chapitre.getLien());

                intent.putExtra("idModule", chapitre.getIdModule());

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

        TextView textView;
        ImageView imageView;


        private View mView;




        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.txt);

            imageView = itemView.findViewById(R.id.img);


            mView = itemView;

        }
    }
}
