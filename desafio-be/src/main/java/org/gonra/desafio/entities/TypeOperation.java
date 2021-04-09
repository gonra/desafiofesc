package org.gonra.desafio.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "TYPEOPERATION")
public class TypeOperation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "typeOperation", cascade = CascadeType.ALL)
    private List<Operation> operationList;

    public TypeOperation() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return this.description;
    }
}
