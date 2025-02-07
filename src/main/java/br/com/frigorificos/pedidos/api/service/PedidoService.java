package br.com.frigorificos.pedidos.api.service;

import br.com.frigorificos.pedidos.api.entity.Pedido;
import br.com.frigorificos.pedidos.api.entity.enums.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    private final Logger logger = LoggerFactory.getLogger(PedidoService.class);
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    public PedidoService(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public Pedido enfileirarPedido(Pedido pedido) {
        pedido.setStatus(Status.EM_PROCESSAMENTO);
        rabbitTemplate.convertAndSend(exchangeName, "", pedido);
        logger.info("Pedido enfileirado: {}", pedido.toString());
        return pedido;
    }
}
