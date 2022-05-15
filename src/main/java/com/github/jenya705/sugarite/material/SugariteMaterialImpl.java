package com.github.jenya705.sugarite.material;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

/**
 * @author Jenya705
 */
@Data
@Builder
class SugariteMaterialImpl implements SugariteMaterial {

    @NonNull private final NamespacedKey key;
    @NonNull private final Material vanillaMaterial;
    private final boolean item;
    private final boolean block;
}
