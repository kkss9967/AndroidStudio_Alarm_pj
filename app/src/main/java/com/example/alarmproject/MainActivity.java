package com.example.alarmproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Dictionary> mArrayList;
    private CustomAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 상단바 투명하게
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        // 커스텀 툴바
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        RecyclerView mRecyclerView = findViewById(R.id.recycler_View);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mArrayList = new ArrayList<>();

        mAdapter = new CustomAdapter(mArrayList);
        mRecyclerView.setAdapter(mAdapter);

    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) { // 추가 버튼
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.menu, menu);
            return true;
        }

        Switch aSwitch;
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            //return super.onOptionsItemSelected(item);
            switch (item.getItemId()) { // 추가 버튼 -> Activity로 넘어가도록
                case R.id.add_comp:
                    Dictionary data = new Dictionary("김송은", "2020/02/27", aSwitch);
                    mArrayList.add(data);
                    mAdapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(), "추가버튼 클릭됨", Toast.LENGTH_LONG).show();
                    return true;

                default:
            }
            return false;
         }

    }