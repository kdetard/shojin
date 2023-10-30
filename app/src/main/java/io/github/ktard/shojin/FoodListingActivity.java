package io.github.ktard.shojin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import io.github.ktard.shojin.Adapter.FoodAdapter;
import com.google.android.material.appbar.MaterialToolbar;

public class FoodListingActivity extends AppCompatActivity {
    private static final Food[] foods = new Food[] {
        new Food("Sườn nướng", 12_000, 15_000, 1, R.drawable.ic_suon_nuong),
        new Food("Gà kho", 15_000, 15_000, 5, R.drawable.ic_ga_kho),
        new Food("Thịt kho trứng", 12_000, 12_000, 3, R.drawable.ic_thit_kho_trung),
        new Food("Nem nướng", 15_000, 17_000, 4, R.drawable.ic_nem_nuong),
    };

    FoodAdapter adapter;
    RecyclerView categoryRecyclerView;
    LinearLayoutManager llm;
    MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_listing);

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        categoryRecyclerView = findViewById(R.id.foodRecyclerView);

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        adapter = new FoodAdapter(foods);
        categoryRecyclerView.setLayoutManager(llm);
        categoryRecyclerView.setAdapter(adapter);

        toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(view -> {
            finish();
        });
    }
}