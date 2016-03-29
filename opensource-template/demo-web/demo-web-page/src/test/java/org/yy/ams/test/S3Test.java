///*
//* 文 件 名:  S3Test.java
//* 版    权:  YY Technologies Co., Ltd. Copyright 2012-2013,  All rights reserved
//* 描    述:  <描述>
//* 修 改 人:  zhouliang
//* 修改时间:  2016年3月29日
//* 修改内容:  <修改内容>
//*/
//package org.yy.ams.test;
//
//import org.junit.Test;
//
//import com.amazonaws.auth.profile.ProfileCredentialsProvider;
//import com.amazonaws.regions.Region;
//import com.amazonaws.regions.Regions;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.model.ListObjectsRequest;
//import com.amazonaws.services.s3.model.ObjectListing;
//
///**
//* <一句话功能简述>
//* <功能详细描述>
//* 
//* @author  zhouliang
//* @version  [版本号, 2016年3月29日]
//* @since  [产品/模块版本]
//*/
//public class S3Test {
//    
//    @Test
//    public void read() {
//        
//        //BasicAWSCredentials awsCreds = new BasicAWSCredentials({access_key_id}, {secret_access_key})
//        //AmazonS3 s3Client = new AmazonS3Client(awsCreds);
//        Region cnNorth1 = Region.getRegion(Regions.CN_NORTH_1);
//        AmazonS3 s3client = new AmazonS3Client(new ProfileCredentialsProvider());
//        s3client.setRegion(cnNorth1);
//        ObjectListing objectListing = s3client.listObjects(new ListObjectsRequest().withBucketName("yibao-bucket"));
//        objectListing = null;
//    }
//    
//    @Test
//    public void write() {
//        
//    }
//}
