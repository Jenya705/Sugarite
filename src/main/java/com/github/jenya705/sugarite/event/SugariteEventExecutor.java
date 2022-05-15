package com.github.jenya705.sugarite.event;

/**
 * @author Jenya705
 */
@FunctionalInterface
public interface SugariteEventExecutor<T extends SugariteEvent> {

    void execute(T event) throws Exception;

}
