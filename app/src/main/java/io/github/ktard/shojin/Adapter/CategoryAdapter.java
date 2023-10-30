package io.github.ktard.shojin.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import io.github.ktard.shojin.Category;
import io.github.ktard.shojin.FoodListingActivity;
import io.github.ktard.shojin.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    protected int contentLayout = R.layout.content_category_card;

    private final Category[] categories;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleTxt;
        private final String titleFmt;
        private final TextView productCountTxt;
        private final String productCountFmt;
        private final TextView saleCountTxt;
        private final String saleCountFmt;
        private final MaterialCardView cardView;
        private final ImageView thumbnail;

        public ViewHolder(View view) {
            super(view);

            View placeholder = view.findViewById(R.id.itemContent);

            ViewGroup parent = (ViewGroup) placeholder.getParent();

            int index = parent.indexOfChild(placeholder);
            parent.removeView(placeholder);

            View itemContent = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.content_category_card, parent, false);
            itemContent.setId(R.id.itemContent);
            parent.addView(itemContent, index);

            titleFmt = view.getResources().getString(R.string.title);
            productCountFmt  = view.getResources().getString(R.string.product_count);
            saleCountFmt = view.getResources().getString(R.string.sale_count);

            titleTxt = view.findViewById(R.id.categoryTitle);
            productCountTxt = view.findViewById(R.id.categoryProductCount);
            saleCountTxt = view.findViewById(R.id.categorySaleCount);
            thumbnail = view.findViewById(R.id.itemThumbnail);

            // Define click listener for the ViewHolder's View
            cardView = view.findViewById(R.id.itemCardView);
        }

        public MaterialCardView getCardView() {
            return cardView;
        }

        public void setData(Category data) {
            titleTxt.setText(String.format(titleFmt, data.name));
            productCountTxt.setText(String.format(productCountFmt, data.productCount));
            saleCountTxt.setText(String.format(saleCountFmt, data.saleCount));
            thumbnail.setImageResource(data.imageResource);

            getCardView().setOnClickListener(view -> {
                Intent foodIntent = new Intent(view.getContext(), FoodListingActivity.class);
                view.getContext().startActivity(foodIntent);
            });
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public CategoryAdapter(Category[] dataSet) {
        categories = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View currentView = createViewFromContent(viewGroup, viewType);
        return new CategoryAdapter.ViewHolder(currentView);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return categories.length;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.setData(categories[position]);
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    protected View createViewFromContent(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        return LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_card, viewGroup, false);
    }
}
