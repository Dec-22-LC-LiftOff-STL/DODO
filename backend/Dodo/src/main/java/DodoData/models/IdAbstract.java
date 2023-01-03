package DodoData.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass //a persistence annotation, maps field 'id' into child classes, ie into the persistent data tables of the other classes
public abstract class IdAbstract {

    @Id
    @GeneratedValue
    private Integer id;

    public Integer getId() {
        return id;
    }


}
