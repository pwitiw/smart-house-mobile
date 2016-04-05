package com.example.mkrzywan.teleinformatyka;

/**
 * Created by MKRZYWAN on 29.03.2016.
 */
public class RasberryCommand {

    public static final String LIVING_ROOM_LIGHT_ON = "garden_light_on";
    public static final String LIVING_ROOM_LIGHT_OFF = "garden_light_off";
    public static final String LIVING_ROOM_VENTILATION_ON = "garden_ventilation_on";
    public static final String LIVING_ROOM_VENTILATION_OFF = "garden_ventilation_off";
    public static final String LIVING_ROOM_ROLLER_BLINDS_OPEN = "garden_rollerblinds_open";
    public static final String LIVING_ROOM_ROLLER_BLINDS_SEMI_OPEN = "garden_rollerblinds_semiopen";
    public static final String LIVING_ROOM_ROLLER_BLINDS_CLOSED = "garden_rollerblinds_closed";

    public static final String BEDROOM_LIGHT_ON = "bedroom_light_on";
    public static final String BEDROOM_LIGHT_OFF = "bedroom_light_off";
    public static final String BEDROOM_VENTILATION_ON = "bedroom_ventilation_on";
    public static final String BEDROOM_VENTILATION_OFF = "bedroom_ventilation_off";
    public static final String BEDROOM_ROLLER_BLINDS_OPEN = "bedroom_rollerblinds_open";
    public static final String BEDROOM_ROLLER_BLINDS_SEMI_OPEN = "bedroom_rollerblinds_semiopen";
    public static final String BEDROOM_ROLLER_BLINDS_CLOSED = "bedroom_rollerblinds_closed";

    public static final String BATHROOM_LIGHT_ON = "bathroom_light_on";
    public static final String BATHROOM_LIGHT_OFF = "bathroom_light_off";
    public static final String BATHROOM_VENTILATION_ON = "bathroom_ventilation_on";
    public static final String BATHROOM_VENTILATION_OFF = "bathroom_ventilation_off";
    public static final String BATHROOM_ROLLER_BLINDS_OPEN = "bathroom_rollerblinds_open";
    public static final String BATHROOM_ROLLER_BLINDS_SEMI_OPEN = "bathroom_rollerblinds_semiopen";
    public static final String BATHROOM_ROLLER_BLINDS_CLOSED = "bathroom_rollerblinds_closed";

    public static final String GARDEN_LIGHT_ON = "garden_light_on";
    public static final String GARDEN_LIGHT_OFF = "garden_light_off";

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
