package SnakeLadders.service;

import SnakeLadders.exceptions.EntityTypeNotFoundException;
import SnakeLadders.interfaces.EntityType;

/**
 * Created by arun.gupta on 21/08/15.
 */
public class Entity {

    private EntityType entityType;
    private Integer startPosition;
    private Integer endPosition;

    public Entity(EntityType entityType, Integer startPosition, Integer endPosition) {
        this.entityType = entityType;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public static EntityType getEntityType(Integer entityValue) throws Exception {
        switch (entityValue) {
            case 1:
                return EntityType.LADDER;
            case 2:
                return EntityType.SNAKE;
            default:
                throw new EntityTypeNotFoundException("Entity Type not Found");
        }
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public Integer getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Integer startPosition) {
        this.startPosition = startPosition;
    }

    public Integer getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Integer endPosition) {
        this.endPosition = endPosition;
    }
}
