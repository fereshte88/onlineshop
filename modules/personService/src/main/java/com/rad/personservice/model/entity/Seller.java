package com.rad.personservice.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_SELLER")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Seller extends BasePerson<Seller> {


    @Column(name="seller_Number")
    private String sellerNumber;
}
