package org.factoriaf5.comicbooks.orders;

import java.util.HashSet;
import java.util.Set;

import org.factoriaf5.comicbooks.comics.Comic;
import org.factoriaf5.comicbooks.customers.Customer;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private java.util.Date date;

    @ManyToOne
    @JoinColumn(name="customer_email",nullable=false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="comic_isbn",nullable=false)
    private Comic comic;  

     
    //usado
    // @ManyToMany
    // @JoinTable(name="customer_order", joinColumns={@JoinColumn(name="order_id",referencedColumnName = "id")}, inverseJoinColumns={@JoinColumn(name="customer_email",referencedColumnName = "email")})
    // @JsonIgnore
    // private Set<Customer> customers = new HashSet<>();
    
    // Getter Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public Comic getComic() {
        return comic;
    }

    public void setComic(Comic comic) {
        this.comic = comic;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // public Set<Customer> getCustomers() {
    //     return customers;
    // }

    // public void setCustomers(Set<Customer> customers) {
    //     this.customers = customers;
    // }

    

    
        
}
