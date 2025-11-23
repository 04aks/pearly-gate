package com.aks.core.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class JsonSerializer {
    private final JsonMapper mapper;
    public JsonSerializer(){
        this.mapper = new JsonMapper();
    }

    public <T> T fromJson(String json, Class<T> clazz){
        try{
            return mapper.readValue(json, clazz);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
