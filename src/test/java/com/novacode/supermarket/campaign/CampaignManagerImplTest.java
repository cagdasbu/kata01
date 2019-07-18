package com.novacode.supermarket.campaign;

import org.junit.Assert;
import org.junit.Test;

public class CampaignManagerImplTest {

    private CampaignManager campaignManager = CampaignManagerImpl.getInstance();

    @Test
    public void getCampaign() {
        Campaign campaign = campaignManager.getCampaign("B");
        Assert.assertNotNull(campaign);
    }

    @Test
    public void getDefaultCampaign() {
        Campaign campaign = campaignManager.getCampaign("O");
        Assert.assertNull(campaign);
    }
}