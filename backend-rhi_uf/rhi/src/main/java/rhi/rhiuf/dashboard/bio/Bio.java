package rhi.rhiuf.dashboard.bio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Bio {

    @Id
    private String bioId;
    private String bioTitle;
    private CategorieBio bioCat;
    private String bioDesc;
}
