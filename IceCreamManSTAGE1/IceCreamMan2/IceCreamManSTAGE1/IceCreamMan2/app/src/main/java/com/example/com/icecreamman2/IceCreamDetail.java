package com.example.com.icecreamman2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class IceCreamDetail extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_ice_cream);

        String imageFromClickedIceCream = getIntent().getStringExtra("image");
        String nameFromClickedIceCream = getIntent().getStringExtra("name");

        ImageView detailIceCreamImage = findViewById(R.id.detailIceCreamImage);
        TextView detailIceCreamName = findViewById(R.id.detailIceCreamName);

        Picasso.get().load(imageFromClickedIceCream).into(detailIceCreamImage);
        detailIceCreamName.setText(nameFromClickedIceCream);

    }


}
