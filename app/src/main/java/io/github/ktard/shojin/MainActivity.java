package io.github.ktard.shojin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import io.github.ktard.shojin.Adapter.CategoryAdapter;
import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {
    private static final Category[] categories = new Category[] {
        new Category("Món mặn", 5, 5, R.drawable.ic_mon_man),
        new Category("Món canh", 10, 10, R.drawable.ic_mon_canh),
        new Category("Món xào", 10, 10, R.drawable.ic_mon_xao),
    };

    CategoryAdapter adapter;
    LinearLayoutManager llm;
    RecyclerView categoryRecyclerView;
    MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        categoryRecyclerView = findViewById(R.id.categoryRecyclerView);
        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        adapter = new CategoryAdapter(categories);
        categoryRecyclerView.setLayoutManager(llm);
        categoryRecyclerView.setAdapter(adapter);

        toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(view -> {
            finishAffinity();
        });
    }
}