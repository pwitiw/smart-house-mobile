package com.example.mkrzywan.teleinformatyka;

/**
 * Created by MKRZYWAN on 29.03.2016.
 */
public class RasberryCommand {

    public static final String LIGHT = "LIGHT";
    public static final String VENTILATION = "VENTILATION";
    public static final String ROLLER_BLINDS = "ROLLER_BLINDS";

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
    public static String ACTION_GET_STATE = "action=getState";

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

    public static int MINIMUM_COMMANDS_NUMBER = garden_commands.length;
}
