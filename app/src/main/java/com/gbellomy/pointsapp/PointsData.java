package com.gbellomy.pointsapp;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dbellomy on 10/16/17.
 */

public class PointsData {
    private static PointsData instance = null;
    private static final String FILENAME = "points.data";
    private static final String POINTS_ARG = "Points";

    private int points = 0;
    private Map<String, Integer> rewards = new HashMap<>();
    private Context context;

    private PointsData() {
        rewards.put("TV", 15);
        rewards.put("Lego Star Wars", 15);
        rewards.put("Play Outside", 5);
        rewards.put("Movies", 50);
    }

    public static PointsData getInstance(Context context) {
        if (instance == null) {
            instance = new PointsData();
        }

        instance.context = context;
        return instance;
    }

    public void save() {
        try {
            HashMap<String, Integer> data = new HashMap<>();
            data.put(POINTS_ARG, points);
            JSONObject json = new JSONObject(data);

            FileOutputStream fout = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fout.write(json.toString().getBytes());
            fout.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            FileInputStream fin = context.openFileInput(FILENAME);
            StringBuffer fileContent = new StringBuffer("");

            byte[] buffer = new byte[1024];
            int n;

            while ((n = fin.read(buffer)) != -1)
                fileContent.append(new String(buffer, 0, n));

            JSONObject jsonObject = new JSONObject(fileContent.toString());

            points = (int) jsonObject.get(POINTS_ARG);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getPoints() {
        return points;
    }

    public Map<String, Integer> getRewards() {
        return rewards;
    }

    public void addPoints(int val) {
        points += val;
    }

    public void removePoints(int val) {
        points -= (points < val)? points : val;
    }
}
