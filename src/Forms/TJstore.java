/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Pascal
 */
@Entity
@Table(name = "t_jstore", catalog = "b_geststockstandar", schema = "")
@NamedQueries({
    @NamedQuery(name = "TJstore.findAll", query = "SELECT t FROM TJstore t"),
    @NamedQuery(name = "TJstore.findByRow", query = "SELECT t FROM TJstore t WHERE t.row = :row"),
    @NamedQuery(name = "TJstore.findByRaisSoc", query = "SELECT t FROM TJstore t WHERE t.raisSoc = :raisSoc"),
    @NamedQuery(name = "TJstore.findByStatJuri", query = "SELECT t FROM TJstore t WHERE t.statJuri = :statJuri"),
    @NamedQuery(name = "TJstore.findByAdresse", query = "SELECT t FROM TJstore t WHERE t.adresse = :adresse"),
    @NamedQuery(name = "TJstore.findByTele", query = "SELECT t FROM TJstore t WHERE t.tele = :tele"),
    @NamedQuery(name = "TJstore.findByEmail", query = "SELECT t FROM TJstore t WHERE t.email = :email")})
public class TJstore implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "row")
    private Integer row;
    @Basic(optional = false)
    @Column(name = "RaisSoc")
    private String raisSoc;
    @Basic(optional = false)
    @Column(name = "StatJuri")
    private String statJuri;
    @Basic(optional = false)
    @Column(name = "Adresse")
    private String adresse;
    @Basic(optional = false)
    @Column(name = "Tele")
    private String tele;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Lob
    @Column(name = "Logo")
    private byte[] logo;

    public TJstore() {
    }

    public TJstore(Integer row) {
        this.row = row;
    }

    public TJstore(Integer row, String raisSoc, String statJuri, String adresse, String tele, String email, byte[] logo) {
        this.row = row;
        this.raisSoc = raisSoc;
        this.statJuri = statJuri;
        this.adresse = adresse;
        this.tele = tele;
        this.email = email;
        this.logo = logo;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        Integer oldRow = this.row;
        this.row = row;
        changeSupport.firePropertyChange("row", oldRow, row);
    }

    public String getRaisSoc() {
        return raisSoc;
    }

    public void setRaisSoc(String raisSoc) {
        String oldRaisSoc = this.raisSoc;
        this.raisSoc = raisSoc;
        changeSupport.firePropertyChange("raisSoc", oldRaisSoc, raisSoc);
    }

    public String getStatJuri() {
        return statJuri;
    }

    public void setStatJuri(String statJuri) {
        String oldStatJuri = this.statJuri;
        this.statJuri = statJuri;
        changeSupport.firePropertyChange("statJuri", oldStatJuri, statJuri);
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        String oldAdresse = this.adresse;
        this.adresse = adresse;
        changeSupport.firePropertyChange("adresse", oldAdresse, adresse);
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        String oldTele = this.tele;
        this.tele = tele;
        changeSupport.firePropertyChange("tele", oldTele, tele);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        byte[] oldLogo = this.logo;
        this.logo = logo;
        changeSupport.firePropertyChange("logo", oldLogo, logo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (row != null ? row.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TJstore)) {
            return false;
        }
        TJstore other = (TJstore) object;
        if ((this.row == null && other.row != null) || (this.row != null && !this.row.equals(other.row))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Forms.TJstore[ row=" + row + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
