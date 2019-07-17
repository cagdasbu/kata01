package com.novacode.supermarket.campaign;

import com.novacode.supermarket.product.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CampaignManagerImpl implements CampaignManager {

    private static CampaignManagerImpl campaignService;

    private Map<String, Campaign> campaigns;

    private StoreService storeService;

    private CampaignManagerImpl() {
        storeService = StoreServiceImpl.getInstance();
        campaigns = new HashMap<>();

        //TODO campaigns needs to be externalised to be provisioned properly
        campaigns.put("1", new XForYCampaignImpl(storeService.getProduct("1"), 3, 2));
        campaigns.put("2", new QuantityForPriceCampaignImpl(storeService.getProduct("2"), 2, new BigDecimal(1)));
    }

    public static CampaignManager getInstance() {
        if (campaignService == null) {
            campaignService = new CampaignManagerImpl();
        }
        return campaignService;
    }

    @Override
    public Campaign getCampaign(String productId) {
        return campaigns.get(productId);
    }
}
