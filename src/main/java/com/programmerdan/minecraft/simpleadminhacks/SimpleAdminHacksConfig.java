package com.programmerdan.minecraft.simpleadminhacks;

import org.bukkit.configuration.ConfigurationSection;
import vg.civcraft.mc.civmodcore.CoreConfigManager;

/**
 * Baseline configuration for SimpleAdminHacks and parser for all actual Hacks.
 *
 * @author ProgrammerDan
 */
public class SimpleAdminHacksConfig extends CoreConfigManager {

	private static final int EXPECTED_CONFIG_LEVEL = 1;

	private static final String DEFAULT_BROADCAST_PERM = "simpleadmin.broadcast";

	private String broadcastPermission;

	public SimpleAdminHacksConfig(SimpleAdminHacks plugin) {
		super(plugin);
		reset();
	}

	@Override
	protected boolean parseInternal(ConfigurationSection config) {
		int actual_config_level = config.getInt("configuration_file_version", -1);
		if (actual_config_level < 0 || actual_config_level > SimpleAdminHacksConfig.EXPECTED_CONFIG_LEVEL) {
			this.plugin.severe("Invalid configuration version!");
			return false;
		}
		this.broadcastPermission = config.getString("broadcast_permission", DEFAULT_BROADCAST_PERM);
		this.plugin.info("Broadcast permission: " + this.broadcastPermission);
		return true;
	}

	public void reset() {
		super.reset();
		this.broadcastPermission = DEFAULT_BROADCAST_PERM;
	}

	public String getBroadcastPermission() {
		return this.broadcastPermission;
	}

}
