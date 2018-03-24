package intern.appman.sirichai.appmanintern.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import intern.appman.sirichai.appmanintern.R;
import intern.appman.sirichai.appmanintern.controller.JsonController;
import intern.appman.sirichai.appmanintern.model.recyclerview.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    private TextView titleTv;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private JsonController jsonController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTv = findViewById(R.id.titleTv);
        recyclerView = findViewById(R.id.dataRv);
        jsonController = new JsonController(getResources());
        jsonController.loadJson();
        setupRecyclerView();

    }

    private void setupRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(jsonController.allDataModel, MainActivity.this);
        recyclerView.setAdapter(adapter);
        //noinspection AndroidLintSetTextI18n
        titleTv.setText("Id:" + jsonController.allDataModel.getId() + " Name: " + jsonController.allDataModel.getFirstname()
                + " " + jsonController.allDataModel.getLastname());
    }


}
