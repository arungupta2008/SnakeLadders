package SnakeLadders.interfaces;

/**
 * Created by arun.gupta on 21/08/15.
 */
public enum EntityType {
    SNAKE(0), LADDER(1);

    int type;

    EntityType(int type) {
        this.type = type;
    }

    int getEntityValue() {
        return type;
    }
}
