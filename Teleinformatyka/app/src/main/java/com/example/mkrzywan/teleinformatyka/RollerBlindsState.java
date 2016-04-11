package com.example.mkrzywan.teleinformatyka;

import java.util.EnumMap;
import java.util.Iterator;

/**
 * Created by MKRZYWAN on 20.03.2016.
 */
public enum RollerBlindsState {

    CLOSED, SEMI_OPEN, OPEN, SEMI_CLOSED;

    public static int getIndex(RollerBlindsState rollerBlindsState){
        switch(rollerBlindsState){
            case SEMI_CLOSED:
                return 3;
            case OPEN:
                return 2;
            case SEMI_OPEN:
                return 1;
            case CLOSED:
                return 0;
        }
        return -1;
    }

}
