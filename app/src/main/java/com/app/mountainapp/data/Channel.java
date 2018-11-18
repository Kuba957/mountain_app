package com.app.mountainapp.data;

import org.json.JSONObject;

public class Channel implements JSONPopulator {

    private Units units;
    private Item item;
    private Astronomy astronomy;
    private Wind wind;
    private Atmosphere atmosphere;

    public Units getUnits() {
        return units;
    }

    public Item getItem() {
        return item;
    }

    public Astronomy getAstronomy() {
        return astronomy;
    }

    public Wind getWind() {
        return wind;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    @Override
    public void populate(JSONObject data) {
        units = new Units();
        units.populate(data.optJSONObject("units"));
        item = new Item();
        item.populate(data.optJSONObject("item"));
        astronomy = new Astronomy();
        astronomy.populate(data.optJSONObject("astronomy"));
        wind = new Wind();
        wind.populate(data.optJSONObject("wind"));
        atmosphere = new Atmosphere();
        atmosphere.populate(data.optJSONObject("atmosphere"));
    }
}
