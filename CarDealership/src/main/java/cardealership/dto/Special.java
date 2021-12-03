package cardealership.dto;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Harrison Fok
 */
public class Special {
    private int specialID;
    private Date startDate;
    private Date endDate;
    private String discount;
    
    public Special(){
        
    }

    public Special(int specialID, Date startDate, Date endDate, String discount) {
        this.specialID = specialID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discount = discount;
    }

    public int getSpecialID() {
        return specialID;
    }

    public void setSpecialID(int specialID) {
        this.specialID = specialID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.specialID;
        hash = 97 * hash + Objects.hashCode(this.startDate);
        hash = 97 * hash + Objects.hashCode(this.endDate);
        hash = 97 * hash + Objects.hashCode(this.discount);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Special other = (Special) obj;
        if (this.specialID != other.specialID) {
            return false;
        }
        if (!Objects.equals(this.discount, other.discount)) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.endDate, other.endDate)) {
            return false;
        }
        return true;
    }
    
    
}
