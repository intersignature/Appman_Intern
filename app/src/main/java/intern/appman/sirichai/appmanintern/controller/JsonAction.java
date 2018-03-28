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
        // dataList will contain all data child
        List<Data> dataList = new ArrayList<>();
        try {
            // Get all string to json object
            JSONObject root = new JSONObject(s);
            // Get all data in root's child to json array
            JSONArray datas = root.getJSONArray("data");
            // Loop for get each data and add to dataList
            for (int i = 0; i < datas.length(); i++) {
                // Get each data to json object
                JSONObject data = datas.getJSONObject(i);
                // Get description in each data to json object
                JSONObject description = new JSONObject(getString(data.get("description")));
                // Initial Description type with 'th' and 'en'
                Description descriptionModel = new Description(getString(description.get("th")), getString(description.get("en")));
                // Initial Data type with 'docType' and Description type
                Data dataModel = new Data(getString(data.get("docType")), descriptionModel);
                // Add each data to 'dataList'
                dataList.add(dataModel);
            }
            // Initial all AappmanInternData type with 'Id', 'firstName', 'lastName' and dataList
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
