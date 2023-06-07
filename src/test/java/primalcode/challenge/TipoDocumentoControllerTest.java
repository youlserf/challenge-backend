package primalcode.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import primalcode.challenge.controller.TipoDocumentoController;
import primalcode.challenge.model.TipoDocumento;
import primalcode.challenge.service.TipoDocumentoService;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TipoDocumentoControllerTest {

    @Mock
    private TipoDocumentoService tipoDocumentoService;

    @InjectMocks
    private TipoDocumentoController tipoDocumentoController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllTypedocuments_ReturnsListOfTypedocuments() {
        // Arrange
        TipoDocumento tipoDocumento1 = new TipoDocumento();
        tipoDocumento1.setIdTipoDocumento(1L);
        TipoDocumento tipoDocumento2 = new TipoDocumento();
        tipoDocumento2.setIdTipoDocumento(2L);
        List<TipoDocumento> expectedTipoDocumentos = Arrays.asList(tipoDocumento1, tipoDocumento2);
        when(tipoDocumentoService.getAllTipoDocumentos()).thenReturn(expectedTipoDocumentos);

        // Act
        ResponseEntity<List<TipoDocumento>> response = tipoDocumentoController.getAllTypedocuments();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedTipoDocumentos, response.getBody());
    }

    @Test
    void getTipoDocumentoById_ExistingId_ReturnsTipoDocumento() {
        // Arrange
        Long tipoDocumentoId = 1L;
        TipoDocumento expectedTipoDocumento = new TipoDocumento();
        expectedTipoDocumento.setIdTipoDocumento(tipoDocumentoId);
        when(tipoDocumentoService.getTipoDocumentoById(tipoDocumentoId)).thenReturn(expectedTipoDocumento);

        // Act
        ResponseEntity<TipoDocumento> response = tipoDocumentoController.getTipoDocumentoById(tipoDocumentoId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedTipoDocumento, response.getBody());
    }

    @Test
    void createTipoDocumento_ValidTipoDocumento_ReturnsCreatedTipoDocumento() {
        // Arrange
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setIdTipoDocumento(1L);
        when(tipoDocumentoService.createTipoDocumento(tipoDocumento)).thenReturn(tipoDocumento);

        // Act
        ResponseEntity<TipoDocumento> response = tipoDocumentoController.createTipoDocumento(tipoDocumento);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(tipoDocumento, response.getBody());
    }

    @Test
    void updateTipoDocumento_ExistingIdAndValidTipoDocumento_ReturnsUpdatedTipoDocumento() {
        // Arrange
        Long tipoDocumentoId = 1L;
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setIdTipoDocumento(tipoDocumentoId);
        TipoDocumento updatedTipoDocumento = new TipoDocumento();
        updatedTipoDocumento.setIdTipoDocumento(tipoDocumentoId);
        when(tipoDocumentoService.updateTipoDocumento(tipoDocumentoId, tipoDocumento)).thenReturn(updatedTipoDocumento);

        // Act
        ResponseEntity<TipoDocumento> response = tipoDocumentoController.updateTipoDocumento(tipoDocumentoId, tipoDocumento);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedTipoDocumento, response.getBody());
    }

    @Test
    void deleteTipoDocumento_ExistingId_ReturnsNoContent() {
        // Arrange
        Long tipoDocumentoId = 1L;
        doNothing().when(tipoDocumentoService).deleteTipoDocumento(tipoDocumentoId);

        // Act
        ResponseEntity<Void> response = tipoDocumentoController.deleteTipoDocumento(tipoDocumentoId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(null, response.getBody());
    }
}
