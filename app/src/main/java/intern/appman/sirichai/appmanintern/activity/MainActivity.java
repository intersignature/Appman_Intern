package intern.appman.sirichai.appmanintern.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import intern.appman.sirichai.appmanintern.R;
import intern.appman.sirichai.appmanintern.controller.JsonAction;
import intern.appman.sirichai.appmanintern.recyclerview.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    private TextView titleTv;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private JsonAction jsonAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTv = findViewById(R.id.titleTv);
        recyclerView = findViewById(R.id.dataRv);
        jsonAction = new JsonAction(getResources());
        jsonAction.loadJson();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(jsonAction.appmanInternData, MainActivity.this);
        recyclerView.setAdapter(adapter);
        //noinspection AndroidLintSetTextI18n
        titleTv.setText("Id:" + jsonAction.appmanInternData.getId() + " Name: " + jsonAction.appmanInternData.getFirstname()
                + " " + jsonAction.appmanInternData.getLastname());
    }
}
