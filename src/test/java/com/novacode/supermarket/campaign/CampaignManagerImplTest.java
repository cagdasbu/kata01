package com.novacode.supermarket.campaign;

import org.junit.Assert;
import org.junit.Test;

public class CampaignManagerImplTest {

    private CampaignManager campaignManager = CampaignManagerImpl.getInstance();

    @Test
    public void getCampaign() {
        Campaign campaign = campaignManager.getCampaign("1");
        Assert.assertNotNull(campaign);
    }

    @Test
    public void getDefaultCampaign() {
        Campaign campaign = campaignManager.getCampaign("3");
        Assert.assertNull(campaign);
    }
}