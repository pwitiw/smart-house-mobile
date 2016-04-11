package com.example.mkrzywan.teleinformatyka;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

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

    protected void initialize(final IconFontButton lightBtn, IconFontButton ventilationBtn,
                              final IconFontButton rollerBlindsBtn, String [] rollerSymbols){

        this.rollerBlindsSymbols = rollerSymbols;

        lightButton = lightBtn;
        lightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                light = !light;

                if(light){
                    lightButton.setTextColor(Color.parseColor("#651FFF"));
                    sendHttpPostRequest(RasberryCommand.STATE_CHANGE, rasberryCommands[0]);
                }
                else{
                    lightButton.setTextColor(Color.BLACK);
                    sendHttpPostRequest(RasberryCommand.STATE_CHANGE, rasberryCommands[1]);
                }
            }
        });
        ventilationButton = ventilationBtn;
        ventilationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ventilation = !ventilation;

                if(ventilation){
                    ventilationButton.setTextColor(Color.parseColor("#651FFF"));

                    if(rasberryCommands.length > RasberryCommand.MINIMUM_ROOM_FUNCTIONS_NUMBER){
                        sendHttpPostRequest(RasberryCommand.STATE_CHANGE, rasberryCommands[2]);
                    }
                }
                else{
                    ventilationButton.setTextColor(Color.BLACK);

                    if(rasberryCommands.length > RasberryCommand.MINIMUM_ROOM_FUNCTIONS_NUMBER){
                        sendHttpPostRequest(RasberryCommand.STATE_CHANGE, rasberryCommands[3]);
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
                    sendHttpPostRequest(RasberryCommand.STATE_CHANGE, rasberryCommands[httpRequestIndex]);
                }
            }
        });

        checkCurrentStates();
    }

    private void checkCurrentStates(){
        for(int i = 0; i<pinsNumbers.length; i++)
        {
            httpHelper.makeGetRequest(context, pinsNumbers[i], this);
        }

    }

    private void setLight(String value){
        if(Integer.parseInt(value) == 0){
            light = false;
        }else{
            light = true;
        }
    }

    private void setVentilation(String value){
        if(Integer.parseInt(value) == 0){
            ventilation = false;
        }else{
            ventilation = true;
        }
    }

    private void setRollerBlindsState(String value){
        int index = Integer.parseInt(value);
        rollerBlindsState = RollerBlindsState.values()[index];
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

    private void sendHttpPostRequest(String key, String value){
        try {
            httpHelper.makePostRequestWithSingleParam(context, key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        @Override
    public void onResponse(int key, String response) {

            if(pinsNumbers.length == 0){
                return;
            }

            if(key == pinsNumbers[0]){
                setLight(response);
            }

            if(pinsNumbers.length <= RasberryCommand.MINIMUM_ROOM_FUNCTIONS_NUMBER){
                return;
            }

            if(key == pinsNumbers[1]){
                setVentilation(response);
            }

            if(key == pinsNumbers[2]){
                setRollerBlindsState(response);
            }

        }
}
