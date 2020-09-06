package HomeRent.incomeexpenditure;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/incomeExpenditures")
@Slf4j
public class IncomeExpenditureAPI {
    @GetMapping
    public JsonNode incomeExpenditurefindAll() {
        String url ="http://localhost:8081/api/incomeExpenditures"; // 기본 Spring Boot Data REST 적용

        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

            HttpEntity entity = new HttpEntity("parameters", httpHeaders);
            URI uri = URI.create(url);
            ResponseEntity response= restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.getBody().toString());

            //System.out.println("### 응답결과 <jsonNode> : " + jsonNode); // data._embedded.incomeExpenditures
            log.debug("### 응답결과 <jsonNode> : " + jsonNode);
            //System.out.println("### 응답결과2(ResponseEntity ) : "+ ResponseEntity.ok(response).getBody());
            return jsonNode ;
        } catch (Exception e) {
            //System.err.println(e.toString());
            log.error("### 응답결과 오류 발생!!: \n" + e.toString());
            return null;
        }

    }

    @PostMapping
    public ResponseEntity create(@RequestBody Object incomeexpenditure) {
        String url ="http://localhost:8081/api/incomeExpenditures";
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

            HttpEntity< Object > entity = new HttpEntity<>(incomeexpenditure, httpHeaders);
            String result = restTemplate.postForObject(url, entity, String.class);

            //System.out.println("### 응답결과(POST) : " + result);
            log.debug("### 응답결과(POST) : " + result);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            log.error("### 응답결과 오류 발생!!: \n" + e.toString());
            return null;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity incomeExpenditurefindById(@PathVariable Long id) {

        String url ="http://localhost:8081/api/incomeExpenditures/"+id;
        RestTemplate restTemplate = new RestTemplate();
        //HttpHeaders httpHeaders = new HttpHeaders();
        //httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Object stock = restTemplate.getForObject(url, String.class);

        if (Objects.isNull(stock)) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        log.debug("### 응답결과 : ID ("+ id +") 결과 : " + stock.getClass().toString());
        return ResponseEntity.ok(stock);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody IncomeExpenditure incomeexpenditure) {
        String url ="http://localhost:8081/api/incomeExpenditures/"+id;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        //URI uri = URI.create().fromHttpUrl(url).build();
        HttpEntity< IncomeExpenditure > entity = new HttpEntity<>(incomeexpenditure, httpHeaders);
        ResponseEntity<IncomeExpenditure> result = restTemplate.exchange(url, HttpMethod.PUT
                , entity, new ParameterizedTypeReference<IncomeExpenditure>() {
                    @Override
                    public Type getType() {
                        return super.getType();
                    }
                });
        log.debug("### 응답결과 PUT : " + result.getBody().toString());
        return ResponseEntity.ok(result.getBody().toString());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        String url ="http://localhost:8081/api/incomeExpenditures/"+id;
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.delete(url);
            log.debug("### 삭제결과 : " + url + "삭제 완료");
        } catch (Exception e) {
            ResponseEntity.badRequest().build();
            log.error("### 삭제결과 : " + id + " 삭제중 오류 발생!! \n" + e.toString());
        }

        return ResponseEntity.ok().build();
    }
}
