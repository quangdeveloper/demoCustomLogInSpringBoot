package vn.devpro.jackson.demo_jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.SerializationConfig;
import vn.devpro.jackson.model.Student;


@Slf4j
public class Jackson {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";
        try {
            Student student = mapper.readValue(jsonString,Student.class);
            System.out.println(student.toString());


            Student st = Student.builder()
                    .id(1L)
                    .name("Quang")
                    .age(22)
                    .build();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            String jsonParse = mapper.writeValueAsString(st);
            System.out.println(jsonParse);
        } catch (JsonProcessingException e) {
           log.error(e.getMessage());
        }


    }
}
