package rhi.rhiuf.dashboard.bio;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rhi.rhiuf.ApiResponse;

@CrossOrigin(value = "http://localhost:4200")
@RestController()
@RequestMapping(path = "/dashboard/bio")
public class ControllerBio {
    @Autowired
    private ServiceBio serviceBio;

    //GET ALL HOME DATA
    @GetMapping
    public ResponseEntity<ApiResponse> getAllBio() throws IOException {

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .apiTimestamp(LocalDateTime.now())
                        .apiData(Map.of("datas",serviceBio.listAllBio()))
                        .apiStatus(HttpStatus.valueOf(200))
                        .apiMessage("Acceuil retrieved!")
                .build());
    }

    //CREATE HOME DATA
    @PostMapping
    public ResponseEntity<ApiResponse> createBio(
            @RequestBody Bio bio ){
        System.out.println("Value Bio : " + bio );
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .apiTimestamp(LocalDateTime.now())
                        .apiData(Map.of("data",serviceBio.createOrUpdateBio(bio)))
                        .apiStatus(HttpStatus.CREATED)
                        .apiMessage("")
                        .build());
    }
    //CREATE HOME DATA
    @PutMapping()
    public ResponseEntity<ApiResponse> updateBio(
            @RequestBody Bio bio ){

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .apiTimestamp(LocalDateTime.now())
                        .apiData(Map.of("data",serviceBio.createOrUpdateBio(bio)))
                        .apiStatus(HttpStatus.ACCEPTED)
                        .apiMessage("")
                        .build());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getBio(
            @PathVariable("id") String id
    ){
       return ResponseEntity.ok(
               ApiResponse.builder()
                       .apiTimestamp(LocalDateTime.now())
                       .apiData(Map.of("data",serviceBio.getBio(id)))
                       .apiStatus(HttpStatus.OK)
                       .apiMessage("Data retrieved!")
                       .build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteAcceuil(
            @PathVariable("id") String id
    ){
        return  ResponseEntity.ok(
                ApiResponse.builder()
                        .apiTimestamp(LocalDateTime.now())
                        .apiData(Map.of("data",serviceBio.deleteBio(id)))
                        .apiStatus(HttpStatus.OK)
                        .apiMessage("Data deleted!")
                        .build()
        );
    }
}
