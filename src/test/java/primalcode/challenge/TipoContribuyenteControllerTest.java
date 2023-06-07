package primalcode.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import primalcode.challenge.controller.TipoContribuyenteController;
import primalcode.challenge.model.TipoContribuyente;
import primalcode.challenge.service.TipoContribuyenteService;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TipoContribuyenteControllerTest {

    @Mock
    private TipoContribuyenteService tipoContribuyenteService;

    @InjectMocks
    private TipoContribuyenteController tipoContribuyenteController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllTypeContributors_ReturnsListOfTypeContributors() {
        // Arrange
        List<TipoContribuyente> typeContributors = List.of(
                new TipoContribuyente(1, "Contributor 1", true),
                new TipoContribuyente(2, "Contributor 2", false)
        );
        when(tipoContribuyenteService.getAllTipoContribuyentes()).thenReturn(typeContributors);

        // Act
        ResponseEntity<List<TipoContribuyente>> response = tipoContribuyenteController.getAllTypeContributors();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(typeContributors, response.getBody());
    }

    @Test
    void getTipoContribuyenteById_ExistingId_ReturnsTipoContribuyente() {
        // Arrange
        Long id = 1L;
        TipoContribuyente tipoContribuyente = new TipoContribuyente(1, "Contributor", true);
        when(tipoContribuyenteService.getTipoContribuyenteById(id)).thenReturn(tipoContribuyente);

        // Act
        ResponseEntity<TipoContribuyente> response = tipoContribuyenteController.getTipoContribuyenteById(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(tipoContribuyente, response.getBody());
    }

    @Test
    void createTipoContribuyente_ValidTipoContribuyente_ReturnsCreatedTipoContribuyente() {
        // Arrange
        TipoContribuyente tipoContribuyente = new TipoContribuyente(1, "Contributor", true);
        when(tipoContribuyenteService.createTipoContribuyente(tipoContribuyente)).thenReturn(tipoContribuyente);

        // Act
        ResponseEntity<TipoContribuyente> response = tipoContribuyenteController.createTipoContribuyente(tipoContribuyente);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(tipoContribuyente, response.getBody());
    }

    @Test
    void updateTipoContribuyente_ExistingIdAndValidTipoContribuyente_ReturnsUpdatedTipoContribuyente() {
        // Arrange
        Long id = 1L;
        TipoContribuyente tipoContribuyente = new TipoContribuyente(1, "Contributor", true);
        when(tipoContribuyenteService.updateTipoContribuyente(id, tipoContribuyente)).thenReturn(tipoContribuyente);

        // Act
        ResponseEntity<TipoContribuyente> response = tipoContribuyenteController.updateTipoContribuyente(id, tipoContribuyente);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(tipoContribuyente, response.getBody());
    }

    @Test
    void deleteTipoContribuyente_ExistingId_ReturnsNoContent() {
        // Arrange
        Long id = 1L;

        // Act
        ResponseEntity<Void> response = tipoContribuyenteController.deleteTipoContribuyente(id);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(tipoContribuyenteService, times(1)).deleteTipoContribuyente(id);
    }
}
