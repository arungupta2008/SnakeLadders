package SnakeLadders.interfaces;

/**
 * Created by arun.gupta on 21/08/15.
 */
public interface EntityInterface {
    public SnakeLadders.service.Entity createEntity(EntityType entityType, Integer startLocation, Integer endLocation);
}
