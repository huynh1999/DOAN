package online.newbrandshop.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "nametype")
public class NameTypeEntity extends BaseEntity {
    @Column(name = "type")
    int type;
    @Column(name = "nametype")
    String nameType;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
