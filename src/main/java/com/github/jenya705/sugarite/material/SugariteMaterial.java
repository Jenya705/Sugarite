package com.github.jenya705.sugarite.material;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;

/**
 * @author Jenya705
 */
public interface SugariteMaterial {

    static SugariteMaterialImpl.SugariteMaterialImplBuilder builder() {
        return SugariteMaterialImpl.builder();
    }

    NamespacedKey getKey();

    Material getVanillaMaterial();

    boolean isItem();

    boolean isBlock();

}
