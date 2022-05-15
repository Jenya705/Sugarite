package com.github.jenya705.sugarite.item;

import com.github.jenya705.sugarite.material.SugariteBukkitMaterial;
import com.github.jenya705.sugarite.material.SugariteMaterial;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @author Jenya705
 */
@Getter
public class SugariteItemStack extends ItemStack {

    private SugariteMaterial sugariteMaterial;

    public SugariteItemStack(SugariteMaterial material) {
        super(material.getVanillaMaterial());
        this.sugariteMaterial = material;
    }

    public SugariteItemStack(SugariteItemStack itemStack) {
        super(itemStack);
        this.sugariteMaterial = itemStack.getSugariteMaterial();
    }

    public SugariteItemStack(ItemStack itemStack, SugariteMaterial material) {
        super(itemStack);
        super.setType(material.getVanillaMaterial());
        this.sugariteMaterial = material;
    }

    @Override
    public void setType(@NotNull Material type) {
        super.setType(type);
        this.sugariteMaterial = new SugariteBukkitMaterial(type);
    }

    public void setType(@NotNull SugariteMaterial type) {
        super.setType(type.getVanillaMaterial());
        this.sugariteMaterial = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SugariteItemStack that = (SugariteItemStack) o;
        return Objects.equals(sugariteMaterial, that.sugariteMaterial) && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sugariteMaterial);
    }

    @Override
    public @NotNull SugariteItemStack clone() {
        return new SugariteItemStack(super.clone(), sugariteMaterial);
    }
}
