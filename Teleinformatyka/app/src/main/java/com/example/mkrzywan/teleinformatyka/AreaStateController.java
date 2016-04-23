package com.example.mkrzywan.teleinformatyka;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MKRZYWAN on 20.03.2016.
 */
public class AreaStateController implements OnResponseListener{

    //default values
    public boolean light = false;
    public boolean ventilation = false;
    public RollerBlindsState rollerBlindsState = RollerBlindsState.CLOSED;

    private HttpHelper httpHelper;

    private String [] rollerBlindsSymbols;
    private String [] rasberryCommands;
    private int [] pinsNumbers;

    private Context context;

    private IconFontButton lightButton;
    private IconFontButton ventilationButton;
    private IconFontButton rollerBlindsButton;

    public AreaStateController(String[] commands, int[] pinsNumbers, Context context){
        this.httpHelper = HttpHelper.getInstance();
        this.rasberryCommands = commands;
        this.context = context;
        this.pinsNumbers = pinsNumbers;
    }

    protected void initialize(final IconFontButton lightBtn, final IconFontButton ventilationBtn,
                              final IconFontButton rollerBlindsBtn, String [] rollerSymbols){

        this.rollerBlindsSymbols = rollerSymbols;

        lightButton = lightBtn;
        lightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                light = !light;

                actualizeVisualLightState(light);

                if(light){
                    sendHttpPostRequest(RasberryCommand.STATE_CHANGE, getParameterMap(rasberryCommands[0]));
                }
                else{
                    sendHttpPostRequest(RasberryCommand.STATE_CHANGE, getParameterMap(rasberryCommands[1]));
                }
            }
        });
        ventilationButton = ventilationBtn;
        ventilationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ventilation = !ventilation;

                actualizeVisualVentilationState(ventilation);

                if(ventilation){
                    if(rasberryCommands.length > RasberryCommand.MINIMUM_ROOM_FUNCTIONS_NUMBER){
                        sendHttpPostRequest(RasberryCommand.STATE_CHANGE, getParameterMap(rasberryCommands[2]));
                    }
                }
                else{
                    if(rasberryCommands.length > RasberryCommand.MINIMUM_ROOM_FUNCTIONS_NUMBER){
                        sendHttpPostRequest(RasberryCommand.STATE_CHANGE, getParameterMap(rasberryCommands[3]));
                    }
                }
            }
        });
        rollerBlindsButton = rollerBlindsBtn;
        rollerBlindsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newRollerBlindsIndex = (RollerBlindsState.getIndex(rollerBlindsState) + 1) % RollerBlindsState.values().length;
                rollerBlindsState = RollerBlindsState.values()[newRollerBlindsIndex];
                rollerBlindsButton.setText(rollerBlindsSymbols[newRollerBlindsIndex]);

                //send http request
                int httpRequestIndex = -1;
                switch(rollerBlindsState){
                    case OPEN:
                        httpRequestIndex = 4;
                        break;
                    case SEMI_OPEN:
                        httpRequestIndex = 5;
                        break;
                    case CLOSED:
                        httpRequestIndex = 6;
                        break;
                }

                if(rasberryCommands.length > RasberryCommand.MINIMUM_ROOM_FUNCTIONS_NUMBER && httpRequestIndex != -1) {
                    sendHttpPostRequest(RasberryCommand.STATE_CHANGE, getParameterMap(rasberryCommands[httpRequestIndex]));
                }
            }
        });

        checkCurrentStates();
    }

    private void actualizeVisualLightState(boolean light){
        if(light){
            lightButton.setTextColor(Color.parseColor("#651FFF"));
        }
        else{
            lightButton.setTextColor(Color.BLACK);
        }
    }

    private void actualizeVisualVentilationState(boolean ventilation){
        if(ventilation){
            ventilationButton.setTextColor(Color.parseColor("#651FFF"));
        }
        else{
            ventilationButton.setTextColor(Color.BLACK);
        }
    }

    private void checkCurrentStates(){
        for(int i = 0; i<pinsNumbers.length; i++)
        {
            Map<String, String> params = new HashMap<>();
            params.put(RasberryCommand.PIN_NUMBER, pinsNumbers[i] + "");
            try {
                httpHelper.makePostRequestWithSingleParam(context, this, RasberryCommand.ACTION_GET_STATE, params);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void setLight(String value){
        if(Integer.parseInt(value) == 0){
            light = false;
        }else{
            light = true;
        }

        actualizeVisualLightState(light);
    }

    private void setVentilation(String value){
        if(Integer.parseInt(value) == 0){
            ventilation = false;
        }else{
            ventilation = true;
        }

        actualizeVisualVentilationState(ventilation);
    }

    private void setRollerBlindsState(String value){
        int index = Integer.parseInt(value);
        rollerBlindsState = RollerBlindsState.values()[index];
        rollerBlindsButton.setText(rollerBlindsSymbols[index]);
    }

    public void turnLightOn(){
        light = true;
    }

    public void turnLightOff(){
        light = false;
    }

    public void turnVentilationOn(){
        ventilation = true;
    }

    public void turnVentilationOff(){
        ventilation = false;
    }

    public boolean isLight() {
        return light;
    }

    public boolean isVentilation() {
        return ventilation;
    }

    public RollerBlindsState getRollerBlindsState() {
        return rollerBlindsState;
    }

    public void setRollerBlindsState(RollerBlindsState rollerBlindsState) {
        this.rollerBlindsState = rollerBlindsState;
    }

    private void sendHttpPostRequest(String activityType, Map<String, String> paramsMap){
        try {
            httpHelper.makePostRequestWithSingleParam(context, this, activityType, paramsMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        @Override
    public void onResponse(String response) {

            JSONObject fieldsJson = null;
            int pinNumber = -1;
            String state = null;
            try {
                fieldsJson = new JSONObject(response);
                pinNumber = Integer.parseInt(fieldsJson.getString(RasberryCommand.PIN_NUMBER));
                state = fieldsJson.getString(RasberryCommand.STATE);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if(pinsNumbers.length == 0){
                return;
            }

            if(pinNumber == pinsNumbers[0]){
                setLight(state);
            }

            if(pinsNumbers.length <= RasberryCommand.MINIMUM_ROOM_FUNCTIONS_NUMBER){
                return;
            }

            if(pinNumber == pinsNumbers[1]){
                setVentilation(state);
            }

            if(pinNumber == pinsNumbers[2]){
                setRollerBlindsState(state);
            }

        }

    private Map<String, String> getParameterMap(String data){
        Map<String, String> params = new HashMap<>();
        String [] paramsArray = data.split("-");
        params.put(RasberryCommand.PIN_NUMBER, paramsArray[0]);
        params.put(RasberryCommand.STATE, paramsArray[1]);

        return params;
    }
}
