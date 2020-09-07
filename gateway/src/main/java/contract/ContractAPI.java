package contract;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.Charset;
import java.util.Objects;

@RestController
@RequestMapping("/api/contracts")
@Slf4j
@RequiredArgsConstructor
public class ContractAPI {
    //private final ProductService productService;

    @GetMapping
    public String contractfindAll() {
        String url ="http://localhost:8081/api/contracts";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();
        //String response = restTemplate.getForObject(uri.toUriString(), String.class);
        String response = restTemplate.getForObject(url, String.class);
        //ResponseEntity<String> response = restTemplate.getForEntity(uri.toString(), String.class);


        //ResponseEntity<List<Contract>> = new ResponseBody(HttpMethod.GET,Optional<'http://localhost:8081/api/contracts'>)
        System.out.println("### 응답결과 : " + response);
        System.out.println("### 응답결과2(ResponseEntity ) : "+ ResponseEntity.ok(response));
        return response;
        //return ResponseEntity.ok(response);
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
    public ResponseEntity create(@RequestBody String contract) {
        String url ="http://localhost:8081/api/contracts";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        String result = restTemplate.postForObject(url, contract, String.class);
                //getForObject(url+'/'+id, String.class);
        //Object result = HttpClient.Builder(httpHeaders, contract);
        System.out.println("### 응답결과 : " + result);
        return ResponseEntity.ok(result);
    }




    @GetMapping("/{id}")
    public ResponseEntity contractfindById(@PathVariable Long id) {
        //Optional<Product> stock = productService.findById(id);
        String url ="http://localhost:8081/api/contracts/{id}";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Object stock = restTemplate.getForObject(url+'/'+id, String.class);

        if (Objects.isNull(stock)) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.getClass());
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

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!productService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        productService.deleteById(id);

        return ResponseEntity.ok().build();
    }

 */
}
