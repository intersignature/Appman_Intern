package intern.appman.sirichai.appmanintern.controller;

import android.content.res.Resources;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import intern.appman.sirichai.appmanintern.R;
import intern.appman.sirichai.appmanintern.model.pojo.AllDataModel;
import intern.appman.sirichai.appmanintern.model.pojo.DataModel;
import intern.appman.sirichai.appmanintern.model.pojo.DescriptionModel;

public class JsonController {

    public AllDataModel allDataModel;
    private Resources resources;

    public JsonController(Resources resources) {
        this.resources = resources;
    }

    public void loadJson() {
        Resources res = resources;
        InputStream input = res.openRawResource(R.raw.intern);
        Scanner scanner = new Scanner(input);
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
        }
        parseJson(stringBuilder.toString());
    }

    private void parseJson(String s) {
        List<DataModel> dataModelList = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(s);
            JSONArray datas = root.getJSONArray("data");
            for (int i = 0; i < datas.length(); i++) {
                JSONObject data = datas.getJSONObject(i);
                JSONObject description = new JSONObject(getString(data.get("description")));
                DescriptionModel descriptionModel = new DescriptionModel(getString(description.get("th")), getString(description.get("en")));
                DataModel dataModel = new DataModel(getString(data.get("docType")), descriptionModel);
                dataModelList.add(dataModel);
            }
            allDataModel = new AllDataModel(getString(root.get("Id")), getString(root.get("firstName")),
                    getString(root.get("lastName")), dataModelList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String getString(Object o) {
        return String.valueOf(o);
    }
}
