package com.worldpay.innovation.wpwithin.producerex;


import com.worldpay.innovation.wpwithin.WPWithinGeneralException;
import com.worldpay.innovation.wpwithin.WPWithinWrapper;
import com.worldpay.innovation.wpwithin.WPWithinWrapperImpl;
import com.worldpay.innovation.wpwithin.types.WWPrice;
import com.worldpay.innovation.wpwithin.types.WWPricePerUnit;
import com.worldpay.innovation.wpwithin.types.WWService;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        try {

            System.out.println("WorldpayWithin Sample Producer...");

            WPWithinWrapper wpw = new WPWithinWrapperImpl("127.0.0.1", 9067, true);

            wpw.setup("Producer CarUbantu", "nUber");

            WWService svc = new WWService();
            svc.setName("Car charger");
            svc.setDescription("Can charge your hybrid / electric car");
            svc.setId(1);

            WWPrice ccPrice = new WWPrice();
            ccPrice.setId(1);
            ccPrice.setDescription("Kilowatt-hour");
            ccPrice.setUnitDescription("One kilowatt-hour");
            ccPrice.setUnitId(1);
            WWPricePerUnit ppu = new WWPricePerUnit();
            ppu.setAmount(25);
            ppu.setCurrencyCode("GBP");
            ccPrice.setPricePerUnit(ppu);

            HashMap<Integer, WWPrice> prices = new HashMap<>(1);
            prices.put(ccPrice.getId(), ccPrice);

            svc.setPrices(prices);

            wpw.addService(svc);
            //wpw.initProducer("T_C_03eaa1d3-4642-4079-b030-b543ee04b5af", "T_S_f50ecb46-ca82-44a7-9c40-421818af5996"); OLd
            wpw.initProducer("T_C_4e05e5ff-6812-49b8-9aeb-c5b94a7c7308", "T_S_6a02c61d-6fce-48eb-9419-06d9d2708427");
//T_C_4e05e5ff-6812-49b8-9aeb-c5b94a7c7308
            wpw.startServiceBroadcast(0);

        } catch (WPWithinGeneralException e) {

            e.printStackTrace();
        }
    }
}
