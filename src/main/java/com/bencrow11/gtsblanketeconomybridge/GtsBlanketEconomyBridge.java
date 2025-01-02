package com.bencrow11.gtsblanketeconomybridge;

import com.bencrow11.gtsblanketeconomybridge.config.Config;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.pokesplash.gts.api.economy.GtsEconomyProvider;
import org.pokesplash.gts.enumeration.Priority;

public class GtsBlanketEconomyBridge implements ModInitializer {

    public static Config config = new Config();

    @Override
    public void onInitialize() {
        config.init();

        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            GtsEconomyProvider.putEconomy(Priority.HIGH, new BlanketEconomyService());
        });
    }


}
