package com.example.every_server.global.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Convert {

    public static String ToJson(List<String> contentList){
        StringBuilder sb = new StringBuilder();
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            sb.append(objectMapper.writeValueAsString(contentList));
        }catch (Exception e){
            log.error("JSON 변환 에러 발생");
        }
        return sb.toString();
    }

    public static List<String> ToList(String json) {
        List<String> list = new ArrayList<>();
        try {
        ObjectMapper objectMapper = new ObjectMapper();

        list = objectMapper.readValue(json, List.class);
        }catch (Exception e){
            log.error("List 변환 에러 발생");
        }
        return list;
    }
}
