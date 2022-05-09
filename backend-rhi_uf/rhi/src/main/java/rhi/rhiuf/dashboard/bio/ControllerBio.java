package rhi.rhiuf.dashboard.bio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@CrossOrigin(value = "http://localhost:4200")
@RestController()
@RequestMapping(path = "/dashboard/bio")
public class ControllerBio {
    @Autowired
    private ServiceBio serviceBio;

    //GET ALL HOME DATA
    @GetMapping
    public ResponseEntity<ResponseBio> getAllBio(){
        return ResponseEntity.ok(
                ResponseBio.builder()
                        .bioTimeStamp(LocalDateTime.now())
                        .bioData(Map.of("bios",serviceBio.listAllBio()))
                        .bioStatus(HttpStatus.valueOf(200))
                        .bioMessage("Acceuil retrieved!")
                .build());
    }

    //CREATE HOME DATA
    @PostMapping
    public ResponseEntity<ResponseBio> createBio(
            @RequestBody Bio bio ){
        System.out.println("Value Bio : " + bio );
        return ResponseEntity.ok(
                ResponseBio.builder()
                        .bioTimeStamp(LocalDateTime.now())
                        .bioData(Map.of("bio",serviceBio.createOrUpdateBio(bio)))
                        .bioStatus(HttpStatus.CREATED)
                        .bioMessage("")
                        .build());
    }
    //CREATE HOME DATA
    @PutMapping()
    public ResponseEntity<ResponseBio> updateBio(
            @RequestBody Bio bio ){

        return ResponseEntity.ok(
                ResponseBio.builder()
                        .bioTimeStamp(LocalDateTime.now())
                        .bioData(Map.of("bio",serviceBio.createOrUpdateBio(bio)))
                        .bioStatus(HttpStatus.ACCEPTED)
                        .bioMessage("")
                        .build());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBio> getBio(
            @PathVariable("id") String id
    ){
       return ResponseEntity.ok(
               ResponseBio.builder()
                       .bioTimeStamp(LocalDateTime.now())
                       .bioData(Map.of("bio",serviceBio.getBio(id)))
                       .bioStatus(HttpStatus.OK)
                       .bioMessage("Data retrieved!")
                       .build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBio> deleteAcceuil(
            @PathVariable("id") String id
    ){
        return  ResponseEntity.ok(
                ResponseBio.builder()
                        .bioTimeStamp(LocalDateTime.now())
                        .bioData(Map.of("bio",serviceBio.deleteBio(id)))
                        .bioStatus(HttpStatus.OK)
                        .bioMessage("Data deleted!")
                        .build()
        );
    }
}
