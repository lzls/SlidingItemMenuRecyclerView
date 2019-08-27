package com.liuzhenlin.simrv.sample;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.liuzhenlin.simrv.SlidingItemMenuRecyclerView;

/**
 * @author 刘振林
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SwipeRefreshLayout srl = (SwipeRefreshLayout) View.inflate(this,
                R.layout.activity_main, null);
        srl.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary);

        setContentView(srl);

        final SlidingItemMenuRecyclerView simrv = srl.findViewById(R.id.simrv);
        simrv.setLayoutManager(new LinearLayoutManager(this));
        simrv.setAdapter(new RecyclerAdapter());
        simrv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            final Runnable refreshListRunnable = new Runnable() {
                @Override
                public void run() {
                    RecyclerAdapter adapter = ((RecyclerAdapter) simrv.getAdapter());
                    assert adapter != null;
                    final int old = adapter.itemCount;
                    adapter.itemCount += 3;
                    adapter.notifyItemRangeInserted(old, 2);

                    srl.setRefreshing(false);
                    simrv.setItemDraggable(true);
                }
            };

            @Override
            public void onRefresh() {
                simrv.releaseItemView(false);
                simrv.setItemDraggable(false);

                srl.postDelayed(refreshListRunnable, 2000);
            }
        });

        final int duration = simrv.getItemScrollDuration();
        simrv.post(new Runnable() {
            @Override
            public void run() {
                simrv.openItemAtPosition(0);
                simrv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        simrv.openItemAtPosition(1);
                        simrv.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                simrv.openItemAtPosition(2);
                                simrv.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        simrv.openItemAtPosition(3);
                                        simrv.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                simrv.openItemAtPosition(4);
                                                simrv.postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        simrv.openItemAtPosition(5);
                                                    }
                                                }, duration);
                                            }
                                        }, duration);
                                    }
                                }, duration);
                            }
                        }, duration);
                    }
                }, duration);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_see_github, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_see_github:
                startActivity(new Intent(Intent.ACTION_VIEW)
                        .setData(Uri.parse(
                                "https://github.com/freeze-frames/SlidingItemMenuRecyclerView")));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
            implements View.OnClickListener {
        int itemCount = 5;

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_simrv, parent, false));
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.text.setText("ItemView " + position);
            holder.text.setTag(position);
            holder.renameButton.setTag(position);
            holder.deleteButton.setTag(position);
            holder.topButton.setTag(position);
        }

        @Override
        public int getItemCount() {
            return itemCount;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView text;
            final TextView renameButton;
            final TextView deleteButton;
            final TextView topButton;

            private ViewHolder(View itemView) {
                super(itemView);
                text = itemView.findViewById(R.id.text);
                renameButton = itemView.findViewById(R.id.button_rename);
                deleteButton = itemView.findViewById(R.id.button_delete);
                topButton = itemView.findViewById(R.id.button_top);

                text.setOnClickListener(RecyclerAdapter.this);
                renameButton.setOnClickListener(RecyclerAdapter.this);
                deleteButton.setOnClickListener(RecyclerAdapter.this);
                topButton.setOnClickListener(RecyclerAdapter.this);
            }
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.text:
                    Toast.makeText(MainActivity.this,
                            "Click itemView " + v.getTag().toString(),
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_rename:
                    Toast.makeText(MainActivity.this,
                            "Rename itemView " + v.getTag().toString(),
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_delete:
                    Toast.makeText(MainActivity.this,
                            "Delete itemView " + v.getTag().toString(),
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_top:
                    Toast.makeText(MainActivity.this,
                            "Top itemView " + v.getTag().toString(),
                            Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}