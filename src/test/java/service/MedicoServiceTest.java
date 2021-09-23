package service;


import com.bcg.testepraticobcg.dto.MedicoDTO;
import com.bcg.testepraticobcg.entity.Especialidade;
import com.bcg.testepraticobcg.repository.EspecialidadeRepository;
import com.bcg.testepraticobcg.repository.MedicoRepository;
import com.bcg.testepraticobcg.service.MedicoService;
import com.bcg.testepraticobcg.service.exceptions.InvalidNumberOfSpecialtiesException;
import com.bcg.testepraticobcg.viacep.EnderecoDTO;
import com.bcg.testepraticobcg.viacep.ViaCEPWebService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;
import static utils.MedicoUtils.mockMedico;
import static utils.MedicoUtils.mockMedico2;

@RunWith(MockitoJUnitRunner.class)
public class MedicoServiceTest {


    @Mock
    private MedicoRepository medicoRepository;

    @InjectMocks
    private MedicoService medicoService;

    @Mock
    private ViaCEPWebService viaCepWbService;

    @Mock
    private EspecialidadeRepository especialidadeRepository;

    @Test
    public void deveSalvarMedicoNoBanco() {

        MedicoDTO medicoDTO = mockMedico();

        when(viaCepWbService.viaCEPWebService(anyInt())).thenReturn(new EnderecoDTO());

        when(especialidadeRepository.getById(anyLong())).thenReturn(new Especialidade());

        medicoService.save(medicoDTO);
        verify(viaCepWbService, times(1)).viaCEPWebService(anyInt());
    }

    @Test(expected = InvalidNumberOfSpecialtiesException.class)
    public void deveLevantarrErroAoTentarSalvarMedicoNoBanco() {

        MedicoDTO medicoDTO = mockMedico2();


        when(viaCepWbService.viaCEPWebService(anyInt())).thenReturn(new EnderecoDTO());

        when(especialidadeRepository.getById(anyLong())).thenReturn(new Especialidade());

        medicoService.save(medicoDTO);

        verify(viaCepWbService, times(1)).viaCEPWebService(anyInt());
    }


}
