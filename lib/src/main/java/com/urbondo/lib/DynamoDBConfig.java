package com.urbondo.lib;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import static com.amazonaws.regions.Regions.US_EAST_1;

public class DynamoDBConfig {
    private final DynamoDBMapper dynamoDBMapper;
    private static DynamoDBConfig init;

    public static synchronized DynamoDBConfig getInstance() {
        if (init == null) {
            init = new DynamoDBConfig();
        }

        return init;
    }

    private DynamoDBConfig() {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB(awsCredentials()));
    }

    public DynamoDBMapper getDynamoDBMapper() {
        return dynamoDBMapper;
    }

    private AmazonDynamoDB amazonDynamoDB(AWSCredentials awsCredentials) {
        return AmazonDynamoDBClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(US_EAST_1)
                .build();
    }

    private AWSCredentials awsCredentials() {
        return new DefaultAWSCredentialsProviderChain().getCredentials();
    }
}
