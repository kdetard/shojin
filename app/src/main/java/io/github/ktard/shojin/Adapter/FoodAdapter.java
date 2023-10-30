package io.github.ktard.shojin.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import io.github.ktard.shojin.Food;
import io.github.ktard.shojin.R;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    protected int contentLayout = R.layout.content_food_card;

    private final Food[] foods;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleTxt;
        private final String titleFmt;
        private final TextView discountPriceTxt;
        private final String discountPriceFmt;
        private final TextView originalPriceTxt;
        private final String originalPriceFmt;
        private final MaterialCardView cardView;
        private final RatingBar ratingBar;
        private final ImageView thumbnail;

        public ViewHolder(View view) {
            super(view);

            View placeholder = view.findViewById(R.id.itemContent);

            ViewGroup parent = (ViewGroup) placeholder.getParent();

            int index = parent.indexOfChild(placeholder);
            parent.removeView(placeholder);

            View itemContent = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.content_food_card, parent, false);
            itemContent.setId(R.id.itemContent);
            parent.addView(itemContent, index);

            titleFmt = view.getResources().getString(R.string.title);
            discountPriceFmt  = view.getResources().getString(R.string.discount_price);
            originalPriceFmt = view.getResources().getString(R.string.original_price);

            titleTxt = view.findViewById(R.id.foodTitle);
            discountPriceTxt = view.findViewById(R.id.foodDiscountPrice);
            originalPriceTxt = view.findViewById(R.id.foodOriginalPrice);
            ratingBar = view.findViewById(R.id.foodRatingBar);
            thumbnail = view.findViewById(R.id.itemThumbnail);

            // Define click listener for the ViewHolder's View
            cardView = view.findViewById(R.id.itemCardView);
        }

        public MaterialCardView getCardView() {
            return cardView;
        }

        public void setData(Food data) {
            titleTxt.setText(String.format(titleFmt, data.name));
            discountPriceTxt.setText(String.format(discountPriceFmt, data.discountPrice));
            originalPriceTxt.setText(String.format(originalPriceFmt, data.originalPrice));
            ratingBar.setRating(data.rating);
            thumbnail.setImageResource(data.imageResource);

            getCardView().setOnClickListener(view ->
                    Toast.makeText(view.getContext(), String.format("Đã chọn %s", titleTxt.getText()), Toast.LENGTH_SHORT).show());
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public FoodAdapter(Food[] dataSet) {
        foods = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View currentView = createViewFromContent(viewGroup, viewType);
        return new FoodAdapter.ViewHolder(currentView);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return foods.length;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ViewHolder viewHolder, final int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.setData(foods[position]);
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    protected View createViewFromContent(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        return LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_card, viewGroup, false);
    }
}
