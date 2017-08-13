package com.yaotao.rest.tb;
// Generated 2016-1-2 22:34:23 by Hibernate Tools 3.6.0.Final

/**
 * TbIpfilterAccesscodeRelationId generated by hbm2java
 */
public class TbIpfilterAccesscodeRelationId implements java.io.Serializable {

	private int ipfilterId;
	private String accessCode;
	private String tenantId;

	public TbIpfilterAccesscodeRelationId() {
	}

	public TbIpfilterAccesscodeRelationId(int ipfilterId, String accessCode, String tenantId) {
		this.ipfilterId = ipfilterId;
		this.accessCode = accessCode;
		this.tenantId = tenantId;
	}

	public int getIpfilterId() {
		return this.ipfilterId;
	}

	public void setIpfilterId(int ipfilterId) {
		this.ipfilterId = ipfilterId;
	}

	public String getAccessCode() {
		return this.accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	public String getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbIpfilterAccesscodeRelationId))
			return false;
		TbIpfilterAccesscodeRelationId castOther = (TbIpfilterAccesscodeRelationId) other;

		return (this.getIpfilterId() == castOther.getIpfilterId())
				&& ((this.getAccessCode() == castOther.getAccessCode()) || (this.getAccessCode() != null
						&& castOther.getAccessCode() != null && this.getAccessCode().equals(castOther.getAccessCode())))
				&& ((this.getTenantId() == castOther.getTenantId()) || (this.getTenantId() != null
						&& castOther.getTenantId() != null && this.getTenantId().equals(castOther.getTenantId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIpfilterId();
		result = 37 * result + (getAccessCode() == null ? 0 : this.getAccessCode().hashCode());
		result = 37 * result + (getTenantId() == null ? 0 : this.getTenantId().hashCode());
		return result;
	}

}
