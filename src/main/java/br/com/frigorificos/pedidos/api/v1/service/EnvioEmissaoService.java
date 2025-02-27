package br.com.frigorificos.pedidos.api.v1.service;

import br.com.frigorificos.pedidos.api.v1.dto.PainelDTO;
import br.com.frigorificos.pedidos.api.v1.utils.LogUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EnvioEmissaoService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private LogUtils logger;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    public PainelDTO enfileirarEmissoes(PainelDTO painelDTO) {
        rabbitTemplate.convertAndSend(exchangeName, "", painelDTO);
        logger.info("Pedido enfileirado: " + painelDTO.numeroNotaFiscal());
        return painelDTO;
    }
}
