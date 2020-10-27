package sk.badand.mafuti.model.club;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Stadium implements Facility {
    private String name;
    private String city;
    private int capacity;
}
