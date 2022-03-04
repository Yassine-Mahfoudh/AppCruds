package com.example.myapp.Departement;

        import com.example.myapp.salle.Salle;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.stereotype.Repository;

        import java.util.List;
        import java.util.Optional;

@Repository
public interface DepartementRepository
        extends JpaRepository<Departement,Long> {
    @Query("SELECT dep FROM Departement dep where dep.nom = ?1")
    Departement findDepartementByNom(String nom);

    Optional <Departement> findDepartementById(Long id);
    @Query("SELECT dep.Salles FROM Departement dep where dep.id = ?1")
    List<Salle> getSallebyDepartement(Long id);
}
