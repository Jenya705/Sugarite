package com.github.jenya705.sugarite.material;

import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

/**
 * @author Jenya705
 */
@RequiredArgsConstructor
public class SugariteBukkitMaterial implements SugariteMaterial {

    private final Material material;

    @Override
    public NamespacedKey getKey() {
        return material.getKey();
    }

    @Override
    public Material getVanillaMaterial() {
        return material;
    }

    @Override
    public boolean isItem() {
        return material.isItem();
    }

    @Override
    public boolean isBlock() {
        return material.isBlock();
    }
}
