package test.controller;

import org.testng.annotations.Test;
import test.service.serviceCCapp.*;

public class TestCCapp {

    @Test(priority = 0, description = "上传视频")
    public static void videoUpload() throws Exception {
        VideoUpload.videoUpload();
    }

    @Test(priority = 0, description = "视频收藏")
    public static void favoriteVideos() throws Exception {
        FavoriteVideos.favoriteVideos();
    }

    @Test(priority = 0, description = "视频点赞")
    public static void fabulous() throws Exception {
        Fabulous.fabulous();
    }

    @Test(priority = 0, description = "视频分享")
    public static void share() throws Exception {
        Share.share();
    }

    @Test(priority = 0, description = "视频播放")
    public static void videoPlayback() throws Exception {
        VideoPlayback.videoPlayback();
    }

    @Test(priority = 0, description = "视频完播")
    public static void fullplay() throws Exception {
        FullPlay.fullPlay();
    }



}
