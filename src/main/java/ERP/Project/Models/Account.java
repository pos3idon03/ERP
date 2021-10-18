package ERP.Project.Models;

import lombok.Data;

import javax.persistence.*;


//@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "code", nullable = false)
    private String accountCode;
    @Column(name = "description", nullable = false)
    private String accountDescription;
}
