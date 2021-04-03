package com.example.task;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.task.entity.Product;
import com.example.task.entity.ProductPrice;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyMovieViewHolder> {

    private Context mContext;
    private List<Product> mMovieList;

    public ProductAdapter(Context context, List<Product> movieArrayList) {
        mContext = context;
        mMovieList = movieArrayList;
    }

    @NonNull
    @Override
    public MyMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_product, parent, false);
        return new MyMovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyMovieViewHolder holder, int position) {
        Product product = mMovieList.get(position);

        String productImage = product.getProductImage();
        String productName = product.getProductName();
        List<ProductPrice> productPrices = product.getProductPrice();

        Glide
                .with(mContext)
                .load(productImage)
                .centerCrop()
                .placeholder(R.drawable.progress_animation)
                .into(holder.product_img);
        holder.product_name.setText(productName);
        holder.offer_price.setText("$"+productPrices.get(0).getProductPrice());
        holder.actual_price.setText("$"+productPrices.get(0).getProductPrice());
        holder.actual_price.setPaintFlags(holder.actual_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.selected_variant.setText("Variant "+ productPrices.get(0).getProductVariation());
        Log.v("imagepath", productImage);

//        holder.selected_variant.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ShowDropDown(holder, productPrices.get(0).getProductVariation());
//            }
//        });

        final int[] count = {Integer.parseInt(holder.quantity.getText().toString())};

        holder.minus_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count[0] = Integer.parseInt(holder.quantity.getText().toString());

                if(count[0] > 1){
                    count[0]--;
                    holder.quantity.setText(String.valueOf(count[0]));
                } else {
                    holder.quantity.setText("0");
                }

            }
        });

        holder.plus_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count[0] = Integer.parseInt(holder.quantity.getText().toString());

                if(count[0] >= 0){
                    count[0]++;
                    holder.quantity.setText(String.valueOf(count[0]));
                }
            }
        });



    }

    private void ShowDropDown(MyMovieViewHolder holder, String productVariation) {
        String[] users = { productVariation };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        holder.selected_variant.setAdapter(adapter);
//
//        holder.selected_variant.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public class MyMovieViewHolder extends RecyclerView.ViewHolder {

        public ImageView product_img, wishlist_ic, minus_count, plus_count;
        public TextView offer_price, actual_price, product_name, quantity;
//        Spinner selected_variant;
        TextView selected_variant;
        LinearLayout variant_layout;


        public MyMovieViewHolder(@NonNull View itemView) {
            super(itemView);

            product_img = itemView.findViewById(R.id.product_img);
            product_name = itemView.findViewById(R.id.product_name);
            wishlist_ic = itemView.findViewById(R.id.wishlist_ic);
            minus_count = itemView.findViewById(R.id.minus_count);
            plus_count = itemView.findViewById(R.id.plus_count);
            offer_price = itemView.findViewById(R.id.offer_price);
            actual_price = itemView.findViewById(R.id.actual_price);
            selected_variant = itemView.findViewById(R.id.selected_variant);
            variant_layout = itemView.findViewById(R.id.variant_layout);
            quantity = itemView.findViewById(R.id.quantity);
        }



    }
}