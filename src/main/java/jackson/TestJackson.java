package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by wangb on 2020/4/15.
 */
public class TestJackson {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Friend friend = new Friend("yitian", 25);

        String text = mapper.writeValueAsString(friend);
        byte[] bytes = mapper.writeValueAsBytes(friend);
        System.out.println(text);
    }
}
