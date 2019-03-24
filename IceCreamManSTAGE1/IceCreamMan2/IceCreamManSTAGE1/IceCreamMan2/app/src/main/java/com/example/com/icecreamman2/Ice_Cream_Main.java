package com.example.com.icecreamman2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Ice_Cream_Main extends AppCompatActivity {


    private RecyclerView iceCreamRecyclerView;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ice__cream__main);
        iceCreamRecyclerView = findViewById(R.id.iceCreamRecycler);
        mContext = getApplicationContext();
        updateIceCreamRecycler();
    }


    public void updateIceCreamRecycler(){
        if(iceCreamRecyclerView != null){
            IceCreamAdapter iceCreamAdapter = new IceCreamAdapter(mContext,
                    generateIceCreamImageLinks(), generateIceCreamNames());
            iceCreamRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            iceCreamRecyclerView.setAdapter(iceCreamAdapter);
        }
    }


    public ArrayList<String> generateIceCreamImageLinks(){
        String vanillaImageLink = "https://firebasestorage.googleapis.com/v0/b/gymapp-8e0cc.appspot.com/o/vanilla.png?alt=media&token=f705daf8-d136-4a0b-acc1-d65582df64f8";
        String mintChocolateImageLink = "https://firebasestorage.googleapis.com/v0/b/gymapp-8e0cc.appspot.com/o/mintchocolate.png?alt=media&token=88bd61c2-2545-4e9b-b926-ff66b62190f6";
        String cottonCandyImageLink = "https://firebasestorage.googleapis.com/v0/b/gymapp-8e0cc.appspot.com/o/cottoncandy.png?alt=media&token=5e21b66b-b634-4343-8997-5496b811a573";

        ArrayList<String> iceCreamImageLinks = new ArrayList<>();
        iceCreamImageLinks.add(vanillaImageLink);
        iceCreamImageLinks.add(mintChocolateImageLink);
        iceCreamImageLinks.add(cottonCandyImageLink);

        return iceCreamImageLinks;

    }

    public ArrayList<String> generateIceCreamNames(){
        String vanillaName = "Vanilla";
        String mintChocolateName = "Mint Chocolate";
        String cottonCandyName = "Cotton Candy";

        ArrayList<String> iceCreamImageNames = new ArrayList<>();
        iceCreamImageNames.add(vanillaName);
        iceCreamImageNames.add(mintChocolateName);
        iceCreamImageNames.add(cottonCandyName);

        return iceCreamImageNames;

    }

}
