package rhi.rhiuf.dashboard.bio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ImpServiceBio implements ServiceBio {
    @Autowired
    private RepositoryBio repoAccManagement;

    @Override
    public List<Bio> listAllBio() {
        return repoAccManagement.findAll();
    }

    @Override
    public Bio createOrUpdateBio(Bio manage) {
        if(manage.getBioId() == null){
            UUID uuid = UUID.randomUUID();
            manage.setBioId(uuid.toString());
        }
        return repoAccManagement.save(manage);
    }

    @Override
    public Bio getBio(String id) {
        Bio acceuilManagement = repoAccManagement.findById(id).orElse(null);
        if(acceuilManagement == null)
            return new Bio();
        return acceuilManagement;
    }

    @Override
    public boolean deleteBio(String id){
          if(!repoAccManagement.existsById(id)) return false;
          repoAccManagement.deleteById(id);
          return  true;
    }
}
