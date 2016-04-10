package com.example.mkrzywan.teleinformatyka;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

/**
 * Created by MKRZYWAN on 20.03.2016.
 */
public class AreaStateController{

    //default values
    public boolean light = false;
    public boolean ventilation = false;
    public RollerBlindsState rollerBlindsState = RollerBlindsState.CLOSED;

    private String [] rollerBlindsSymbols;
    private String [] rasberryCommands;

    private Context context;

    private IconFontButton lightButton;
    private IconFontButton ventilationButton;
    private IconFontButton rollerBlindsButton;

    public AreaStateController(String[] commands, Context context){
        this.rasberryCommands = commands;
        this.context = context;
    }

    public AreaStateController(boolean light, boolean ventilation, RollerBlindsState rollerBlindsState) {
        this.light = light;
        this.ventilation = ventilation;
        this.rollerBlindsState = rollerBlindsState;
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
                    sendHttpPostRequest(HttpHelper.STATE_CHANGE, rasberryCommands[0]);
                }
                else{
                    lightButton.setTextColor(Color.BLACK);
                    sendHttpPostRequest(HttpHelper.STATE_CHANGE, rasberryCommands[1]);
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

                    if(rasberryCommands.length > RasberryCommand.MINIMUM_COMMANDS_NUMBER){
                        sendHttpPostRequest(HttpHelper.STATE_CHANGE, rasberryCommands[2]);
                    }
                }
                else{
                    ventilationButton.setTextColor(Color.BLACK);

                    if(rasberryCommands.length > RasberryCommand.MINIMUM_COMMANDS_NUMBER){
                        sendHttpPostRequest(HttpHelper.STATE_CHANGE, rasberryCommands[3]);
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

                if(rasberryCommands.length > RasberryCommand.MINIMUM_COMMANDS_NUMBER  && httpRequestIndex != -1) {
                    sendHttpPostRequest(HttpHelper.STATE_CHANGE, rasberryCommands[httpRequestIndex]);
                }
            }
        });
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
            HttpHelper.makePostRequestWithSingleParam(context, key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
