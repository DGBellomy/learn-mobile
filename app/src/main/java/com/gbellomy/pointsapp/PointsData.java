package com.gbellomy.pointsapp;

import android.content.Context;
import android.util.JsonWriter;

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
            FileOutputStream fout = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);

            HashMap<String, Integer> data = new HashMap<>();
            data.put("Points", points);
            JSONObject json = new JSONObject(data);

            fout.write(json.toString().getBytes());
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            FileInputStream fin = context.openFileInput(FILENAME);
            byte[] data;
            fin.read(data);
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
