package rhi.rhiuf.dashboard.bio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBio extends JpaRepository<Bio,String> {

}
