// package tp.backend.reportes.services;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.*;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.springframework.boot.test.context.SpringBootTest;
// import tp.backend.agencia.entities.Prueba;
// import tp.backend.reportes.repositories.PruebaRepository;

// import java.time.LocalDate;
// import java.util.Collections;

// @SpringBootTest
// class ReporteServiceTest {

//     @Mock
//     private PruebaRepository pruebaRepository;

//     @InjectMocks
//     private ReporteService reporteService;

//     @Test
//     void testKilometrosPorVehiculoYPeriodo() {
//         // Arrange
//         when(pruebaRepository.findByVehiculoPlacaAndFechaBetween(anyString(), any(LocalDate.class), any(LocalDate.class)))
//             .thenReturn(Collections.singletonList(new Prueba(null, null, 100.0, LocalDate.now())));

//         // Act
//         double kilometros = reporteService.kilometrosPorVehiculoYPeriodo("ABC123", LocalDate.now().minusDays(10), LocalDate.now());

//         // Assert
//         assertEquals(100.0, kilometros);
//         verify(pruebaRepository, times(1)).findByVehiculoPlacaAndFechaBetween(anyString(), any(LocalDate.class), any(LocalDate.class));
//     }
// }
