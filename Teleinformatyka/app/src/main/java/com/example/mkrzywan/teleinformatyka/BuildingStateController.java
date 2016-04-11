package com.example.mkrzywan.teleinformatyka;

import android.app.Activity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MKRZYWAN on 20.03.2016.
 */
public class BuildingStateController implements OnResponseListener {
    private AreaStateController bathroomController;
    private AreaStateController livingRoomController;
    private AreaStateController bedroomController;
    private AreaStateController gardenController;

    private HttpHelper httpHelper;


    public BuildingStateController(Activity activity){
        initialize(activity);
    }

    private void initialize(Activity activity){

        String [] rollerBlindsSymbols = {activity.getString(R.string.fa_square),
                activity.getString(R.string.fa_minus_square), activity.getString(R.string.fa_square_o),
                activity.getString(R.string.fa_minus_square)};

        livingRoomController = new AreaStateController(RasberryCommand.living_room_commands, activity.getApplicationContext());
        livingRoomController.initialize((IconFontButton)activity.findViewById(R.id.light_bulb_1),
                (IconFontButton)activity.findViewById(R.id.ventilator_1),
                (IconFontButton)activity.findViewById(R.id.cog_1), rollerBlindsSymbols);

        bedroomController = new AreaStateController(RasberryCommand.bedroom_commands, activity.getApplicationContext());
        bedroomController.initialize((IconFontButton)activity.findViewById(R.id.light_bulb_2),
                (IconFontButton)activity.findViewById(R.id.ventilator_2),
                (IconFontButton)activity.findViewById(R.id.cog_2), rollerBlindsSymbols);

        bathroomController = new AreaStateController(RasberryCommand.bathroom_commands, activity.getApplicationContext());
        bathroomController.initialize((IconFontButton)activity.findViewById(R.id.light_bulb_3),
                (IconFontButton)activity.findViewById(R.id.ventilator_3),
                (IconFontButton)activity.findViewById(R.id.cog_3), rollerBlindsSymbols);

        gardenController = new AreaStateController(RasberryCommand.garden_commands, activity.getApplicationContext());
        gardenController.initialize((IconFontButton)activity.findViewById(R.id.light_bulb_4),
                (IconFontButton)activity.findViewById(R.id.ventilator_4),
                (IconFontButton)activity.findViewById(R.id.cog_4), rollerBlindsSymbols);

        httpHelper = HttpHelper.getInstance();

        checkCurrentBuildingState(activity);
    }

    private void checkCurrentBuildingState(Activity activity){
        String[] params = {RasberryCommand.ACTION_GET_STATE};
        httpHelper.makeGetRequest(activity, params , this);
    }

    private void addSettingToApropriateController(String key, String value){
        if(key.startsWith(AreaType.LIVING_ROOM.toString())){
            livingRoomController.actualizeSettings(key, value);
        }else if(key.startsWith(AreaType.BEDROOM.toString())){
            bedroomController.actualizeSettings(key, value);
        }else if(key.startsWith(AreaType.BATHROOM.toString())){
            bathroomController.actualizeSettings(key, value);
        }else{
            gardenController.actualizeSettings(key, value);
        }
    }

    @Override
    public void onResponse(String response) {
        //TODO convert response to key-values map
        Map<String, String> settingsMap = new HashMap();

        for(String key : settingsMap.keySet()){
            addSettingToApropriateController(key, settingsMap.get(key));
        }
    }
}
