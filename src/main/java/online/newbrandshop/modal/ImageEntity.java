package online.newbrandshop.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class ImageEntity extends BaseEntity{
    @Column(name = "link")
    String link;
    @Column(name = "idproduct")
    int idproduct;
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }
}
