package test.controller;

import org.testng.annotations.Test;
import test.service.*;
import java.io.IOException;

public class TestOwner {
//    @Test(priority = 0, description = "获取登录token")
//    public static void getVerificationCode() throws IOException, InterruptedException {
//        GetVerificationCode.getVerificationCode();
//    }

    @Test(priority = 0, description = "用户信息")
    public static void userInformation() throws Exception {
        UserInformation.userInformation();
    }

    @Test(priority = 0, description = "查询赛季人数")
    public static void querySeasonNumber() throws Exception {
        QuerySeasonNumber.querySeasonNumber();
    }

    @Test(priority = 0, description = "领取升级奖励")
    public static void receiveUpgradeAward() throws Exception {
        ReceiveUpgradeAward.receiveUpgradeAward();
    }

    @Test(priority = 0, description = "查询当前赛季")
    public static void queryCurrentSeason() throws Exception {
        QueryCurrentSeason.queryCurrentSeason();
    }

    @Test(priority = 0, description = "查询赛季结算奖励")
    public static void querySeasonSettlementRewards() throws Exception {
        QuerySeasonSettlementRewards.querySeasonSettlementRewards();
    }

    @Test(priority = 0, description = "领取赛季结算奖励")
    public static void receiveSeasonSettlementAward() throws Exception {
        ReceiveSeasonSettlementAward.receiveSeasonSettlementAward();
    }

    @Test(priority = 0, description = "排行榜列表")
    public static void leaderboardList() throws Exception {
        LeaderboardList.leaderboardList();
    }

    @Test(priority = 0, description = "查询我的排行")
    public static void queryMyRanking() throws Exception {
        QueryMyRanking.queryMyRanking();
    }


}
