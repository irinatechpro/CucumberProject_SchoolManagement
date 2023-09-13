package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {
/*
    This method will accept json as String and convert it into any data type
    <T> T -> represents any data type, its not an object. If it would an object,
            we would have to do a type casting. T is generally used for a generic class and
            stands for Type, but it can be any name.
    readValue() methd converts the first String parameter to any required data
                type for Java (key-value data)
    With ObjectMapper we can take jSon data as String and convert it to Java, it will return
    the data in any required data type, so if Pojo class is required it will convert it to Pojo,
    if Map -> Map, etc, thats why its called generic.
    The first parameter has to be in String data type. tClall can be any name
 */
    public static <T> T convertJsonToJava(String json, Class<T> tClass)  {//Generic Method -> will return any data type
        try {
            return new ObjectMapper().readValue(json, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}