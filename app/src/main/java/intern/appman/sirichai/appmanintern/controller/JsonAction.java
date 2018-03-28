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
import intern.appman.sirichai.appmanintern.pojo.AppmanInternData;
import intern.appman.sirichai.appmanintern.pojo.Data;
import intern.appman.sirichai.appmanintern.pojo.Description;

public class JsonAction {

    public AppmanInternData appmanInternData;
    private Resources resources;

    public JsonAction(Resources resources) {
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
        List<Data> dataList = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(s);
            JSONArray datas = root.getJSONArray("data");
            for (int i = 0; i < datas.length(); i++) {
                JSONObject data = datas.getJSONObject(i);
                JSONObject description = new JSONObject(getString(data.get("description")));
                Description descriptionModel = new Description(getString(description.get("th")), getString(description.get("en")));
                Data dataModel = new Data(getString(data.get("docType")), descriptionModel);
                dataList.add(dataModel);
            }
            appmanInternData = new AppmanInternData(getString(root.get("Id")), getString(root.get("firstName")),
                    getString(root.get("lastName")), dataList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String getString(Object o) {
        return String.valueOf(o);
    }
}
