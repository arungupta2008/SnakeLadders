package SnakeLadders.service;

import SnakeLadders.interfaces.EntityInterface;
import SnakeLadders.interfaces.EntityType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by arun.gupta on 08/11/15.
 */
public class EntityService implements EntityInterface {

    @Override
    public Entity createEntity(EntityType entityType, Integer startLocation, Integer endLocation) {
        return new Entity(entityType, startLocation, endLocation);
    }


    public String validateEntities(HashMap<Integer, Entity> board) {
        Set<Integer> pointsSerial = new HashSet<Integer>();
        Set<Integer> onlyStartPoint = new HashSet<Integer>();

        Integer tailPoint;
        for (Entity entity : board.values()) {
            if (pointsSerial.contains(entity.getEndPosition())) {
                return "Cyclic Error";
            }
            if (onlyStartPoint.contains(entity.getStartPosition())) {
                return "Two entities can not start from same Location" + entity.getStartPosition();
            }

            pointsSerial.add(entity.getStartPosition());
            onlyStartPoint.add(entity.getStartPosition());
        }
        return null;
    }
}
