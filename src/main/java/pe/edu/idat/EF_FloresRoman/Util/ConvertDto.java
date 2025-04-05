package pe.edu.idat.EF_FloresRoman.Util;
import pe.edu.idat.EF_FloresRoman.Dto.DtoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
public class ConvertDto {
    public DtoEntity convertirADto(Object object,
                                   DtoEntity dto){
        return new ModelMapper().map(object, dto.getClass());
    }
}