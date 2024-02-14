package com.harbour.springboot.refactoring.dtos;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class AmazonConfiguration {

    @Bean
    AmazonSQS amazonSQS() {
        return new AmazonSQS() {
            @Override
            public void setEndpoint(String endpoint) {

            }

            @Override
            public void setRegion(Region region) {

            }

            @Override
            public AddPermissionResult addPermission(AddPermissionRequest addPermissionRequest) {
                return null;
            }

            @Override
            public AddPermissionResult addPermission(String queueUrl, String label, List<String> aWSAccountIds, List<String> actions) {
                return null;
            }

            @Override
            public ChangeMessageVisibilityResult changeMessageVisibility(ChangeMessageVisibilityRequest changeMessageVisibilityRequest) {
                return null;
            }

            @Override
            public ChangeMessageVisibilityResult changeMessageVisibility(String queueUrl, String receiptHandle, Integer visibilityTimeout) {
                return null;
            }

            @Override
            public ChangeMessageVisibilityBatchResult changeMessageVisibilityBatch(ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest) {
                return null;
            }

            @Override
            public ChangeMessageVisibilityBatchResult changeMessageVisibilityBatch(String queueUrl, List<ChangeMessageVisibilityBatchRequestEntry> entries) {
                return null;
            }

            @Override
            public CreateQueueResult createQueue(CreateQueueRequest createQueueRequest) {
                return null;
            }

            @Override
            public CreateQueueResult createQueue(String queueName) {
                return null;
            }

            @Override
            public DeleteMessageResult deleteMessage(DeleteMessageRequest deleteMessageRequest) {
                return null;
            }

            @Override
            public DeleteMessageResult deleteMessage(String queueUrl, String receiptHandle) {
                return null;
            }

            @Override
            public DeleteMessageBatchResult deleteMessageBatch(DeleteMessageBatchRequest deleteMessageBatchRequest) {
                return null;
            }

            @Override
            public DeleteMessageBatchResult deleteMessageBatch(String queueUrl, List<DeleteMessageBatchRequestEntry> entries) {
                return null;
            }

            @Override
            public DeleteQueueResult deleteQueue(DeleteQueueRequest deleteQueueRequest) {
                return null;
            }

            @Override
            public DeleteQueueResult deleteQueue(String queueUrl) {
                return null;
            }

            @Override
            public GetQueueAttributesResult getQueueAttributes(GetQueueAttributesRequest getQueueAttributesRequest) {
                return null;
            }

            @Override
            public GetQueueAttributesResult getQueueAttributes(String queueUrl, List<String> attributeNames) {
                return null;
            }

            @Override
            public GetQueueUrlResult getQueueUrl(GetQueueUrlRequest getQueueUrlRequest) {
                return null;
            }

            @Override
            public GetQueueUrlResult getQueueUrl(String queueName) {
                return null;
            }

            @Override
            public ListDeadLetterSourceQueuesResult listDeadLetterSourceQueues(ListDeadLetterSourceQueuesRequest listDeadLetterSourceQueuesRequest) {
                return null;
            }

            @Override
            public ListQueueTagsResult listQueueTags(ListQueueTagsRequest listQueueTagsRequest) {
                return null;
            }

            @Override
            public ListQueueTagsResult listQueueTags(String queueUrl) {
                return null;
            }

            @Override
            public ListQueuesResult listQueues(ListQueuesRequest listQueuesRequest) {
                return null;
            }

            @Override
            public ListQueuesResult listQueues() {
                return null;
            }

            @Override
            public ListQueuesResult listQueues(String queueNamePrefix) {
                return null;
            }

            @Override
            public PurgeQueueResult purgeQueue(PurgeQueueRequest purgeQueueRequest) {
                return null;
            }

            @Override
            public ReceiveMessageResult receiveMessage(ReceiveMessageRequest receiveMessageRequest) {
                return null;
            }

            @Override
            public ReceiveMessageResult receiveMessage(String queueUrl) {
                return null;
            }

            @Override
            public RemovePermissionResult removePermission(RemovePermissionRequest removePermissionRequest) {
                return null;
            }

            @Override
            public RemovePermissionResult removePermission(String queueUrl, String label) {
                return null;
            }

            @Override
            public SendMessageResult sendMessage(SendMessageRequest sendMessageRequest) {
                return null;
            }

            @Override
            public SendMessageResult sendMessage(String queueUrl, String messageBody) {
                return null;
            }

            @Override
            public SendMessageBatchResult sendMessageBatch(SendMessageBatchRequest sendMessageBatchRequest) {
                return null;
            }

            @Override
            public SendMessageBatchResult sendMessageBatch(String queueUrl, List<SendMessageBatchRequestEntry> entries) {
                return null;
            }

            @Override
            public SetQueueAttributesResult setQueueAttributes(SetQueueAttributesRequest setQueueAttributesRequest) {
                return null;
            }

            @Override
            public SetQueueAttributesResult setQueueAttributes(String queueUrl, Map<String, String> attributes) {
                return null;
            }

            @Override
            public TagQueueResult tagQueue(TagQueueRequest tagQueueRequest) {
                return null;
            }

            @Override
            public TagQueueResult tagQueue(String queueUrl, Map<String, String> tags) {
                return null;
            }

            @Override
            public UntagQueueResult untagQueue(UntagQueueRequest untagQueueRequest) {
                return null;
            }

            @Override
            public UntagQueueResult untagQueue(String queueUrl, List<String> tagKeys) {
                return null;
            }

            @Override
            public void shutdown() {

            }

            @Override
            public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
                return null;
            }
        };
    }
}
