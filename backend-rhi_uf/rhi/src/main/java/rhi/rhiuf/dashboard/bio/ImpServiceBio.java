package rhi.rhiuf.dashboard.bio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ImpServiceBio implements ServiceBio {
    @Autowired
    private RepositoryBio repoBio;

    @Override
    public List<Bio> listAllBio() throws IOException {
        if(repoBio.findAll().isEmpty() ||repoBio.findAll().size() < BioMockData.init().size()){            
            BioMockData.init().forEach(
                bio -> {
                    if(!repoBio.findByBioCat(bio.getBioCat()).isPresent()){
                        bio.setBioId(UUID.randomUUID().toString());
                        System.out.println("Bio : " + bio);
                        repoBio.save(bio);
                    }
                }
            );
            
        }
        return repoBio.findAll();
    }

    @Override
    public Bio createOrUpdateBio(Bio manage) {
        if(manage.getBioId() == null){
            manage.setBioId(UUID.randomUUID().toString());
        }
        return repoBio.save(manage);
    }

    @Override
    public Bio getBio(String id) {
        Bio acceuilManagement = repoBio.findById(id).orElse(null);
        if(acceuilManagement == null)
            return new Bio();
        return acceuilManagement;
    }

    @Override
    public boolean deleteBio(String id){
          if(!repoBio.existsById(id)) return false;
          repoBio.deleteById(id);
          return  true;
    }
}
