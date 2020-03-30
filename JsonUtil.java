package ar.com.flexibility.transaction.manager.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class JsonUtil {
    
    private JsonUtil() {}
    
    public static <T> T convertirAObjeto(String json, TypeReference<T> tipo, PropertyNamingStrategy strategy) throws IOException {
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(strategy);
        mapper.registerModule(new JavaTimeModule());
        
        return mapper.readValue(json, tipo);
    }

    public static <T> String convertirAJson(T objeto, PropertyNamingStrategy strategy) throws IOException {
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(strategy);
        mapper.registerModule(new JavaTimeModule());

        return mapper.writeValueAsString(objeto);
    }
}
