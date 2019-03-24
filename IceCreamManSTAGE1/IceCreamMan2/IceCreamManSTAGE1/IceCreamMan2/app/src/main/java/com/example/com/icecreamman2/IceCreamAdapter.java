package com.example.com.icecreamman2;


import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.icu.util.ICUUncheckedIOException;
import android.media.Image;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;



import com.squareup.picasso.Picasso;


import java.util.ArrayList;



public class IceCreamAdapter extends RecyclerView.Adapter<IceCreamAdapter.IceCreamAdapterViewHolder> {


    public class IceCreamAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {



        public ImageView iceCreamImageView;
        public TextView iceCreamTextView;


        //our adapter is made up of 3 views that matter being the image,
        //the title and the description



        public IceCreamAdapterViewHolder(View itemView) {
            super(itemView);

            iceCreamImageView = itemView.findViewById(R.id.ice_cream_icon);
            iceCreamTextView = itemView.findViewById(R.id.ice_cream_name);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent iceCreamDetailScreen = new Intent(getContext(), IceCreamDetail.class);
                    iceCreamDetailScreen.putExtra("image", mIceCreamImages.get(getAdapterPosition()));
                    iceCreamDetailScreen.putExtra("name", mIceCreamNames.get(getAdapterPosition()));
                    view.getContext().startActivity(iceCreamDetailScreen);
                }
            });


        }


        @Override
        public void onClick(View v) {

        }
    }

    private Context mContext;

    private ArrayList<String> mIceCreamImages;

    private ArrayList<String> mIceCreamNames;



    public IceCreamAdapter(Context context, ArrayList<String> iceCreamImageList,
                           ArrayList<String> iceCreamNameList) {

        mContext = context;

        mIceCreamImages = iceCreamImageList;

        mIceCreamNames = iceCreamNameList;

    }


    private Context getContext() {
        return mContext;
    }

    @Override
    public IceCreamAdapter.IceCreamAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);


        View drawableView = inflater.inflate(R.layout.ice_cream_layout_item, parent, false);

        IceCreamAdapterViewHolder viewHolder = new IceCreamAdapterViewHolder(drawableView);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(IceCreamAdapter.IceCreamAdapterViewHolder holder, int position) {




        String iceCreamImage = mIceCreamImages.get(position);
        String iceCreamName = mIceCreamNames.get(position);

        Log.d("ICECREAM", iceCreamImage);

        Picasso.get().setLoggingEnabled(true);
        Picasso.get().load(iceCreamImage).into(holder.iceCreamImageView);
        holder.iceCreamTextView.setText(iceCreamName);






    }





    @Override
    public int getItemCount() {
        return mIceCreamNames.size();
    }
}


