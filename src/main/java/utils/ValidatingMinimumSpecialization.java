package utils;

import com.bcg.testepraticobcg.dto.MedicoDTO;
import com.bcg.testepraticobcg.service.exceptions.InvalidNumberOfSpecialtiesException;

public class ValidatingMinimumSpecialization {

    public static void validating(MedicoDTO dto) {

        if (dto.getEspecialidades().size() <= 1) {
            throw new InvalidNumberOfSpecialtiesException("É necssário escolher 2 especialidades no minímo");
        }
    }
}
