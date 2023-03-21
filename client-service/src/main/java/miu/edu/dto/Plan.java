package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.domain.Location;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plan {
    private long id;
    private String name;
    private String description;

    private List<Location> locations;
}
