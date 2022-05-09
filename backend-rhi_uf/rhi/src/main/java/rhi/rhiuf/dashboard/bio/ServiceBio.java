package rhi.rhiuf.dashboard.bio;

import java.util.List;

public interface ServiceBio {
    public List<Bio> listAllBio();
    public Bio createOrUpdateBio(Bio manage);
    public Bio getBio(String id);
    public boolean deleteBio(String id);
}
