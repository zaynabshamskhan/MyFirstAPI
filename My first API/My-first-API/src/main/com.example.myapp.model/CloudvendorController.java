import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/Cloudvendor")

public class CloudvendorController {
    @Autowired
    private CloudvendorRepository cloudvendorRepository;
    @PostMapping("/")
    public ResponseEntity<Cloudvendor> createCloudvendor(@RequestBody Cloudvendor cloudvendor){
        Cloudvendor savedCloudvendor=todoRepository.save(cloudvendor);
        return new ResponseEntity<T>(savedCloudvendor, HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<Cloudvendor>>getAllCloudvendors(){
        List<Cloudvendor> cloudvendors = cloudvendorRepository.findAll();
        return new ResponseEntity<T>(cloudvendors, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cloudvendor> updateCloudvendor(@PathVariable Long id, @RequestBody Cloudvendor updatedCloudvendor){
        Optional<Cloudvendor> existingCloudvendor = cloudvendorRepository.findbyID(id);
        if (existingCloudvendor.isPresent()) {
            Cloudvendor cloudvendor = existingCloudvendor.get();

        cloudvendor.setTitle(updatedCloudvendor.getTitle());
        cloudvendor.setCompleted(updatedCloudvendor.isCompleted());
        Cloudvendor savedcloudvendor = cloudvendorRepository.save(cloudvendor);
        return new ResponseEntity<T>(savedcloudvendor, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCloudvendor(@PathVariable Long id){
        if (cloudvendorRepository.existsById(id)){
            cloudvendorRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
