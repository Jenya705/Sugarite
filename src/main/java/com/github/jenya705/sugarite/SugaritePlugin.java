package com.github.jenya705.sugarite;

import lombok.Getter;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Jenya705
 */
public final class SugaritePlugin extends JavaPlugin {

    @Getter
    private final Sugarite sugarite = new Sugarite();

    @Override
    public void onEnable() {
        getServer().getServicesManager().register(
                Sugarite.class, sugarite, this, ServicePriority.Normal
        );
    }

    @Override
    public void onDisable() {

    }

}
