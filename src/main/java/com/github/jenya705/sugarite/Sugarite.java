package com.github.jenya705.sugarite;

import com.github.jenya705.sugarite.event.SugariteEventExecutor;
import com.github.jenya705.sugarite.event.SugariteItemEvent;
import com.github.jenya705.sugarite.material.SugariteMaterial;
import org.bukkit.NamespacedKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Jenya705
 */
public class Sugarite {

    private final Map<NamespacedKey, SugariteMaterial>
            materialMap = new ConcurrentHashMap<>();
    private final Map<Class<?>, Map<NamespacedKey, Collection<SugariteEventExecutor<SugariteItemEvent>>>>
            itemListenerMap = new ConcurrentHashMap<>();

    private final Logger logger = LoggerFactory.getLogger("Sugarite");

    public SugariteMaterial getMaterial(NamespacedKey key) {
        return materialMap.get(key);
    }

    public boolean registerMaterial(SugariteMaterial material) {
        return materialMap.putIfAbsent(material.getKey(), material) == null;
    }

    public void executeEvent(SugariteItemEvent event) {
        itemListenerMap.getOrDefault(event.getClass(), Collections.emptyMap())
                .getOrDefault(event.getItem().getSugariteMaterial().getKey(), Collections.emptyList())
                .forEach(func -> {
                    try {
                        func.execute(event);
                    } catch (Throwable e) {
                        logger.warn("Failed to execute event " + func, e);
                    }
                });
    }

    @SuppressWarnings("unchecked")
    public <T extends SugariteItemEvent> void addItemListener(Class<T> eventClass, NamespacedKey itemKey, SugariteEventExecutor<T> executor) {
        itemListenerMap.computeIfAbsent(eventClass, key -> new ConcurrentHashMap<>())
                .computeIfAbsent(itemKey, key -> new CopyOnWriteArrayList<>())
                .add(event -> executor.execute((T) event));
    }

}
