package to.kit.data.conversion.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class KenAll {
	@Id
	private String id;
	private String x0401;
	private String x0402;
	private String zip5;
	private String zip7;
	/** prefecture. */
	private String prefKana;
	/** municipality. */
	private String municKana;
	private String cityKana;
	private String pref;
	private String munic;
	private String city;
	private boolean someCity;
	private boolean someNumber;
	private boolean someChome;
	private boolean someZip;
	private String update;
	private String reason;

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getX0401() {
		return this.x0401;
	}
	public void setX0401(String x0401) {
		this.x0401 = x0401;
	}
	public String getX0402() {
		return this.x0402;
	}
	public void setX0402(String x0402) {
		this.x0402 = x0402;
	}
	public String getZip5() {
		return this.zip5;
	}
	public void setZip5(String zip5) {
		this.zip5 = zip5;
	}
	public String getZip7() {
		return this.zip7;
	}
	public void setZip7(String zip7) {
		this.zip7 = zip7;
	}
	public String getPrefKana() {
		return this.prefKana;
	}
	public void setPrefKana(String prefKana) {
		this.prefKana = prefKana;
	}
	public String getMunicKana() {
		return this.municKana;
	}
	public void setMunicKana(String municKana) {
		this.municKana = municKana;
	}
	public String getCityKana() {
		return this.cityKana;
	}
	public void setCityKana(String cityKana) {
		this.cityKana = cityKana;
	}
	public String getPref() {
		return this.pref;
	}
	public void setPref(String pref) {
		this.pref = pref;
	}
	public String getMunic() {
		return this.munic;
	}
	public void setMunic(String munic) {
		this.munic = munic;
	}
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isSomeCity() {
		return this.someCity;
	}
	public void setSomeCity(boolean hasSomeCity) {
		this.someCity = hasSomeCity;
	}
	public boolean isSomeNumber() {
		return this.someNumber;
	}
	public void setSomeNumber(boolean hasNumber) {
		this.someNumber = hasNumber;
	}
	public boolean isSomeChome() {
		return this.someChome;
	}
	public void setSomeChome(boolean hasChome) {
		this.someChome = hasChome;
	}
	public boolean isSomeZip() {
		return this.someZip;
	}
	public void setSomeZip(boolean someZip) {
		this.someZip = someZip;
	}
	public String getUpdate() {
		return this.update;
	}
	public void setUpdate(String update) {
		this.update = update;
	}
	public String getReason() {
		return this.reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
