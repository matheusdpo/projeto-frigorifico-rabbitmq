package br.com.frigorificos.pedidos.api.v1.model;

public class ResponsePedidoEnfileiradoModel extends ResponseObjectModel {
    private String nroNotaFiscal;

    public ResponsePedidoEnfileiradoModel(String nroNotaFiscal) {
        this.nroNotaFiscal = nroNotaFiscal;
        this.message = "Pedido enfileirado com sucesso";
    }

    public String getNroNotaFiscal() {
        return nroNotaFiscal;
    }

    public String getMessagem() {
        return message;
    }
}
