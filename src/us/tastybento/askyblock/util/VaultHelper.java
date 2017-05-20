package us.tastybento.askyblock.util;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import us.tastybento.askyblock.ASkyBlock;

/**
 * Helper class for Vault Economy and Permissions
 * 
 * @author Tastybento
 * @author Poslovitch
 */
public class VaultHelper {
    public static Economy econ = null;
    public static Permission permission = null;
    
    /**
     * Sets up the economy instance
     * 
     * @return true if successful
     */
    public static boolean setupEconomy(ASkyBlock plugin) {
        RegisteredServiceProvider<Economy> economyProvider = plugin.getServer().getServicesManager()
                .getRegistration(Economy.class);
        if (economyProvider != null) {
            econ = economyProvider.getProvider();
        }
        return econ != null;
    }

    /**
     * Sets up the permissions instance
     * 
     * @return true if successful
     */
    public static boolean setupPermissions(ASkyBlock plugin) {
        RegisteredServiceProvider<Permission> permissionProvider = plugin.getServer().getServicesManager()
                .getRegistration(Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }

    /**
     * Checks permission of player in the world the player is in now
     * 
     * @param player
     * @param perm
     * @return true if the player has the perm
     */
    public static boolean hasPerm(final Player player, final String perm) {
        return permission.has(player, perm);
    }

    /**
     * Checks permission of player in world 
     * 
     * @param player
     * @param perm
     * @param world
     * @return
     */
    public static boolean hasPerm(final Player player, final String perm, final World world) {
        return permission.playerHas(world.getName(), player, perm);
    }

    /**
     * Adds permission to player
     * 
     * @param player
     * @param perm
     */
    public static void addPerm(final Player player, final String perm) {
        permission.playerAdd(player, perm);
    }
    
    /**
     * Add permission to player in world
     * @param player
     * @param perm
     * @param world
     */
    public static void addPerm(final Player player, final String perm, final World world) {
        permission.playerAdd(world.getName(), player, perm);
    }

    /**
     * Removes a player's permission
     * 
     * @param player
     * @param perm
     */
    public static void removePerm(final Player player, final String perm) {
        permission.playerRemove(player, perm);
    }

    /**
     * Removes a player's permission in world
     * 
     * @param player
     * @param perm
     * @param world
     */
    public static void removePerm(final Player player, final String perm, World world) {
        permission.playerRemove(world.getName(), player, perm);
    }
}