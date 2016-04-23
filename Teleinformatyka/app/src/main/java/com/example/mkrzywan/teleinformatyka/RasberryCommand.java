package com.example.mkrzywan.teleinformatyka;

/**
 * Created by MKRZYWAN on 29.03.2016.
 */
public class RasberryCommand {

   public static final String stateON = "-1";
   public static final String stateOFF = "-0";

 //Pins
    public static final int LIVING_ROOM_LIGHT = 12;
    public static final int LIVING_ROOM_VENTILATION = 18;
    public static final int LIVING_ROOM_ROLLER_BLINDS = 40;
    public static final int BEDROOM_LIGHT = 11;
    public static final int BEDROOM_VENTILATION = 16;
    public static final int BEDROOM_ROLLER_BLINDS = 40;
    public static final int BATHROOM_LIGHT = 7;
    public static final int BATHROOM_VENTILATION = 15;
    public static final int BATHROOM_ROLLER_BLINDS = 40;
    public static final int GARDEN_LIGHT = 13;

    public static final String LIVING_ROOM_LIGHT_ON = LIVING_ROOM_LIGHT + stateON;
    public static final String LIVING_ROOM_LIGHT_OFF = LIVING_ROOM_LIGHT + stateOFF;
    public static final String LIVING_ROOM_VENTILATION_ON = LIVING_ROOM_VENTILATION + stateON;
    public static final String LIVING_ROOM_VENTILATION_OFF =  LIVING_ROOM_VENTILATION + stateOFF;
    public static final String LIVING_ROOM_ROLLER_BLINDS_OPEN = LIVING_ROOM_ROLLER_BLINDS + stateOFF;
    public static final String LIVING_ROOM_ROLLER_BLINDS_SEMI_OPEN = LIVING_ROOM_ROLLER_BLINDS + stateOFF;
    public static final String LIVING_ROOM_ROLLER_BLINDS_CLOSED = LIVING_ROOM_ROLLER_BLINDS + stateOFF;

    public static final String BEDROOM_LIGHT_ON = BEDROOM_LIGHT + stateON;
    public static final String BEDROOM_LIGHT_OFF = BEDROOM_LIGHT + stateOFF;
    public static final String BEDROOM_VENTILATION_ON = BEDROOM_VENTILATION + stateON;
    public static final String BEDROOM_VENTILATION_OFF = BEDROOM_VENTILATION + stateOFF;
    public static final String BEDROOM_ROLLER_BLINDS_OPEN = BEDROOM_ROLLER_BLINDS + stateOFF;
    public static final String BEDROOM_ROLLER_BLINDS_SEMI_OPEN = BEDROOM_ROLLER_BLINDS + stateOFF;
    public static final String BEDROOM_ROLLER_BLINDS_CLOSED = BEDROOM_ROLLER_BLINDS + stateOFF;

    public static final String BATHROOM_LIGHT_ON = BATHROOM_LIGHT + stateON;
    public static final String BATHROOM_LIGHT_OFF = BATHROOM_LIGHT + stateOFF;
    public static final String BATHROOM_VENTILATION_ON = BATHROOM_VENTILATION + stateON;
    public static final String BATHROOM_VENTILATION_OFF = BATHROOM_VENTILATION + stateOFF;
    public static final String BATHROOM_ROLLER_BLINDS_OPEN = BATHROOM_ROLLER_BLINDS + stateOFF;
    public static final String BATHROOM_ROLLER_BLINDS_SEMI_OPEN = BATHROOM_ROLLER_BLINDS + stateOFF;
    public static final String BATHROOM_ROLLER_BLINDS_CLOSED = BATHROOM_ROLLER_BLINDS + stateOFF;

    public static final String GARDEN_LIGHT_ON = GARDEN_LIGHT + stateON;
    public static final String GARDEN_LIGHT_OFF = GARDEN_LIGHT + stateOFF;

    public static String STATE_CHANGE = "changeState";
    public static String STATE = "state";
    public static String ACTION_GET_STATE = "getState";
    public static String PIN_NUMBER = "pinNumber";

    public static final String[] living_room_commands = {LIVING_ROOM_LIGHT_ON, LIVING_ROOM_LIGHT_OFF,
            LIVING_ROOM_VENTILATION_ON, LIVING_ROOM_VENTILATION_OFF,
            LIVING_ROOM_ROLLER_BLINDS_CLOSED, LIVING_ROOM_ROLLER_BLINDS_SEMI_OPEN,
            LIVING_ROOM_ROLLER_BLINDS_OPEN};

    public static final String[] bedroom_commands = {BEDROOM_LIGHT_ON, BEDROOM_LIGHT_OFF,
    BEDROOM_VENTILATION_ON, BEDROOM_VENTILATION_OFF, BEDROOM_ROLLER_BLINDS_CLOSED,
    BEDROOM_ROLLER_BLINDS_SEMI_OPEN, BEDROOM_ROLLER_BLINDS_OPEN};

    public static final String[] bathroom_commands = { BATHROOM_LIGHT_ON, BATHROOM_LIGHT_OFF,
    BATHROOM_VENTILATION_ON, BATHROOM_VENTILATION_OFF, BATHROOM_ROLLER_BLINDS_CLOSED,
    BATHROOM_ROLLER_BLINDS_SEMI_OPEN, BATHROOM_ROLLER_BLINDS_OPEN};

    public static final String[] garden_commands = { GARDEN_LIGHT_ON, GARDEN_LIGHT_OFF};

    public static final int[] living_room_pins = {LIVING_ROOM_LIGHT, LIVING_ROOM_VENTILATION, LIVING_ROOM_ROLLER_BLINDS};
    public static final int[] bedroom_pins = { BEDROOM_LIGHT, BEDROOM_VENTILATION, BEDROOM_ROLLER_BLINDS };
    public static final int[] bathroom_pins = { BATHROOM_LIGHT, BATHROOM_VENTILATION, BATHROOM_ROLLER_BLINDS };
    public static final int[] garden_pins = { GARDEN_LIGHT };

    public static int MINIMUM_ROOM_FUNCTIONS_NUMBER = garden_commands.length;
}
