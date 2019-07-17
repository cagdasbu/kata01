package com.novacode.supermarket.campaign;

import org.junit.Assert;
import org.junit.Test;

public class CampaignManagerImplTest {

    @Test
    public void getCampaign() {
        CampaignManager campaignManager = CampaignManagerImpl.getInstance();
        Campaign campaign = campaignManager.getCampaign("1");
        Assert.assertNotNull(campaign);
    }

    @Test
    public void getDefaultCampaign() {
        CampaignManager campaignManager = CampaignManagerImpl.getInstance();
        Campaign campaign = campaignManager.getCampaign("3");
        Assert.assertNotNull(campaign);
        assert campaign instanceof DefaultCampaignImpl;
    }
}