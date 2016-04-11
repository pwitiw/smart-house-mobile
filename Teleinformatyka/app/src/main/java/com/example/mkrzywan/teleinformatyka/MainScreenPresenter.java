package com.example.mkrzywan.teleinformatyka;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MKRZYWAN on 19.03.2016.
 */
public class MainScreenPresenter {

    private MainActivityView view;
    public static BuildingStateController buildingStateController;

    public MainScreenPresenter(MainActivityView view, Activity activity){
        this.view = view;
        buildingStateController = new BuildingStateController(activity);
    }
}
