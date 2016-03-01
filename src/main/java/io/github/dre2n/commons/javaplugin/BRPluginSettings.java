/*
 * Copyright (C) 2015-2016 Daniel Saukel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.github.dre2n.commons.javaplugin;

import io.github.dre2n.commons.compatibility.Internals;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Daniel Saukel
 */
public class BRPluginSettings {

    private boolean spigot;
    private boolean uuid;
    private boolean economy;
    private boolean permissions;
    private Set<Internals> internals;

    public BRPluginSettings(boolean spigot, boolean uuid, boolean economy, boolean permissions, Set<Internals> internals) {
        this.spigot = spigot;
        this.uuid = uuid;
        this.economy = economy;
        this.permissions = permissions;
        this.internals = internals;
    }

    public BRPluginSettings(boolean spigot, boolean uuid, boolean economy, boolean permissions, Internals... internals) {
        this.spigot = spigot;
        this.uuid = uuid;
        this.economy = economy;
        this.permissions = permissions;
        this.internals = new HashSet<>(Arrays.asList(internals));
    }

    /**
     * @return
     * if this plugin requires the Spigot API
     */
    public boolean requiresSpigot() {
        return spigot;
    }

    /**
     * @return
     * if this plugin requires UUID support
     */
    public boolean requiresUUID() {
        return uuid;
    }

    /**
     * @return
     * if this plugin requires the economy API of Vault
     */
    public boolean requiresVaultEconomy() {
        return economy;
    }

    /**
     * @return
     * if this plugin requires the permission API of Vault
     */
    public boolean requiresVaultPermissions() {
        return permissions;
    }

    /**
     * @return
     * the internals supported by this plugin
     */
    public Set<Internals> getInternals() {
        return internals;
    }

}