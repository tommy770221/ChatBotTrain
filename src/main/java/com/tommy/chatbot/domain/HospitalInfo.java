package com.tommy.chatbot.domain;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "hospital_info")
@Entity
@Table(name="hospital_info" )
public class HospitalInfo {

    @PersistenceContext
    transient EntityManager entityManager;

    public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "hp_code")
    private String hpCode;

    @Column(name = "hp_name")
    private String hpName;

    @Column(name = "hp_auth")
    private String hpAuth;

    @Column(name = "hp_type")
    private String hpType;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "address")
    private String address;

    @Column(name = "medical_treatment_section")
    private String medicalTreatmentSection;

    @Column(name = "western_doctor")
    private String westernDoctor;

    @Column(name = "chinese_medicine_practitioners")
    private String chineseMedicinePractitioners;

    @Column(name = "dentist")
    private String dentist;

    @Column(name = "pharmacist")
    private String pharmacist;

    @Column(name = "pharmacy_health")
    private String pharmacyHealth;

    @Column(name = "nursing_division")
    private String nursingDivision;

    @Column(name = "nurse")
    private String nurse;

    @Column(name = "midwife")
    private String midwife;

    @Column(name = "midwife_asist")
    private String midwifeAsist;

    @Column(name = "medical_examiner")
    private String medicalExaminer;

    @Column(name = "medical_examiner_asist")
    private String medicalExaminerAsist;

    @Column(name = "physical_therapist")
    private String physicalTherapist;

    @Column(name = "functional_therapist")
    private String functionalTherapist;

    @Column(name = "medical_radiologist")
    private String medicalRadiologist;

    @Column(name = "medical_literati")
    private String medicalLiterati;

    @Column(name = "physical_therapy")
    private String physicalTherapy;

    @Column(name = "respiratory_therapist")
    private String respiratoryTherapist;

    @Column(name = "functional_therapy")
    private String functionalTherapy;

    @Column(name = "consult_a_psychologist")
    private String consultAPsychologist;

    @Column(name = "clinical_psychologist")
    private String clinicalPsychologist;

    @Column(name = "nutritionist")
    private String nutritionist;

    @Column(name = "language_therapist")
    private String languageTherapist;

    @Column(name = "dental_technician")
    private String dentalTechnician;

    @Column(name = "listener")
    private String listener;

    @Column(name = "dental_technician_asist")
    private String dentalTechnicianAsist;

    public String getHpCode() {
        return hpCode;
    }

    public void setHpCode(String hpCode) {
        this.hpCode = hpCode;
    }

    public String getHpName() {
        return hpName;
    }

    public void setHpName(String hpName) {
        this.hpName = hpName;
    }

    public String getHpAuth() {
        return hpAuth;
    }

    public void setHpAuth(String hpAuth) {
        this.hpAuth = hpAuth;
    }

    public String getHpType() {
        return hpType;
    }

    public void setHpType(String hpType) {
        this.hpType = hpType;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMedicalTreatmentSection() {
        return medicalTreatmentSection;
    }

    public void setMedicalTreatmentSection(String medicalTreatmentSection) {
        this.medicalTreatmentSection = medicalTreatmentSection;
    }

    public String getWesternDoctor() {
        return westernDoctor;
    }

    public void setWesternDoctor(String westernDoctor) {
        this.westernDoctor = westernDoctor;
    }

    public String getChineseMedicinePractitioners() {
        return chineseMedicinePractitioners;
    }

    public void setChineseMedicinePractitioners(String chineseMedicinePractitioners) {
        this.chineseMedicinePractitioners = chineseMedicinePractitioners;
    }

    public String getDentist() {
        return dentist;
    }

    public void setDentist(String dentist) {
        this.dentist = dentist;
    }

    public String getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(String pharmacist) {
        this.pharmacist = pharmacist;
    }

    public String getPharmacyHealth() {
        return pharmacyHealth;
    }

    public void setPharmacyHealth(String pharmacyHealth) {
        this.pharmacyHealth = pharmacyHealth;
    }

    public String getNursingDivision() {
        return nursingDivision;
    }

    public void setNursingDivision(String nursingDivision) {
        this.nursingDivision = nursingDivision;
    }

    public String getNurse() {
        return nurse;
    }

    public void setNurse(String nurse) {
        this.nurse = nurse;
    }

    public String getMidwife() {
        return midwife;
    }

    public void setMidwife(String midwife) {
        this.midwife = midwife;
    }

    public String getMidwifeAsist() {
        return midwifeAsist;
    }

    public void setMidwifeAsist(String midwifeAsist) {
        this.midwifeAsist = midwifeAsist;
    }

    public String getMedicalExaminer() {
        return medicalExaminer;
    }

    public void setMedicalExaminer(String medicalExaminer) {
        this.medicalExaminer = medicalExaminer;
    }

    public String getMedicalExaminerAsist() {
        return medicalExaminerAsist;
    }

    public void setMedicalExaminerAsist(String medicalExaminerAsist) {
        this.medicalExaminerAsist = medicalExaminerAsist;
    }

    public String getPhysicalTherapist() {
        return physicalTherapist;
    }

    public void setPhysicalTherapist(String physicalTherapist) {
        this.physicalTherapist = physicalTherapist;
    }

    public String getFunctionalTherapist() {
        return functionalTherapist;
    }

    public void setFunctionalTherapist(String functionalTherapist) {
        this.functionalTherapist = functionalTherapist;
    }

    public String getMedicalRadiologist() {
        return medicalRadiologist;
    }

    public void setMedicalRadiologist(String medicalRadiologist) {
        this.medicalRadiologist = medicalRadiologist;
    }

    public String getMedicalLiterati() {
        return medicalLiterati;
    }

    public void setMedicalLiterati(String medicalLiterati) {
        this.medicalLiterati = medicalLiterati;
    }

    public String getPhysicalTherapy() {
        return physicalTherapy;
    }

    public void setPhysicalTherapy(String physicalTherapy) {
        this.physicalTherapy = physicalTherapy;
    }

    public String getRespiratoryTherapist() {
        return respiratoryTherapist;
    }

    public void setRespiratoryTherapist(String respiratoryTherapist) {
        this.respiratoryTherapist = respiratoryTherapist;
    }

    public String getFunctionalTherapy() {
        return functionalTherapy;
    }

    public void setFunctionalTherapy(String functionalTherapy) {
        this.functionalTherapy = functionalTherapy;
    }

    public String getConsultAPsychologist() {
        return consultAPsychologist;
    }

    public void setConsultAPsychologist(String consultAPsychologist) {
        this.consultAPsychologist = consultAPsychologist;
    }

    public String getClinicalPsychologist() {
        return clinicalPsychologist;
    }

    public void setClinicalPsychologist(String clinicalPsychologist) {
        this.clinicalPsychologist = clinicalPsychologist;
    }

    public String getNutritionist() {
        return nutritionist;
    }

    public void setNutritionist(String nutritionist) {
        this.nutritionist = nutritionist;
    }

    public String getLanguageTherapist() {
        return languageTherapist;
    }

    public void setLanguageTherapist(String languageTherapist) {
        this.languageTherapist = languageTherapist;
    }

    public String getDentalTechnician() {
        return dentalTechnician;
    }

    public void setDentalTechnician(String dentalTechnician) {
        this.dentalTechnician = dentalTechnician;
    }

    public String getListener() {
        return listener;
    }

    public void setListener(String listener) {
        this.listener = listener;
    }

    public String getDentalTechnicianAsist() {
        return dentalTechnicianAsist;
    }

    public void setDentalTechnicianAsist(String dentalTechnicianAsist) {
        this.dentalTechnicianAsist = dentalTechnicianAsist;
    }

    public static HospitalInfo findHospitalInfo(Integer id) {
        if (id == null) return null;
        return entityManager().find(HospitalInfo.class, id);
    }

    public static final EntityManager entityManager() {
        EntityManager em = new HospitalInfo().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public static long countHospitalInfoes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM HospitalInfo o", Long.class).getSingleResult();
    }

    public static List<HospitalInfo> findAllHospitalInfoes() {
        return entityManager().createQuery("SELECT o FROM HospitalInfo o", HospitalInfo.class).getResultList();
    }

    public static List<HospitalInfo> findAllHospitalInfoes(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM HospitalInfo o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, HospitalInfo.class).getResultList();
    }



    public static List<HospitalInfo> findHospitalInfoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM HospitalInfo o", HospitalInfo.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    public static List<HospitalInfo> findHospitalInfoEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM HospitalInfo o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, HospitalInfo.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Transactional
    public void persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }

    @Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            HospitalInfo attached = findHospitalInfo(this.id);
            this.entityManager.remove(attached);
        }
    }

    @Transactional
    public void flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }

    @Transactional
    public void clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }

    @Transactional
    public HospitalInfo merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        HospitalInfo merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
