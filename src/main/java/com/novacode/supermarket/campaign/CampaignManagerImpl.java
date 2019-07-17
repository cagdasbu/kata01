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
    }

    public static CampaignManager getInstance() {
        if (campaignService == null) {
            campaignService = new CampaignManagerImpl();
        }
        return campaignService;
    }

    @Override
    public Campaign getCampaign(String productId) {
        return campaigns.get(productId) == null ? new DefaultCampaignImpl(storeService.getProduct(productId)) : campaigns.get(productId);
    }
}
