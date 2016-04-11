package com.example.mkrzywan.teleinformatyka;

/**
 * Created by MKRZYWAN on 29.03.2016.
 */
public class RasberryCommand {

 //Pins
    public static final int LIVING_ROOM_LIGHT = 11;
    public static final int LIVING_ROOM_VENTILATION = 12;
    public static final int LIVING_ROOM_ROLLER_BLINDS = 13;
    public static final int BEDROOM_LIGHT = 14;
    public static final int BEDROOM_VENTILATION = 15;
    public static final int BEDROOM_ROLLER_BLINDS = 16;
    public static final int BATHROOM_LIGHT = 18;
    public static final int BATHROOM_VENTILATION = 19;
    public static final int BATHROOM_ROLLER_BLINDS = 21;
    public static final int GARDEN_LIGHT = 22;

    public static final String LIVING_ROOM_LIGHT_ON = "11-1";
    public static final String LIVING_ROOM_LIGHT_OFF = "11-0";
    public static final String LIVING_ROOM_VENTILATION_ON = "12-1";
    public static final String LIVING_ROOM_VENTILATION_OFF = "12-0";
    public static final String LIVING_ROOM_ROLLER_BLINDS_OPEN = "13-2";
    public static final String LIVING_ROOM_ROLLER_BLINDS_SEMI_OPEN = "13-1";
    public static final String LIVING_ROOM_ROLLER_BLINDS_CLOSED = "13-0";

    public static final String BEDROOM_LIGHT_ON = "14-1";
    public static final String BEDROOM_LIGHT_OFF = "14-0";
    public static final String BEDROOM_VENTILATION_ON = "15-1";
    public static final String BEDROOM_VENTILATION_OFF = "15-0";
    public static final String BEDROOM_ROLLER_BLINDS_OPEN = "16-2";
    public static final String BEDROOM_ROLLER_BLINDS_SEMI_OPEN = "16-1";
    public static final String BEDROOM_ROLLER_BLINDS_CLOSED = "16-0";

    public static final String BATHROOM_LIGHT_ON = "18-1";
    public static final String BATHROOM_LIGHT_OFF = "18-0";
    public static final String BATHROOM_VENTILATION_ON = "19-1";
    public static final String BATHROOM_VENTILATION_OFF = "19-0";
    public static final String BATHROOM_ROLLER_BLINDS_OPEN = "21-2";
    public static final String BATHROOM_ROLLER_BLINDS_SEMI_OPEN = "21-1";
    public static final String BATHROOM_ROLLER_BLINDS_CLOSED = "21-0";

    public static final String GARDEN_LIGHT_ON = "22-1";
    public static final String GARDEN_LIGHT_OFF = "22-0";

    public static String STATE_CHANGE = "stateChange";
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
