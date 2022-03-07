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
    Optional <Departement> findDepartementByNom(String nom);
    boolean existsByNom(String nom);
    void deleteByNom(String nom);


     Departement findDepartementById(Long id);

    @Query("SELECT dep.Salles FROM Departement dep where dep.nom = ?1")
    List<Salle> getSallebyDepartement(String nom);
}
