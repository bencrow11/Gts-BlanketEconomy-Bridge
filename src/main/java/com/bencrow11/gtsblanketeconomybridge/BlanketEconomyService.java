package com.bencrow11.gtsblanketeconomybridge;

import org.blanketeconomy.api.BlanketEconomy;
import org.blanketeconomy.api.EconomyAPI;
import org.pokesplash.gts.api.economy.GtsEconomy;

import java.math.BigDecimal;
import java.util.UUID;

public class BlanketEconomyService implements GtsEconomy {

    EconomyAPI api = BlanketEconomy.INSTANCE.getAPI();

    @Override
    public boolean add(UUID uuid, double amount) {

        api.addBalance(uuid, new BigDecimal(amount), GtsBlanketEconomyBridge.config.getCurrencyName());

        return true;
    }

    @Override
    public boolean remove(UUID uuid, double amount) {
        return api.subtractBalance(uuid, new BigDecimal(amount), GtsBlanketEconomyBridge.config.getCurrencyName());
    }
}
