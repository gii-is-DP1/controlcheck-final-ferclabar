package org.springframework.samples.petclinic.care;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "cares")
public class Care extends BaseEntity{
    
    @NotEmpty
    @NotNull
    @Size(min = 5, max = 30)
    @Column(name = "name", unique = true)
    String name;

    @NotEmpty
    String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @Size(min = 1)
    @JoinTable(name = "pet_cares", joinColumns = @JoinColumn(name = "pet_type_id"),inverseJoinColumns = @JoinColumn(name = "care_id"))
    @NotEmpty
    Set<PetType> compatiblePetTypes;
}
