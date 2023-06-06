package primalcode.challenge;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import primalcode.challenge.controller.EntidadController;
import primalcode.challenge.model.Entidad;
import primalcode.challenge.service.EntidadService;

@RunWith(SpringRunner.class)
@WebMvcTest(EntidadController.class)
public class EntidadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EntidadService entidadService;

    @Test
    public void testGetEntidadById() throws Exception {
        // Mock the service behavior
        Entidad entidad = new Entidad();
        Mockito.when(entidadService.getEntidadById(Mockito.anyLong())).thenReturn(entidad);

        // Perform the GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/api/entidad/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idEntidad").value(entidad.getIdEntidad()));
    }

    @Test
    public void testCreateEntidad() throws Exception {
        // Mock the service behavior
        Entidad entidad = new Entidad();
        Mockito.when(entidadService.createEntidad(Mockito.any(Entidad.class))).thenReturn(entidad);

        // Perform the POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/api/entidad")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"idEntidad\": 1}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idEntidad").value(entidad.getIdEntidad()));
    }

    // Implement tests for other endpoints: updateEntidad and deleteEntidad

}
