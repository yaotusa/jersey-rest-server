package com.yaotao.rest.tb;
// Generated 2016-1-2 22:34:23 by Hibernate Tools 3.6.0.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * TbEvent generated by hbm2java
 */
public class TbEvent implements java.io.Serializable {

	private String eventId;
	private TbTenant tbTenant;
	private String name;
	private String comment;
	private boolean conditionCreate;
	private boolean conditionRead;
	private boolean conditionUpdate;
	private boolean conditionDelete;
	private String notifyStartTime;
	private String notifyEndTime;
	private Integer notifyNumericValue;
	private BigDecimal notifyFloatValue;
	private Integer notifyNumericCondition;
	private String notifyStringValue;
	private Integer notifyStringCondition;
	private boolean stopFlag;
	private Integer awakeNumericValue;
	private BigDecimal awakeFloatValue;
	private Integer awakeNumericCondition;
	private String awakeStringValue;
	private Integer awakeStringCondition;
	private int action;
	private String reserved01;
	private String reserved02;
	private String reserved03;
	private Set tbTargetResources = new HashSet(0);
	private TbActionApi tbActionApi;
	private TbActionEmail tbActionEmail;

	public TbEvent() {
	}

	public TbEvent(String eventId, boolean conditionCreate, boolean conditionRead, boolean conditionUpdate,
			boolean conditionDelete, boolean stopFlag, int action) {
		this.eventId = eventId;
		this.conditionCreate = conditionCreate;
		this.conditionRead = conditionRead;
		this.conditionUpdate = conditionUpdate;
		this.conditionDelete = conditionDelete;
		this.stopFlag = stopFlag;
		this.action = action;
	}

	public TbEvent(String eventId, TbTenant tbTenant, String name, String comment, boolean conditionCreate,
			boolean conditionRead, boolean conditionUpdate, boolean conditionDelete, String notifyStartTime,
			String notifyEndTime, Integer notifyNumericValue, BigDecimal notifyFloatValue,
			Integer notifyNumericCondition, String notifyStringValue, Integer notifyStringCondition, boolean stopFlag,
			Integer awakeNumericValue, BigDecimal awakeFloatValue, Integer awakeNumericCondition,
			String awakeStringValue, Integer awakeStringCondition, int action, String reserved01, String reserved02,
			String reserved03, Set tbTargetResources, TbActionApi tbActionApi, TbActionEmail tbActionEmail) {
		this.eventId = eventId;
		this.tbTenant = tbTenant;
		this.name = name;
		this.comment = comment;
		this.conditionCreate = conditionCreate;
		this.conditionRead = conditionRead;
		this.conditionUpdate = conditionUpdate;
		this.conditionDelete = conditionDelete;
		this.notifyStartTime = notifyStartTime;
		this.notifyEndTime = notifyEndTime;
		this.notifyNumericValue = notifyNumericValue;
		this.notifyFloatValue = notifyFloatValue;
		this.notifyNumericCondition = notifyNumericCondition;
		this.notifyStringValue = notifyStringValue;
		this.notifyStringCondition = notifyStringCondition;
		this.stopFlag = stopFlag;
		this.awakeNumericValue = awakeNumericValue;
		this.awakeFloatValue = awakeFloatValue;
		this.awakeNumericCondition = awakeNumericCondition;
		this.awakeStringValue = awakeStringValue;
		this.awakeStringCondition = awakeStringCondition;
		this.action = action;
		this.reserved01 = reserved01;
		this.reserved02 = reserved02;
		this.reserved03 = reserved03;
		this.tbTargetResources = tbTargetResources;
		this.tbActionApi = tbActionApi;
		this.tbActionEmail = tbActionEmail;
	}

	public String getEventId() {
		return this.eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public TbTenant getTbTenant() {
		return this.tbTenant;
	}

	public void setTbTenant(TbTenant tbTenant) {
		this.tbTenant = tbTenant;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isConditionCreate() {
		return this.conditionCreate;
	}

	public void setConditionCreate(boolean conditionCreate) {
		this.conditionCreate = conditionCreate;
	}

	public boolean isConditionRead() {
		return this.conditionRead;
	}

	public void setConditionRead(boolean conditionRead) {
		this.conditionRead = conditionRead;
	}

	public boolean isConditionUpdate() {
		return this.conditionUpdate;
	}

	public void setConditionUpdate(boolean conditionUpdate) {
		this.conditionUpdate = conditionUpdate;
	}

	public boolean isConditionDelete() {
		return this.conditionDelete;
	}

	public void setConditionDelete(boolean conditionDelete) {
		this.conditionDelete = conditionDelete;
	}

	public String getNotifyStartTime() {
		return this.notifyStartTime;
	}

	public void setNotifyStartTime(String notifyStartTime) {
		this.notifyStartTime = notifyStartTime;
	}

	public String getNotifyEndTime() {
		return this.notifyEndTime;
	}

	public void setNotifyEndTime(String notifyEndTime) {
		this.notifyEndTime = notifyEndTime;
	}

	public Integer getNotifyNumericValue() {
		return this.notifyNumericValue;
	}

	public void setNotifyNumericValue(Integer notifyNumericValue) {
		this.notifyNumericValue = notifyNumericValue;
	}

	public BigDecimal getNotifyFloatValue() {
		return this.notifyFloatValue;
	}

	public void setNotifyFloatValue(BigDecimal notifyFloatValue) {
		this.notifyFloatValue = notifyFloatValue;
	}

	public Integer getNotifyNumericCondition() {
		return this.notifyNumericCondition;
	}

	public void setNotifyNumericCondition(Integer notifyNumericCondition) {
		this.notifyNumericCondition = notifyNumericCondition;
	}

	public String getNotifyStringValue() {
		return this.notifyStringValue;
	}

	public void setNotifyStringValue(String notifyStringValue) {
		this.notifyStringValue = notifyStringValue;
	}

	public Integer getNotifyStringCondition() {
		return this.notifyStringCondition;
	}

	public void setNotifyStringCondition(Integer notifyStringCondition) {
		this.notifyStringCondition = notifyStringCondition;
	}

	public boolean isStopFlag() {
		return this.stopFlag;
	}

	public void setStopFlag(boolean stopFlag) {
		this.stopFlag = stopFlag;
	}

	public Integer getAwakeNumericValue() {
		return this.awakeNumericValue;
	}

	public void setAwakeNumericValue(Integer awakeNumericValue) {
		this.awakeNumericValue = awakeNumericValue;
	}

	public BigDecimal getAwakeFloatValue() {
		return this.awakeFloatValue;
	}

	public void setAwakeFloatValue(BigDecimal awakeFloatValue) {
		this.awakeFloatValue = awakeFloatValue;
	}

	public Integer getAwakeNumericCondition() {
		return this.awakeNumericCondition;
	}

	public void setAwakeNumericCondition(Integer awakeNumericCondition) {
		this.awakeNumericCondition = awakeNumericCondition;
	}

	public String getAwakeStringValue() {
		return this.awakeStringValue;
	}

	public void setAwakeStringValue(String awakeStringValue) {
		this.awakeStringValue = awakeStringValue;
	}

	public Integer getAwakeStringCondition() {
		return this.awakeStringCondition;
	}

	public void setAwakeStringCondition(Integer awakeStringCondition) {
		this.awakeStringCondition = awakeStringCondition;
	}

	public int getAction() {
		return this.action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public String getReserved01() {
		return this.reserved01;
	}

	public void setReserved01(String reserved01) {
		this.reserved01 = reserved01;
	}

	public String getReserved02() {
		return this.reserved02;
	}

	public void setReserved02(String reserved02) {
		this.reserved02 = reserved02;
	}

	public String getReserved03() {
		return this.reserved03;
	}

	public void setReserved03(String reserved03) {
		this.reserved03 = reserved03;
	}

	public Set getTbTargetResources() {
		return this.tbTargetResources;
	}

	public void setTbTargetResources(Set tbTargetResources) {
		this.tbTargetResources = tbTargetResources;
	}

	public TbActionApi getTbActionApi() {
		return this.tbActionApi;
	}

	public void setTbActionApi(TbActionApi tbActionApi) {
		this.tbActionApi = tbActionApi;
	}

	public TbActionEmail getTbActionEmail() {
		return this.tbActionEmail;
	}

	public void setTbActionEmail(TbActionEmail tbActionEmail) {
		this.tbActionEmail = tbActionEmail;
	}

}
