package br.com.frigorificos.pedidos.api.v1.controller;

import br.com.frigorificos.pedidos.api.v1.dto.PainelDTO;
import br.com.frigorificos.pedidos.api.v1.model.ResponsePedidoEnfileiradoModel;
import br.com.frigorificos.pedidos.api.v1.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Pedidos", description = "Contém a operação para realização de pedidos")
@RestController
@RequestMapping("/api/v1/")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @RouterOperation(operation = @Operation(description = "Say hello", operationId = "hello", tags = "persons",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = PainelDTO.class)))))
    @PostMapping("/enviarFila")
    public ResponseEntity<?> init(@RequestBody PainelDTO painelDTO) {
        try {
            pedidoService.enfileirarEmissoes(painelDTO);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponsePedidoEnfileiradoModel(painelDTO.numeroNotaFiscal()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
