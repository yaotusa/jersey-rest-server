package com.yaotao.rest.tb;
// Generated 2016-1-2 22:34:23 by Hibernate Tools 3.6.0.Final

/**
 * TbDispersionPolceId generated by hbm2java
 */
public class TbDispersionPolceId implements java.io.Serializable {

	private String tenantId;
	private int dispersionPolceType;

	public TbDispersionPolceId() {
	}

	public TbDispersionPolceId(String tenantId, int dispersionPolceType) {
		this.tenantId = tenantId;
		this.dispersionPolceType = dispersionPolceType;
	}

	public String getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public int getDispersionPolceType() {
		return this.dispersionPolceType;
	}

	public void setDispersionPolceType(int dispersionPolceType) {
		this.dispersionPolceType = dispersionPolceType;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbDispersionPolceId))
			return false;
		TbDispersionPolceId castOther = (TbDispersionPolceId) other;

		return ((this.getTenantId() == castOther.getTenantId()) || (this.getTenantId() != null
				&& castOther.getTenantId() != null && this.getTenantId().equals(castOther.getTenantId())))
				&& (this.getDispersionPolceType() == castOther.getDispersionPolceType());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTenantId() == null ? 0 : this.getTenantId().hashCode());
		result = 37 * result + this.getDispersionPolceType();
		return result;
	}

}
