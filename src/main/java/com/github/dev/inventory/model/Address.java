package com.github.dev.inventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    @Column(name = "address_country", nullable = false, length = 2)
    private String country;

    @Column(name = "address_state", nullable = false, length = 5)
    private String state;

    @Column(name = "address_city", nullable = false, length = 100)
    private String city;

    @Column(name = "address_district", nullable = false)
    private String district;

    @Column(name = "address_street", nullable = false)
    private String street;

    @Column(name = "address_number", nullable = false)
    private Integer number;

    @Column(name = "address_complement", length = 100)
    private String complement;

    @Column(name = "address_reference", nullable = false)
    private String reference;

    @Column(name = "address_formatted_address", nullable = false)
    private String formattedAddress = formattedAddress();

    @Column(name = "address_postal_code", nullable = false, length = 9)
    private String postalCode;

    public String formattedAddress() {
        return street + number + complement + district + city + state + country;
    }

}
