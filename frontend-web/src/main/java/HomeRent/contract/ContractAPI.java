package HomeRent.contract;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.*;

@RestController
@RequestMapping("/api/contracts")
@Slf4j
@RequiredArgsConstructor
public class ContractAPI {
    //private final ProductService productService;

    @GetMapping
    public ResponseEntity contractfindAll() {
        String url ="http://localhost:8081/api/contracts"; // 기본 Spring Boot Data REST 적용
        //String url ="http://localhost:8081/v1/contracts";
        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

            HttpEntity entity = new HttpEntity("parameters", httpHeaders);
            URI uri = URI.create(url);
            ResponseEntity response= restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.getBody().toString());

//            String urlGETList = url;
//            ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(urlGETList, Object[].class);
//            Object[] objects = responseEntity.getBody();
//            MediaType contentType = responseEntity.getHeaders().getContentType();
//            HttpStatus statusCode = responseEntity.getStatusCode();
//            System.out.println("### 응답 objects: " + objects.toString());
//            System.out.println("### 응답 contentType: " + contentType);
//            System.out.println("### 응답 statusCode: " + statusCode);

//            ResponseEntity<List<Contract>> rateResponse =
//                    restTemplate.exchange(url,
//                            HttpMethod.GET, null, new ParameterizedTypeReference<List<Contract>>() {
//                            });
//            List<Contract> response = rateResponse.getBody();
            String jsonString = (jsonNode.get("_embedded")).get("contracts").toString();
            log.debug("### 응답결과 <response> : " + response);
            log.debug("### 응답결과 <jsonNode> : " + jsonNode);
            log.debug("### 응답결과 <jsonString> : " + jsonString);
            //System.out.println("### 응답결과2(ResponseEntity ) : "+ ResponseEntity.ok(response).getBody());
            return ResponseEntity.ok(jsonString);
        } catch (Exception e) {
            System.err.println(e.toString());

            return ResponseEntity.badRequest().build();
        }

    }
    /*
    private static void getEmployees()
    {
        final String uri = "http://localhost:8080/springrestexample/employees.json";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);
    }
     */

 /*
    @GetMapping
    public void get() {
        String requestURL ="http://localhost:8081/api/contracts";
        try {
            HttpClient client = HttpClientBuilder.create().build(); // HttpClient 생성
            HttpGet getRequest = new HttpGet(requestURL); //GET 메소드 URL 생성
            getRequest.addHeader("x-api-key", RestTestCommon.API_KEY); //KEY 입력

            HttpResponse response = client.execute(getRequest);

            //Response 출력
            if (response.getStatusLine().getStatusCode() == 200) {
                ResponseHandler<String> handler = new BasicResponseHandler();
                String body = handler.handleResponse(response);
                System.out.println(body);
            } else {
                System.out.println("response is error : " + response.getStatusLine().getStatusCode());
            }

        } catch (Exception e){
            System.err.println(e.toString());
        }
    }

    //출처: https://digitalbourgeois.tistory.com/58 [IT 글자국]


    //String result = restTemplate.getForObject("http://example.com/hotels/{hotel}/bookings/{booking}", String.class, "42", "21");


    @PostMapping
    public void post(String jsonMessage) {
        String requestURL ="http://localhost:8081/api/contracts";
        try {
            HttpClient client = HttpClientBuilder.create().build(); // HttpClient 생성
            HttpPost postRequest = new HttpPost(requestURL); //POST 메소드 URL 새성
            postRequest.setHeader("Accept", "application/json");
            postRequest.setHeader("Connection", "keep-alive");
            postRequest.setHeader("Content-Type", "application/json");
            postRequest.addHeader("x-api-key", RestTestCommon.API_KEY); //KEY 입력
            //postRequest.addHeader("Authorization", token); // token 이용시

            postRequest.setEntity(new StringEntity(jsonMessage)); //json 메시지 입력

            HttpResponse response = client.execute(postRequest);

            //Response 출력
            if (response.getStatusLine().getStatusCode() == 200) {
                ResponseHandler<String> handler = new BasicResponseHandler();
                String body = handler.handleResponse(response);
                System.out.println(body);
            } else {
                System.out.println("response is error : " + response.getStatusLine().getStatusCode());
            }
        } catch (Exception e){
            System.err.println(e.toString());
        }
    }
 */

    @PostMapping
    public ResponseEntity create(@RequestBody Object contract) {
        String url ="http://localhost:8081/api/contracts";
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
            //URI uri = URI.create().fromHttpUrl(url).build();
            HttpEntity< Object > entity = new HttpEntity<>(contract, httpHeaders);
            String result = restTemplate.postForObject(url, entity, String.class);

            log.debug("### 응답결과(POST) : " + result);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            log.error("### 저장(POST) 중 오류 발생!!");
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity contractfindById(@PathVariable Long id) {
        //Optional<Product> stock = productService.findById(id);
        String url ="http://localhost:8081/api/contracts/"+id;
        RestTemplate restTemplate = new RestTemplate();
        //HttpHeaders httpHeaders = new HttpHeaders();
        //httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Object stock = restTemplate.getForObject(url, String.class);

        if (Objects.isNull(stock)) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contract> update(@PathVariable Long id, @RequestBody Contract contract) {
        String url ="http://localhost:8081/api/contracts/"+id;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        //URI uri = URI.create().fromHttpUrl(url).build();
        HttpEntity< Contract > entity = new HttpEntity<>(contract, httpHeaders);
        ResponseEntity<Contract> result = restTemplate.exchange(url, HttpMethod.PUT
                , entity, new ParameterizedTypeReference<Contract>() {
                    @Override
                    public Type getType() {
                        return super.getType();
                    }
                });
        log.debug("### 응답결과 PUT : " + result);
        return result;
    }
/*
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody Product product) {
        if (!productService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(productService.save(product));
    }
*/
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        String url ="http://localhost:8081/api/contracts/"+id;
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.delete(url);
            System.out.println("### 결과 : " + url + "삭제 완료");
        } catch (Exception e) {
            ResponseEntity.badRequest().build();
            log.error("### 삭제결과 : " + id + " 삭제중 오류 발생!!");
        }

        return ResponseEntity.ok().build();
    }

}
