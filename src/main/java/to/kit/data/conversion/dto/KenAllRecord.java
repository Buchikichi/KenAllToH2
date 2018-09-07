package to.kit.data.conversion.dto;

public class KenAllRecord {
	private String x0402;
	private String oldZip;
	private String newZip;
	private String prefectureKana;
	private String municipalityKana;
	private String areaKana;
	private String prefecture;
	private String municipality;
	private String area;
	private String dupAreaFlag;
	private String banFlag;
	private String chomeFlag;
	private String dupZipFlag;
	private String update;
	private String reason;

	/**
	 * @return X0401
	 */
	public String getX0401() {
		return this.x0402.substring(0, 2);
	}
	/**
	 * @return the x0402
	 */
	public String getX0402() {
		return this.x0402;
	}
	/**
	 * @param x0402 the x0402 to set
	 */
	public void setX0402(String x0402) {
		this.x0402 = x0402;
	}
	/**
	 * @return the oldZip
	 */
	public String getOldZip() {
		return this.oldZip;
	}
	/**
	 * @param oldZip the oldZip to set
	 */
	public void setOldZip(String oldZip) {
		this.oldZip = oldZip;
	}
	/**
	 * @return the newZip
	 */
	public String getNewZip() {
		return this.newZip;
	}
	/**
	 * @param newZip the newZip to set
	 */
	public void setNewZip(String newZip) {
		this.newZip = newZip;
	}
	/**
	 * @return the prefectureKana
	 */
	public String getPrefectureKana() {
		return this.prefectureKana;
	}
	/**
	 * @param prefectureKana the prefectureKana to set
	 */
	public void setPrefectureKana(String prefectureKana) {
		this.prefectureKana = prefectureKana;
	}
	/**
	 * @return the municipalityKana
	 */
	public String getMunicipalityKana() {
		return this.municipalityKana;
	}
	/**
	 * @param municipalityKana the municipalityKana to set
	 */
	public void setMunicipalityKana(String municipalityKana) {
		this.municipalityKana = municipalityKana;
	}
	/**
	 * @return the areaKana
	 */
	public String getAreaKana() {
		return this.areaKana;
	}
	/**
	 * @param areaKana the areaKana to set
	 */
	public void setAreaKana(String areaKana) {
		this.areaKana = areaKana;
	}
	/**
	 * @return the prefecture
	 */
	public String getPrefecture() {
		return this.prefecture;
	}
	/**
	 * @param prefecture the prefecture to set
	 */
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}
	/**
	 * @return the municipality
	 */
	public String getMunicipality() {
		return this.municipality;
	}
	/**
	 * @param municipality the municipality to set
	 */
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	/**
	 * @return the area
	 */
	public String getArea() {
		return this.area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * @return the dupAreaFlag
	 */
	public String getDupAreaFlag() {
		return this.dupAreaFlag;
	}
	/**
	 * @param dupAreaFlag the dupAreaFlag to set
	 */
	public void setDupAreaFlag(String dupAreaFlag) {
		this.dupAreaFlag = dupAreaFlag;
	}
	/**
	 * @return the banFlag
	 */
	public String getBanFlag() {
		return this.banFlag;
	}
	/**
	 * @param banFlag the banFlag to set
	 */
	public void setBanFlag(String banFlag) {
		this.banFlag = banFlag;
	}
	/**
	 * @return the chomeFlag
	 */
	public String getChomeFlag() {
		return this.chomeFlag;
	}
	/**
	 * @param chomeFlag the chomeFlag to set
	 */
	public void setChomeFlag(String chomeFlag) {
		this.chomeFlag = chomeFlag;
	}
	/**
	 * @return the dupZipFlag
	 */
	public String getDupZipFlag() {
		return this.dupZipFlag;
	}
	/**
	 * @param dupZipFlag the dupZipFlag to set
	 */
	public void setDupZipFlag(String dupZipFlag) {
		this.dupZipFlag = dupZipFlag;
	}
	/**
	 * @return the update
	 */
	public String getUpdate() {
		return this.update;
	}
	/**
	 * @param update the update to set
	 */
	public void setUpdate(String update) {
		this.update = update;
	}
	/**
	 * @return the reason
	 */
	public String getReason() {
		return this.reason;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
}
