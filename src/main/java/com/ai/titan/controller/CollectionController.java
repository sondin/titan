package com.ai.titan.controller;

import com.ai.titan.aop.Permission;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.milvus.v2.client.ConnectConfig;
import io.milvus.v2.client.MilvusClientV2;
import io.milvus.v2.common.ConsistencyLevel;
import io.milvus.v2.service.collection.request.CreateCollectionReq;
import io.milvus.v2.service.collection.request.DropCollectionReq;
import io.milvus.v2.service.vector.request.GetReq;
import io.milvus.v2.service.vector.request.InsertReq;
import io.milvus.v2.service.vector.request.QueryReq;
import io.milvus.v2.service.vector.request.SearchReq;
import io.milvus.v2.service.vector.response.GetResp;
import io.milvus.v2.service.vector.response.InsertResp;
import io.milvus.v2.service.vector.response.QueryResp;
import io.milvus.v2.service.vector.response.SearchResp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/ai/milvus")
public class CollectionController {


    @GetMapping("/create")
    @Permission(value = "xxxxx")
    public void createCollection() throws InterruptedException {


        ConnectConfig config = ConnectConfig.builder()
                .uri("http://localhost:19530")
                .build();
        MilvusClientV2 client = new MilvusClientV2(config);

        String collectionName = "java_sdk_example_simple_v2";
        // Drop collection if exists
        client.dropCollection(DropCollectionReq.builder()
                .collectionName(collectionName)
                .build());

        // Quickly create a collection with "id" field and "vector" field
        client.createCollection(CreateCollectionReq.builder()
                .collectionName(collectionName)
                .dimension(4)
                .build());
        List<JsonObject> rows = new ArrayList<>();
        Gson gson = new Gson();
        for (int i = 0; i < 100; i++) {
            JsonObject row = new JsonObject();
            row.addProperty("id", i);
            row.add("vector", gson.toJsonTree(new float[]{i, (float) i /2, (float) i /3, (float) i /4}));
            row.addProperty(String.format("dynamic_%d", i), "this is dynamic value"); // this value is stored in dynamic field
            rows.add(row);
        }

        // Get row count, set ConsistencyLevel.STRONG to sync the data to query node so that data is visible
        QueryResp countR = client.query(QueryReq.builder()
                .collectionName(collectionName)
                .filter("")
                .outputFields(Collections.singletonList("count(*)"))
                .consistencyLevel(ConsistencyLevel.STRONG)
                .build());
        System.out.printf("%d rows persisted\n", (long)countR.getQueryResults().get(0).getEntity().get("count(*)"));

        // Retrieve
        List<Object> ids = Arrays.asList(1L, 50L);
        GetResp getR = client.get(GetReq.builder()
                .collectionName(collectionName)
                .ids(ids)
                .outputFields(Collections.singletonList("*"))
                .build());
        System.out.println("\nRetrieve results:");
        for (QueryResp.QueryResult result : getR.getGetResults()) {
            System.out.println(result.getEntity());
        }

        // Search
//        SearchResp searchR = client.search(SearchReq.builder()
//                .collectionName(collectionName)
//                .data(Collections.singletonList(new FloatVec(new float[]{1.0f, 1.0f, 1.0f, 1.0f})))
//                .filter("id < 100")
//                .topK(10)
//                .outputFields(Collections.singletonList("*"))
//                .build());
//        List<List<SearchResp.SearchResult>> searchResults = searchR.getSearchResults();
//        System.out.println("\nSearch results:");
//        for (List<SearchResp.SearchResult> results : searchResults) {
//            for (SearchResp.SearchResult result : results) {
//                System.out.printf("ID: %d, Score: %f, %s\n", (long)result.getId(), result.getScore(), result.getEntity().toString());
//            }
//        }

        client.close(1);

    }


}
