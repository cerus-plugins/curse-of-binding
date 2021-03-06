/*
 *  Copyright (c) 2018 Cerus
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * Cerus
 *
 */

package de.cerus.curseofbinding;

import de.cerus.curseofbinding.listener.PlayerDeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public class CurseOfBindingPlugin extends JavaPlugin {

    private boolean usePerm;
    private String perm;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.usePerm = this.getConfig().getBoolean("use-permission", false);
        this.perm = this.getConfig().getString("permission", "curseofbinding.keep");

        this.getServer().getPluginManager().registerEvents(new PlayerDeathListener(this), this);
    }

    public boolean isUsePerm() {
        return this.usePerm;
    }

    public String getPerm() {
        return this.perm;
    }

}
