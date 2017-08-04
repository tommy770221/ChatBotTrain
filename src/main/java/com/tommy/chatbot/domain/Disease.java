package com.tommy.chatbot.domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "disease")
@Entity
@Table(name="disease")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;


    @Column(name = "doc_category")
    private String docCategory;

    @Column(name = "category")
    private String category;

    @Column(name = "big_category")
    private String bigCategory;

    @Column(name = "symptom")
    private String symptom;

    public String getDocCategory() {
        return docCategory;
    }

    public void setDocCategory(String docCategory) {
        this.docCategory = docCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBigCategory() {
        return bigCategory;
    }

    public void setBigCategory(String bigCategory) {
        this.bigCategory = bigCategory;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public static Disease findDisease(Integer id) {
        if (id == null) return null;
        return entityManager().find(Disease.class, id);
    }
    @PersistenceContext
    transient EntityManager entityManager;




    public static final EntityManager entityManager() {
        EntityManager em = new Disease().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("");



    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static long countDiseases() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Disease o", Long.class).getSingleResult();
    }

    public static List<Disease> findAllDiseases() {
        return entityManager().createQuery("SELECT o FROM Disease o", Disease.class).getResultList();
    }

    public static List<Disease> findAllDiseases(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Disease o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Disease.class).getResultList();
    }



    public static List<Disease> findDiseaseEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Disease o", Disease.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    public static List<Disease> findDiseaseEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Disease o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Disease.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Disease attached = findDisease(this.id);
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
    public Disease merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Disease merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
