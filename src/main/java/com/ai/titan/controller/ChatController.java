package com.ai.titan.controller;


import com.alibaba.cloud.ai.dashscope.api.DashScopeApi;
import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatOptions;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class ChatController {


    private final ChatClient chatClient;
    private final ChatModel chatModel;


//    private final  chatClient;


    public ChatController(ChatClient.Builder chatClientBuilder,ChatModel chatModel) {
        this.chatClient = chatClientBuilder.build();
        this.chatModel = chatModel;
    }

    @GetMapping("/chat")
    public String chat(String input) {

//        Prompt prompt =     new Prompt("xxx", DashScopeChatOptions.builder()
//                .withModel(DashScopeApi.ChatModel.QWEN_MAX.getModel())
//                .withTemperature(0.7F)
//                .withEnableSearch()
//                .withSeed()
//                 .withIncrementalOutput()
//                .build());

        return chatClient.prompt()
                .functions("getOrderFunction")
                .user("帮我查询一下订单, 用户编号为1001, 订单编号为2001")
                .call()
                .content();
    }

    @GetMapping("/order-detail")
    public String orderDetail() {

        return  "";
        
        
//        Prompt prompt = new Prompt("XXXX",ImageModeO)
//        return chatClient.prompt()
//                .functions("getOrderFunction")
//                .user("帮我查询一下订单, 用户编号为1001, 订单编号为2001")
//                .call()
//                .content();
    }
}
