package rhi.rhiuf.dashboard.actuality;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Actuality {
    @Id
    private String ActId;
    private  String ActTitle;
    private String ActDesc;
    private String ActImage;

}
