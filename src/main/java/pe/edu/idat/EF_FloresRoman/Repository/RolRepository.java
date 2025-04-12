package pe.edu.idat.EF_FloresRoman.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.EF_FloresRoman.Model.Rol;
@Repository
public interface RolRepository extends JpaRepository<Rol,
        Integer> {
    Rol findByNomrol(String nomrol);
}