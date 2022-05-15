package com.github.jenya705.sugarite.event;

import com.github.jenya705.sugarite.item.SugariteItemStack;

/**
 * @author Jenya705
 */
public interface SugariteItemEvent extends SugariteEvent {

    SugariteItemStack getItem();

}
