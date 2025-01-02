package com.bencrow11.gtsblanketeconomybridge.config;

import com.google.gson.Gson;
import org.pokesplash.gts.util.Utils;

import java.util.concurrent.CompletableFuture;

public class Config {

    private String currencyName;

    public Config() {
        this.currencyName = "cobblecoins";
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void init() {

        String filePath = "/config/gtsblanketeconomybridge/";
        String fileName = "config.json";

        CompletableFuture<Boolean> future = Utils.readFileAsync(filePath, fileName,
            el -> {
                Gson gson = new Gson();
                Config config = gson.fromJson(el, Config.class);
                this.currencyName = config.getCurrencyName();
            }
        );

        if (!future.join()) {
            Gson gson = new Gson();
            String json = gson.toJson(this);
            Utils.writeFileAsync(filePath, fileName, json);
        }
    }
}
