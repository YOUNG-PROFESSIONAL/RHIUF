package rhi.rhiuf.dashboard.bio;

import java.io.IOException;
import java.util.List;

public interface ServiceBio {
    public List<Bio> listAllBio() throws IOException;
    public Bio createOrUpdateBio(Bio manage);
    public Bio getBio(String id);
    public boolean deleteBio(String id);
}
