package com.example.newproject.pojoClasses.MedicationPOjo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MedicationData {
    @SerializedName("OredrID")
    @Expose
    private String oredrID;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Medication")
    @Expose
    private String medication;
    @SerializedName("Strength")
    @Expose
    private String strength;
    @SerializedName("MedType")
    @Expose
    private String medType;
    @SerializedName("NeedBody")
    @Expose
    private String needBody;
    @SerializedName("Diagnosis")
    @Expose
    private String diagnosis;
    @SerializedName("StartDate")
    @Expose
    private String startDate;
    @SerializedName("EndDate")
    @Expose
    private String endDate;
    @SerializedName("SidingScale")
    @Expose
    private String sidingScale;
    @SerializedName("EqulantTo")
    @Expose
    private String equlantTo;
    @SerializedName("ControlledDrug")
    @Expose
    private String controlledDrug;
    @SerializedName("Barcode")
    @Expose
    private String barcode;
    @SerializedName("Record")
    @Expose
    private String record;
    @SerializedName("Instruction")
    @Expose
    private String instruction;
    @SerializedName("OrderType")
    @Expose
    private String orderType;
    @SerializedName("Psrno")
    @Expose
    private String psrno;
    @SerializedName("FacilityCode")
    @Expose
    private String facilityCode;
    @SerializedName("Prescriber")
    @Expose
    private String prescriber;
    @SerializedName("Source")
    @Expose
    private String source;
    @SerializedName("Route")
    @Expose
    private String route;
    @SerializedName("OrginDate")
    @Expose
    private String orginDate;
    @SerializedName("PackageExpires")
    @Expose
    private String packageExpires;
    @SerializedName("LastPrescribed")
    @Expose
    private String lastPrescribed;
    @SerializedName("WaitAdmins")
    @Expose
    private String waitAdmins;
    @SerializedName("RequireFollowUp")
    @Expose
    private String requireFollowUp;
    @SerializedName("StartTime")
    @Expose
    private String startTime;
    @SerializedName("EndTime")
    @Expose
    private String endTime;
    @SerializedName("PhyId")
    @Expose
    private String phyId;
    @SerializedName("MinPRN")
    @Expose
    private String minPRN;
    @SerializedName("Qnty4")
    @Expose
    private String qnty4;
    @SerializedName("Option4")
    @Expose
    private String option4;
    @SerializedName("Tabs4")
    @Expose
    private String tabs4;
    @SerializedName("Time4")
    @Expose
    private String time4;
    @SerializedName("MaxPRN")
    @Expose
    private String maxPRN;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("PRN")
    @Expose
    private String pRN;
    @SerializedName("DoseTime")
    @Expose
    private String doseTime;
    @SerializedName("time1")
    @Expose
    private String time1;
    @SerializedName("time2")
    @Expose
    private String time2;
    @SerializedName("ImgURL")
    @Expose
    private String imgURL;

    public String getOredrID() {
        return oredrID;
    }

    public void setOredrID(String oredrID) {
        this.oredrID = oredrID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getMedType() {
        return medType;
    }

    public void setMedType(String medType) {
        this.medType = medType;
    }

    public String getNeedBody() {
        return needBody;
    }

    public void setNeedBody(String needBody) {
        this.needBody = needBody;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSidingScale() {
        return sidingScale;
    }

    public void setSidingScale(String sidingScale) {
        this.sidingScale = sidingScale;
    }

    public String getEqulantTo() {
        return equlantTo;
    }

    public void setEqulantTo(String equlantTo) {
        this.equlantTo = equlantTo;
    }

    public String getControlledDrug() {
        return controlledDrug;
    }

    public void setControlledDrug(String controlledDrug) {
        this.controlledDrug = controlledDrug;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getPsrno() {
        return psrno;
    }

    public void setPsrno(String psrno) {
        this.psrno = psrno;
    }

    public String getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(String facilityCode) {
        this.facilityCode = facilityCode;
    }

    public String getPrescriber() {
        return prescriber;
    }

    public void setPrescriber(String prescriber) {
        this.prescriber = prescriber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getOrginDate() {
        return orginDate;
    }

    public void setOrginDate(String orginDate) {
        this.orginDate = orginDate;
    }

    public String getPackageExpires() {
        return packageExpires;
    }

    public void setPackageExpires(String packageExpires) {
        this.packageExpires = packageExpires;
    }

    public String getLastPrescribed() {
        return lastPrescribed;
    }

    public void setLastPrescribed(String lastPrescribed) {
        this.lastPrescribed = lastPrescribed;
    }

    public String getWaitAdmins() {
        return waitAdmins;
    }

    public void setWaitAdmins(String waitAdmins) {
        this.waitAdmins = waitAdmins;
    }

    public String getRequireFollowUp() {
        return requireFollowUp;
    }

    public void setRequireFollowUp(String requireFollowUp) {
        this.requireFollowUp = requireFollowUp;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPhyId() {
        return phyId;
    }

    public void setPhyId(String phyId) {
        this.phyId = phyId;
    }

    public String getMinPRN() {
        return minPRN;
    }

    public void setMinPRN(String minPRN) {
        this.minPRN = minPRN;
    }

    public String getQnty4() {
        return qnty4;
    }

    public void setQnty4(String qnty4) {
        this.qnty4 = qnty4;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getTabs4() {
        return tabs4;
    }

    public void setTabs4(String tabs4) {
        this.tabs4 = tabs4;
    }

    public String getTime4() {
        return time4;
    }

    public void setTime4(String time4) {
        this.time4 = time4;
    }

    public String getMaxPRN() {
        return maxPRN;
    }

    public void setMaxPRN(String maxPRN) {
        this.maxPRN = maxPRN;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPRN() {
        return pRN;
    }

    public void setPRN(String pRN) {
        this.pRN = pRN;
    }

    public String getDoseTime() {
        return doseTime;
    }

    public void setDoseTime(String doseTime) {
        this.doseTime = doseTime;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }


}
