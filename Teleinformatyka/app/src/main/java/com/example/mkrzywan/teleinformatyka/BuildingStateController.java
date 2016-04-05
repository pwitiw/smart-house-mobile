package com.example.mkrzywan.teleinformatyka;

import android.app.Activity;

/**
 * Created by MKRZYWAN on 20.03.2016.
 */
public class BuildingStateController {
    private AreaStateController bathroomController;
    private AreaStateController livingRoomController;
    private AreaStateController bedroomController;
    private AreaStateController gardenController;

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
    }

    public void setBathroomController(AreaStateController bathroomController) {
        this.bathroomController = bathroomController;
    }

    public void setLivingRoomController(AreaStateController livingRoomController) {
        this.livingRoomController = livingRoomController;
    }

    public void setBedroomController(AreaStateController bedroomController) {
        this.bedroomController = bedroomController;
    }

    public void setGardenController(AreaStateController gardenController) {
        this.gardenController = gardenController;
    }
}
